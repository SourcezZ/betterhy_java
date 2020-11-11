/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/9/25 17:55:22                           */
/*==============================================================*/


drop table if exists admin_menu;

drop table if exists admin_permission;

drop table if exists admin_role;

drop table if exists admin_role_menu;

drop table if exists admin_role_permission;

drop table if exists oa_auth_jnl;

drop table if exists oa_business;

drop table if exists oa_holiday;

drop table if exists oa_leave;

drop table if exists oa_payment;

drop table if exists oa_rank;

drop table if exists oa_signin;

drop table if exists oa_signin_config;

drop table if exists oa_signin_later;

drop table if exists oa_user;

drop table if exists oa_user_rank;

drop table if exists oa_workday;

/*==============================================================*/
/* Table: admin_menu                                            */
/*==============================================================*/
create table admin_menu
(
   MENU_ID              varchar(64) not null comment '菜单ID',
   NAME                 varchar(64) comment '名称',
   PARENT_ID            varchar(64) not null comment '父菜单ID',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (MENU_ID)
);

alter table admin_menu comment '系统菜单表';

/*==============================================================*/
/* Table: admin_permission                                      */
/*==============================================================*/
create table admin_permission
(
   PERMISSION_ID        varchar(64) not null comment '菜单ID',
   NAME                 varchar(64) comment '名称',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (PERMISSION_ID)
);

alter table admin_permission comment '系统功能权限表';

/*==============================================================*/
/* Table: admin_role                                            */
/*==============================================================*/
create table admin_role
(
   ROLE_ID              varchar(64) not null comment '菜单ID',
   NAME                 varchar(64) comment '名称',
   ENABLED              int not null default 1 comment '是否可用 0-否 1-是',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (ROLE_ID)
);

alter table admin_role comment '系统角色表';

/*==============================================================*/
/* Table: admin_role_menu                                       */
/*==============================================================*/
create table admin_role_menu
(
   ROLE_ID              varchar(64) not null comment '角色ID',
   MENU_ID              varchar(64) not null comment '菜单ID',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (ROLE_ID, MENU_ID)
);

alter table admin_role_menu comment '系统角色菜单映射表';

/*==============================================================*/
/* Table: admin_role_permission                                 */
/*==============================================================*/
create table admin_role_permission
(
   ROLE_ID              varchar(64) not null comment '角色ID',
   PERMISSION_ID        varchar(64) not null comment '权限ID',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (ROLE_ID, PERMISSION_ID)
);

alter table admin_role_permission comment '系统角色权限映射表';

/*==============================================================*/
/* Table: oa_auth_jnl                                           */
/*==============================================================*/
create table oa_auth_jnl
(
   AUTH_ID              bigint unsigned not null auto_increment comment '审核ID',
   APPLY_ID             bigint not null comment '申请ID',
   APPLY_TYPE           int not null comment '0-补卡 1-请假 2-外出 3-报销',
   USER_ID              int not null comment '用户ID',
   USERNAME             varchar(64) not null comment '用户名称',
   AUTH_USER_ID         int comment '审核人ID',
   AUTH_USERNAME        varchar(64) comment '审核人名称',
   AUTH_STATUS          int not null default 0 comment '0-未审批 1-已审批 2-已拒绝',
   AUTH_REMARK          varchar(255) comment '审核意见',
   AUTH_DATE            datetime comment '审核日期',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (AUTH_ID)
);

alter table oa_auth_jnl comment '审核流水表';

