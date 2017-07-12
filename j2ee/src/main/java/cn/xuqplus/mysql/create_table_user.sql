show databases;

create database mydb default character set utf8;

use mydb;

show create table mydb.user;

drop table user;
CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `user_id` varchar(20) NOT NULL,
   `user_name` varchar(20) NOT NULL,
   `user_email` varchar(20) NOT NULL,
   `user_password` varchar(20) NOT NULL,
   `account_state` varchar(20),
   `login_state` varchar(20),
   PRIMARY KEY (`id`),
   UNIQUE KEY `user_id_UNIQUE` (`user_id`),
   UNIQUE KEY `user_name_UNIQUE` (`user_name`),
   UNIQUE KEY `user_email_UNIQUE` (`user_email`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 select * from user;
 insert into user values(1, 'xuqplus', '许小群', '445172495@qq.com', '123123', '', '');

grant all privileges on *.* to 'root'@'%' identified by 'wayout';
grant all privileges on *.* to 'centos'@'%' identified by 'wayout';
grant all privileges on *.* to 'xuqplus'@'%' identified by 'wayout';
