<?php
require 'manager/dbh.inc.php';
session_start();

if (!isset($_SESSION['loggedin'])) {
  $msg = '';
}else{
  header("Location: controlpanel.php");
  exit();
  $msg = '<a href="manager/logout.inc.php">Ausloggen</a><br>';
}

?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <noscript>Bitte nutze einen neueren Browser mit JavaScript Unterstützung!</noscript>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="assets/img/favicon.png" type="image/png" />
    <title></title>
  </head>
  <body>


<div class="container">
  <form class="box" action="manager/login.inc.php" method="post">
    <h1>Lizenzsystem | Login</h1>
    <input type="text" name="uid" placeholder="Username">
    <input type="password" name="pwd" placeholder="Password">
    <input type="submit" name="submit" value="Login">
  </form>
</div>

<br>
<?php echo $msg ?>
    <a href="loggedin.php">Debug</a><br>
    <a href="produkte.php">Produkte</a><br>
    <a href="lizenzen.php">Lizenzen</a><br>

  </body>
</html>
