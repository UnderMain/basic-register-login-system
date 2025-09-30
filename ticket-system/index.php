
<?php
if (isset($_SESSION['id'])) {

  header("Location: cp.php?error=schonEingeloggt");
  exit();
}else {

}
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/10d059be6c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <title></title>
  </head>
  <body class="bg-primary">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div class="container-fluid text">
      <div class="container">
        <div class="jumbotron bg-dark">
          <center>
            <span class="mb-0" class="text-white"><i class="fas fa-ticket-alt"></i> Ticket-System</span>
            <small id="emailHelp" class="form-text text-muted">Setzte deine Daten mit /setlogin auf unserem Server</small>
          </center>
          <br>
          <form class="text-white" method="post" action="manager/loginManager.php">
            <div class="form-group">
              <label for="email" class="text-white"><i class="fas fa-envelope"></i> email</label>
              <input type="email" class="form-control" name="mailuid" aria-describedby="emailHelp">
            </div>
            <div class="form-group">
              <label for="passwort" class="text-white"><i class="fas fa-lock"></i> Passwort</label>
              <input type="password" class="form-control" name="pwd">
            </div>
            <br>
            <center>
            <button type="submit" name="login-submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Einloggen</button>
          </center>
          </form>
        </div>

      </div>

    </div>
  </body>
</html>
