--오라클 - 시퀀스(Sequence)
--  :테이블 내의 유일한 숫자를 자동으로 생성하는 자동 번호 발생기
--	 :테이블 생성 후 시퀀스(일련번호)를 따로 만들어야 한다.


--생성방법
--create sequence 시퀀스이름 start with 시작숫자 imcrement by 증가량;

--주로 number형식에 기본키값으로 사용함
--일련번호정도로 이해해도 무방
--number(자리수):자료형의 자릿수가 몇자리냐에 따라 그만큼 숫자가 증가할 수 있음

--[1] 시퀀스의 생성
create sequence book_seq start with 1 increment by 1;

--테이블에 레코드를 추가함
alter table booklist add grade;
insert into BOOKLIST values(book_seq.nextVal, 'The Giver', 2010, 12150, 2000, 'all');
insert into BOOKLIST values(book_seq.nextVal, 'The Handmaid Tale', 2005, 20000, 2000, '18');
insert into BOOKLIST values(book_seq.nextVal, '체리새우', 2022, 18000, 2000, '12');

select*from booklist;

--[3] 시퀀스 수정 : 최대 증가값을 14까지로 제한
alter sequence book_seq maxvalue 100;
--[4]시퀀스 삭제
drop sequence book_seq;
--[5]시퀀스 재생성 : 다음 숫자부터 시작하게 하여 기존 레코드와 중복되지 않게 함
create sequence book_seq start with 21 increment by 1;

select*from tabs;

--1부터 1씩 늘어나는 member_seq rent_seq 생성
create sequence member_seq start with 1 increment by 1;
create sequence rent_seq start with 1 increment by 1;

