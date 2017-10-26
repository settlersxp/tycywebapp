<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<title>NASTYCRAFT | Gamster Community</title>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">




<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="static/css/nastycraft.css" rel="stylesheet" media="screen">
<link href="static/css/checkbox.css" rel="stylesheet" media="screen">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="static/js/nastycraft.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="icon" type="image/png" href="static/images/fav.png">
</head>

<body class="body-custom">
	<%
		Object loggedIn = session.getAttribute("loggedIn");
	%>

	<c:choose>
		<c:when test="${loggedIn eq true}">

			<!-- Start NavBar -->
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Nastycraft Admin CP</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="/admincp">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">General Options <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="newsletter">Send Newsletter</a></li>
								<li><a href="#">Page 1-2</a></li>
								<li><a href="#">Page 1-3</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="all-tasks">Donations Menu <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/rankcp">Ranks Menu</a></li>
								<li><a href="/newrank">New Ranks</a></li>
								<li><a href="/newrankoption">New Ranks Options</a></li>
								<li><a href="/rankoptioncp">Ranks Options Menu</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Vote Menu <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/newvote">Create new vote box</a></li>
								<li><a href="/votecp">Vote Edit</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Forum<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/newforum">Add Forum</a></li>
								<li><a href="/forumcp">Forum Edit </a></li>

							</ul></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="/logOut"><span
								class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
					</ul>
				</div>
			</nav>



			<!-- Finish Nav bar -->
			<c:choose>
				<c:when test="${mode == 'NEWEMAIL'}">

					<div class="container text-center" id="taskDiv">

						<h3>Send newsletter</h3>
						<hr>
						<div class="row">
							<div class="col-xs-6">
								<form class="form-horizontal" action="sendnewsletter"
									method="POST">
									<div class="form-group" style="width: 650px;">
										<div class="col-sm-10">
											<input type="text" class="form-control" placeholder="Subject"
												name="subject"> <br />
											<textarea class="form-control"
												placeholder="Nasticraft Newsletter" name="textarea"></textarea>
											<br /> <br />

											<button type="submit" class="btn btn-default pull-left">Send
												Newsletter</button>
										</div>

									</div>
								</form>
							</div>
							<div class="col-xs-6">
								<div class="alert alert-warning text-left">
									<strong>Emails in database!</strong>
									<br />
									<p>${emailsavailable}</p>
								</div>
							</div>
						</div>


					</div>
					<c:choose>
						<c:when test="${send == true}">
							<br>
							<div class="alert alert-info text-center">
								<strong>Success</strong> You send the newslettler.
							</div>
						</c:when>

						<c:when test="${emptyFields == true}">
							<br>
							<div class="alert alert-danger">
								<strong>Error ! One or both fields are empty, please fill them up </strong>
							</div>
						</c:when>
					</c:choose>

				</c:when>

				<c:when test="${mode == 'NEWRANK' || mode == 'UPDATERANK'}">

					<div class="container text-center" id="taskDiv">

						<h3>Create new rank</h3>
						<hr>
						<div class="row">
							<div class="col-xs-6">
								<form class="form-horizontal" action="saveranks" method="POST">
									<div class="form-group" style="width: 650px;">
										<input type="hidden" name="id" value="${ranksup.id}" />
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="Enter the rank title" name="ranktitle"
												value="${ranksup.ranktitle}"> <br /> <input
												type="text" class="form-control"
												placeholder="Enter the img name" name="rankimg"
												value="${ranksup.rankimg}"> <br /> <input
												type="text" class="form-control"
												placeholder="Enter the rank price" name="rankprice"
												value="${ranksup.rankprice}"> <br /> <input
												type="text" class="form-control"
												placeholder="Enter the background img title or leave blank"
												name="titlebg" value="${ranksup.titlebg}"> <br /> <input
												type="text" class="form-control"
												placeholder="Enter the color for the title and price"
												name="titlecolor" value="${ranksup.titlecolor}"> <br />
											<button type="submit" class="btn btn-default pull-left">Add
												Rank</button>
										</div>

									</div>
								</form>
							</div>
							<div class="col-xs-6">
								<div class="alert alert-warning text-left">
									<strong>Images name should be written without
										extensions !</strong>
									<p>Example: imgname / Not imgname.png</p>
									<br> <strong>Colors for the title and price
										should be written in hexadecimal format !</strong>
									<p>Example: #0066ff</p>
								</div>
							</div>
						</div>

						<div class="alert alert-info text-left">
							<strong>Background title images names: </strong>
							<p>bg1 to bg9</p>
							<strong>Title and Price color samples: </strong>
							<p>
								<span style="color: #00e600;">#00e600</span> <span
									style="color: #9933ff;">#9933ff</span> <span
									style="color: #e600e6;">#e600e6</span> <span
									style="color: #0066ff;">#0066ff</span>

							</p>
						</div>

					</div>

				</c:when>

				<c:when test="${mode == 'RANK'}">

					<div class="container text-center" id="taskDiv">
						<h3>Ranks Options</h3>
						<hr>
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered text-center text-info bg-pimary"
								style="background-color: #D8D8D8;">
								<thead>
									<tr>
										<th class="bg-inverse text-center">Id</th>
										<th class="bg-inverse text-center">Rank Title</th>
										<th class="bg-inverse text-center">Img name</th>
										<th class="bg-inverse text-center">Price</th>
										<th class="bg-inverse text-center">Title Color</th>
										<th class="bg-inverse text-center">Background img name</th>
										<th class="bg-inverse text-center">Edit</th>
										<th class="bg-inverse text-center">Delete</th>
									</tr>
								<thead>
								<tbody>
									<c:forEach var="rank" items="${ranksList}">
										<tr>
											<td>${rank.id}</td>
											<td>${rank.ranktitle}</td>
											<td>${rank.rankimg}</td>
											<td>${rank.rankprice}</td>
											<td><span style="color:${rank.titlecolor}">${rank.titlecolor}</span></td>
											<td><img src="static/images/${rank.titlebg}.gif"
												width="24" height="24"></td>
											<td class="text-center"><a
												href="updateranks?id=${rank.id}"><span
													class="glyphicon glyphicon-pencil"></span></a></td>
											<td class="text-center"><a
												href="deleteranks?id=${rank.id}"><span
													class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

							<c:choose>
								<c:when test="${addedr == true}">
									<a href="/newrank" class="btn btn-primary pull-left"><span
										class="glyphicon glyphicon-plus"></span> Add More</a>
									<br />
									<br />
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>

								<c:when test="${deletedr == true}">
									<br />
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>

								<c:when test="${addNoMore == true}">
									<br>
									<div class="alert alert-danger">
										<strong>Error ! You are not allowed to add more than
											4 ranks.</strong>
									</div>
								</c:when>
							</c:choose>
						</div>
					</div>

				</c:when>

				<c:when
					test="${mode == 'NEWRANKOPTION' || mode == 'UPDATERANKOPTION'}">

					<div class="container text-center" id="taskDiv">
						<h3>Create new rank option</h3>
						<hr>
						<form class="form-horizontal" action="saveranksoption"
							method="POST">
							<div class="form-group" style="width: 890px;">
								<input type="hidden" name="id" value="${rankOptionsup.id}" />
								<div class="col-sm-10">
									<input type="text" class="form-control"
										placeholder="Enter the rank option name" name="name"
										value="${rankOptionsup.name}"> <br />


									<div class="pull-left">
										<!--  <label for="default" class="btn btn-default">CHECK ALL <input type="checkbox" id="default" class="badgebox"><span class="badge">&check;</span></label> -->
										<label for="success" class="btn btn-success">HELPER <input
											type="checkbox" id="success" class="badgebox" value="green"
											name="helper"
											${rankOptionsup.helper == 'green' ? 'checked' : ''}><span
											class="badge">&check;</span></label> <label for="danger"
											class="btn btn-purple">MODERATOR <input
											type="checkbox" id="danger" class="badgebox" value="green"
											name="moderator"
											${rankOptionsup.moderator == 'green' ? 'checked' : ''}><span
											class="badge">&check;</span></label> <label for="info"
											class="btn btn-pink">ADMIN <input type="checkbox"
											id="info" class="badgebox" value="green" name="admin"
											${rankOptionsup.admin == 'green' ? 'checked' : ''}><span
											class="badge">&check;</span></label> <label for="primary"
											class="btn btn-primary">OPERATOR<input
											type="checkbox" id="primary" class="badgebox" value="green"
											name="operator"
											${rankOptionsup.operator == 'green' ? 'checked' : ''}><span
											class="badge">&check;</span></label>

									</div>
									<br /> <br /> <br />
									<button type="submit" class="btn btn-default pull-left">Add
										Rank Option</button>
								</div>

							</div>
						</form>
					</div>

				</c:when>

				<c:when test="${mode == 'RANKOPTION' || mode == 'UPDATERANKOPTION'}">

					<div class="container text-center" id="taskDiv">
						<h3>Ranks Options</h3>
						<hr>
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered text-center text-info bg-pimary"
								style="background-color: #D8D8D8;">
								<thead>
									<tr>
										<th class="bg-inverse text-center">Id</th>
										<th class="bg-inverse text-center">NAME</th>
										<th class="bg-inverse text-center">HELPER</th>
										<th class="bg-inverse text-center">MODERATOR</th>
										<th class="bg-inverse text-center">ADMIN</th>
										<th class="bg-inverse text-center">OPERATOR</th>
										<th class="bg-inverse text-center">Edit</th>
										<th class="bg-inverse text-center">Delete</th>
									</tr>
								<thead>
								<tbody>
									<c:forEach var="rankO" items="${ranksOptionsList}">
										<tr>
											<td>${rankO.id}</td>
											<td>${rankO.name}</td>
											<td><img src="static/images/${rankO.helper}.png"
												width="24" height="24" /></td>
											<td><img src="static/images/${rankO.moderator}.png"
												width="24" height="24" /></td>
											<td><img src="static/images/${rankO.admin}.png"
												width="24" height="24" /></td>
											<td><img src="static/images/${rankO.operator}.png"
												width="24" height="24" /></td>
											<td class="text-center"><a
												href="updaterankoption?id=${rankO.id}"><span
													class="glyphicon glyphicon-pencil"></span></a></td>
											<td class="text-center"><a
												href="deleterankoption?id=${rankO.id}"><span
													class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

							<c:choose>
								<c:when test="${addedr == true}">
									<a href="/newrankoption" class="btn btn-primary pull-left"><span
										class="glyphicon glyphicon-plus"></span> Add More</a>
									<br />
									<br />
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>

								<c:when test="${deletedr == true}">
									<br />
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>

							</c:choose>
						</div>
					</div>

				</c:when>




				<c:when test="${mode == 'NEWVOTE' || mode == 'UPDATEVOTE'}">

					<div class="container text-center" id="taskDiv">
						<h3>Create new vote box</h3>
						<hr>
						<form class="form-horizontal" action="savevote" method="POST">
							<div class="form-group" style="width: 650px;">
								<input type="hidden" name="id" value="${voteup.id}" />
								<div class="col-sm-10">
									<input type="text" class="form-control"
										placeholder="Enter the voting title" name="title"
										value="${voteup.title}"> <br /> <input type="text"
										class="form-control" placeholder="Enter the img name"
										name="imglink" value="${voteup.imglink}"> <br /> <input
										type="text" class="form-control"
										placeholder="Enter the voting link" name="votelink"
										value="${voteup.votelink}"> <br />

									<button type="submit" class="btn btn-default pull-left">Add
										Vote</button>
								</div>

							</div>
						</form>
					</div>

				</c:when>

				<c:when test="${mode == 'VOTE'}">

					<div class="container text-center" id="taskDiv">
						<h3>Voting boxes</h3>
						<hr>
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered text-center text-info bg-pimary"
								style="background-color: #D8D8D8;">
								<thead>
									<tr>
										<th class="bg-inverse text-center">Id</th>
										<th class="bg-inverse text-center">Title</th>
										<th class="bg-inverse text-center">Img link</th>
										<th class="bg-inverse text-center">Voting Link</th>
										<th class="bg-inverse text-center">Edit</th>
										<th class="bg-inverse text-center">Delete</th>
									</tr>
								<thead>
								<tbody>
									<c:forEach var="vote" items="${votingList}">
										<tr>
											<td>${vote.id}</td>
											<td>${vote.title}</td>
											<td>${vote.imglink}</td>
											<td>${vote.votelink}</td>
											<td class="text-center"><a
												href="updatevoting?id=${vote.id}"><span
													class="glyphicon glyphicon-pencil"></span></a></td>
											<td class="text-center"><a
												href="deletevoting?id=${vote.id}"><span
													class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

							<c:choose>

								<c:when test="${addedv == true}">
									<a href="/newvote" class="btn btn-primary pull-left"><span
										class="glyphicon glyphicon-plus"></span> Add More</a>
									<br />
									<br />
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>

								<c:when test="${deletedv == true}">
									<br />
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>

								<c:when test="${addNoMoreVote == true}">
									<br>
									<div class="alert alert-danger">
										<strong>Error ! You are not allowed to add more than
											4 voting box.</strong>
									</div>
								</c:when>

							</c:choose>
						</div>
					</div>

				</c:when>

				<c:when test="${mode == 'NEWFORUM' || mode == 'UPDATEFORUM'}">

					<div class="container text-center" id="taskDiv">
						<h3>New forum link</h3>
						<hr>
						<form class="form-horizontal" action="saveforum" method="POST">
							<div class="form-group" style="width: 650px;">
								<input type="hidden" name="id" value="${links.id}" />
								<div class="col-sm-10">
									<input type="text" class="form-control"
										placeholder="Enter forum Link" name="link"
										value="${links.link}"> <br />
									<button type="submit" class="btn btn-default pull-left">Add
										Link</button>
								</div>

							</div>
						</form>
					</div>

				</c:when>


				<c:when test="${mode == 'FORUM'}">
					<div class="container text-center" id="taskDiv">
						<h3>Forum</h3>
						<hr>
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered text-center text-info bg-pimary"
								style="background-color: #D8D8D8;">
								<thead>
									<tr>
										<th class="bg-inverse text-center">Id</th>
										<th class="bg-inverse text-center">Link</th>
										<th class="bg-inverse text-center">Edit</th>
										<th class="bg-inverse text-center">Delete</th>
									</tr>
								<thead>
								<tbody>
									<c:forEach var="links" items="${linkk}">
										<tr>
											<td>${links.id}</td>
											<td>${links.link}</td>
											<td class="text-center"><a
												href="updateforum?id=${links.id}"><span
													class="glyphicon glyphicon-pencil"></span></a></td>
											<td class="text-center"><a
												href="deleteforum?id=${links.id}"><span
													class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

							<c:choose>
								<c:when test="${added == true}">
									<br>
									<div class="alert alert-success">
										<strong>Success!</strong>
									</div>
								</c:when>
							</c:choose>
						</div>
					</div>
				</c:when>


				<c:when test="${mode == 'ADMINCP'}">
					<hr>
					<div class="text-center text-primary jumbotron">
						<h1>Welcome to Admin CP</h1>
					</div>
				</c:when>

			</c:choose>

		</c:when>

		<c:otherwise>
			<c:choose>
				<c:when test="${mode == 'HOME'}">
					<div class="container">
						<div class="card card-container">

							<img id="profile-img" class="profile-img-card"
								src="static/images/logo.png" width="96" height="96" />
							<p id="profile-name" class="profile-name-card">Nasticraft
								Admin CP</p>
							<form class="form-signin" method="POST" action="login-user">
								<span id="reauth-email" class="reauth-email"></span> <input
									type="text" id="inputEmail" class="form-control"
									placeholder="name" name="name" required autofocus> <input
									type="password" id="inputPassword" class="form-control"
									placeholder="password" name="password" required>
								<div id="remember" class="checkbox">
									<label> <input type="checkbox" value="remember-me">
										Remember me
									</label>
								</div>
								<button class="btn btn-lg btn-primary btn-block btn-signin"
									type="submit">Sign in</button>
							</form>
							<!-- /form -->
							<p id="profile-name" class="profile-name-card">
								&copy; <a href="http://nasticraft.ro" class="forgot-password">nasticraft.ro
								</a> | <a href="" class="forgot-password">Created By TyCy </a>
							</p>

							<c:choose>
								<c:when test="${wrong_password == true}">
									<br>
									<div class="alert alert-danger">
										<strong>Error!</strong> Wrong Details!
									</div>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${log_out == true}">
									<br>
									<div class="alert alert-info">
										<strong>Info!</strong> Logged Out
									</div>
								</c:when>
							</c:choose>

						</div>
						<!-- /card-container -->
					</div>
					<!-- /container -->
				</c:when>


				<c:otherwise>
					<!-- Not log in script. -->

					<div class="container">
						<div class="card card-container">

							<img id="profile-img" class="profile-img-card"
								src="static/images/logo.png" width="96" height="96" />
							<p id="profile-name" class="profile-name-card">Website Admin
								CP</p>
							<br>
							<div class="alert alert-danger text-center">
								<strong>Error!</strong> You are not Logged In!
							</div>

							<div class="text-center">
								<a href="/redirectLogIn"><button type="button"
										class="btn btn-warning">Click Here To Log In</button></a>
							</div>

						</div>
						<!-- /card-container -->
					</div>
					<!-- /container -->
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>






</body>
</html>
