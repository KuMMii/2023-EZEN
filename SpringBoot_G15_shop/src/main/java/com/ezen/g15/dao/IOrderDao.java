package com.ezen.g15.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.g15.dto.CartVO;
import com.ezen.g15.dto.OrderVO;

@Mapper
public interface IOrderDao {

	void insertOrders(String id);

	int LookupMaxOseq();

	void deleteCart(Integer cseq);

	void insertOrderDetail(CartVO cvo, int oseq);

	List<OrderVO> listOrderByOseq(int oseq);

	void orderInsertOne(String id, int pseq, int quantity);

	void OrderDetailInsertOne(int oseq, int pseq, int quantity);

	List<Integer> selectSeqOrderIng(String id);

	List<Integer> getFinalListAll(String id);

}
