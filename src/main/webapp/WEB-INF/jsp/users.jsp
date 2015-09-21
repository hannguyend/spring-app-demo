<%@ include file="../layouts/taglib.jsp"%>

<table class="table table-bordered table-hover">
	<thead>
		<tr class = "success">
			<th>User Name</th>
			<th>Delete user information</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="users">
			<tr>
				<td><a href="<spring:url value='/users/${users.id}'/>">
						${users.name} </a></td>
				<td><a href = "<spring:url value = '/users/remove/${users.id}'/>" class ="btn btn-danger">Delete</a>
			</tr>

		</c:forEach>
	</tbody>

</table>