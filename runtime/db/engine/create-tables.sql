/* TABLES:
	1)	x_src_config 
	2)	x_system
	3)	x_category 
	4)	x_users
	5)	x_log
	6)	x_log_raw
	7)	x_log_raw_history
	8)	x_log_statistics
	9)	x_job_log
*/

-- create x_src_config --
create table X_SRC_CONFIG
(
  f_sys_id          NUMBER(4) not null,
  f_cat_id          NUMBER(4) not null,
  f_url             VARCHAR2(255) not null,
  f_username        VARCHAR2(50),
  f_password        VARCHAR2(50),
  f_sch_class       VARCHAR2(255),
  f_idx_class       VARCHAR2(255),
  f_idx_dir         VARCHAR2(255) not null,
  f_dst_table       VARCHAR2(500) not null,
  f_i8_url          VARCHAR2(500),
  f_highlight_begin VARCHAR2(200),
  f_highlight_end   VARCHAR2(200),
  f_need_speller    NUMBER(1) default 0,
  f_disabled        NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table X_SRC_CONFIG
  add constraint X_SRC_CONFIG_PK primary key (F_SYS_ID, F_CAT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
/

-- create x_system --
create table X_SYSTEM
(
  f_sys_id   NUMBER(4) not null,
  f_sys_name VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table X_SYSTEM
  is '业务系统描述表';
comment on column X_SYSTEM.f_sys_id
  is '业务系统Id';
comment on column X_SYSTEM.f_sys_name
  is '业务系统名称';
alter table X_SYSTEM
  add constraint X_SYSTEM_PK primary key (F_SYS_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
/

-- create x_category -- 
create table X_CATEGORY
(
  f_cat_id   NUMBER(4) not null,
  f_cat_name VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table X_CATEGORY
  add constraint X_CATEGORY_PK primary key (F_CAT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
/

-- create x_users --
create table X_USERS
(
  f_login_name VARCHAR2(50) not null,
  f_login_pwd  VARCHAR2(50) not null,
  f_user_name  VARCHAR2(50),
  f_user_group VARCHAR2(50) not null,
  f_mail       VARCHAR2(100) not null,
  f_user_state NUMBER(1) not null,
  f_tel        VARCHAR2(20),
  f_sys_id     NUMBER(4)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column X_USERS.f_login_name
  is '登录名';
comment on column X_USERS.f_login_pwd
  is '登录密码';
comment on column X_USERS.f_user_name
  is '用户名';
comment on column X_USERS.f_user_group
  is '用户所属群组';
comment on column X_USERS.f_mail
  is '邮件地址';
comment on column X_USERS.f_user_state
  is '0-有效 1-禁用';
comment on column X_USERS.f_tel
  is '电话';
alter table X_USERS
  add constraint PK_USER primary key (F_LOGIN_NAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
/

-- create x_log --
create table X_LOG
(
  f_id                VARCHAR2(50) not null,
  f_status            NUMBER(4),
  f_query_text        VARCHAR2(200),
  f_parsed_query_text VARCHAR2(200),
  f_count             NUMBER(20) default 0,
  f_elapsed_millis    NUMBER(20) default 0,
  f_result_offset     NUMBER(10,2) default 0,
  f_result_text       VARCHAR2(500),
  f_begin_query       TIMESTAMP(6),
  f_end_query         TIMESTAMP(6),
  f_flag              NUMBER(1) default 0,
  f_sys_id            NUMBER(4),
  f_cat_id            NUMBER(4),
  f_utime             TIMESTAMP(6),
  f_total_hits        NUMBER(20,2),
  f_enabled           NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
comment on column X_LOG.f_id
  is '主键';
comment on column X_LOG.f_status
  is '状态码';
comment on column X_LOG.f_query_text
  is '搜索文本';
comment on column X_LOG.f_parsed_query_text
  is '解析后的搜索文本';
comment on column X_LOG.f_count
  is '搜索总次数';
comment on column X_LOG.f_elapsed_millis
  is '搜索耗费的时间(ms)';
comment on column X_LOG.f_result_offset
  is '搜索结果偏移量(1~N)';
comment on column X_LOG.f_result_text
  is '搜索结果文本';
comment on column X_LOG.f_begin_query
  is '最早搜索的日期';
comment on column X_LOG.f_end_query
  is '最后搜索的日期';
comment on column X_LOG.f_flag
  is '0:默认 1: 自动';
comment on column X_LOG.f_sys_id
  is '业务系统编号(忽略)';
comment on column X_LOG.f_cat_id
  is '业务系统分类编号(忽略)';
comment on column X_LOG.f_utime
  is '更新时间';
comment on column X_LOG.f_total_hits
  is '索引文档数';
comment on column X_LOG.f_enabled
  is '是否使用';
alter table X_LOG
  add constraint X_LOG_PK primary key (F_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
/

-- create x_log_raw --
create table X_LOG_RAW
(
  f_id_time        NUMBER(20) not null,
  f_id_machine     NUMBER(20) not null,
  f_id_inc         NUMBER(20) not null,
  f_class_name     VARCHAR2(100),
  f_status         NUMBER(4),
  f_query_text     VARCHAR2(200),
  f_total_hits     NUMBER(10),
  f_elapsed_millis NUMBER(20),
  f_result_offset  NUMBER(4),
  f_result_text    VARCHAR2(100),
  f_start_date     TIMESTAMP(6),
  f_end_date       TIMESTAMP(6),
  f_sys_id         NUMBER(4),
  f_cat_id         NUMBER(4),
  f_mobile         VARCHAR2(20),
  f_brand          VARCHAR2(20),
  f_city           VARCHAR2(20),
  f_utime          TIMESTAMP(6),
  f_start_page     INTEGER,
  f_page_size      INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 104M
    minextents 1
    maxextents unlimited
  );
comment on column X_LOG_RAW.f_id_time
  is '时间Id';
comment on column X_LOG_RAW.f_id_machine
  is '机器Id';
comment on column X_LOG_RAW.f_id_inc
  is '序号Id';
comment on column X_LOG_RAW.f_class_name
  is '日志类名';
comment on column X_LOG_RAW.f_status
  is '状态码 0-成功 2-搜索无结果 3-i8';
comment on column X_LOG_RAW.f_query_text
  is '搜索文本';
comment on column X_LOG_RAW.f_total_hits
  is '索引命中数';
comment on column X_LOG_RAW.f_elapsed_millis
  is '搜索耗费的毫秒数';
comment on column X_LOG_RAW.f_result_offset
  is '搜索结果偏移量';
comment on column X_LOG_RAW.f_result_text
  is '搜索结果文本';
comment on column X_LOG_RAW.f_start_date
  is '搜索开始时间';
comment on column X_LOG_RAW.f_end_date
  is '搜索结束时间';
comment on column X_LOG_RAW.f_sys_id
  is '业务系统Id';
comment on column X_LOG_RAW.f_cat_id
  is '业务系统分类Id';
comment on column X_LOG_RAW.f_mobile
  is '手机号';
comment on column X_LOG_RAW.f_brand
  is '用户所属品牌';
comment on column X_LOG_RAW.f_city
  is '用户所属地市';
comment on column X_LOG_RAW.f_utime
  is '更新时间戳';
comment on column X_LOG_RAW.f_start_page
  is '起始页码, 0为第一页';
comment on column X_LOG_RAW.f_page_size
  is '搜索结果分页大小';
alter table X_LOG_RAW
  add constraint X_LOG_RAW_PK primary key (F_ID_TIME, F_ID_MACHINE, F_ID_INC)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 24M
    minextents 1
    maxextents unlimited
  );
/

-- create x_log_raw_history --
create table X_LOG_RAW_HISTORY
(
  f_id_time        NUMBER(20) not null,
  f_id_machine     NUMBER(20) not null,
  f_id_inc         NUMBER(20) not null,
  f_class_name     VARCHAR2(100),
  f_status         NUMBER(4),
  f_query_text     VARCHAR2(200),
  f_total_hits     NUMBER(10),
  f_elapsed_millis NUMBER(20),
  f_result_offset  NUMBER(4),
  f_result_text    VARCHAR2(100),
  f_start_date     TIMESTAMP(6),
  f_end_date       TIMESTAMP(6),
  f_sys_id         NUMBER(4),
  f_cat_id         NUMBER(4),
  f_mobile         VARCHAR2(20),
  f_brand          VARCHAR2(20),
  f_city           VARCHAR2(20),
  f_utime          TIMESTAMP(6),
  f_start_page     INTEGER,
  f_page_size      INTEGER
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 88M
    minextents 1
    maxextents unlimited
  );
/

-- create x_log_statistics --
create table X_LOG_STATISTICS
(
  f_status  NUMBER(4) not null,
  f_count   NUMBER(10),
  f_elapsed NUMBER(10),
  f_begin   TIMESTAMP(6) not null,
  f_end     TIMESTAMP(6) not null,
  f_utime   TIMESTAMP(6) not null,
  f_sys_id  NUMBER(4) not null,
  f_cat_id  NUMBER(4) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column X_LOG_STATISTICS.f_status
  is '搜索状态码';
comment on column X_LOG_STATISTICS.f_count
  is '搜索次数';
comment on column X_LOG_STATISTICS.f_elapsed
  is '搜索消耗的总时间(m)';
comment on column X_LOG_STATISTICS.f_begin
  is '搜索的起始时间';
comment on column X_LOG_STATISTICS.f_end
  is '搜索的结束时间';
comment on column X_LOG_STATISTICS.f_utime
  is '更新时间';
comment on column X_LOG_STATISTICS.f_sys_id
  is '业务系统Id';
comment on column X_LOG_STATISTICS.f_cat_id
  is '业务系统分类Id';
alter table X_LOG_STATISTICS
  add constraint X_LOG_STATISTICS_PK primary key (F_STATUS, F_SYS_ID, F_CAT_ID, F_BEGIN, F_END)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
/

-- create x_job_log --
create table X_JOB_LOG
(
  f_code    INTEGER,
  f_text    VARCHAR2(4000),
  f_on      TIMESTAMP(6),
  f_by      VARCHAR2(100),
  f_what    VARCHAR2(50),
  f_elapsed LONG
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table X_JOB_LOG
  is 'Log the log analysing job. ';
comment on column X_JOB_LOG.f_code
  is 'SQLCODE';
comment on column X_JOB_LOG.f_text
  is 'SQLERRM';
comment on column X_JOB_LOG.f_on
  is 'Created on';
comment on column X_JOB_LOG.f_by
  is 'Create by';
comment on column X_JOB_LOG.f_what
  is 'WHAT';
comment on column X_JOB_LOG.f_elapsed
  is 'ELAPSED time';
/

