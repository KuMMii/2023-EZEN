--서브쿼리
--Sub Query:하나의 select문장의 절 안에 포함된 또하나의 select쿼리문


--SCOTT이 근무하는 곳의 부서명과 지역 출력
select deptno from emp where ename='SCOTT';
select dname, loc from dept where deptno=30;

--위 select 명령으이 결과를 다른 select명령에 사용(서브쿼리 사용)
select dname, loc from dept
where deptno=(select deptno from emp where ename='SCOTT');


--SCOTT과 동일직업(job)을 가진 사원의 모든 정보를 출력
select job from emp where ename='SCOTT';
select * from emp where job='ANALYST';

select *from emp where job=(select job from emp where ename='SCOTT');

select*from emp;
--SCOTT과 급여가 동일하거나 더 많이 받는 사원이름과 급여 출력
select ename, sal from emp where sal>=(select sal from emp where ename='SCOTT');

--[서브쿼리&그룹함수]
--전체사원평균 평균급여보다 더 많은 급여를 받는 사원의 이름, 급여, job
select ename, sal, job from emp where sal>=(select avg(sal)from emp)

--[in,some,any 함수와 서브 쿼리]
--급여를 3000 이상 받는 사원이 소속된 부서와 소속된 부서에서 근무하는 사원들의 이름, 부서번호, job
--급여 3000 이상 사원의 부서번호(중복제거);
select ename, deptno, job from emp 
where deptno in( select DISTINCT deptno from emp where sal>=3000);

select * from emp;
--30번 부서 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 급여가 더 많은 사원의 이름과 job, 급여 출력
--첫번째방법
select ename,job, sal from emp where sal>=(select MAX(sal) from emp where deptno=30);
--두번째 방법
select ename,job, sal from emp where sal>=ALL(select sal from emp where deptno=30);
--30번 부서 사람들의 급여들 모두보다 큰 급여의 사원 조회


--부서번호가 30번인 사원들 중에서 급여 가장 낮은 급여보다 높은 급여를 받는 사원의 이름과 job, 급여 출력
--첫번째방법
select ename,job, sal from emp where sal>(select MIN(sal) from emp where deptno=30);
--두번째방법
select ename,job, sal from emp where sal> any(select sal from emp where deptno=30);
--30번 부서사원의 급여들중 하나보다 큰 급여의 사원

--영업사원(job='SALESMAN')들의 최소 급여보다 많이 받는 사원들의 이름과 급여과 직급, 급여를 출력하되 영업사원은 출력하지 않음
--첫번째 방법
select ename, job, sal from emp 
where sal>=(select min(sal) from emp where job='SALESMAN') and job <>'SALESMAN';

--두번재 방법
select ename, job, sal from emp 
where sal>any(select sal from emp where job='SALESMAN') and job <>'SALESMAN';













