<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$('.trs').click(function() {
    let poster = $(this).attr("data-poster");
    let name = $(this).attr("data-name");
    let fno = $(this).attr("data-fno");

    $('#food_image').attr("src", poster);
    $("#food_name").text(name);
    $("#fno").val(fno);
    $.ajax({
        type: 'post',
        url: '../reserve/food_date.do',
        data: {"fno": fno}, // 수정: 객체 속성으로 변경 및 key:value 형태로 전달
        success: function(result) {
            $('#food_date').html(result);
        } // 수정: 세미콜론이 아닌 콤마 사용
    });
});
</script>
</head>
<body>
  <table class="table">
    <c:forEach var="vo" items="${list }">
      <tr data-poster="https://www.menupan.com${vo.poster }" data-fno="${vo.fno }" data-name="${vo.name }" class="trs">
       <td class="text-center">
        <img src="https://www.menupan.com${vo.poster }" style="width: 30px;height: 30px">
       </td>
       <td>${vo.name }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>