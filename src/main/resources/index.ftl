<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8"/>
		<title>2015 Formula 1 - Standings</title>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
	</head>
	<body>
	<div class="row">
	  <div class="col-md-3"></div>
	  <div class="col-md-6">
		<h2>2015 Formula 1 - Standings</h2>
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