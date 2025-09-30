
<?php
session_start();
require 'manager/dbh.inc.php';
if (isset($_SESSION['id'])) {


}else {
    header("Location: index.php?error=nichtEingeloggt");
    exit();
}

$name = $_SESSION['name'];
$stmt1 = "SELECT ID, status, user, uuid, nachricht, thema, antwort, supporter FROM ticket WHERE status=0 AND name='".$name."'";


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
          <center><span class="mb-0" class="text-white"><i class="fas fa-pen"></i> <u>Ticket schreiben</span></u>
          <p class="text">Hier kannst du ein Ticket schreiben</p>
          </center>
          <br>
          <fieldset>
            <legend></legend>

              <fieldset>

                  <form class="text-white" method="post" action="manager/ticketManager.php">
                    <br>

                    <div class="form-row">

                    <div class="form-group col-md-12 left">
                      <label for="thema"><i class="fas fa-question"></i> Thema</label>
                      <input type="string" name="Thema" class="form-control" placeholder="Thema">
                    </div>

                    <div class="form-group col-md-12 left">
                        <label for="nachricht"><i class="fas fa-comment-alt"></i> Deine Nachricht</label>
                        <textarea class="form-control" name="Nachricht" rows="3" placeholder="Deine Nachricht"></textarea>
                    </div>

                    <br>

                    <div class="form-group col-md-12">
                    <label for="antwort"></label>
                    <button type="submit" class="btn btn-primary btn-lg btn-block" name="submit"><i class="fas fa-sign-in-alt"></i> Abschicken</button>
                    </div>


                  </Div>
                  </form>
            </fieldset>
          </fieldset>
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
