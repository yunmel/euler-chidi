/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/8/8 9:08:49                            */
/*==============================================================*/


drop table if exists CHIDI_PRODUCT_SCRIPT;

/*==============================================================*/
/* Table: CHIDI_PRODUCT_SCRIPT                                  */
/*==============================================================*/
create table CHIDI_PRODUCT_SCRIPT
(
   SCRIPT_ID            varchar(64) not null comment '脚本ID',
   PRODUCT_ID           varchar(64) not null comment '产品ID',
   SCRIPT_PATH          varchar(1024) comment '脚本路径',
   SCRIPT_NAME          varchar(1024) comment '脚本名称',
   primary key (SCRIPT_ID)
);

alter table CHIDI_PRODUCT_SCRIPT comment '产品脚本表';


drop table if exists CHIDI_PRODUCT_INSTANCE;

/*==============================================================*/
/* Table: CHIDI_PRODUCT_INSTANCE                                */
/*==============================================================*/
create table CHIDI_PRODUCT_INSTANCE
(
   INSTCNCE_ID          varchar(64) not null comment '产品实例ID',
   DEPENDENT_INSTANCE_INFO varchar(1024) comment '依赖产品实例信息,json格式',
   primary key (INSTCNCE_ID)
);

alter table CHIDI_PRODUCT_INSTANCE comment '产品实例表';



