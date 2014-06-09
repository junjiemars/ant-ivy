-- create x_p_analyse_log_old job --
DECLARE
	name_job constant varchar2(20) default 'X_P_ANALYSE_LOG_OLD;';
	job_exist integer;
	job_no integer;
BEGIN

	--job exist?
	select count(0) into job_exist from user_jobs where what = name_job;

	if job_exist > 0 then
		select job into job_exist from user_jobs where what = name_job;
		dbms_job.remove (job_exist);
		commit;
	end if;

	--create job
	job_no := 0;
	dbms_job.submit(
		 job => job_no
		,what => name_job
		,next_date => trunc(next_day(sysdate,1))+3/24
		,interval => 'trunc(sysdate,1)+27/24'
	); 
	commit;

	dbms_output.put_line('created job:' || job_no);

	/* run immediatly
	dbms_job.run(
		job => job_no
	   ,force => false
	);
	*/

	NULL;
END;
/


