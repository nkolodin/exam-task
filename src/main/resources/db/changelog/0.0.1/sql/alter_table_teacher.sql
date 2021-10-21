create sequence teacher_seq start 1;

create table if not exists teacher
(

    id         bigint      not null default (nextval('teacher_seq')),
    first_name      varchar(20),
    last_name varchar(20),
    middle_name varchar(20),
    department int

);

alter table teacher
    add constraint  teacher_id_pk primary key (id);

alter table teacher
    add constraint teacher_id_uq unique (id);

comment on table  teacher is 'Учитель';
comment on column teacher.id is 'id';
comment on column teacher.first_name  is 'имя';
comment on column teacher.last_name is 'фамилия';
comment on column teacher.middle_name is 'отчество';
comment on column teacher.department is 'кафедра';
