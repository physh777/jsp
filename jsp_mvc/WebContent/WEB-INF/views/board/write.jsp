<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>이름</th>
				<td>${user.name}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="bTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea id="bText"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="writeBtn">글등록</button> 
					<button type="button" id="listBtn">목록이동</button>
				</td>
			</tr>
		</table>
	</div>
<script>
	$(document).ready(function(){
		$('#writeBtn').click(function(){
			var param = {};
			param["bTitle"] = $('#bTitle').val();
			param["bText"] = $('#bText').val();
			param = JSON.stringify(param);
			$.ajax({
				url : '/board/write',
				dataType : 'json',
				data : 'param=' + encodeURIComponent(param),
				success : function(res){
					alert(res.msg);
					if(res.result=='true'){
						location.href='/views/board/list';
					}
				},
				error : function(err){
					alert('err : ' + err.responseHTML);
				}
			})
		})
	})
</script>	
</body>
</html>