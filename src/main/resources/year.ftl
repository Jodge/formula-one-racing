<#include "/partials/header.ftl">
	<div class="row">
	  <div class="col-md-3"></div>
	  <div class="col-md-6">
		<h2>${year} Formula 1 - Standings</h2>
		<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select Year
				<span class="caret"></span></button>
				<ul id="yearList" class="dropdown-menu">
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
<#include "/partials/footer.ftl">

