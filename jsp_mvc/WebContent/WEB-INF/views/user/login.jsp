<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	.login-form {
		width: 385px;
		margin: 30px auto;
	}
    .login-form form {        
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .login-btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .input-group-addon .fa {
        font-size: 18px;
    }
    .login-btn {
        font-size: 15px;
        font-weight: bold;
    }
	.social-btn .btn {
		border: none;
        margin: 10px 3px 0;
        opacity: 1;
	}
    .social-btn .btn:hover {
        opacity: 0.9;
    }
	.social-btn .btn-primary {
        background: #507cc0;
    }
	.social-btn .btn-info {
		background: #64ccf1;
	}
	.social-btn .btn-danger {
		background: #df4930;
	}
    .or-seperator {
        margin-top: 20px;
        text-align: center;
        border-top: 1px solid #ccc;
    }
    .or-seperator i {
        padding: 0 10px;
        background: #f7f7f7;
        position: relative;
        top: -11px;
        z-index: 1;
    }   
</style>
<body>
<div class="login-form">
    <form action="/examples/actions/confirmation.php" method="post">
        <h2 class="text-center">Sign in</h2>   
        <div class="form-group">
        	<div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" id="id" placeholder="Username" required="required">				
            </div>
        </div>
		<div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" id="pwd" placeholder="Password" required="required">				
            </div>
        </div>        
        <div class="form-group">
            <button type="button" id="login" class="btn btn-primary login-btn btn-block">Sign in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right" id="forgotPwd">Forgot Password?</a>
        </div>
    </form>
    <p class="text-center text-muted small">Don't have an account? <a href="#" id="join">Sign up here!</a></p>
</div>
<script>
	$('#login').click(function(){
		var id = $('#id').val();
		if(id.trim().length<4){
			alert('아이디는 4글자 이상입니다.')
			$('#id').val('');
			$('#id').focus();
			return;
		}

		var pwd = $('#pwd').val();
		if(pwd.trim().length<4){
			alert('비밀번호는 4글자 이상입니다.')
			$('#pwd').val('');
			$('#pwd').focus();
			return;
		}
		var p = {id:id,pwd:pwd};
		p = JSON.stringify(p);
		$.ajax({
			url:'/user/login',
			dataType:'json',
			data:'cmd=login&param=' + encodeURIComponent(p),
			success : function(res){
				alert(res.msg);
				location.href="/";
			},
			error : function(res){
				alert('error : ' + res.responseText);
			}
		})
	})
</script>
</body>
</html>