/*==============================================================*/
/* Table: oa_business                                           */
/*==============================================================*/
create table oa_business
(
   BUSINESS_ID          bigint unsigned not null auto_increment comment '外出ID',
   USER_ID              int not null comment '用户ID',
   USERNAME             varchar(64) not null comment '用户名称',
   BUSINESS_BEGIN_DATE  date not null comment '外出开始时间',
   BUSINESS_END_DATE    date not null comment '外出结束时间',
   BEGIN_DATE_TYPE      int not null comment '开始日期类型',
   END_DATE_TYPE        int not null comment '结束日期类型',
   BUSINESS_PLACE       varchar(64) comment '外出地点',
   REMARK               varchar(255) comment '备注',
   AUTH_STATUS          int not null default 0 comment '0-未审批 1-已审批 2-已拒绝',
   APPLY_TIME           datetime not null default CURRENT_TIMESTAMP comment '申请日期',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (BUSINESS_ID)
);

alter table oa_business comment '出差申请表';

/*==============================================================*/
/* Table: oa_holiday                                            */
/*==============================================================*/
create table oa_holiday
(
   ID                   int not null auto_increment comment 'ID',
   HOLIDAY_NAME         varchar(64) comment '节日名称',
   HOLIDAY_DATE         date not null comment '节日日期',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (ID)
);

alter table oa_holiday comment '节日表';

/*==============================================================*/
/* Table: oa_leave                                              */
/*==============================================================*/
create table oa_leave
(
   LEAVE_ID             bigint unsigned not null auto_increment comment '请假ID',
   USER_ID              int not null comment '用户ID',
   USERNAME             varchar(64) not null comment '用户名称',
   LEAVE_BEGIN_DATE     date not null comment '请假开始时间',
   LEAVE_END_DATE       date not null comment '请假结束时间',
   BEGIN_DATE_TYPE      int not null comment '开始日期类型',
   END_DATE_TYPE        int not null comment '结束日期类型',
   REMARK               varchar(255) comment '备注',
   AUTH_STATUS          int not null default 0 comment '0-未审批 1-已审批 2-已拒绝',
   APPLY_TIME           datetime not null default CURRENT_TIMESTAMP comment '申请时间',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (LEAVE_ID)
);

alter table oa_leave comment '请假申请表';

/*==============================================================*/
/* Table: oa_payment                                            */
/*==============================================================*/
create table oa_payment
(
   PAYMENT_ID           bigint unsigned not null auto_increment comment '报销ID',
   USER_ID              int not null comment '用户ID',
   USERNAME             varchar(64) not null comment '用户名称',
   PAYMENT_TYPE         varchar(64) not null comment '报销类别 1差旅费 2市内交通 3住宿 4邮递 5培训及教育职工经费 6咨询费 7会议费 8员工福利费 9租车费 10停车费 11网络通讯费 12办公费 13电脑维修费 14其他',
   AMOUNT               decimal(8,2) not null comment '报销金额（最长8位）',
   PAYMENT_REMARK       varchar(64) not null comment '报销事由',
   REMARK               varchar(255) comment '备注',
   BILL_TYPE            int not null comment '发票类型 0纸质发票 1电子发票',
   BILL_CODE            varchar(64) comment '发票代码',
   BILL_NUM             varchar(64) comment '发票号码',
   VEHICLE_TYPE         varchar(64) comment '交通工具 1火车 2飞机 3轮船 4出租车 5公交 6地铁',
   START_PLACE          varchar(64) comment '起始点',
   END_PLACE            varchar(64) comment '目的地',
   CREATE_DATE          datetime comment '乘车时间',
   CHECK_IN_TIME        datetime comment '入住时间',
   LEAVE_TIME           datetime comment '离开时间',
   AUTH_STATUS          int not null default 0 comment '0-未审批 1-已审批 2-已拒绝',
   APPLY_TIME           datetime not null default CURRENT_TIMESTAMP comment '申请日期',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (PAYMENT_ID)
);

alter table oa_payment comment '报销申请表';

/*==============================================================*/
/* Table: oa_rank                                               */
/*==============================================================*/
create table oa_rank
(
   RANK_ID              int not null comment '角色ID',
   RANK_NAME            varchar(64) not null comment '职位名称',
   RANK_LEVEL           int not null comment '职位等级',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (RANK_ID)
);

alter table oa_rank comment '职级表';

