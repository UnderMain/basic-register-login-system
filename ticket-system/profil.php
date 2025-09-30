
<?php
session_start();
if (isset($_SESSION['id'])) {


}else {
    header("Location: index.php?error=nichtEingeloggt");
    exit();
}

$name = $_SESSION['name'];
$email = $_SESSION['email'];
$uuid = $_SESSION['uuid'];
$id = $_SESSION['id'];

$msg = "Wilkommen <strong>".$name."</strong> auf deinem Profil!";

?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/10d059be6c.js" crossorigin="anonymous"></script>
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
        <span class="mb-0" class="text-white"><i class="fas fa-address-card"></i> <u>Dein PRofil</span></u>
        <br>
        <br>
        <p class="text"><?php echo $msg?></p>
        </center>
        <br>
        <br>
      <center>
        <?php echo '<img src="https://minotar.net/helm/'.$name.'/100.png" class="rounded mx-auto d-block z-depth-1" alt="...">' ?>
      </center>

        <br>
        <br>
        <label for="inputDisabledEx2" class="disabled"><i class="fas fa-tags"></i> Benutzername:</label>
        <?php echo '<input value="'.$name.'" type="text" id="inputDisabledEx2" class="form-control" disabled>' ?>
        <br>
        <br>
        <label for="inputDisabledEx2" class="disabled"><i class="fas fa-envelope"></i> Email:</label>
        <?php echo '<input value="'.$email.'" type="text" id="inputDisabledEx2" class="form-control" disabled>' ?>
        <br>
        <br>
        <label for="inputDisabledEx2" class="disabled"><i class="fas fa-lightbulb"></i> UUID:</label>
        <?php echo '<input value="'.$uuid.'" type="text" id="inputDisabledEx2" class="form-control" disabled>' ?>
<br>
<br>
<br>
<div class="container">
  <center>
    <form form method="post" action="manager/weiterleitungManager.php">
      <button type="submit" name="back" class="btn btn-outline-danger btn-lg  text"><i class="fas fa-angle-double-left"></i> Zurück</button>
    </form>
  </center>
</div>
      </div>
      </div>
    </div>
  </body>
</html>
