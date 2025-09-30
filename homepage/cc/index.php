<?php
require '../php/dbh.inc.php';

session_start();

if (!isset($_SESSION['loggedin'])) {
    header('Location: login.php');
    exit();
}

$stmt1 = "SELECT * FROM kontakt WHERE status=1 ORDER BY id ASC";
$stmt0 = "SELECT status FROM kontakt WHERE status=1 ORDER BY id ASC";

$queryy = $conn->query($stmt0);

if(mysqli_num_rows($queryy) > 0) {

    $msg1 = "";

}else {

  $msg1 = '
  <br>
  <br>
  <div class="alert alert-warning " role="alert">
    <i class="fas fa-info-circle "></i> <h1>Es gibt zurzeit keine Anfragen!</h1>
  </div>
  ';

}

?>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>undermain - control</title>
    <link rel="icon" href="../assets/img/favicon.png" type="image/png" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <link href="../assets/fonts/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <noscript>Bitte nutze einen neueren Browser mit JavaScript UnterstÃ¼tzung!</noscript>

    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
  <div id="content">

    <h1><i class="fas fa-cogs"></i> undermain - control panel</h1>
    <center><a href="../php/logout.inc.php"><i class="fas fa-sign-out-alt"></i></a>   <a href="../index.php"><i class="fas fa-home"></i></a></center>



<br>
<br>
<br>

<hr>

    <h2><i class="fas fa-file-signature"></i> Anfragen</h2>
    <?php
    echo $msg1;
foreach($conn->query($stmt1) as $row) {

  echo '

  <br>
  <br>
<form>
<fieldset disabled>
     <div class="form-row">
    <div class="form-group col-md-2">
    <label for="id" class="text-white">ID</label>
         <input type="text" name="id" class="form-control" placeholder="'.$row['id'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">Name</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['name'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">Datum</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['datum'].'">
    </div>

    <div class="form-group col-md-6">
    <label for="email" class="text-white">Email</label>
       <input type="email" name="email" class="form-control" placeholder="'.$row['email'].'">
    </div>

    <div class="form-group col-md-12">
        <label for="antwort" class="text-white">Nachricht</label>
        <textarea class="form-control" id="antwort" rows="6" placeholder="'.$row['text'].'"></textarea>
    </div>

    </div>
</fieldset>
</form>



  ';

}
?>

<hr>
<h2><i class="fas fa-clipboard-check"></i> Abhaken </h2>
<br>
<br>
<center>
  <form method="post" action="manager/updateManager.php">
      <div class="form">
      <div class="form-group col-md-1">
           <input name="id" class="form-control" placeholder="ID">
      </div>
      <div class="form-group col-md-2">
        <button type="submit" name="submit" class="btn btn-dark">Senden</button>
      </div>
      </div>
  </form>
</center>
<hr>
<h2><i class="fas fa-comment-alt"></i> Feeds </h2>
<br>

<form action="../php/addfeed.inc.php" method="post">

    <label for="label" class="text-white">Allgemeines</label>
    <select id="label" name="label" class="form-control">
        <option class="option" value="0">(Keine Auswahl)</option>
        <option class="option" value="Ankündigung">Ankündigung</option>
        <option class="option" value="Update">Update</option>
        <option class="option" value="Sonstiges">Sonstiges</option>
    </select>
    <input id="title" name="title" placeholder="Titel des Feeds" class="form-control">
    <br>
    <label for="message" class="text-white">Nachricht</label>
    <textarea rows="8" id="message" name="message" placeholder="Inhalt des Feeds" class="form-control"></textarea>
    <input type="submit" name="submit-addfeed" value="Feed posten" class="btn btn-dark">
</form>

<hr>

  </div>
</body>
</html>
