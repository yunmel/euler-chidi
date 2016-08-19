/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/8/18 9:08:49                            */
/*==============================================================*/


drop table if exists PRODUCT_SCRIPT;

/*==============================================================*/
/* Table: PRODUCT_SCRIPT                                        */
/*==============================================================*/
create table PRODUCT_SCRIPT
(
   SCRIPT_ID            varchar(64) not null comment '脚本ID',
   PRODUCT_ID           varchar(64) not null comment '产品ID',
   PRODUCT_SCRIPT       text not null comment '脚本内容',
   primary key (SCRIPT_ID)
);

alter table PRODUCT_SCRIPT comment '产品脚本表';

