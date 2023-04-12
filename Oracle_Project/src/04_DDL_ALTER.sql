-- 04_DDL_ALTER.sql

--create table 테이블이름();
-- create user 유저이름 identified by 비번;

--alter table 테이블 이름 수정내용들
--alter user 유저이름 identified by 비번;

--1.필드명의 변경
--ALTER TABLE 테이블이름 RENAME COLUMN 변경전이름 TO 변경후이름
--테이블이름: 변경하고자하는 필드명이 있는 테이블의 이름



select*from booklist;
select*from booklist;
--booklist 테이블의 subject 필드명을 title로 수정
alter table booklist rename column subject to title

alter table booklist rename column title to subject

alter table booklist rename column outprice to rentprice

alter table memberlist rename column membername to name
alter table rentlist rename column rent_date to rentdate
alter table rentlist rename column indexk to numseq

alter table rentlist rename column bnum to booknum;
--create 로 테이블을 만들며 생성한 기본키와 외래키 등등은 필드명이 바뀌어도 설정되어 있는 
--기본키 외래키 속성이 그대로 바뀐 이름이 승계되어 자동적용됨
alter table rentlist rename column booknum to bnum;




--2.필드 자료형의 변경
--ALTER TABLE 테이블명 MODIFY 필드명 자료형. 디폴트값이나 제약사항도 함께 변경이 가능함
--varchar2(12)였던 memberlist 테이블의 name필드를 varchar2(30)으로 변경
alter table memberlist modify name varchar2(30);

alter table booklist modify booknum number(5); --수정실패
alter table memberlist modify membernum number(5); --수정실패
alter table rentlist modify bnum number(5); --수정실패
alter table rentlist modify mnum number(5); --수정실패

--외래키로 연결되어서 참조되고, 참조하고 있는 필드들은 위의 명령으로 수정이 바로 불가능
--가능하게 하려면, 외래키 제약 조건을 수정해 없애버리고, 참조되는 필드와 참조하는 필드를 모두 수정한 후 외래키 제약 조건을 다시 설정
--alter명령에 의해서 제약조건을 수정하는 명령을 아래에서 학습함

--3.필드의 추가
--ALTER TABLE 테이블명 ADD필드명 자료형
alter table booklist add grade varchar2(15);
alter table memberlist add gender varchar2(3);
alter table memberlist add age number(2);

select*from booklist;
select*from memberlist;
select*from rentlist;

--4.필드의 삭제
--ALTER TABLE 테이블명 DROP COLUMN 필드명
alter table memberlist drop column gender;
alter table booklist drop column grade;
alter table memberlist drop column age;

--5.제약조건의 추가/삭제

--필드 레벨의 제약조건 수정 ->modify명령을 통해서 수정/생성/삭제함
--생성
--check() :괄호안의 연산식의 결과가 true일때만 필드값으로 인정하고 입력받겠다는 제약조건 함수
alter table memberlist modify gender varchar2(3) check (gender in('F','M'));
--gender in('F','M') : gender필드값이 in 함수 안에 있는 값들일 때만 true를 결과로.
alter table memberlist modify gender varchar2(3) check (gender ='F' or gender='M'));
--원래대로
alter table memberlist modify gender varchar2(3);

--테이블레벨의 제약조건의 생성/삭제
--추가:ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건식
--테이블 level의 제약 조건은 위의 명령 형식으로 제약조건 이름과 함께 추가함

--memberlist 테이블의 성별 필드에 'F','M'두글자만 입력되도록 제약조건을 추가하기
alter table memberlist add constraint check_gender check(gender in('F', 'M'));

--memberlist테이블의 나이(age)필드에 120살이 초과되는 나이는 입력되지 못하게 제약조건 추가
--제약 조건명 :check_age
alter table memberlist add constraint check_age check(gender in(age<=120));


--삭제 : ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명
--rentlist테이블의 bnum에 걸려있는 외래키 제약조건 제거(fk1)
alter table rentlist drop constraint fk1;
--rentlist테이블의 mnum에 걸려있는 외래키 제약조건 제거(fk2)
alter table rentlist drop constraint fk2;

--rentlist 테이블의 기본키 제거 (rent_pk)
alter table rentlist drop constraint rentlist_pk;

--앞에서 필드 자료형 수정실패한 내용들 다시 실행
--booklist의 booknum필드를 number(5)로 자료형 변경
alter table booklist modify booknum number(5);
--memberlist의 membernum필드를 number(5)로 자료형 변경
alter table memberlist modify membernum number(5);
--rentlist의 bnum필드를 number(5)로 자료형 변경
alter table rentlist modify bnum number(5);
--rentlist의 mnum필드를 number(5)로 자료형 변경
alter table rentlist modify mnum number(5);
--rentlist의 기본키를 numseq로 설정
alter table rentlist add constraint rentlist_pk primary key(numseq);
--rentlist의 외래키 fk1, fk2 재설정

alter table rentlist add constraint fk1 foreign key(bnum) references booklist(booknum);
alter table rentlist add constraint fk2 foreign key(mnum) references memberlist(membernum);

create table orders1(
order_id number(12,0),
order_date date,
order_mode varchar2(8),
custormer_id number(6,0),
order_status number(2,0),
order_total number(8,2) default 0,
sales_rep_id number(6,0),
promotion_id number(6,0),

constraint pk_order primary key(order_id),
constraint order_mode check(order_mode in('direct','online'))

);

--테이블 수정 ex
--customer_id 필드명을 customer_number로 수정
--promotion_id값은 10000~99999 사이의 값만 저장 가능
alter table orders1 rename column custormer_id to customer_number;
alter table orders1 add constraint check_pro check(promotion_id between 10000 and 99999);

--테이블의 복사
create table orders2 as select*from orders1;
select*from orders2;
--as select 구문은 select 구문 이후에 다시 학습함

--테이블의 제거
drop table orders2 purge; --purge생략가능
--purge가 없이 삭제된 테이블은 나중에 휴지통과 같이 복구가 가능
--purge 사용하면 완전 삭제



