<?php
require 'manager/dbh.inc.php';
require 'manager/dbh0.inc.php';
session_start();
if (!isset($_SESSION['loggedin'])) {
  header("Location: index.php?fehler");
  exit();
}else{
  $msg = "Wilkommen ".$_SESSION['name'];
}

$email = $_SESSION['email'];


 ?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
<?php

$stmt1 = $conn->query("SELECT * FROM wp_woocommerce_downloadable_product_permissions WHERE user_email ='$email'");
if($stmt1->num_rows > 0){
  $stmt = $mysql->query("SELECT * FROM lizenz WHERE email ='$email'");
  if($stmt->num_rows > 0){
    while ($zeile = $stmt->fetch_assoc()) {

      if($zeile['ip'] == NULL){
        $msg = "Die Lizenz wurde noch nicht benutzt!";
      }else{
        $msg = "Die Lizenz wurde auf die IP: ".$zeile['ip']." gebunden.";

      }

        echo ''.$zeile['bestellnummer'].' Produkt: '.$zeile['produkt'].' Lizenz: '.$zeile['lizenz'].' Status: '.$msg.'<br>';
    }
  }else{
    echo "Bitte warte 10-20 Minuten bis deine Lizenz angemeldet ist!";
  }
}else{
  echo"Du hast noch kein Produkt gekauft!";
}



 ?>
  </body>
</html>
