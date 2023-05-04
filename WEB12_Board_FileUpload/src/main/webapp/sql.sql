create table board(
	num number(5) primary key,
	pass varchar2(30),		--게시물의 수정 삭제를 위한 비밀번호
	userid varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,		--조회수
	writedate date default sysdate	--작성일자
);

alter table board add imgfilename varchar2(255);

create sequence board_seq start with 1 increment by 1;

insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'hong', 'abc@naver.com','1234', '집에 가고싶다','집에 보내줘~!~!');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'somi', 'somi@naver.com','1234','기아 홧팅','기아 이겨라~!~!');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'cute', 'jerong@naver.com','1234','재롱이 귀여워','재롱아 사랑해~!!!~!');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'home', 'home@naver.com','1234','집에 보내줘','아이러브 마이하우스');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'bears', 'doosan@naver.com','1234','두산바보','정철원바보~!~!');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'bears', 'doosan@naver.com','1234','양찬열,,','잘생김');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'eu', 'eu@eu.com','1234','유럽여행','유럽여행 다시 보내줘~!~!');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'trip', 'trip@naver.com','1234','여행가고싶다진짜로','제발 로또당첨 연금복권당첨 스피또2000당첨 스피또1000당첨되게 해주세요 제발요');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'bag', 'bag@naver.com','1234','칼하트백팩사야하는데','어디서 사지????뭐사지???');
insert into board(num,userid, email, pass, title, content) values(board_seq.nextVal, 'lunch', 'lunch@naver.com','1234','점메추','오늘 점심 머먹지');

select * from board order by num desc;
select * from member;

commit


create table reply(
	replynum number(7) primary key,		--댓글 순번
	boardnum number(5),		--댓글의 해당 게시물 번호
	userid varchar2(20),		--댓글쓰니
	writedate date default sysdate,		--작성일
	content varchar2(1000)		--작성 내용
);
--댓글은 board 테이블에 저장되지 않음. 한두개의 댓글만 달리고 말거라면 board테이블에 댓글 필드를 두세개 생성하고 저장해도 되지만
--게시판에 있는 각 게시물들에 대한 댓글은 작성될 수 있는 개수가 제한이 없기 대문에 모든 댓글을 하나의 테이블에 저장함.
--이때 반드시 저장되는 댓글에는 어느 게시물의 댓글인지 게시물 번호를 같이 저장해야함
--그래야 해당 게시물이 화면에 표시될때 그 게시물의 댓글만 조회(검색)해서 따로 화면에 표시할 수 있음
create sequence reply_seq start with 1 increment by 1;

insert into reply values(reply_seq.nextVal, 1, 'somi', sysdate, '집에 가세요 그럼;');
insert into reply values(reply_seq.nextVal, 2, 'cute', sysdate, '타이거즈 소크라테스 소크라테스 오오오오~타이거즈 소크라테스 소크라테스 오오오오~');
insert into reply values(reply_seq.nextVal, 3, 'bears', sysdate, '안녕하세요 제 블로그에서 자격증 정보 얻어가세요');

select * from reply;

delete from reply;

select*from(
	select*from(
		select rownum as rn, b.* from(
			(select * from board order by num desc) b
		)
	)where rn>=1
)where rn<=10;













