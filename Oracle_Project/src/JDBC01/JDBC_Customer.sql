create table customer(
	num number(3),
	name varchar2(10),
	email varchar2(20),
	tel varchar2(15)
);

insert into customer values(1,'홍길동', 'abc1@abc.com','010-1234-2334');
insert into customer values(2,'홍길서', 'abc2@abc.com','010-2234-2334');
insert into customer values(3,'홍길남', 'abc3@abc.com','010-3234-2334');
insert into customer values(4,'홍길북', 'abc4@abc.com','010-4234-2334');
insert into customer values(5,'홍길아', 'abc5@abc.com','010-5234-2334');

select*from customer;

commit