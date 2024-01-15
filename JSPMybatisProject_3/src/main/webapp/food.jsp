<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
   
}
</style>
</head>
<body>
  <div id="app">
   <div class="container">
     <div class="row">
       <div class="col-md-3" v-for="vo in food">
         <div class="thumnail">
           <a href="#">
		        <img :src="vo.poster" style="width:260px">
		        <div class="caption">
		          <p style="font-size: 10px">{{vo.name }}</p>
		        </div>
		      </a>
         </div>
       </div>
     </div>
     </div>
  </div>
  <script>
    const App={
       data(){
    	   return {
    		   food:[] //json
    	   }
       },
       mounted(){
    	   //$($function(){})
    	   axios.get('../food/list.do').then(response=>{
    		   //axios => 요청할때 //then => 결과값 받을때
    		   console.log(response.data)
    		   this.food=response.data
    	   })
       }
    }
    Vue.createApp(App).mount('#app')
  </script>
</body>
</html>