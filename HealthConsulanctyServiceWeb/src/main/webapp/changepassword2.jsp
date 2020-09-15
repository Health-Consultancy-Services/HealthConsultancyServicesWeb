<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>View Doctor</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Change Password</a></li>
					<li><a href="/show-patient">Patient list</a></li>
					<li><a href="/show-doctor">Doctor list</a></li>
				</ul>
			</div>
		</div>
	</div>
      <div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<div class="form-group" style=" color: red; ">
					<c:if test="${not empty error}">
					<h5>${error}</h5>
					</c:if>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Old Password</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email" required data-validation-required-message="This field is required"
								value="${user.email }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">New Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password" required data-validation-required-message="This field is required"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Confirm Password</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="role" required data-validation-required-message="This field is required"/>
						</div>
					</div>
					<div class="form-group ">
					<style>                                                        
.btn-success, .btn-success.disabled {
    background: #26dad2;
    border: 1px solid #26dad2;
    -webkit-box-shadow: 0 2px 2px 0 rgba(40, 190, 189, 0.14), 0 3px 1px -2px rgba(40, 190, 189, 0.2), 0 1px 5px 0 rgba(40, 190, 189, 0.12);
    box-shadow: 0 2px 2px 0 rgba(40, 190, 189, 0.14), 0 3px 1px -2px rgba(40, 190, 189, 0.2), 0 1px 5px 0 rgba(40, 190, 189, 0.12);
    -webkit-transition: 0.2s ease-in;
    -o-transition: 0.2s ease-in;
    transition: 0.2s ease-in
}

.btn-success.disabled:hover, .btn-success:hover {
    background: #26dad2;
    -webkit-box-shadow: 0 14px 26px -12px rgba(40, 190, 189, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(40, 190, 189, 0.2);
    box-shadow: 0 14px 26px -12px rgba(40, 190, 189, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(40, 190, 189, 0.2);
    border: 1px solid #26dad2
}

.btn-success.active, .btn-success.disabled.active, .btn-success.disabled:active, .btn-success.disabled:focus, .btn-success:active, .btn-success:focus {
    background: #1eacbe;
    -webkit-box-shadow: 0 14px 26px -12px rgba(40, 190, 189, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(40, 190, 189, 0.2);
    box-shadow: 0 14px 26px -12px rgba(40, 190, 189, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(40, 190, 189, 0.2)
}
.btn-danger, .btn-danger.disabled {
    background: #ef5350;
    border: 1px solid #ef5350;
    -webkit-box-shadow: 0 2px 2px 0 rgba(239, 83, 80, 0.14), 0 3px 1px -2px rgba(239, 83, 80, 0.2), 0 1px 5px 0 rgba(239, 83, 80, 0.12);
    box-shadow: 0 2px 2px 0 rgba(239, 83, 80, 0.14), 0 3px 1px -2px rgba(239, 83, 80, 0.2), 0 1px 5px 0 rgba(239, 83, 80, 0.12);
    -webkit-transition: 0.2s ease-in;
    -o-transition: 0.2s ease-in;
    transition: 0.2s ease-in
}

.btn-danger.disabled:hover, .btn-danger:hover {
    background: #ef5350;
    -webkit-box-shadow: 0 14px 26px -12px rgba(239, 83, 80, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(239, 83, 80, 0.2);
    box-shadow: 0 14px 26px -12px rgba(239, 83, 80, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(239, 83, 80, 0.2);
    border: 1px solid #ef5350
}

.btn-danger.active, .btn-danger.disabled.active, .btn-danger.disabled:active, .btn-danger.disabled:focus, .btn-danger:active, .btn-danger:focus {
    background: #e6294b;
    -webkit-box-shadow: 0 14px 26px -12px rgba(239, 83, 80, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(239, 83, 80, 0.2);
    box-shadow: 0 14px 26px -12px rgba(239, 83, 80, 0.42), 0 4px 23px 0 rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(239, 83, 80, 0.2)
}

                                                            </style>
						<input type="submit" class="btn btn-success" value="Submit" />
						<input type="reset" class="btn btn-danger" value="Reset" />
					</div>
					</form>
					</div>
</body>
</html>