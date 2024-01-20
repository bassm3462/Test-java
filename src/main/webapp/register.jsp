<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>

<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
          class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
      ${requestScope.status}
        <form method="post" action="RegisterServlat">
          <!-- name input -->
          <div class="form-outline mb-4">
            <input type="text" id="form1Example13" name="name" class="form-control form-control-lg" />
            <label class="form-label" for="form1Example13">name </label>
          </div>
          <!-- email input -->
          <div class="form-outline mb-4">
            <input type="email" id="form1Example23"name="email" class="form-control form-control-lg" />
            <label class="form-label" for="form1Example23">email</label>
          </div>
          <!-- Password input -->
          <div class="form-outline mb-4">
            <input type="password" id="form1Example23" name="pass" class="form-control form-control-lg" />
            <label class="form-label" for="form1Example23">Password</label>
          </div>
          

          <div class="d-flex justify-content-around align-items-center mb-4">
            <!-- Checkbox -->
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
              <label class="form-check-label" for="form1Example3"> Remember me </label>
            </div>
            <a href="#!">Forgot password?</a>
          </div>

          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-lg btn-block">Regiser now</button>
        </form>
      </div>
    </div>
  </div>
</section>
</body>
</html>