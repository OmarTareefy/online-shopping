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
					<sf:form class="form-horizontal" method="post" id="registerForm"
						modelAttribute="billing">

						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" placeholder="Enter Address Line One"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line Two</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo" placeholder="Enter Address Line Two"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" placeholder="City"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" placeholder="State"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" placeholder="Country"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" placeholder="Postal Code"
									class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary"
									name="_eventId_personal">
									<span class="glyphicon glyphicon-chevron-left"></span> Previous - Personal
								</button>
								
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirm">
									Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span> 
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