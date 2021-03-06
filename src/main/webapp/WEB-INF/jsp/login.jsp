<%@ include file="../layouts/taglib.jsp"%>
<style>
.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
<form:form  cssClass="form-signin"
	action='/spring-app-demo/j_spring_security_check' method='POST'>
	<h2 class="form-signin-heading">Please sign in</h2>
	<label for="inputEmail" class="sr-only">User</label>
	<input type="text"
		name='j_username' id="inputEmail" class="form-control"
		placeholder="Name" required autofocus/>
	<label
		for="inputPassword" class="sr-only">Password</label>
	<input
		type='password' name='j_password' id="inputPassword"
		class="form-control" placeholder="Password" required/>
	<button class="btn btn-lg btn-primary btn-block" name="submit"
		type="submit" value="Login">Sign in</button>
</form:form>
