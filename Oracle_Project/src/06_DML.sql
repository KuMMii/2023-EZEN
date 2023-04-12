--DML(Data Management Language)데이터 조작 언어

--테이블에 레코드를 조작(추가, 수정, 삭제, 조회)하기 위한 명령어들
--INSERT(추가)
--UPDATE(수정)
--DELETE(삭제)
--SELECT(조회 및 선택)


--[1]샘플 테이블 생성
drop table exam01 purge;

create table exam01(
deptno number(2), --위치
dname varchar2(14)  --부서명
loc varchar2(14)  --위치
);

--[2]레코드 추가
--레코드 추가 명령 사용1
--insert into 테이블이름(필드명1, 필드명2,...)values(값1, 값2 , ...)
--값은 문자('123')와 숫자(123)를 구분해 입력함

--레코드 추가 명령 사용2
--insert into 테이블 이름 values(전체 column(필드, 열)에 넣을 값들);

--첫번째 방식은 필드명과 입력되어야 하는 값을 1:1로 매핑해 입력함
-- null값이 있어도 되는 필드는 필드명, 또는 기본값이 있는 필드명은 필드명ㄱ과 값을 생략하고 입력가능함
--두번재 방식은 모든 필드에 해당하는 데이터를 모두 입력하는 경우로서 필드명들을 명령어 속에 나열하지 않아도 되지만,
--필드의 순서대로 빠짐없이 데이터가 나열되어야 하는 불편함도 있음

--첫번째 방식의 레코드 추가
insert into exam01(deptno, dname, loc) values(10,'ACCOUNT','NEW YORK');

--두번째 방식의 레코드 추가
insert into exam01 values(30,'SALES','CHICAGO');

--두가지 방법 모두 null값을 입력할 수 있음
insert into exam01(deptno, dname) values(20,'MARKETING'); --첫번째 방법
insert into exam01 values(40,'OPERATION',null);  --두번째 방법

select*from exam01;

select*from booklist;
--두가지 방법 중 자유롭게 선택해 booklist 테이블에 7개의 레코드를 추가하기
--booknum은 시퀀스를 이용함
--grade는 'all' '13, '18' 세가지만 골라서 입력하기. grade가 없으면 입력하지 않아도 됨

insert into booklist(booknum, subject, makeyear, inprice, rentprice, grade)
values(book_seq.nextVal, 'Harrypotter',2002,15000,2500,'all');
insert into booklist values(book_seq.nextVal, 'Sherlock Holmes', 1852,10000,4000,'all');
insert into booklist values(book_seq.nextVal, '아몬드', 2018,14000,3000,'13');
insert into booklist values(book_seq.nextVal, 'Big Picture', 2008,11500,2000,'18');
insert into booklist values(book_seq.nextVal, '가면산장 살인사건', 2017,18000,2000,'18');
insert into booklist values(book_seq.nextVal, '이것이 자바다', 2020,20000,8000,'all');
insert into booklist values(book_seq.nextVal, '그 환자', 2020,13000,2000,'13');

create sequence member_seq start with 1 increment by 1; 
select*from memberlist;
insert into memberlist(membernum, name, phone)
values(member_seq.nextVal, 'james','010-1111-1111');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '최주환', '010-3333-3333');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '양의지', '010-4444-4444');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '정수빈', '010-3131-3131');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '허경민', '010-1313-1313');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '김재호', '010-5252-5252');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '김재환', '010-3335-3333');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '오재원', '010-4441-4444');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '조수행', '010-3133-3131');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '류지혁', '010-1353-1313');
insert into memberlist (membernum, name, phone) values(member_seq.nextVal, '이승엽', '010-5452-5252');

create sequence rent_seq start with 1 increment by 1;
select*from memberlist;
select*from booklist;
select*from rentlist;
insert into rentlist values('2021/10/01',rent_seq.nextVal, 3,2,100);
insert into rentlist values('2023/01/11',rent_seq.nextVal, 1,3,100);
insert into rentlist values('2022/12/01',rent_seq.nextVal, 2,4,100);
insert into rentlist values('2021/04/01',rent_seq.nextVal, 4,5,100);
insert into rentlist values('2021/06/06',rent_seq.nextVal, 5,6,100);
insert into rentlist values('2022/04/14',rent_seq.nextVal, 6,1,100);
insert into rentlist values('2022/07/31',rent_seq.nextVal, 7,7,100);
insert into rentlist values('2022/06/16',rent_seq.nextVal, 8,8,100);
insert into rentlist values('2022/05/29',rent_seq.nextVal, 9,9,100);
insert into rentlist values('2022/04/22',rent_seq.nextVal, 10,10,100);
insert into rentlist values('2022/02/28',rent_seq.nextVal, 11,11,100);


--[3]데이터 변경 -수정(UPDATE)
--UPDATE 테이블명 SET 변경내용 WHERE검색 조건
--update memberlist set age=30 where membernum=3;

