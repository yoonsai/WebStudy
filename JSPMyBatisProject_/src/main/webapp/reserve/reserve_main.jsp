<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width: 100%
}
#food_list tr:hover{
   cursor: pointer;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'post',
		url:'../reserve/food_list.do',
		data:{"no":1},
		success:function(result)
		{
			$('#food_list').html(result)
		}
	})
	$('.foods').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'../reserve/food_list.do',
			data:{"no":no},
			success:function(result)
			{
				$('#food_list').html(result)
			}
		})
	})
})
</script>
</head>
<body>
  <div class="container">
   <h1 class="text-center">맛집 예약</h1>
   <div class="row">
    <table class="table" height="700">
      <tr>
       <td width=20% height="580" class="danger">
        <table class="table">
         <caption><h3>맛집정보</h3></caption>
         <tr>
           <td>
             <span class="btn btn-xs btn-danger foods" data-no="1">한식</span>
             <span class="btn btn-xs btn-warning foods" data-no="2">양식</span>
             <span class="btn btn-xs btn-success foods" data-no="3">중식</span>
             <span class="btn btn-xs btn-info foods" data-no="4">일식</span>
           </td>
         </tr>
         <tr>
           <td>
            <div id="food_list" style="height: 450px;overflow-y:scroll "></div>
           </td>
         </tr>
        </table>
       </td>
       <td width=45% height="580" class="success">
         <table class="table">
          <caption><h3>예약일 정보</h3></caption>
         </table>
       </td>
       <td width=35% rowspan="2" class="info">
         <table class="table">
          <caption><h3>예약정보</h3></caption>
          <tr>
           <td>
            <img src="../reserve/noimage.png" style="width: 100%" id="food_image">
           </td>
          </tr>
          <tr>
            <td>업체명:<span id="food_name"></span></td>
          </tr>
          <tr>
            <td>예약일:<span id="food_day"></span></td>
          </tr>
          <tr>
            <td>예약시간:<span id="food_time"></span></td>
          </tr>
          <tr>
            <td>인원:<span id="food_inwon"></span></td>
          </tr>
         </table>
       </td>
      </tr>
      <tr>
        <td width="35%" height="120" class="warning">
          <table class="table">
           <caption><h3>시간정보</h3></caption>
          </table>
        </td>
        <td width="30%" height="120" class="danger">
          <table class="table">
           <caption><h3>인원정보</h3></caption>
          </table>
        </td>
      </tr>
    </table>
   </div>
  </div>
</body>
</html>



