<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8"/>
		<title>2015 Formula 1 - Standings</title>
		<link rel="icon" type="image/ico" href="/img/favicon/f1.ico">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
	</head>
	<body>
	<div class="row">
	  <div class="col-md-3"></div>
	  <div class="col-md-6">
		<h2>${year} Formula 1 - Standings</h2>
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select Year
			<span class="caret"></span></button>
				<ul class="dropdown-menu">
				<li><a href="#">2014</a></li>
				<li><a href="#">2015</a></li>
				<li><a href="#">2016</a></li>
			</ul>
		</div>
		&nbsp;
		&nbsp;
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Race</th>
					<th>Points</th>
				</tr>
			</thead>
			<tbody>	
			<#list formulaones as formulaone>
				<tr>
					<td>${formulaone.position}</td>
					<td><img src="/img/flags/${formulaone.nationality}.png"/>&nbsp;&nbsp;<a href="${formulaone.url}" target="_blank">${formulaone.name}</a></td>
					<td><a href="${formulaone.raceUrl}" target="_blank">${formulaone.race}</a></td>
					<td>${formulaone.points}</td>
				</tr>
			</#list>							
			</tbody>
		</table>
	  </div>
	  <div class="col-md-3"></div>
	</div>
	</body>
</html>