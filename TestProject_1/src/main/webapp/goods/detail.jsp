<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
    margin-top: 50px;
}
.row{
   margin: 50px auto;
   width: 1024px;
}
img{
	max-width: 100%;
}
#title-big{
	font-size: 28px;
	font-weight: bold;
}

#title-small{
	font-size: 18px;
	font-weight: 600;
}
.table{
	margin-top: 30px;
}
.table>tbody>tr>td{
	padding: 0 15px;
	vertical-align: middle;
}
.sub{
	color: #444;
	font-size: 16px;
}
#price{
	color: #286090;
	font-size: 24px;
	font-weight: bold;
}
.dimage{
	margin: 0 auto;
	padding-top: 50px;
	border-top: 1px solid #ccc;
}
.dimage img{
	display: block;
	margin: 0 auto;
}
.btn{
	padding: 10px 20px;
	font-size: 16px;
}
</style>
</head>
<body>
  <div class="row">
  	  <h1 id="title-big" class="text-center">${vo.gname}</h1>
		  <table class="table">
			  <tr>
				  <td width="50%" align="center" rowspan="9">
					  <img src="${vo.poster}" id="image">
				  </td>
				  <td width="50%">
					  <span id="title-small">${vo.gname}</span>
				  </td>
			  </tr>
			  <tr>
			  	  <td width="50%">
					  <span class="sub">${vo.origin}</span>
				  </td>
			  </tr>
			  <tr>
			  	  <td width="50%">
					  <span class="sub">${vo.manufacturer}</span>
				  </td>
			  </tr>
			  <tr>
				  <td width="50%">
					  <span id="price">${vo.price}</span>
				  </td>
			  </tr>
			  <tr>
				  <td width="50%" class="text-center">
					  <input type="button" value="장바구니" id="cart" class="btn btn-lg btn-primary">
					  <input type="button" value="바로구매" id="buy" class="btn btn-lg btn-info">
					  <input type="button" value="목록" id="cart" class="btn btn-lg"
					   onclick="javascript:history.back()">
				  </td>
			  </tr>
		  </table>
		  
		  <div class="dimage text-center">
		  	<img src="${vo.dimage}" id="dimage">
		  </div>
	  </div>
  
</body>
</html>