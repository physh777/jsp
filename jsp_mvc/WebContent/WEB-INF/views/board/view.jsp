<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String bNum = request.getParameter("bNum");
%>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td><%=bNum%></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="userName" disabled></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="bTitle" disabled></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea id="bText" disabled></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="deleteBtn">삭제</button>
					<button type="button" id="modifyBtn">수정</button>
					<button type="button" id="listBtn">목록이동</button>
				</td>
			</tr>
		</table>
	</div>
<script>
	$(document).ready(function(){
		var param = {};
		param["bNum"] = "<%=bNum%>";
		param = JSON.stringify(param);
		$.ajax({
			url : '/board/view',
			dataType : 'json',
			data : 'param=' + encodeURIComponent(param),
			success : function(res){
				for(var key in res){
					$('#' + key).val(res[key]);
				}
			},
			error : function(err){
				alert('err : ' + err.responseHTML);
			}
		})
		
		$('#deleteBtn').click(function(){
			var param = {};
			param["bNum"] = "<%=bNum%>";
			param = JSON.stringify(param);
			$.ajax({
				url : '/board/delete',
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
		
		$('#modifyBtn').click(function(){
			if($('#bTitle').attr('disabled')=='disabled'){
				$('#bTitle').removeAttr('disabled');
				$('#bText').removeAttr('disabled');
			}else{
				var param = {};
				param["bNum"] = "<%=bNum%>";
				param['bTitle'] = $('#bTitle').val();
				param['bText'] = $('#bText').val();
				param = JSON.stringify(param);
				$.ajax({
					url : '/board/update',
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
			}
		})
	})
</script>	
</body>
</html>