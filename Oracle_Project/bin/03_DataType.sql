--1. 정수형 타입
-- -number(2)는 총 두자리 정수형 값이 필드에 설정됨(-99~99)
-- -괄호 안의 숫자가 자리수를 표시하며, 이는 바이트수가 아닌 것을 꼭 기억하기

--2.실수형 타입
-- -number(6,2)는 소수점을 포함한 총 자리수가 6자리이고 소수점 둘째 자리까지 있는 실수형 값이 설정됨
-- -첫번째 인자값 6은 소수점 자리수를 포함한 총자리수를 의미하고, 두번재 인자값 2는 소수점 자리수를 의미함
-- -소수점도 자리수를 차지함. --자바의 %6.2f와 같은 형식
-- -오라클에서는 지정된 용량을 초과하는 데이터를 입력하려고 하면 자료 추가 오류가 발생

--3. 가변형 문자열(최대 4000byte)
-- -varchar2(xx)
-- -입력데이터가 실제 크기를 넘어서면 넘어선 크기만큼 자료형의 크기가 늘어나지는 않음
-- -반대로 지정한 크기보다 적은 문자가 저장되려고 하면 실제 저장크기가 저장하려는 문자만큼 줄어들어서 저장됨
-- - 기억장소가 절약되는 장점이 있음

--4. 고정형 문자열(최대 2000byte)
-- -char(xx)
-- -char(10)으로 만들어진 필드에 영문자 5크기 만큼 데이터를 저장하면 실제크기와 상관없이 고정형으로 10byte가 저장됨

--5. 고정형 유니코드 문자
-- -nchar(XX) : 다국어를 입력하기 위한 고정형 자료형 최대 2000byte

--6. 가변형 유니코드 문자
-- -nvarchar(XX):다국어를 입력하기 위한 가변형 자료형 최대 4000byte

--7.날짜 데이터
-- -DATE:BC 4712년 9999년 12월 31일 연월일시분초 입력 가능
-- -TIMESTAMP :연도 월 일 시 분 초 밀리초까지 입력가능
-- -가장 일반적이고 많이 사용하는 날짜 데이터 타입은 date
-- -sysdate 와 systimestamp는 현재일자와 시간을 반환하는 오라클 내부 함수

--8. LOB타입
-- -Large OBject의 약자로 대용량 데이터를 저장할 수 있는 타입
-- -CLOB:문자형 대용량 객체, 고정길이와 가변길이 문자집합지원(최대크기(4GB-1)*(데이터베이스 블록 사이즈)
-- -NCLOB:유니코드(다국어 지원)를 포함한 문자형 대용량 객체 (최대크기(4GB-1)*(데이터베이스 블록 사이즈)
-- -BLOB:이진형 대용량 객체(최대크기(4GB-1)*(데이터베이스 블록 사이즈)
-- -BFILE:대용량 이진 파일에 대한 로케이터(위치, 이름)저장 최대 4GB

--9.지금은 잘 사용되지 않는 자료형
-- -varchar : varchar2와 같은 형식이지만 2가 용량이 업그레이드 돼서 잘 사용안함
-- -LONG: 최대 2GB의 가변 길이 문자형. 잘사용안함
-- -FLOAT:number의 하위타임 2진수 기준 22바이트
-- -BINARY_FLOAT:32비트 부동 소수점
-- -BINARY_DOUBLE:64비트 부동 소수점