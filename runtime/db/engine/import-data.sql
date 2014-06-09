/* IMPORTS:
	1)	x_src_config data
	2)	x_system
	3)	x_category 
	4)	x_users
*/

-- import x_src_config data -- 
insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (1, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'system', 'Hell0', 'com.xws.engine.app.dt.DT0s', 'com.xws.engine.app.dt.DT0i', '/home/junjie/cache/index/dt', 'select * from X_SRC_DATA_DT', 'http://10.32.238.217:8001/sms/ws/RobotService/', '<b>', '</b>', 0, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (2, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'xws', 'xws', 'com.xws.engine.app.wt.WT0s', 'com.xws.engine.app.wt.WT0i', '/home/junjie/cache/index/wt', 'select business_code f_code,business_name f_name,process_url f_url,fee f_fee,sub_business_name f_sub_name,business_desc f_desc,business_index f_index,business_keywords f_keywords from x_o_wt_b', 'http://10.32.238.217:8000/web/ws/RobotService/', '<font color="red"><b>', '</b></font>', 1, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (3, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'system', 'Hell0', 'com.xws.engine.app.jm.JM2s', 'com.xws.engine.app.jm.JM2i', '/home/junjie/cache/index/jm/0', 'select business_code f_code,business_name f_name,process_url f_url,fee f_fee,sub_business_name f_sub_name,business_desc f_desc,business_index f_index,business_keywords f_keywords,f_box_url,f_box_boost from x_o_jm_b', 'http://10.32.238.217:8000/web/ws/RobotService/', '<font color="red"><b>', '</b></font>', 1, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (4, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'xws', 'xws', 'com.xws.engine.app.zt.ZT0s', 'com.xws.engine.app.zt.ZT0i', '/home/junjie/cache/index/zt', 'select * from X_O_ZT_0_B', 'http://10.32.238.217:8002/wap/ws/RobotService/', '<font color="red"><b>', '</b></font>', 1, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (5, 1, 'jdbc:oracle:thin:@localhost:1521:XE
', 'system', 'Hell0', 'com.xws.engine.app.wc.WC0s', 'com.xws.engine.app.wc.WC0i', '/home/junjie/cache/index/wc', 'select * from X_SRC_DATA_B_WC', 'http://10.32.238.217:8002/wap/ws/RobotService/', null, null, 0, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (3, 2, 'jdbc:oracle:thin:@localhost:1521:XE', 'system', 'Hell0', 'com.xws.engine.app.jm.JM1s', 'com.xws.engine.app.jm.JM1i', '/home/junjie/cache/index/jm/1', 'select f_code,f_stage_name f_name, f_stage_desc f_desc,f_stage_online_date f_online_date, f_stage_offline_date f_offline_date,f_city,f_url from x_src_jm_a', 'http://10.32.238.217:8000/web/ws/RobotService/', '<font color="red"><b>', '</b></font>', 0, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (8, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'xws', 'xws', 'com.xws.engine.app.jm.JM2s', 'com.xws.engine.app.jm.JM2i', '/home/junjie/cache/index/jm/2', 'select business_code f_code,business_name f_name,process_url f_url,fee f_fee,sub_business_name f_sub_name,business_desc f_desc,business_index f_index,business_keywords f_keywords,f_box_url,f_box_boost from x_o_jm_b', null, '<font color="red"><b>', '</b></font>', 1, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (6, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'xws', 'xws', 'com.xws.engine.app.sc.SH0s', 'com.xws.engine.app.sc.SH0i', '/home/junjie/cache/index/sc/sh/0', 'select * from x_src_data_b_sc_sh where status=1 and checkstatus=1 and del_flag=0 and instr(sale_channel,''01'')>0', null, null, null, 0, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (7, 1, 'jdbc:oracle:thin:@localhost:1521:XE', 'xws', 'xws', 'com.xws.engine.app.sc.ZD0s', 'com.xws.engine.app.sc.ZD0i', '/home/junjie/cache/index/sc/zd/0', 'select * from X_O_SC_ZD_B', null, null, null, 0, 0);

insert into x_src_config (F_SYS_ID, F_CAT_ID, F_URL, F_USERNAME, F_PASSWORD, F_SCH_CLASS, F_IDX_CLASS, F_IDX_DIR, F_DST_TABLE, F_I8_URL, F_HIGHLIGHT_BEGIN, F_HIGHLIGHT_END, F_NEED_SPELLER, F_DISABLED)
values (6, 2, 'jdbc:oracle:thin:@localhost:1521:XE', 'xws', 'xws', 'com.xws.engine.app.sc.SH0s', 'com.xws.engine.app.sc.SH0i', '/home/junjie/cache/index/sc/sh/1', 'select * from x_src_data_b_sc_sh where status=1 and checkstatus=1 and del_flag=0 and instr(sale_channel,''02'')>0', null, null, null, 0, 0);

commit -- end of x_src_config --

-- import x_system --
insert into x_system (F_SYS_ID, F_SYS_NAME)
values (2, '网厅');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (1, '短信营业厅');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (3, '简洁门户');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (4, '掌厅');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (5, '网络爬虫');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (8, 'NEW VERSION');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (7, '终端商城');

insert into x_system (F_SYS_ID, F_SYS_NAME)
values (6, '上海商城');

commit -- end of x_system --

-- import x_category --
insert into x_category (F_CAT_ID, F_CAT_NAME)
values (2, '活动');

insert into x_category (F_CAT_ID, F_CAT_NAME)
values (1, '业务');

commit -- end of x_category --


-- import x_users --
insert into x_users (F_LOGIN_NAME, F_LOGIN_PWD, F_USER_NAME, F_USER_GROUP, F_MAIL, F_USER_STATE, F_TEL, F_SYS_ID)
values ('sysadmin', 'Hell0', '系统管理员', '1', 'JS', 1, null, 0);

insert into x_users (F_LOGIN_NAME, F_LOGIN_PWD, F_USER_NAME, F_USER_GROUP, F_MAIL, F_USER_STATE, F_TEL, F_SYS_ID)
values ('dtadmin', '888888', 'whn', '2', 'JS', 1, null, 1);

commit -- end of x_users --
