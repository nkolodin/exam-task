create sequence student_seq start 1;

create table if not exists student
(

    id         bigint      not null default (nextval('student_seq')),
    first_name      varchar(20),
    last_name varchar(20),
    middle_name varchar(20),
    speciality varchar(20),
    course int
);

alter table student
    add constraint student_id_pk primary key (id);

alter table student
    add constraint student_id_uq unique (id);

comment on table  student is 'Носки';
comment on column student.id is 'id';
comment on column student.first_name  is 'имя';
comment on column student.last_name is 'фамилия';
comment on column student.middle_name is 'отчество';
comment on column student.course is 'курс';
comment on column student.speciality is 'специальность';
