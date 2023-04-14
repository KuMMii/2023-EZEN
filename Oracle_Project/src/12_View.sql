--오라클-뷰(View)
-- -물리적인 테이블에 근거한 논리적인 "가상 테이블"->저장되어있는 select문
-- -가상이란 단어는 실직적으로 데이터를 저장하고 있지 않기 때문에 붙인 것이고, 테이블이란 단어는 실질적으로
--		데이터를 저장하고 있지 않더라고 사용 계정자는 마치 테이블을 사용하는 것과 동일하게 뷰를 사용할 수 있기 때문에 붙임
-- -뷰는 기본테이블에서 파생된 객체로서 기본테이블에 대한 하나의 쿼리문임
-- -실제 테이블에 저장된 데이터를 뷰를 통해 볼 수 있도록 함
-- -사용자에게 주어진 뷰를 통해서 기본 테이블을 제한적으로 사용하게 됨
-- -뷰는 이미 존재하고 있는 테이블에 제한적으로 접근하도록 한다
-- -뷰를 생성하기 위해서는 실질적으로 데이터를 저장하고 있는 물리적인 테이블이 존재해야 되는데
--		이테이블을 기본테이블이라고 함

--뷰 생성 방법
--create or replace view 뷰이름 as select 조회 명령
-- ->결과는 select의 결과를 테이블로 내어놓는 가상테이블 제작 명령이 생기는 셈임
--뷰이름으로 조회명령을 저장하고 있다가 뷰이름으로 조회할때마다 조회명령이 실행되어 결과를 내놓음

create or replace view result_inner_join as
select a.empno, a.ename, a.job, a.hiredate, a.deptno, b.dname, b.loc
from emp a, dept b
where a.deptno=b.deptno;

select *from result_inner_join where job='MANAGER';
--where를 붙여서 결과내에서 또다른 조건을 사용할 수 있음

--create or replace view result_inner_join을 사용해 다른 select 문을 적용하고 실행하면 
--replace명령이 동작해 result_inner_join라는 이름으로 뷰내용이 대체됨
--최초실행은 create 실행 || 같은 이름의 두번째 실행부터는 replace 실행















