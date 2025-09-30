
<?php
session_start();
if (isset($_SESSION['id'])) {


}else {
    header("Location: index.php?error=nichtEingeloggt");
    exit();
}

$name = $_SESSION['name'];


    $msg = "Wilkommen <strong>".$name."</strong> im Control-Panel!";

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
        <span class="mb-0" class="text-white"><i class="fas fa-cog"></i> <u>Control panel</span></u>
        <br>
        <br>
        <p class="text"><?php echo $msg?></p>
        </center>
        <br>
        <br>
        <div class="container">
          <form form method="post" action="manager/weiterleitungManager.php">
            <p class="text"><i class="fas fa-pen"></i> Falls du ein Ticket schreiben möchtest </p>
            <button type="submit" name="ticket-schreiben" class="btn btn-outline-primary btn-lg btn-block text"><i class="fas fa-chevron-right"></i> klick </button>
          </form>
        </div>
        <br>
        <br>
        <div class="container">
          <form form method="post" action="manager/weiterleitungManager.php">
            <p class="text"><i class="fas fa-clipboard-check"></i> Deine Tickets</p>
            <button type="submit" name="tickets-anzeigen" class="btn btn-outline-primary btn-lg btn-block text"><i class="fas fa-chevron-right"></i> klick</button>
          </form>
        </div>
        <br>
        <br>
        <div class="container">
          <form form method="post" action="manager/weiterleitungManager.php">
            <p class="text"><i class="fas fa-address-card"></i> Dein Profil</p>
            <button type="submit" name="profiln" class="btn btn-outline-primary btn-lg btn-block text"><i class="fas fa-chevron-right"></i> klick</button>
          </form>
        </div>
        <br>
        <br>
        <div class="container">
          <center>
            <form form method="post" action="manager/logoutManager.php">
              <button type="submit" class="btn btn-outline-danger btn-lg  text"><i class="fas fa-sign-out-alt"></i></i> Ausloggen</button>
            </form>
          </center>
        </div>
      </div>
      </div>
    </div>
  </body>
</html>
