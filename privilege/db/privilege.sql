/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/3/2 18:47:56                            */
/*==============================================================*/


drop table if exists privilege;

drop table if exists role;

drop table if exists role_privilege;

drop table if exists user;

drop table if exists user_role;

/*==============================================================*/
/* Table: privilege                                             */
/*==============================================================*/
create table privilege
(
   privilegeID          int not null auto_increment,
   privilegePID 		int,
   privilegeName        varchar(50),
   url                  varchar(50),
   icon                 varchar(50),
   orderNumber          int,
   primary key (privilegeID)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   roleID               int not null auto_increment,
   roleName             varchar(50),
   roleDesc             varchar(50),
   primary key (roleID)
);

/*==============================================================*/
/* Table: role_privilege                                        */
/*==============================================================*/
create table role_privilege
(
   roleID               int not null,
   privilegeID          int not null,
   primary key (roleID, privilegeID)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userID               int not null auto_increment,
   username             varchar(50),
   password             varchar(50),
   primary key (userID)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   roleID               int not null,
   userID               int not null,
   primary key (roleID, userID)
);

alter table role_privilege add constraint FK_privilege_role_fk foreign key (privilegeID)
      references privilege (privilegeID) on delete restrict on update restrict;

alter table role_privilege add constraint FK_role_privilege_fk foreign key (roleID)
      references role (roleID) on delete restrict on update restrict;

alter table user_role add constraint FK_role_fk foreign key (roleID)
      references role (roleID) on delete restrict on update restrict;

alter table user_role add constraint FK_user_fk foreign key (userID)
      references user (userID) on delete restrict on update restrict;

