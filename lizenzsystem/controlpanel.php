<?php

if (!isset($_SESSION['loggedin'])) {
  header("Location: index.php?nichtEingeloggt");
  exit();
}else{

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
    <h1>Wilkommen im Controlpanel</h1>
    <div class="nav">
    <a href="loggedin.php">Debug</a><br>
    <a href="produkte.php">Produkte</a><br>
    <a href="lizenzen.php">Lizenzen</a><br>
    </div>
    <div class="container">


    </div>
  </body>
</html>
