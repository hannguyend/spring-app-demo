<%@ include file="../layouts/taglib.jsp"%>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('.nav-tabs a:first').tab('show') // Select first tab
				$('.triggerRemove').click(
						function(e) {
							e.preventDefault();
							$('#blogModelRemove .removeBtn').attr("href",
									$(this).attr("href"));
							$('#blogModelRemove').modal();
						});
				$('.addBlog').validate(
						{
							rules : {
								name : {
									required : true,
									minlength : 3
								},
								url : {
									required : true,
									minlength : 3,
									url : true
								},
							},
							highlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-success').addClass('has-error');
							},
							unhighlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-error').addClass('has-success');
							}
						});
			});
</script>


<form:form commandName="blogC" cssClass="form-horizontal addBlog">
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">New Blog</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Blog</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">URL</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary triggerSubmit"
						value="Save" />
				</div>
			</div>
		</div>
	</div>
</form:form>

<br />


<div>
	<!-- Nav tabs -->
	<ul class="nav nav-tabs">
		<c:forEach items="${user.blogs}" var="blog">
			<li><a href="#blog_${blog.id}" data-toggle="tab"><c:out
						value="${blog.name}" /></a></li>
		</c:forEach>
	</ul>

	<!-- Tab panels -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div class="tab-pane" id="blog_${blog.id}">
				<h1>
					<c:out value="${blog.name}" />
				</h1>
				<p>
					<c:out value="${blog.url}" />
				</p>
				<a href="<spring:url value='/blog/remove/${blog.id}'/>"
					class="btn btn-danger triggerRemove">Remove Blog</a>
				<p></p>
				<table class="table table-hover table-bordered">
					<thead>
						<tr class="success">
							<th>Title</th>
							<th>Link</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.items}" var="item">
							<tr>
								<td>${item.title}</td>
								<td><a href="${item.link}" target="_blank">"${item.link}"</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="blogModelRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
			</div>
			<div class="modal-body">Are you sure that you want to remove
				this?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href="" class="btn btn-danger removeBtn">Remove</a>
			</div>
		</div>
	</div>
</div>