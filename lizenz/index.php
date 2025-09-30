<?php
require 'php/dbh.inc.php';
session_start();
?>

<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>undermain</title>

    <link href="assets/fonts/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="icon" href="assets/img/favicon.png" type="image/png" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <noscript>Bitte nutze einen neueren Browser mit JavaScript Unterstützung!</noscript>



</head>
<body>

<h1>Lizenz-System</h1>
<br>
<h2>Neue Lizenz erstellen</h2>


<form method="post" action="manager/lizenzManager.php">
 <div class="form-group">
   <label for="Lizenz" class="text-white"><i class="fas fa-barcode"></i> Lizenz</label>
   <input type="lizenz" class="form-control" name="lizenz" placeholder="XX-XX-XX-XX">
 </div>
 <div class="form-group">
   <label for="Email" class="text-white"><i class="fas fa-envelope"></i> E-Mail</label>
   <input type="email" class="form-control" name="email" placeholder="name@beispiel.de">
 </div>
 <div class="form-group">
   <label for="Name" class="text-white"><i class="fas fa-signature"></i> Name</label>
   <input class="form-control" name="name" placeholder="Max Mustermann">
 </div>
 <div class="form-group">
   <label for="Produkt" class="text-white"><i class="fas fa-tag"></i> Produkt</label>
   <input class="form-control" name="produkt" placeholder="Produkt">
 </div>
 <div class="form-group">
   <label for="Bestellnummer" class="text-white"><i class="fas fa-cannabis"></i> Bestellnummer</label>
   <input class="form-control" name="bestellnummer" placeholder="#XXXX">
 </div>
<br>

  <button type="submit" class="btn btn-secondary btn-lg btn-block" name="submit"><i class="fas fa-check-circle"></i> Abschicken</button>
</form>

</body>
</html>
