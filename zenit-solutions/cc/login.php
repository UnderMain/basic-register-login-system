
<?php
require '../php/dbh.inc.php';

session_start();

if (isset($_SESSION['loggedin'])) {
    header('Location: index.php');
    exit();
}
?>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>undermain - login</title>
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

  <div class="container">
    <div class="container">
      <div class="container">
        <div id="content">

<br>


        <h1><i class="fas fa-sign-in-alt"></i> Anmelden</h1>
        <br>
        <h3><i class="fas fa-user-cog"></i> undermain Control-Panel</h3>


        <form action="../php/login.inc.php" method="post">
            <label for="uid" class="text-white">Benutzername</label>
            <input type="text" id="uid" name="uid" placeholder="Benutzername" class="form-control">

            <label for="pwd" class="text-white">Passwort</label>
            <input type="password" id="pwd" name="pwd" placeholder="Passwort" class="form-control">

            <input type="submit" name="submit-login" value="Anmelden" class="form-control">
        </form>
</div>
</div>
</div>
</div>

</body>
</html>
