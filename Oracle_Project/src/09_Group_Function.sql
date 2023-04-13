--sum():특정 필드의 합계
select sum(rentprice) as "대여가격 합계" from BOOKLIST;
select sum(rentprice) as "대여가격 합계" from BOOKLIST where inprice>=18000;

--count():필드내의 데이터 개수(레코드 개수)
select count(*) as "회원인원수" from memberlist
select count(*) as "회원인원수" from memberlist where bpoint>=2000

--avg:평균
select round(avg(INPRICE),0) from booklist;

--max:최대값
select max(inprice) from booklist

--min:최소값
select min(inprice) from booklist

--variance(분산), Stddev(표준편차)
SELECT VARIANCE(salary), STDDEV(salary) FROM EMPLOYEES;
select salary from employees

--group by:하나의 필드를 지목해서 같은 값끼리 그룹을 형성한 결과를 도출함
--도서별 대여 건수
select count(*)from rentlist; --전체 대여건수
select bnum, count(*) from RENTLIST group by bnum;
--각 도서별 대여건수:한번도 대여안된 도서제외
--**group by 에 사용된 필드는 select와 from 사이에 반드시 포함되어야함(*라도 써서 포함시킴)


select*from rentlist;
select avg(discount), rentdate from RENTLIST
group by rentdate;

select rentdate ,count(*) from RENTLIST
group by rentdate;

select*from employees;
select department_id, round(avg(salary))  from employees
group by department_id;



--kor_loan_status 테이블의 period(년도와 월)을 1차 그룹으로 region(지역)을 2차 그룹으로 한 대출잔액(loan_jan_amt)의 합계
select*from kor_loan_status;

select period, region, sum(loan_jan_amt) from KOR_LOAN_STATUS group by period, region;

--having 절 : 그룹핑된 내용들에 조건을 붙일 때
--날짜 별 할인 금액의 평균을 출력함. 다만 그 평균 금액이 150 미만인 그룹만 출력
select rentdate as 날짜, avg(discount) as 할인평균 from rentlist
group by rentdate
having avg(discount)<180;

--kor_loan_status테이블의 날짜별 대출 잔액의합계 중 period가 2013년 11월인 데이터만 출력
select period, region, sum(loan_jan_amt) as total_jan, count(*) as 건수
from kor_loan_status
where period='201311'
group by period, region
order by region;




















