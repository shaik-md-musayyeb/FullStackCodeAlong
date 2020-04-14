<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<nav>
		<img src="./assets/logo.svg" alt="logo"/>
		<ul>
			<li><a href="${pageContext.request.contextPath }/login">Login</a></li>
			<li><a href="${pageContext.request.contextPath }/signup">Sign Up</a></li>
		</ul>
		
	</nav>
	<div class="welcome-back"> LEARN. CODE.. REPEAT...</div>
	<div class="sub-text"> CODEWALL is a collaboration learning platform for each enthusiastic. Developers across the world
		contribute /discuss about modern technology, web-development and all things about coding.</div>
	<div class="signup-form">
		<div class="title">SIGN UP</div>
		<form action="${pageContext.request.contextPath }/signup" method="post">
			<label class="label" for="email">Email</label>
			<input type="text" name="email" id="email" />
			
			<label class="label" for="password">Password</label>
			<input type="password" name="password" id="password" />
			<div class="password-hint">Must consists of at least 8 characters, a symbol, an upper and a lower case letter </div>
			
			<label class="label" for="confirmPassword">Confirm Password</label>
			<input type="password" name="confirmPassword" id="password" />
			${message}
			<button class="button" type="submit">Sign Up</button>
			
		</form>
	</div>
</body>
</html>