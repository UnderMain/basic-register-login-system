<?php
session_start();
require 'db-con.php';
require 'config.php';

if (isset($_GET['success'])) {
  if ($_GET['success'] == "y") {
      
  }else {

header("Location: index.php?keinTicket");

  }
}else {

  header("Location: index.php?keinTicket");

}


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.12.0/js/mdb.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.12.0/css/mdb.min.css" rel="stylesheet">


    <title><?php echo $ServerName ?> | Ticket-System</title>
</head>
<body class="font" >
    
<div class="container">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="jumbotron font shadow-lg p-3 mb-5 bg-white rounded border border-dark">
  <h2 class="display-4 text-success"><center>Glückwunsch</center></h2>
  <br>
  <hr>
  <br>
  <br>
  <br>

  <center><p class="lead">Unser System hat dein Anliegen aufgenommen</p>
  <p class="lead">Du solltest innerhalb von Paar Tagen eine Antwort bekommen!</p></center>
  <br>
  <center><a href="index.php" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Zurück zum Anfang</a></center>
  <br>
  <br>
<br>

<br>


<br>
  <hr>
  <br>

</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</div>

</body>
</html>