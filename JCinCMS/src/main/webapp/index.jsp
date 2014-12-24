<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="首页">
<meta http-equiv="description" content="This is my page">
<link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
					class="brand" href="#"><img src="/images/w3r.png" width="111"
					height="30" alt="w3cschool logo" />
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a>
						</li>
						<li><a href="#about">About</a>
						</li>
						<li><a href="#contact">Contact</a>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="leaderboard">
			<h1>w3cschool Web Store</h1>
			<p>Try and purchase HTML5, JS, Ruby, PHP-MySQL based web apps to
				enhance your productivity at affordable price.</p>
			<p>
				<a class="btn btn-success btn-large">Sign Up for a 30 day free
					trial</a>
			</p>
		</div>
		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>HTML5 and JS Apps</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh,ut fermentum massa justo sit amet risus. Etiam porta sem
					malesuada magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-success btn-large" href="#">View apps</a>
				</p>
			</div>
			<div class="span4">
				<h2>Ruby Apps</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh,ut fermentum massa justo sit amet risus. Etiam porta sem
					malesuada magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-success btn-large" href="#">View apps</a>
				</p>
			</div>
			<div class="span4">
				<h2>PHP MySQL Apps</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</p>
				<p>
					<a class="btn btn-success btn-large" href="#">View apps</a>
				</p>
			</div>
		</div>
		<hr>
		<footer>
		<p>&copy; Company 2012</p>
		</footer>
	</div>
	<!-- /container -->
</body>
</html>
