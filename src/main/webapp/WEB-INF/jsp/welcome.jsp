<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Home Page</div>
		<div class="panel-body">
			Welcome ${userName}!! <a href="/recipes-list">Click here</a> to manage
			your Recipes.
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>