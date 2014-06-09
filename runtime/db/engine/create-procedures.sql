/* PROCEDURES: 
	1) x_p_analyse_log_old
	2) 	
*/

-- create x_p_analyse_log_old --
CREATE OR REPLACE PROCEDURE X_P_ANALYSE_LOG_OLD
AS
	begin_date date default sysdate;
	current_c constant timestamp default systimestamp;
    job_name constant varchar2(30) := 'X_P_ANALYSE_LOG_OLD';
	begin_time constant timestamp := systimestamp;
	table_names constant varchar2(1000) default 
		'X_LOG_STATISTICS,X_LOG,+X_LOG_RAW_HISTORY,X_LOG_RAW';

	cursor c_config is
		select f_sys_id, f_cat_id 
		from x_src_config order by f_sys_id, f_cat_id;
BEGIN
    --note:end_date is dummy argument

    --generate log statistics
    merge into x_log_statistics d
      using (
        select
            t.f_status
          , t.f_sys_id
          , t.f_cat_id
          , count(0) f_count
          , sum(t.f_elapsed_millis) f_elapsed
        from x_log_raw t
        where
			t.f_start_date < begin_date
            --and t.f_end_date < end_date
            --exclusive old record
            and t.f_sys_id <> 0 and t.f_cat_id <> 0
        group by t.f_status, t.f_sys_id, t.f_cat_id
      ) s
      on (  d.f_status = s.f_status
        and d.f_sys_id = s.f_sys_id
        and d.f_cat_id = s.f_cat_id
        and d.f_begin = begin_date
        --and d.f_end = end_date
		--and d.f_utime = current_c
		)
      when matched then
        update set
            d.f_count = s.f_count
          , d.f_elapsed = s.f_elapsed
          , d.f_utime = current_c

      when not matched then
        insert (
              d.f_status
            , d.f_sys_id
            , d.f_cat_id
            , d.f_begin
            , d.f_end
            , d.f_count
            , d.f_elapsed
            , d.f_utime
          )

        values (
              s.f_status
            , s.f_sys_id
            , s.f_cat_id
            , begin_date
            , begin_date --end_date
            , s.f_count
            , s.f_elapsed
            , current_c
          );

      --generate top 100 anlysise result
      for r in c_config
      loop
          merge into x_log d
            using (
              select
                  o.f_status
                , o.f_sys_id
                , o.f_cat_id
                , o.f_query_text
                , o.f_count
                , o.f_elapsed_millis
                , o.f_total_hits
              from
                (select
                    t.f_status
                  , t.f_sys_id
                  , t.f_cat_id
                  , t.f_query_text
                  , count(0) f_count
                  , sum(t.f_elapsed_millis) f_elapsed_millis
                  , sum(t.f_total_hits) f_total_hits
                 from x_log_raw t
                 where  t.f_sys_id = r.f_sys_id
                    and t.f_cat_id = r.f_cat_id
                    and t.f_status >= 0
                    --and t.f_end_date < end_date
                    and t.f_start_date < begin_date
                 group by
                      t.f_status
                    , t.f_sys_id
                    , t.f_cat_id
                    , t.f_query_text
                 order by f_count desc
                ) o
              where rownum <= 100
            ) s
            on (  d.f_status = s.f_status
              and d.f_sys_id = s.f_sys_id
              and d.f_cat_id = s.f_cat_id
              and d.f_query_text = s.f_query_text)

          when matched then
            update set
                d.f_count = d.f_count + s.f_count
              , d.f_elapsed_millis = d.f_elapsed_millis + s.f_elapsed_millis
              , d.f_total_hits = d.f_total_hits + s.f_total_hits
              , d.f_begin_query = begin_date
              , d.f_end_query = begin_date
          when not matched then
            insert (
                d.f_id
              , d.f_status
              , d.f_sys_id
              , d.f_cat_id
              , d.f_count
              , d.f_query_text
              , d.f_elapsed_millis
              , d.f_total_hits
              , d.f_begin_query
              , d.f_end_query
              , d.f_utime
              )
            values (
                x_s_log_id.nextval
              , s.f_status
              , s.f_sys_id
              , s.f_cat_id
              , s.f_count
              , s.f_query_text
              , s.f_elapsed_millis
              , s.f_total_hits
              , begin_date
              , begin_date --end_date
              , current_c
              );

      end loop;

	--move already analyzed records
	insert into x_log_raw_history
		select * from x_log_raw r
		where r.f_start_date < begin_date
		--and r.f_start_date >= begin_date
		;
	delete from x_log_raw r
		where r.f_start_date < begin_date
		--and r.f_start_date >= begin_date
        ;
	delete from x_log_raw_history r
		where r.f_start_date < (begin_date-30)--remains 30 days log
		;

	commit;
    x_p_log_job(0, table_names, job_name, begin_time);

	NULL;
EXCEPTION
  when others then
    declare
      e_code pls_integer := sqlcode;
      e_text varchar2(1000) := sqlerrm;
    begin
    	rollback;
		dbms_output.put_line(sqlcode || ' - ' || sqlerrm);

		if c_config%isopen then
			close c_config;
      	end if;
		x_p_log_job(e_code, e_text, job_name, begin_time);
    end;
END X_P_ANALYSE_LOG_OLD;
/


