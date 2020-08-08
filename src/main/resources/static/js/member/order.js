/**
 * 
 */
$(()=>{
	let cancle = $(".re-button.cancle");

	cancle.click((e)=>{
		e.preventDefault();
		var msg = "주문을 취소하시겠습니까?";
		var flag = confirm(msg);
		
		if(flag==true){
			alert("취소하였습니다.");
//			cancle.unbind('click').click(); 약간 봉인해제
			window.location = cancle.attr('href');
		}
		else
			alert("머라해야하누");
		
	
	})//cancle클릭 이벤트 닫히는 부분
	
});//윈도우로드 닫히는 부분
