<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
 ID : <input type="text" id="id"><button>유저검색</button>
<div class="container">
	<table border="1" class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비번</th>
			<th>성별</th>
			<th>취미</th>
			<th>주소</th>
		</tr>
		<tbody id="user_tbody">
			<tr>
				<td colspan="7">유저데이터가 없습니다.</td>
			</tr>
		</tbody>
	</table>
</div> 
<script>
	$("button").click(function(){
		var p = {
				name : "박경훈",
				age : 33,
				hobbies : ["잠자기","영화"]
			}
		p = JSON.stringify(p);
		$.ajax({
			url: "/lt/lottot",
			dataType:"json",
			data:"lotto=" + encodeURIComponent(p),
			success : function(res){
				var html =""
				for(var idx in res){
					var user = res[idx];
					html += "<tr>";
					html += "<td>" + user.num + "</td>";
					html += "<td>" + user.name + "</td>";
					html += "<td>" + user.id + "</td>";
					html += "<td>" + user.pwd + "</td>";
					html += "<td>" + user.trans + "</td>";
					html += "<td>" + user.hobby + "</td>";
					html += "<td>" + user.address + "</td>";
					html += "</tr>";
				}
				$("#user_tbody").html(html);
			},
			error : function(res){
				alert(res);
			}
		});
	})
</script>
</body>
</html>