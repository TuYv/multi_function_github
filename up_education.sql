create table school
        (
        id                 int auto_increment
        primary key,
        code               varchar(255)                       null comment '院校code',
        name               varchar(255)                       null comment '院校名称',
        subject_name       varchar(255)                       null comment '专业名称',
        exam_a             varchar(255)                       null comment '统考科目1',
        exam_b             varchar(255)                       null comment '统考科目2',
        subject_exam       varchar(255)                       null comment '专业综合科目',
        extend_exam        varchar(255)                       null comment '加试科目',
        exam_num_2024      varchar(255)                       null comment '2024报考人数',
        exam_pass_num_2024 varchar(255)                       null comment '2024录取人数',
        create_time        datetime default CURRENT_TIMESTAMP null comment '创建时间',
        update_time        datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
        deleted            tinyint  default 0                 null comment '是否删除'
        )
        comment '学院表';

        create table specialist_subject
        (
        id         int auto_increment
        primary key,
        class_name varchar(255) null comment '专业类名称',
        name       varchar(255) null comment '专业名称',
        code       varchar(255) null comment '专业code',
        class_code varchar(255) null comment '专业类code'
        )
        comment '专科专业表';

        create table subject
        (
        id          bigint                             not null
        primary key,
        code        varchar(255)                       null comment '专业code',
        name        varchar(255)                       null comment '专业名称',
        type        tinyint(1)                         null comment '专业类型(1-专科, 2-本科)',
        create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
        update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
        deleted     tinyint(1)                         null comment '是否删除(1-已删除0-未删除)'
        )
        comment '专业表';

        create table subject_mapping
        (
        id                 int auto_increment
        primary key,
        undergraduate_code varchar(255)                       null comment '本科专业类code',
        undergraduate_name varchar(255)                       null comment '本科专业类名称',
        specialist_code    varchar(255)                       null comment '专科专业类code',
        specialist_name    varchar(255)                       null comment '专科专业类名称',
        create_time        datetime default CURRENT_TIMESTAMP null comment '创建时间',
        update_time        datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
        deleted            tinyint                            null comment '是否删除'
        )
        comment '专业mapping表';

        create table undergraduate_school_mapping
        (
        id                         int auto_increment
        primary key,
        undergraduate_class_code   varchar(255)                       null comment '本科专业类code',
        undergraduate_class_name   varchar(255)                       null comment '本科专业类名称',
        undergraduate_subject_code varchar(255)                       null comment '本科专业code',
        undergraduate_subject_name varchar(255)                       null comment '本科专业名称',
        undergraduate_school_name  varchar(255)                       null comment '本科院校',
        create_time                datetime default CURRENT_TIMESTAMP null comment '创建时间',
        update_time                datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
        deleted                    tinyint                            null comment '是否删除'
        )
        comment '专业院校mapping表';

        create table undergraduate_subject
        (
        id   int auto_increment
        primary key,
        code varchar(255) null comment '代码',
        name varchar(255) null comment '名称'
        )
        comment '本科专业表';

        create table user
        (
        id          bigint auto_increment
        primary key,
        name        varchar(255)                       null comment '用户名',
        nick_name   varchar(255)                       null comment '昵称',
        create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
        update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
        deleted     tinyint(1)                         null comment '是否删除(1-已删除,0-未删除)'
        );

