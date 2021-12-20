
create table if not exists attribute
(
    id         bigint auto_increment
        primary key,
    maximum    bigint       null,
    minimum    bigint       null,
    mutability varchar(255) null,
    name       varchar(255) not null,
    supported  varchar(255) null,
    writable   varchar(255) null,
    step       bigint       null,
    state       longtext     null,
    created_at  datetime     null,
    modified_at datetime     null
);

create table if not exists capability
(
    id          bigint auto_increment
        primary key,
    created_at  datetime     null,
    modified_at datetime     null,
    name        varchar(255) not null
);

create table if not exists capability_attribute
(
    id            bigint auto_increment
        primary key,
    created_at    datetime null,
    modified_at   datetime null,
    attribute_id  bigint   null,
    capability_id bigint   null
);

create table if not exists device_type
(
    id          bigint auto_increment
        primary key,
    created_at  datetime     null,
    modified_at datetime     null,
    name        varchar(255) not null,
    code        varchar(255) not null
);

create table if not exists device_type_capability
(
    id             bigint auto_increment
        primary key,
    created_at     datetime null,
    modified_at    datetime null,
    capability_id  bigint   null,
    device_type_id bigint   null
);

create table if not exists user_device
(
    id          bigint auto_increment
        primary key,
    created_at  datetime     null,
    modified_at datetime     null,
    name        varchar(255) null,
    reachable   bit          not null,
    user_id     bigint       not null
);

