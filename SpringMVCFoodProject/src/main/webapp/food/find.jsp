<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 900px;
}
p{
overflow: hidden;
white-space: nowrap;
text-overflow: ellipsis;
}
</head>
</style>
<body>
	<div class="container">
		<div class="row">
			<form method="post" action="find.do">
				<select name="column" class="input-sm">
					<option value="name" ${address=="name"?"selected":"" }>주소</option>
				</select>
				<input type="text" name="address" class="input-sm" size=20 value="${address!=null?address:'' }">
				<button class="btn-sm btn-primary">검색</button>
			</form>
			<c:forEach var="vo" items="${list }">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="/w3images/lights.jpg"> 
					<img src="${vo.poster }" style="width: 230px; height:120px;" title="${vo.name }">
						<div class="caption">
							<p>${vo.name }</p>
						</div>
					</a>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="row text-center" style="margin-top: 20px;">
			<a href="find.do?page=${curpage>1?curpage-1:curpage }&address=${address}" class="btn btn-sm btn-success">이전</a>
			${curpage } page / ${totalpage } pages
			<a href="find.do?page=${curpage<totalpage?curpage+1:curpage }&address=${address}" class="btn btn-sm btn-success">다음</a>
		</div>
	</div>
</body>
</html>