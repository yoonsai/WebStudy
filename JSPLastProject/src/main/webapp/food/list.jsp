<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear">
    <h2 class="sectiontitle">전국 맛집 리스트</h2>
   <div class="row">
         <div class="text-center">
            
         </div>
   </div>
      <div class="content"> 
      <div id="gallery">
        <figure>
          <header class="heading">${address } 맛집</header>
          <ul class="nospace clear">
          <c:forEach var="vo" items="${list }" varStatus="s">
             <li class="one_quarter ${s.index%4 == 0?'first':''}"><a href="../food/food_before_detail.do?fno=${vo.fno }"><img src="${vo.poster}"></a></li>
<%--              title="${vo.title} --%>
          </c:forEach>
          </ul>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
        
          <c:if test="${startPage>1 }">
          <li><a href="../food/list.do?page=${startPage-1}">&laquo; Previous</a></li>
          </c:if>
          
          <c:forEach var="i" begin="${startPage }" end="${endPage }">
          <li ${i==curpage?"class=current":""}><a href="../food/list.do?page=${i}">${i}</a></li>
          </c:forEach>
          
          <c:if test="${endPage<totalpage}">
          <li><a href="../food/list.do?page=${endPage+1}">Next &raquo;</a></li>
          </c:if>
          
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>