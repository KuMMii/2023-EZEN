create table bbs(
	id number(3),
	writer varchar2(30),
	title varchar2(30),
	content varchar2(1000)
);

create sequence bbs_seq start with 1;

insert into bbs values(bbs_seq.nextVal, 'Gildong', '반갑습니다.', '방가워용');
insert into bbs values(bbs_seq.nextVal, 'Gilding', '안녕하세요.', '안뇽');
insert into bbs values(bbs_seq.nextVal, 'Gildang', 'ㅎㅇ', 'ㅎㅇㅎㅇ');

select * from bbs;