package com.ezen.g13.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.g13.dao.ITransactionDao1;
import com.ezen.g13.dao.ITransactionDao2;

@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;

	@Autowired
	ITransactionDao2 td2;
	
//	@Transactional에 아무 옵션도 없을 때의 기본 속성
//	@Transactional(rollbackFor= {RuntimeException.class, Error.class}) 
	//RuntimeException과 Error이 발생했을 겨우에는 기본적으로 rollback이 된다는 것. 그 외에는 안됨
	@Transactional(rollbackFor= {RuntimeException.class, Exception.class})
	public int buy(String id, int amount, int error) {
		td1.buy(id, amount);
		if(error==0) {
			int n =10/0;
//			throw new RuntimeErrorException(null);
		}
		td2.buy(id, amount);
		return error;
	}
	//try-catch를 적으면 @Transactional이 작동하지 않음
	//에러뜰때 rollback은 되는데 바로 에러 화면으로 넘어감 
	
	
	
	/*
	@Autowired
	TransactionTemplate tt;
	
	public int buy(String id, int amount, int error) {
		try {
			
			tt.execute(new TransactionCallbackWithoutResult(){

				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					td1.buy(id, amount);
					if(error==0) {
						int n =10/0;
					}
					td2.buy(id, amount);
					System.out.println("Transaction Commit");
				}
			});
			
		}catch(Exception e) {
			System.out.println("Transaction RollBack");
			return 0;
		}
		return 1;
	}
	*/
	
	/*
	@Autowired
	PlatformTransactionManager ptm;
	
	@Autowired
	TransactionDefinition td;
	
	public int buy(String id, int amount, int error) {
		//transaction1 테이블과 transaction2 테이블의 레코드를 insert하는 메소드를 각각의 dao에서 따로 호출함
		
		//하나이상의 데이터베이스 작업을 한단위로 묶어서 하나의 실행단위로 정의되는 것을 트랜잭션이라고 함
		// 트랜잭션 하나가 모두 다 실행이 되어 완료되면, commit 이라는 명령으로 작업을 완료하고,
	    // 중간에 에러가 발생하여 트랜잭션을 취소하고자 한다면 rollback이라는 명령으로 취소합니다
		
		//트랜젝션의 시작
		TransactionStatus status = ptm.getTransaction(td);
		//끝은 commit 또는 rollback
		
		try {
			td1.buy(id, amount);
			if(error==0) {
				int n=10/0;
			}
			
			td2.buy(id, amount);
			
			System.out.println("에러없이 둘 다 실행됨");
			ptm.commit(status); //영역 안의 모든 데이터베이스 작업의 실행적용 -트랜젝션의 끝
			
		}catch(Exception e) {
			System.out.println("중간에 에러나서 둘 다 실행 안됨");
			ptm.rollback(status); //영역 안의 모든 데이터베이스 작업의 취소
			
			return 0;
		}
		
		return 1;
	}
	*/

}
