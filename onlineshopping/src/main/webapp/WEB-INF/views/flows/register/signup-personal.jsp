<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">

					<!-- Form Elements -->
					<sf:form class="form-horizontal" method="post" id="registerForm" modelAttribute="user">

						<div class="form-group">
							<label class="control-label col-md-4">First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" placeholder="First Name"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" placeholder="Last Name"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" placeholder="abc@zyx.com"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" placeholder="XXXXXXXXXX" maxlength="10"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" placeholder="Password"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
								<label class="radio-inline">
									<sf:radiobutton path="role" value="USER" checked="checked"/> User
								</label>
								<label class="radio-inline">
									<sf:radiobutton path="role" value="SUPPLIER"/> Supplier
								</label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>
						
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../shared/flows-footer.jsp"%>