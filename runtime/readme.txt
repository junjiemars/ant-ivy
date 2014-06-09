1) 数据库配置
a. 表X_SRC_CONFIG
f_sys_id: 对应X_SYSTEM.f_sys_id,唯一性;
f_cat_id: 对应X_CATEGORY.f_cat_id,唯一性;
f_url: Oracle数据源的url;
f_username/f_password: Oracle数据源的用户名/密码;
f_sch_class/f_idx_class: 搜索/索引的class名称;
f_idx_dir: 索引存放路径;
f_dst_table: 数据源的查询语句;
f_disabled: 禁用标识,1为禁用;

2) Web.xml配置
a. dbOption配置数据库连接选项：
minLimit: Oracle数据库连接池的最小连接数;
maxLimit: Oracle数据库连接池的最大连接数;
例如：
{"user":"xws","password":"xws","url":"jdbc:oracle:thin:@localhost:1521/XE","minLimit":2,"maxLimit":10}

3) i8地址
http://10.32.238.217:8001/dev/AskAction?
