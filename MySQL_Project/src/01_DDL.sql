

CREATE TABLE scott.booklist (
  `booknum` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `makeyear` INT NULL,
  `inprice` INT NULL,
  `rentprice` INT NULL,
  `grade` VARCHAR(5) NULL DEFAULT 'all',
  PRIMARY KEY (`booknum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'booklist~!';



--memberlist 테이블 생성하기
-- 필드명:membernum(int, 자동증가, not null 기본키), name(varchar(30), not null), Birth(daate, not null), bpoint(int), 
--joindate(date,기본값 now()), age(int), gender(varchar(3))
--테이블 comment : 회원목록
--기본 문자set:utf-8mb4
--워크벤치에서 테이블 생성하는 명령을 복사해도 됨


CREATE TABLE `scott`.`memberlist` (
  `membernum` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(30) NOT NULL,
  `birth` DATETIME NOT NULL,
  `bpoint` INT NULL,
  `joindate` DATETIME NULL DEFAULT now(),
  `age` INT NULL,
  `gender` VARCHAR(3) NULL,
  PRIMARY KEY (`membernum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'memberlist~!';


--자주쓰는 자료형
--INT:정수 자료형(FLOAT, Double은 실수)
--VARCHAR:문자열 자료형, 가변길이(CHAR은 고정길이)
--TEXT:긴 문자열은 TEXT로 별도 저장
--DATETIME:날짜 자료형 저장
--TINYINT:-128~127까지 저장하지만 여기서는 1또는 0만 저장해 BOOLEAN값 표현

--자주 쓰는 제약조건
--NOT NULL :빈 값은 받지 않는다는 뜻
--AUTO_INCREMENT:숫자 자료형인 경우 다음 로우가 저장될 때 자동으로 1추가
--UNSIGNED:0과 양수만 허용
--ZEROFILL:숫자의 자릿수가 고정된 경우 빈 자리에 0을 넣음
--DEFAULT now():날짜 컬럼의 기본값을 현재 시간으로. DATETIME자료형에 적용 가능


--테이블 필드의 수정
ALTER TABLE `scott`.`memberlist` 
CHANGE COLUMN `birth` `birthday` DATE NOT NULL ;
--오라클은 modify했는데 mysql은 change임

ALTER TABLE `scott`.`memberlist` 
DROP COLUMN `gender`,

ALTER TABLE `scott`.`memberlist` 
CHANGE COLUMN `` `gender` VARCHAR(3) NULL ;




CREATE TABLE `scott`.`rentlist` (
  `rentdate` DATETIME NOT NULL DEFAULT now(),
  `numseq` INT NOT NULL AUTO_INCREMENT,
  `bnum` INT NOT NULL,
  `mnum` INT NOT NULL,
  `discount` INT NULL DEFAULT 100,
  PRIMARY KEY (`numseq`) )
--  INDEX `fk1_idx` (`bnum` ASC) VISIBLE,
--  INDEX `fk2_idx` (`mnum` ASC) VISIBLE,
--  CONSTRAINT `fk1`  FOREIGN KEY (`bnum`)   REFERENCES `scott`.`booklist` (`booknum`) 
--  ON DELETE CASCADE  ON UPDATE CASCADE,
--  CONSTRAINT `fk2`    FOREIGN KEY (`mnum`)    REFERENCES `scott`.`memberlist` (`membernum`)
--    ON DELETE CASCADE   ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;



--외래키 제약 조건 추가
ALTER TABLE `scott`.`rentlist` 
ADD INDEX `fk1_idx` (`bnum` ASC) VISIBLE,
ADD INDEX `fk2_idx` (`mnum` ASC) VISIBLE;
;
ALTER TABLE `scott`.`rentlist` 
ADD CONSTRAINT `fk1`
  FOREIGN KEY (`bnum`)
  REFERENCES `scott`.`booklist` (`booknum`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk2`
  FOREIGN KEY (`mnum`)
  REFERENCES `scott`.`memberlist` (`membernum`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;



