<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Favourite Recipe</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="recipe">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:errors path="name"  cssClass="text-warning" style="color:red"/><br>
							<form:label path="name">Recipe Name</form:label>
							<form:input path="name" type="text" class="form-control"
								required="required" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="veg">Is Veg?</form:label>
							<form:radiobutton path="veg" value="true" />Yes
							<form:radiobutton path="veg" value="false"/>No<br/>
						</fieldset>

						<fieldset class="form-group">
							<form:errors path="suitableForNoOfPeople" cssClass="text-warning" style="color:red"/><br>
							<form:label path="suitableForNoOfPeople">Suitable for no of people</form:label>
							<form:input path="suitableForNoOfPeople" type="number" class="form-control"
								required="required" />
						</fieldset>

						<fieldset class="form-group">
							<form:errors path="ingredientsList" cssClass="text-warning" style="color:red"/><br>
							<form:label path="ingredientsList">Ingredients List</form:label>
							<form:textarea path="ingredientsList" type="txt" class="form-control"
								required="required" />
						</fieldset>

						<fieldset class="form-group">
							<form:errors path="cookingInstructions" cssClass="text-warning" style="color:red"/><br>
							<form:label path="cookingInstructions">Cooking Instructions</form:label>
							<form:textarea path="cookingInstructions" type="txt" class="form-control"
								required="required" />
						</fieldset>

						<button type="submit" class="btn btn-primary">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>