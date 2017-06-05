<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	
		<div id="signIn" class="row">
			<div class="col-md-6">
				<h4>Sign in</h4>
				<hr />
		      
				<form name="signInForm" method="post" action="signInProcess">
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
			        	<div class="col-md-offset-2 col-md-10">
			          		<input type="submit" value="Sign in" class="btn btn-default" /><br />
			        	</div>
			      	</div>
				</form>
				
				<div class="clearfix"></div>
				<div class="blank-20"></div>
				<div class="form-group col-md-12">
					<p><a href="/Account/FindPW">Forgot password?</a></p>
					<p><a href="/Account/SignUp">New member?</a></p>
			   </div>
		  </div>
		
		  <div class="col-md-6">
		    <img src="/resources/img/logo.jpg" class="logo-md" alt="lgoo" />
		  </div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>