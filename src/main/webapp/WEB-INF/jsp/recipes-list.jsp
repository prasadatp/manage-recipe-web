<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-recipe">Add Favourite Recipes</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3> Dear ${userName}! List of your favourite Recipes</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="10%">Recipe Name</th>
						<th width="10%">Is Veg?</th>
						<th width="10%">Creation Date</th>
						<th width="5%">Suitable for</th>
						<th width="30%">Ingredients List</th>
						<th width="30%">Cooking Instructions</th>
						<th width="5%"></th>
						<th width="5%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${recipes}" var="recipe">
						<tr>
							<td>${recipe.name}</td>
							<td>${recipe.veg}</td>

							<td><fmt:formatDate value="${recipe.creationDate}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>

							<td>${recipe.suitableForNoOfPeople}</td>
							<td>${recipe.ingredientsList}</td>
							<td>${recipe.cookingInstructions}</td>

							<td><a type="button" class="btn btn-primary"
								href="/update-recipe?id=${recipe.id}">Update</a>
								</td><td>
							<a type="button" class="btn btn-danger"
								href="/delete-recipe?id=${recipe.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>