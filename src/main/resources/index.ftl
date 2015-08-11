<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8"/>
		<title>Ergast Moto Racing</title>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
	</head>
	<body>
		<h1>Ergast Moto Racing</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Race</th>
					<th>Points</th>
				</tr>
			</thead>
			<tbody>	
			<#list motors as motor>
				<tr>
					<td>${motor.position}</td>
					<td>${motor.name}</td>
					<td>${motor.race}</td>
					<td>${motor.points}</td>
				</tr>
			</#list>							
			</tbody>
		</table>
	</body>
</html>