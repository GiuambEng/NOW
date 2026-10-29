<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>:: TIM ::</title>

<!-- build:css -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="bower_components/angular-ui/build/angular-ui.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="assets/app/app.css" />
<!-- endbuild -->

<link rel="icon" type="image/png" href="img/tim-icon.png" />
</head>
<!-- RU_856 -->
<body class="exit">
	<div class="page-container">
		<!-------------------------        HEADER SECTION       START ----------------------------- -->
		<section class="headerbg">
			<div class="header-container">
				<div class="logo" style="height: 300px;">
					<img src="img/logo.png" alt="logo">
				</div>
			</div>
		</section>
		<section class="help-container">
			<div class="help-section"></div>
		</section>
		<div class="ng-scope">
		<!-- SM_8655 -->
			<div class="banner-section ng-scope" >
				<div class="banner-content">
					
				</div>
				<div style="color:white; margin-left: 30px; font-size: 1.5em; padding-left: 10px;padding-right: 10px">${sessionScope.messaggioDaMostrare}</div>
			</div>
			<section class="menu-container">
				<div class="row menu" style="height: 200px"> </div>
			</section>
		</div>
	</div>
</body>
</html>
