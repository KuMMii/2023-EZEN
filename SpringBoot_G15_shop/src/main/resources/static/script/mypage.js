function go_cart(){
	if(document.formm.quantity.value==""){
		alert("수량을 입력해 주세요.");
		document.formm.quantity.focus();
	}else{
		document.formm.action="cartInsert";
		document.formm.submit();
	}
}

function go_cart_delete(){
	var count=0;
	if(document.formm.cseq.length==undefined){
		if(document.formm.cseq.checked==true)
		count++;
	}else{
		for(var i=0; i<document.formm.cseq.length;i++){
			if(document.formm.cseq[i].checked==true)
			count++;
		}
	}
	if( count ==0 )
      alert('삭제할 항목을 선택하세요');
    else{
      document.formm.action = "cartDelete";
	  document.formm.submit();
   }
}



function go_order_insert(){
   document.formm.action ="orderInsert";
   document.formm.submit();
}



function go_order(){
   document.formm.action ="orderInsertOne";
   document.formm.submit();
}


function orderEnd(oseq,odseq){
	//oseq는 orderDetail로 되돌아오기 위한 주문번호, odseq는 result를 변경하기 위한 주문 상세번호
	
	location.href="orderEnd?odseq="+odseq+"&oseq="+oseq;
}


