<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Оленеводы</title>
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
<link href="http://code.jquery.com/ui/jquery-ui-git.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Оленеводы (${title})</a>
		</div>
		<div class="navbar-form navbar-right">
			<a class="btn btn-default" href="<c:url value="/" />">Отмена</a>
			<a class="btn btn-success" href="<c:url value="/EditGame/0" />">Сохранить</a>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" role="tablist">
					<li role="presentation" class="active"><a href="#Common" aria-controls="Common" role="tab" data-toggle="tab">Основное</a></li>
					<li role="presentation"><a href="#Codes" aria-controls="Codes" role="tab" data-toggle="tab">Коды</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="Common">
						<h1 class="page-header">Основное</h1>
						<form:form method="POST" commandName="game" action="saveLevel">
							<div class="form-group row">
								<label for="number" class="col-xs-2 col-form-label">Номер</label>
								<div class="col-xs-10">
									<input class="form-control" type="text" id="number" value="${game.num}">
								</div>
							</div>
							<div class="form-group row">
								<label for="name" class="col-xs-2 col-form-label">Название</label>
								<div class="col-xs-10">
									<input class="form-control" type="search" id="name" value="${game.name}">
								</div>
							</div>
							<div class="form-group row">
								<label for="date" class="col-xs-2 col-form-label">Дата</label>
								<div class="col-xs-10">
									<input class="form-control" type="text" id="date" value="${game.date}">
								</div>
							</div>
							<div class="form-group row">
								<label for="location" class="col-xs-2 col-form-label">Зона игры</label>
								<div class="col-xs-10">
									<input class="form-control" type="text" id="location" value="${game.location}">
								</div>
							</div>
							<div class="form-group row">
								<label for="author" class="col-xs-2 col-form-label">Авторы</label>
								<div class="col-xs-10">
									<input class="form-control" type="text" id="author" value="${game.author}">
								</div>
							</div>
							<div class="form-group row">
								<label for="legend" class="col-xs-2 col-form-label">Легенда</label>
								<div class="col-xs-10">
									<textarea class="form-control" rows="5" id="legend" value="${game.legend}"></textarea>
								</div>
							</div>
						</form:form>
					</div>
					<div role="tabpanel" class="tab-pane" id="Codes">
						<h1 class="page-header">Коды</h1>
						<p>
							<button id="addCodeBtn" class="btn btn-sm btn-success">Добавить</button>
							<button id="removeCodeBtn" class="btn btn-sm btn-danger">Удалить</button>
						</p>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="bg-primary">
										<th><input type="checkbox"></th>
										<th>Номер</th>
										<th>Код</th>
										<th>КО</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${codesList}" var="code" varStatus="status">
										<tr>
											<td><input type="checkbox"></td>
											<td><input type="number" value="${code.num}" /></td>
											<td>${level.name}</td>
											<td>${level.type}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="Lines">
						<h1 class="page-header">Линейки</h1>
						<!-- 						<div class="table-responsive"> -->
						<!-- 							<table class="table table-striped"> -->
						<!-- 								<thead> -->
						<!-- 									<tr class="bg-primary"> -->
						<!-- 										<th>#</th> -->
						<!-- 										<th>ID</th> -->
						<!-- 										<th>Название</th> -->
						<!-- 										<th>Email</th> -->
						<!-- 										<th>Дата создания</th> -->
						<!-- 										<th>Лига</th> -->
						<!-- 									</tr> -->
						<!-- 								</thead> -->
						<!-- 								<tbody> -->
						<%-- 									<c:forEach items="${teamsList}" var="team" varStatus="status"> --%>
						<!-- 										<tr> -->
						<%-- 											<td>${status.count}</td> --%>
						<%-- 											<td>${team.id}</td> --%>
						<%-- 											<td>${team.name}</td> --%>
						<%-- 											<td>${team.email}</td> --%>
						<%-- 											<td>${team.date}</td> --%>
						<%-- 											<td>${team.league}</td> --%>
						<!-- 										</tr> -->
						<%-- 									</c:forEach> --%>
						<!-- 								</tbody> -->
						<!-- 							</table> -->
						<!-- 						</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
	<script src="<c:url value="/resources/jquery-3.1.1.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap.min.js" />"></script>
	<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/editLevel.js" />"></script>
</body>
</html>
