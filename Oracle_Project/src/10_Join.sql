

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

--equi join :조인 대상이 되는 두테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결해 결과를 생성
select*from dept, emp where emp.deptno=dept.deptno;


