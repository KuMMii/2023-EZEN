insert into scott.booklist(subject, makeyear, inprice, rentprice, grade)
values('Harrypotter',2002,15000,2500,'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('Sherlock Holmes', 1852,10000,4000,'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('아몬드', 2018,14000,3000,'13');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('Big Picture', 2008,11500,2000,'18');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('가면산장 살인사건', 2017,18000,2000,'18');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('이것이 자바다', 2020,20000,8000,'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('그 환자', 2020,13000,2000,'13');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('살인자의 기억법', 2009,12000,2000,'18');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('구의 증명', 2017,18000,5000,'13');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('눈사람 아저씨', 2000,20000,8000,'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) 
values('눈사람 자살사건', 2018,11000,1000,'all');

insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('재롱이','010-1111-1111', '18/04/01',200,5,'F');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('김꾸미','010-2222-2222', '16/04/20',3000,7,'M');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('한여진','010-7777-7777', '94/12/28',2000,30,'F');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('황시목','010-3333-3333', '90/04/10',200,34,'M');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('이연재','010-4444-4444', '99/10/28',200,5,'F');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('서동재','010-5555-5555', '85/05/05',1200,39,'M');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('최주환','010-5353-5353', '92/07/11',220,32,'M');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('강조지','010-1111-1122', '94/08/01',2200,30,'F');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('도라에몽','010-3333-1111', '18/04/23',200,5,'M');
insert into scott.memberlist(name, phone, birth, bpoint, age, gender)
values('장군이','010-5656-0000', '18/04/01',5200,5,'F');

insert into scott.rentlist(bnum,mnum,discount) values(3,2,100);
insert into scott.rentlist(bnum,mnum,discount) values(1,3,100);
insert into scott.rentlist(bnum,mnum,discount) values(2,4,100);
insert into scott.rentlist(bnum,mnum,discount) values(4,5,100);
insert into scott.rentlist(bnum,mnum,discount) values(5,6,100);
insert into scott.rentlist(bnum,mnum,discount) values(5,1,100);
insert into scott.rentlist(bnum,mnum,discount) values(7,4,100);
insert into scott.rentlist(bnum,mnum,discount) values(6,10,100);
insert into scott.rentlist(bnum,mnum,discount) values(9,9,100);
insert into scott.rentlist(bnum,mnum,discount) values(10,10,100);
insert into scott.rentlist(bnum,mnum,discount) values(11,1,100);

select*from memberlist;
select*from booklist;
select*from rentlist;