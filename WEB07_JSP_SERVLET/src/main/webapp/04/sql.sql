CREATE TABLE members(
	id varchar2(10),
	name varchar2(15),
	pwd varchar2(20),
	phone varchar2(15)
);

INSERT INTO members VALUES('somi', '이소미', '1234', '010-2323-3434');
INSERT INTO members VALUES('sang', '전상오', '1234', '010-5555-6666');
INSERT INTO members VALUES('light', '김빛나', '1234', '010-2222-3333');

select * from members;
