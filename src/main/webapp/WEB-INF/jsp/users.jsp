<%@ include file="../layouts/taglib.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('.triggerRemove').click(function(e){
			e.preventDefault();
			$('#userModelRemove .removeBtn').attr("href", $(this).attr("href"));
			$('#userModelRemove').modal();
		});
	});
</script>

<table class="table table-bordered table-hover">
	<thead>
		<tr class="success">
			<th>User Name</th>
			<th>Delete user information</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="users">
			<tr>
				<td><a href="<spring:url value='/users/${users.id}'/>">
						 <c:out value="${users.name}"/> </a></td>
				<td><a href="<spring:url value = '/users/remove/${users.id}'/>"
					class="btn btn-danger triggerRemove">Delete</a>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="userModelRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remove User</h4>
			</div>
			<div class="modal-body">
				Are you sure to remove this user?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href="" class="btn btn-danger removeBtn">Remove</a>
			</div>
		</div>
	</div>
</div>