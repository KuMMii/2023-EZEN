

--join
--두개 이상의 테이블에 나눠져 있는 관련 데이터들을 하나의 테이블로 모아서 조회하고자 할때 사용하는 명령


--[1] 이름 Douglas Grant인 사원이 근무하는 부서명, 부서의 지역명 출력하고자 한다면
select department_id from EMPLOYEES where emp_name='Douglas Grant';
select emp_name from EMPLOYEES;
--위 명령을 실행 후 얻어진 부서번호로 아래와 같이 부서번호 검색해 부서명을 알아냄
select department_name, parent_id from departments where department_id=50;

--위 두개의 명령을 하나의 명령으로 합해주는 역할을 join명령이 실행
--[2]join : 두개 이상의 테이블에 나뉘어져있는 데이터를 한번의 sql문으로 원하는 결과를 얻음


--cross join : 두개 이상의 테이블이 조인될때 where절에 의해 공통되는 컬럼에 의한 결합이 발생하지 않는 경우
--가장 최악의 결과를 얻는 조인 방식
--A테이블과 B테이블의 cross join된다면
--A테이블의 1번 레코드와 B테이블의 모든 레코드가 하나하나 모두 조합
--A테이블의 2번 레코드와 B테이블의 모든 레코드가 하나하나 모두 조합
--A테이블의 3번 레코드와 B테이블의 모든 레코드가 하나하나 모두 조합
--...

create table A(
a1 varchar2(5),
a2 varchar2(5),
a3 varchar2(5)
);
create table B(
b1 varchar2(5),
b2 varchar2(5),
b3 varchar2(5)
);

insert into A values('ar1', 'ar1','ar1');
insert into A values('ar2', 'ar2','ar2');
insert into A values('ar3', 'ar3','ar3');

insert into B values('ar1', 'ar1','ar1');
insert into B values('ar2', 'ar2','ar2');
insert into B values('ar3', 'ar3','ar3');
insert into B values('ar4', 'ar4','ar3');

select*from A;
select*from B;

--cross조인: 별도의 조건이나 키워드 없이 from 뒤에 테이블이름을 컴마로 구분해서 두개 이상쓰면 cross 조인이 됨
select*from A,B;
select*from A,B where a1=b3;

select*from dept;
select*from emp;

select*from dept, emp;

--equi join :조인 대상이 되는 두테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결해 결과를 생성 --시험에 나옴
select*from dept, emp where emp.deptno=dept.deptno;

--각 사원의 이름, 부서번호, 부서명, 지역 출력
select emp.ename, dept.deptno, dept.dname, dept.loc from emp,dept where emp.deptno=dept.deptno; 
--이름이 똑같은 필드가 있을때는 소속을 지정해주고 select를 해야함
--이름이 scott인 사원의 이름, 부서번호, 위치 출력
select emp.ename, dept.deptno,  dept.loc from emp,dept 
where emp.deptno=dept.deptno and ename='SCOTT'; 

--테이블 명에 별칭을 부여한 후 컬럼앞에 소속테이블을 지정
--테이블 명으로 소속을 기술할때는 한쪽에만 있는 필드에 생략이 가능하지만 아래와 같이 별칭 부여시에는 모든 필드 앞에 반드시 별칭을 기술해야함
select a.ename, b.dname, b.loc, a.deptno
from emp a, dept b
where a.deptno=b.deptno and a.ename='SCOTT';

--rentlist의 대여건수의 대여일자, 대여도서번호, 대여회원번호, 할인금액을 출력하되, 도서의 제목, 회원의 이름을 도서번호와 회원번호 옆에 출력

select*from rentlist;
select*from memberlist;
select*from booklist;
select a.rentdate, a.bnum, b.subject, a.mnum, c.name,a.discount 
from rentlist a, booklist b, memberlist c
where a.mnum=c.membernum and a.bnum=b.booknum;

select a.rentdate, a.bnum, b.subject, a.mnum, c.name, b.rentprice-a.discount as "매출금액"
from rentlist a, booklist b, memberlist c
where a.mnum=c.membernum and a.bnum=b.booknum;


--non-equi join
--동일 컬럼이 없어서 다른 조건을 사용하여 조인
--조인 조건에 특정 범위내에 있는지를 조사하기 위해 조건절에 조인 조건을'=' 연산자 이외의 비교 연산자를 이용
select * from emp;
select* from salgrade;

select a.ename, a.sal, b.grade from emp a , SALGRADE b
where a.sal>b.losal and a.sal<=b.hisal;

select a.ename, a.sal, b.grade from emp a , SALGRADE b
where a.sal between b.losal and b.hisal;

--outer join --시험에 나옴
--조인 조건에 만족하지 못해서 해당 결과를 출력시에 누락이 되는 문제점이 발생할 때 해당 레코드를 출력하는 조인
select a.booknum, a.subject, b.rentdate from booklist a , rentlist b
where a.booknum=b.bnum(+);

--outer join으로  emp테이블의 인원에 대한 부서명을 출력하되 부서명이 없는 필드는 NULL값으로 표시하기
select * from emp a, dept b
where a.deptno(+)=b.deptno;

--[3]ANSI join

--(1)Ansi Cross Join
select*from emp, dept --일반 크로스 조인 표현
select*from emp cross join dept --ansi cross join -> 일반 크로스 조인과 같은 효과

--(2) Ansi Inner Join --일반 equi조인과 같은 효과
--일반 equi 조인표현방식
select ename, dname from emp a, dept b where a.deptno=b.deptno

--Ansi 이너 조인의 표현 방식
select ename, dname from emp inner join dept on emp.deptno = dept.deptno;
select ename, dname from emp inner join dept on emp.deptno = dept.deptno
where ename='SCOTT';

--Ansi 이너 조인의 다른 표현 방식
select ename, dname from emp inner join dept using(deptno);
--두테이블의 조인 기준이 되는 필드명이 똑같을때만 사용가능

--(3)Ansi Outer Join --기존 아우터 조인의 표현방식
select*from emp, dept where emp.deptno = dept.deptno(+);
select*from emp, dept where emp.deptno(+) = dept.deptno;

--Ansi Outer Join 표현방식
select*from emp left outer join dept on emp.deptno = dept.deptno;
select*from emp right outer join dept on emp.deptno = dept.deptno;
--기준이 되는 필드명 중 A테이블의 필드에는 있으나 B테이블 필드에는 해당값이 없는 경우에 대한 표현 여부 결정














