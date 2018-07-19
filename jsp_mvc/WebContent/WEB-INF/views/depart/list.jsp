<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.pop{display:none;position:absolute;width:100%;height:100%;background-color:black;z-index:9999;opacity:0.9}
</style>
<body> 
	<div class="pop"> 
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
			<button type="button" style="align:center" id="closeBtn">닫기</button>
		</div> 
	</div>
	<div class="container">
		<table class="table">
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>부서설명</th>
				<th>부서인원</th>
			</tr>
			<tbody id="departTbody">
				<tr>
					<td colspan="4">부서정보가 없습니다.</td>
				</tr>
			</tbody>
		</table>
	</div>
<script>
	$(document).ready(function(){
		$('#closeBtn').click(function(){

			$('.pop').hide();
		})
		var p = {};
		p = JSON.stringify(p);
		
		$.ajax({
			url : '/depart/list',
			data : 'param=' + encodeURIComponent(p),
			dataType : 'json',
			success : function(res){
				var html =""
				for(var idx in res){
					var dp = res[idx];
					html += "<tr>";
					html += "<td>" + dp.dpNum + "</td>";
					html += "<td><a href='#' onclick='showPop(" + dp.dpNum + ")'>" + dp.dpName + "<a/></td>";
					html += "<td>" + dp.dpDesc + "</td>";
					html += "<td>" + dp.cnt + "</td>";
					html += "</tr>";
				}
				$("#departTbody").html(html);
			},
			error : function(err){
				console.log(err);
			}
		})
	})
	function showPop(dpNum){
		var p = {dpNum:dpNum};
		p = JSON.stringify(p);

		$.ajax({
			url : '/user/list',
			data : 'cmd=list&param=' + encodeURIComponent(p),
			dataType : 'json',
			success : function(res){
				$('.pop').show();
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
			error : function(err){
				console.log(err);
			}
		})
	}
</script>	
</body>
</html>