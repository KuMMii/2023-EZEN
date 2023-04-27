create table member(
	name varchar2(30),
	userid varchar2(30),
	pwd varchar2(30),
	email varchar2(30),
	phone varchar2(15),
	admin number(1) default 0, --0:일반 사용자, 1:관리자
	primary key(userid)
);

INSERT INTO member VALUES('이소미', 'somi', '1234','gmd@naver.com', '010-2323-3434',1);
INSERT INTO member VALUES('전상오', 'sang', '1234','h12@naver.com', '010-5555-6666',0);
INSERT INTO member VALUES('김빛나', 'light', '1234','yoon1@daum.net', '010-2222-3333',0);

delete from member;

select * from member;