--오라클 명령어: select 문(검색)
--가장 사용빈도수가 높은 명령

--[1] scott사용자가 관리하고 있는 테이블 목록
select*from tab;
select*from tabs;

select*from memberlist;

--[2]특정 테이블의 구조 조회(필드 리스트/데이터 형식)
desc dept;--커맨드 창(sqlplus)에서 확인 요망
desc memberlist;--커맨드 창(sqlplus)에서 확인 요망

--SELECT:select와 from사이에 조회하고자 하는 필드명들을, 로 구분하여 지목
--select booknum, subject, rentprice from...
--모든 필드를 한번에 지목하려면 *를 사용
--from 뒤에는 대상 테이블 명을 써줌
--where 절을 붙여서 조건에 맞는 행만 골라내기도 함
--select...from...where

--아래와 같이 연산식을 써서 연산된 결과를 필드로 조회하고자 할땐 as와 함께 만들어진 필드명을 지어주기도 함

select empno ||'-'|| ename as emp_info from emp
--오라클 SL에서 ||는 이어붙이기 연산
--empno||'-'||ename:empno값과 ename값을 '-'와 함께 이어붙이기 하고 그렇게 만들어진 필드의 이름을 emp_info로 설정함
--필드명에 공백이 있거나 기술하기 어려운 필드명일때도 as로 별칭을 붙이기도 함

select empno as "사원번호", ename as 사원성명 from emp;
select MGR as manager_empno from emp;

--[3] 특정 테이블의 모든 DATA 표시
select*from rentlist;

--[4]모든 컬럼(필드명)이 아닌, 필요한 필드만 조회
select subject, makeyear from booklist;

--[5]각각의 필드명에 별칭을 부여해서 출력
select subject as 도서제목, makeyear as 출판년도 from booklist;

--[6] 중복 제거:distinct
select distinct bnum from rentlist;
--rentlist에서 membernum을 중복 제거 후 조회하기
select distinct mnum from rentlist;

select*from booklist;
select*from memberlist;
--[7] 검색 조건의 추가:입고가격이 20000원 이상인 book 목록
select *from booklist
where inprice>=15000;
--[8]이름이 '홍'으로 시작하는 회원의 모든 회원정보 출력
select*from memberlist
where NAME LIKE '김%';
--[9]1983년도 이후로 태어난 회원의 모든 회원정보
select*from memberlist
where birth>='1983-01-01';
--[10]사은 포인트(bpoint)가 250이상이고 1982년 이후로 태어난 회원의 모든 회원정보(and,or사용)
select*from memberlist
where bpoint>=250 and birth>='1983-01-01';
--[11]제작년도가 2016년 이전이거나 입고가격(inprice)이 18000이하인 book 정보
select*from booklist
where makeyear<2016 or inprice<=18000;

select*from memberlist
where name like '이%';

select*from memberlist
where name like '%용';


select*from booklist
where subject like '%이%';

select name, phone from memberlist
where gender is not null;
select name, phone from memberlist
where gender is null;
--~와 같다:=, ~와같지않다:<>
update memberlist set gender='M' where gender is Null;
select*from memberlist;

select name, phone from memberlist
where gender is null;

select * from booklist
where subject like '_것%';

--emp 테이블에서 deptno가 10,20,30 중 하나인 데이터 모두
select * from emp where deptno=10 or deptno=20 or deptno=30;

--조건식 (ANY, SOME, ALL, (IN))
--1.ANY
select*from emp where deptno=any(10,20,40);
--ANY():괄호안에 나열된 내용 중 어느 하나라도 해당하는 것이 있다면 검색 대상으로 함
select*from emp where deptno in(10,20,30);

--2.SOME 조건식 -ANY와 동일
select*from emp where deptno=some(10,20,40);

--3.All
select*from emp where deptno=all(10,20,40);
--괄호안의 모든값이 동시 만족해야하는 조건이므로 해당하는 레코드가 없을 때가 대부분임
select*from emp where deptno <> all(10,20,40);
--제외시킬때 all많이 사용
select*from emp where deptno NOT in(10,20,30);


--정렬(sort)-where 구문 뒤에, 또는 구문의 맨 끝에 Order by 필드면[desc]
--select명령의 결과를 특정 필드값의 오름차순이나 내림차순으로 정렬하라는 명령
--asc:오름차순, 안쓰면 기본으로 실행됨
--desc:내림차순

select * from emp where sal>=1000 order by ename asc;
select * from emp order by job desc;

--job으로 내림차순 정렬후 같은 job_id사이에서는 순서를 hiredate의 내림차순으로 정렬
select * from emp order by job desc, hiredate desc;
--두개 이상의 정렬 기준이 필요하다면 위와같이 컴마(,)로 구분해서 기준 지정
--위의 예제는 job로 1차 정렬, 같은 job사이에 hiredate로 내림차순정렬

--그 외 활용하기 좋은 select에 대한 예제

--부서번호가 10이 아닌 사원(아래 두문장은 같은 의미의 명령)
select*from emp where not(DEPTNO=10);
select*from emp where DEPTNO<>10;

--급여가 1000달러 이상, 3000달러 이하
select*from emp where SAL>=1000and sal<=3000;
select*from emp where SAL between 1000 and 3000;








