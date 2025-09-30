<?php
$msg = "test";
require 'manager/dbh.inc.php';
session_start();
if (!isset($_SESSION['loggedin'])) {
  header("Location: index.php?fehler");
  exit();
}else{
  $msg = "Wilkommen ".$_SESSION['name'];
}

 ?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <?php echo $msg ?>
    <a href="index.php">home</a>

  </body>
</html>