--명령문에 WHERE이후 구문은 생략이 가능함
--다만 이부분을 생략하면 모든 레코드를 대상으로 해서 UPDATE명령이 실행되어 모든 레코드가 수정됨
--검색조건:필드면(비교-관계연산자)조건값  으로 이루어진 조건연산이며, 흔히 자바에서 if()괄호안에 사용했던 연산 그대로 사용
--나이가 29세 이상 ->WHERE AGE>=29
select*from exam01;
update exam01 set deptno=40 where dname="ACCOUNT";
update exam01 set dNAME='OPERATION' where deptno=20;
update exam01 set dNAME='MARKETING' where deptno=30;

update exam01 set loc="BOSTON" where deptno='30';
update exam01 set loc="LA" where deptno='40';

update BOOKLIST set grade=18 where subject='The Giver';
select*from booklist;

select*from emp;
select*from dept;
select*from bonus;
select*from salgrade;
select*from RENTLIST;
--emp 테이블의 모든 사원의 sal 값을 10%씩 인상
update emp set sal=sal*1.1;
--emp 테이블에서 sal 값이 3000 이상인 사원의 급여 10% 삭감
update emp set sal=sal*0.9 where sal>=3000;
--emp테이블에서 hiredate가 2002년 이전인 사원의 급여를 +2000 ->(2001-12-31보다 작거나 같은)
update emp set sal=sal+2000 where hiredate<='2002-01-01';
--imp테이블의 ename이 j로 시작하는 사원의 job을 manager로 변경
update emp set job='manager' where ename like 'j%'; --j로 시작
update emp set job='manager' where ename like '%j';  --j로 끝나는
update emp set job='manager' where ename like '%j%';  --j가 포함된

--memberlist 테이블에서 bpoint가 200이 넘는 사람만 bpoint*100으로 변경
update MEMBERLIST set bpoint= bpoint*100 where bpoint>=200;
--rentlist 테이블에서 할인금액이 100원이 넘으면 모두 할인 금액을 90으로 변경
update rentlist set discount=90 where discount>=100;

--[4] 레코드의 삭제
--delete from 테이블명 where 조건식
--delete와from 사이에 *넣지 않음
--rentlist테이블에서 discount가 100이하인 레코드를 삭제
delete from rentlist where discount<=10;

--where 절이 없으면 테이블 내의 모든 레코드를 삭제함


--삭제의 제한
delete from booklist where booknum=2;
--2번 도서가 rentlist에 대여목록으로 존재하므로 삭제되면 외래키 참조 무결성에 위배됨. 그래서 에러뜸
select*from booklist;
select*from rentlist;
-- integrity constraint (SCOTT.FK1) violated - child record found ->외래키 참조 무결성에 위배돼서

--해결방법 #1
--이를 해결하려면 우선 rentlist 테이블에 해당 도서 대여목록 레코드를 모두 삭제한 후 booklist 테이블에서 해당 도서를 삭제
--delete from rentlist where bnum=2;
--delete from booklist where booknum=2;


--해결방법#2
--외래키 제약조건을 삭제한 후 다시 생성
--생성키에 "옵션을 추가해서" 참조되는 값이 삭제되면 참조하는 값도 같이 삭제되게 구성

--외래키 삭제
alter table rentlist drop constraint fk1;

--새로운 외래키 추가
alter table rentlist add constraint fk1 foreign key(bnum)
references booklist(booknum) on delete cascade;
--on delete cascade : booklist의 도서가 삭제되면 rentlist의 해당 도서 대여내욕도 함께 삭제하는 옵션


--memberlist 테이블에서 회원 한명을 삭제하면, rentlist테이블에서도 해당회원이 대여한 기록을 같이 삭제하도록
--외래키 설정 바꾸기(외래키 제약조건 삭제 후 재생성)
 alter table rentlist drop constraint fk2;
 
 alter table rentlist add constraint fk2 foreign key(mnum) 
 references memberlist(membernum) on delete cascade;

--참조되는 값의 삭제가 아니라 수정은 아직 적용되지 않음
--booklist 와 memberlist 테이블의 booknum, membernum은 수정이 아직 불가능함
--이를 해결하기 위해 외래키 설정시 on update cascade 옵션을 추가하면 될듯하지만
--이는 오라클에서 허용하지 않음
--mysql에서만 사용이 가능하며, 오라클에서는 뒷단원의 트리거를 공부하면서 외래키가 수정이 되도록 할 예정

 --on update cascade 명령이 없는 현재는 update 테이블명 set 수정내용 where 조건으로 참조하는 
 --테이블내 해당레코드를 먼저 수정하고, 참조되는 테이블의 해당 레코드를 수정
 --update rentlist set bnum=2002 where bnum=2;
 --update booklist set booknum=2002 where booknum=2;



