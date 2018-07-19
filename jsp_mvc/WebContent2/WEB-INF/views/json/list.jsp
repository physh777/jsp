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
<div id="result" data-color="blue">내 색상은 : </div>
<button type="button">blue</button>
<button type="button">red</button>
<button type="button">yellow</button>
<button type="button">black</button>
<button type="button">white</button>

<script>
	var obj = $("#result");
	
	$("button").click(function(){
		$.ajax({
			url : "/user/userlist",
			data : {cmd:"color"},
			success : function(res){
				var map = JSON.parse(res);
				obj.css("background-color",map["color"]);
			}
		})
	});
</script>
</body>
</html>