<%@ include file="../layouts/taglib.jsp" %>

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>user name</th>
		</tr>
		<tr>
	<tbody>
		<c:forEach items="${users}" var="users">
			<tr>
				<td>
					<a href = "<spring:url value='/users/${users.id}'/>">
					${users.name}
					</a>
				</td>
			</tr>

		</c:forEach>
	</tbody>
	</tr>
	</thead>
</table>