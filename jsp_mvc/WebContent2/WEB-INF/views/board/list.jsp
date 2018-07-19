<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
	<div class="container">
		<div>
			<select id="searchType">
				<option value="bTitle">제목</option>
				<option value="userName">작성자</option>
				<option value="bText">내용</option>
			</select>
			<input type="text" id="searchText">
			<button type="button" id="search">검색</button>
		</div>
		<table class="table" id="boardList">
			<tr>
				<th data-field="bNum">번호</th>
				<th data-field="bTitle">제목</th>
				<th data-field="userName">작성자</th>
				<th data-field="bCredat">작성일</th>
				<th data-field="bCretim">작성시간</th>
				<th data-field="bModdat">수정일</th>
				<th data-field="bModtim">수정시간</th>
			</tr>
			<tbody id="board_tbody">
				<tr>
					<td colspan="7">게시물이 없습니다.</td>
				</tr>
			</tbody>
		</table>
		<div style="float:right">
			<button type="button" id="writeBtn">글쓰기</button>
		</div>
	</div>
<script>
	function makeTbody(res){
		var tObj = document.getElementById(this.targetId);
		var html =""
		for(var idx in res){
			var b = res[idx];
			html += "<tr>";
			html += "<td>" + b.bNum + "</td>";
			html += "<td><a href='#' onclick='move(" + b.bNum + ")'>" + b.bTitle + "</a></td>";
			html += "<td>" + b.userName + "</td>";
			html += "<td>" + b.bCredat + "</td>";
			html += "<td>" + b.bCretim + "</td>";
			html += "<td>" + b.bModdat + "</td>";
			html += "<td>" + b.bModtim + "</td>";
			html += "</tr>";
		}
		$("#board_tbody").html(html);
		 
	}
	function move(bNum){
		location.href='/views/board/view?bNum=' + bNum;
	}
	function get(url, data, func){
		$.ajax({
			url : url,
			dataType : 'json',
			data : data,
			success :func,
			error : function(err){
				alert('err : ' + err.responseHTML);
			},
			targetId : 'boardList'
		})
	}
	$(document).ready(function(){
		get('/board/list', '',makeTbody);
		
		$('#search').click(function(){
			var searchType = $('#searchType').val();
			var searchText = $('#searchText').val();
			var p = {};
			p[searchType] = searchText;
			p = JSON.stringify(p);
			p = 'param=' + encodeURIComponent(p);
			get('/board/list',p,makeTbody);
		})
		$('#writeBtn').click(function(){
			location.href='/views/board/write';
		})
		
		
	})
</script>	
</body>
</html>