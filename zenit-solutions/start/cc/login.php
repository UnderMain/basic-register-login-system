<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

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
    <title>START! - Minecraft Website</title>

    <link href="../assets/fonts/css/all.css" rel="stylesheet">

    <noscript>Bitte nutze einen neueren Browser mit JavaScript Unterstützung!</noscript>

    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body id="login">

<div id="login-section">

    <div class="login-form">
        <h1>Anmelden</h1>
        <h3>START! 🔐 Manager</h3>

        <?php
        if (isset($_GET['error'])) {
            if ($_GET['error'] == "empty") {
                echo '<p style="color: crimson; text-align: center">Bitte fülle alle Felder aus.</p>';
            } else if ($_GET['error'] == "incorrect") {
                echo '<p style="color: crimson; text-align: center">Benutzername oder Passwort falsch.</p>';
            }
        }
        ?>

        <form action="../php/login.inc.php" method="post">
            <label for="uid">Benutzername</label>
            <input type="text" id="uid" name="uid" placeholder="Benutzername">

            <label for="pwd">Passwort</label>
            <input type="password" id="pwd" name="pwd" placeholder="Passwort">

            <input type="submit" name="submit-login" value="Anmelden">
        </form>
    </div>
</div>

</body>
</html>