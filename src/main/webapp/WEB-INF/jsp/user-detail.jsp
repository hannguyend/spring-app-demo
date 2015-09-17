<%@ include file="../layouts/taglib.jsp" %>

<h1>${user.name}</h1>

<c:forEach items = "${user.blogs}" var = "blog">

	<h1>${blog.name}</h1>
	<p>${blog.url}</p>
	
	<table class= "table table-hover table-bordered">
		<thead>
			<tr class = "success">
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${blog.items}" var = "item">
				<tr>
					<td>${item.title}</td>
					<td>${item.link}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</c:forEach>