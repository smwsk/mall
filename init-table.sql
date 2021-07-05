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

/*管理用户表*/
create table admin_user
(
  tid varchar(32) not null comment '主键id',
  username varchar (32) not null comment '用户名',
  password varchar (32) not null comment '密码',
  status int comment '用户状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)comment = '管理用户表';

/*管理用户登录凭证表*/
create table admin_user_token
(
  tid bigint(20) not null comment '主键id',
  token varchar (32) not null comment '登录凭证',
  expire_time datetime not null comment '过期时间',
  `create_datetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)comment ='管理用户登录凭证表';

/*后台管理角色表*/
create table admin_role(
 `admin_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
 `admin_role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
 `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
  PRIMARY KEY (admin_role_id)
) comment= '后台管理角色表';

/*admin用户角色表*/
create table admin_user_role(
  `admin_user_id` bigint(20) DEFAULT NULL COMMENT '管理用户ID',
  `admin_role_id` bigint(20) DEFAULT NULL COMMENT '管理角色ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)COMMENT='admin用户角色表';

/*admin用户菜单表*/
create table admin_user_menu(
  `admin_menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_menu_name` bigint(20) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   primary key (admin_menu_id)
)COMMENT='admin用户菜单表';

/*admin用户角色菜单表*/
create table admin_user_role_menu(
  `admin_menu_id` bigint(20) NOT NULL NULL COMMENT '菜单id',
  `admin_role_id` bigint(20) DEFAULT NULL COMMENT '菜单名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)COMMENT='admin用户角色菜单表';

/*前端或app用户表*/
create table app_user
(
  tid varchar(32) not null comment '主键id',
  username varchar (32) not null comment '用户名',
  password varchar (32) not null comment '密码',
  status int comment '用户状态',
  create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)

/*app用户登录凭证表*/
create table app_user_token
(
  tid bigint(20) not null comment '主键id',
  token varchar (32) not null comment '登录凭证',
  expire_time datetime not null comment '过期时间',
  create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

