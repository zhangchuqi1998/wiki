drop table if exists `test`;
create table `test` (
  `id` bigint not null comment 'id',
  `name` varchar(50) comment 'name',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='test';

drop table if exists `demo`;
create table `demo` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment 'name',
                        primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='test';

insert into `demo` (id, name) values (1, 'test');

drop table if exists `ebook`;
create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment 'name',
                         `category1_id` bigint comment 'category1',
                         `category2_id` bigint comment 'category2',
                         `description` varchar(200) comment 'description',
                         `cover` varchar(200) comment 'cover',
                         `doc_count` int not null default 0 comment 'document count',
                         `view_count` int not null default 0 comment 'view count',
                         `vote_count` int not null default 0 comment 'vote count',
                         primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='ebook';

insert into `ebook` (id, name, description) values (1, 'Spring Boot 入门教程', '零基础入门 Java 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (2, 'Vue 入门教程', '零基础入门 Vue 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (3, 'Python 入门教程', '零基础入门 Python 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (4, 'Mysql 入门教程', '零基础入门 Mysql 开发，企业级应用开发最佳首选框架');
insert into `ebook` (id, name, description) values (5, 'Oracle 入门教程', '零基础入门 Oracle 开发，企业级应用开发最佳首选框架');