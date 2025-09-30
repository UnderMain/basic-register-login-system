<?php
require 'manager/dbh.inc.php';
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

<h1>Deine Käufe:</h1>
<?php
$stmt = $conn->query("SELECT * FROM wp_woocommerce_downloadable_product_permissions WHERE user_email ='$email'");
if($stmt->num_rows > 0){
  while ($zeile = $stmt->fetch_assoc()) {
    if($zeile['product_id'] == 3284){
      $pr = "Ticket-System";
    }elseif ($zeile['product_id'] ==3405) {
      $pr = "UFC - utilities for citybuild";
    }elseif ($zeile['product_id'] ==3423) {
      $pr = "Citybuild-System";
    }elseif ($zeile['product_id'] ==3424) {
      $pr = "Bungee-System";
    }
      echo '#'.$zeile['order_id'].' Produkt: '.$pr.' Email: '.$zeile['user_email'].'<br>';
  }

}else {
  echo"Du hast noch keine Produkte gekauft!";
}
 ?>
  </body>
</html>
