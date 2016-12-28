<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Оленеводы</title>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
<link href="http://code.jquery.com/ui/jquery-ui-git.css" rel="stylesheet">
<!--     <link href="dashboard.css" rel="stylesheet"> -->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Оленеводы</a>0
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" role="tablist">
					<li role="presentation" class="active"><a href="#Users" aria-controls="Users" role="tab" data-toggle="tab">Пользователи</a></li>
					<li role="presentation"><a href="#Teams" aria-controls="Teams" role="tab" data-toggle="tab">Команды</a></li>
					<li role="presentation"><a href="#Games" aria-controls="Games" role="tab" data-toggle="tab">Игры</a></li>
					<!-- <li role="presentation"><a href="#AirplaneTypes" aria-controls="AirplaneTypes" role="tab" data-toggle="tab">Типы самолетов</a></li> -->
					<!-- <li role="presentation"><a href="#Airports" aria-controls="Airports" role="tab" data-toggle="tab">Аэропорты</a></li> -->
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="Users">
						<h1 class="page-header">Пользователи</h1>
						<button id="editUserBtn" type="button" data-toggle="modal" data-target="#editUser" hidden="true">Edit user</button>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="bg-primary">
										<th>#</th>
										<th>ID</th>
										<th>Логин</th>
										<th>Email</th>
										<th>Дата регистрации</th>
										<th>Права</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${usersList}" var="user" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td>${user.id}</td>
											<td>${user.name}</td>
											<td>${user.email}</td>
											<td>${user.date}</td>
											<td>${user.role}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="Teams">
						<h1 class="page-header">Команды</h1>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="bg-primary">
										<th>#</th>
										<th>ID</th>
										<th>Название</th>
										<th>Email</th>
										<th>Дата создания</th>
										<th>Лига</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${teamsList}" var="team" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td>${team.id}</td>
											<td>${team.name}</td>
											<td>${team.email}</td>
											<td>${team.date}</td>
											<td>${team.league}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="Games">
						<h1 class="page-header">Игры</h1>
						<a class="btn btn-success" href="<c:url value="/EditGame/0" />">Создать</a>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="bg-primary">
										<th>#</th>
										<th>ID</th>
										<th>Номер</th>
										<th>Название</th>
										<th>Дата</th>
										<th>Авторы</th>
										<th>Редактировать</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${gamesList}" var="game" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td>${game.id}</td>
											<td>${game.num}</td>
											<td>${game.name}</td>
											<td>${game.date}</td>
											<td></td>
											<td><a href="<c:url value="/EditGame/" /> ${game.id}">Edit</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Edit user Modal -->
	<div class="modal fade" id="editUser" tabindex="-1" role="dialog" aria-labelledby="editUserLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="editUserLabel">Редактирование пользователя:</h4>
				</div>
				<div class="modal-body">
					<form:form action="updateUser" commandName="editUser" id="editUserForm" method="POST">
						<form:input path="id" hidden="true" type="text" id="editUserId" />
						<div class="form-group row">
							<label for="editUserName" class="col-xs-2 col-form-label">Логин</label>
							<div class="col-xs-10">
								<form:input path="name" class="form-control" type="text" id="editUserName" />
							</div>
						</div>
						<div class="form-group row">
							<label for="editUserEmail" class="col-xs-2 col-form-label">Email</label>
							<div class="col-xs-10">
								<form:input path="email" class="form-control" type="text" id="editUserEmail" />
							</div>
						</div>
						<div class="form-group row">
							<label for="editUserDate" class="col-xs-2 col-form-label">Date</label>
							<div class="col-xs-10">
								<form:input path="date" class="form-control" id="editUserDate" />
							</div>
						</div>
						<div class="form-group row">
							<label for="editUserRole" class="col-xs-2 col-form-label">Права</label>
							<div class="col-xs-10">
								<form:select path="role" class="form-control" id="editUserRole">
									<c:forEach items="${userRolesList}" var="role" varStatus="status">
										<option>${role}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="editUserSubmit">Сохранить</button>
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
	<script src="<c:url value="/resources/main.js" />"></script>
</body>
</html>
