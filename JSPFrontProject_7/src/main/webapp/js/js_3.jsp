<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<style type="text/css">

</style>
<script type="text/javascript">
function calc(){
	let price=document.querySelector("#price").getAttribute("data-price");
	let sel=document.querySelector("#sel").value;
	let total=sel*price;
	document.querySelector("#total").innerText=total;
	
}
</script>
</head>
<body>
 <div class="container">
  <div class="row">
		  <table class="table">
			  <tr>
				  <td width="35%" align="center" rowspan="9">
					  <img src="https://recipe1.ezmember.co.kr/cache/data/goods/20/09/38/1000012254/1000012254_detail_06.jpg" id="image">
				  </td>
				  <td width="65%" align="center">
					  <span id="title">
					   [연말특가] 라인바싸 탄산수 500ml 40입 무료배송 5종(플레인/레몬/자몽/파인애플/샤인머스켓)
					  </span>
				  </td>
			  </tr>
			  <tr>				  <td width="65%">
					  <span id="sub">정제수가 아닌 진짜 생수로 만든 탄산수!</span>
				  </td>
			  </tr>
			  <tr>
				  <td width="65%">
					  <span id="percent">42%</span>&nbsp;
					  <span id="price" data-price="13,900원">13,900원</span>
					  <p>
						  <del id="psub">24,000원</del>
					  </p>
				  </td>
			  </tr>
			  <tr>
				  <td width="65%">
					  <span id="label">첫구매할인가</span>
					  <span id="price2">13,205원</span>
				  </td>
			  </tr>
			  <tr>
				  <td width="65%">
					  <span id="star">★★★★★</span>&nbsp;
					  <span id="bold">4.5</span>
					  <span id="count">(299)</span>
				  </td>
			  </tr>
			  <tr>
				  <td width="65%">
					  <img src="https://recipe1.ezmember.co.kr/img/mobile/icon_delivery3.png">
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  <span id="delevery">무료배송</span>
				  </td>
			  </tr>			  <tr>				  <td width="65%">
					  <select id="sel" onchange="calc()">
						  <option value="1">1</option>
						  <option value="2">2</option>
						  <option value="3">3</option>
						  <option value="4">4</option>
						  <option value="5">5</option>
					  </select>
				  </td>
			  </tr>
			  <tr>
			      <td width=65% class="text-right">
			      주문금액&nbsp;&nbsp;
			      <span style="color:green;font-size:20px" id="total"></span>원 
			      </td>
			  </tr>
			  <tr>
				  <td width="65%">
					  <input type="button" value="장바구니" id="cart">
					  <input type="button" value="바로구매" id="buy" onclick="requestPay()">
					  <a href="../store/all.do" id="cart">목록</a>
				  </td>
			  </tr>
		  </table>
	  </div>
	 </div>
</body>
</html>