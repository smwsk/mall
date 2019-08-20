/*商品表*/
create table product_info
(
   product_id           varchar(32) not null comment '主键',
   product_name         varchar(128) comment '商品名称',
   product_price        decimal(8,2) comment '商品价格',
   product_stock        int comment '商品库存',
   product_description  varchar(128) comment '商品描述',
   product_icon         text comment '商品主图',
   product_status       tinyint(3) comment '商品状态',
   product_type         int comment '类别编号',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (product_id)
);
alter table product_info comment '商品信息表';

/*==============================================================*/
/* Table: product_image_info 产品图片表                           */
/*==============================================================*/
create table product_image_info
(
   tid                  varchar(32) not null comment '主键Id',
   image_url            text comment '图片地址',
   product_id           varchar(32) comment '产品id',
   image_index          int comment '图片的位置',
   is_main_image        tinyint(1) comment '是否为主图',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (tid)
);

alter table product_image_info comment '产品图片表';



