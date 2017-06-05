<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	
		<div id="main" class="row">
			<div class="col-md-6">
				<h4>Sign up</h4>
				<hr />
		      
				<form name="signUpForm" method="post" action="signUpProcess">
			      	<div class="form-group">
				        <label class="col-md-2 control-label">Email:</label>
				        <div class="col-md-10">
				          <input class="form-control" name="email" autofocus/><br />
				        </div>
			      	</div>
			      	<div class="form-group">
				    	<label class="col-md-2 control-label">Password:</label>
						<div class="col-md-10">
							<input class="form-control" name="password" type="password"/><br/>
				        </div>
					</div>
					<div class="form-group">
				    	<label class="col-md-2 control-label">Name:</label>
						<div class="col-md-10">
							<input class="form-control" name="name"/><br/>
				        </div>
					</div>
					<div class="form-group">
			        	<div class="col-md-offset-2 col-md-10">
			          	<input type="submit" value="Sign up" class="btn btn-default" />
			        	</div>
			      	</div>
				</form>
			
			<div class="clearfix"></div>
			<div class="blank-20"></div>
				<div class="form-group">
			      	<p><a href="/Account/SignIn">Already a member?</a></p>
			   </div>
			</div>
		
		  <div class="col-md-6">
		    <img src="/resources/img/logo.jpg" class="logo-md" alt="lgoo" />
		  </div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>