/*==============================================================*/
/* Table: oa_signin                                             */
/*==============================================================*/
create table oa_signin
(
   SIGNIN_ID            bigint unsigned not null auto_increment comment '签到ID',
   USER_ID              int not null comment '用户ID',
   USERNAME             varchar(64) not null comment '用户名称',
   LATITUDE             varchar(64) comment '纬度',
   LONGITUDE            varchar(64) comment '经度',
   SIGNIN_PLACE         varchar(64) comment '打卡地点',
   SIGNIN_TIME          datetime comment '打卡时间',
   SIGNIN_STATUS        int comment '打卡状态 0-打卡成功 1-请假 2-出差 3-迟到/早退',
   SIGNIN_TYPE          int not null comment '打卡类型 0-上班 1-下班',
   SIGNIN_DATE          date not null comment '打卡日期',
   APPLY_ID             bigint comment '申请ID',
   APPLY_TYPE           int comment '申请类型 0-补卡 1-请假 2-外出 3-报销',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (SIGNIN_ID)
);

alter table oa_signin comment '考勤表';

/*==============================================================*/
/* Table: oa_signin_config                                      */
/*==============================================================*/
create table oa_signin_config
(
   DEPT_ID              int not null comment '机构号',
   LONGITUDE            varchar(64) not null comment '经度',
   LATITUDE             varchar(64) not null comment '纬度',
   SIGNIN_RANGE         int not null comment '打卡半径',
   ON_TIME              varchar(64) not null comment '早卡时间',
   OFF_TIME             varchar(64) not null comment '晚卡时间',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (DEPT_ID)
);

alter table oa_signin_config comment '签到配置表';

/*==============================================================*/
/* Table: oa_signin_later                                       */
/*==============================================================*/
create table oa_signin_later
(
   SIGNIN_LATER_ID      bigint unsigned not null auto_increment comment '补卡ID',
   USER_ID              int not null comment '用户ID',
   USERNAME             varchar(64) not null comment '用户名称',
   SIGNIN_LATER_DATE    date not null comment '补卡日期',
   DATE_TYPE            int not null comment '日期类型',
   REMARK               varchar(255) comment '备注',
   AUTH_STATUS          int not null default 0 comment '0-未审批 1-已审批 2-已拒绝',
   APPLY_TIME           datetime not null default CURRENT_TIMESTAMP comment '申请时间',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (SIGNIN_LATER_ID)
);

alter table oa_signin_later comment '补卡申请表';

/*==============================================================*/
/* Table: oa_user                                               */
/*==============================================================*/
create table oa_user
(
   USER_ID              int not null auto_increment comment '用户ID',
   OPEN_ID              varchar(64) comment '微信ID',
   USERNAME             varchar(64) comment '用户名称',
   PASSWORD             varchar(255) not null comment '密码',
   PHONE                varchar(64) comment '手机号',
   EMAIL                varchar(64) comment '电子邮箱',
   ROLE_ID              varchar(64) not null comment '角色ID',
   RANK_ID              int not null comment '职位ID',
   STATUS               int not null default 1 comment '用户状态 0不正常 1正常',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (USER_ID)
);

alter table oa_user comment '用户表';

/*==============================================================*/
/* Table: oa_user_rank                                          */
/*==============================================================*/
create table oa_user_rank
(
   USER_ID              int not null comment '用户ID',
   RANK_ID              int not null comment '职级ID',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (USER_ID, RANK_ID)
);

alter table oa_user_rank comment '用户职级表';

/*==============================================================*/
/* Table: oa_workday                                            */
/*==============================================================*/
create table oa_workday
(
   ID                   int not null auto_increment comment 'ID',
   WORK_NAME            varchar(64) comment '调休名称',
   WORK_DATE            date not null comment '调休日期',
   CREATE_TIME          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   UPDATE_TIME          datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (ID)
);

alter table oa_workday comment '调休工作日表';

