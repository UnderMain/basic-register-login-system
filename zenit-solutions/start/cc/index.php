<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
require '../php/dbh.inc.php';
require '../php/dbhh.inc.php';

session_start();

if (!isset($_SESSION['loggedin'])) {
    header('Location: login.php');
    exit();
}

$stmt1 = "SELECT * FROM kontakt WHERE status=1 ORDER BY id ASC";

$lizenzen = "SELECT * FROM lizenz ORDER BY id ASC";


$stmt0 = "SELECT status FROM kontakt WHERE status=1 ORDER BY id ASC";

$queryy = $conn->query($stmt0);

if(mysqli_num_rows($queryy) > 0) {

    $msg1 = "";

}else {

  $msg1 = '
  <br>
  <br>
    <h3>Es gibt zurzeit keine Anfragen!</h3><br>
  ';

}
?>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Zenit-Solutions | ControlCenter</title>

    <link href="../assets/fonts/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <noscript>Bitte nutze einen neueren Browser mit JavaScript Unterstützung!</noscript>

    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body class="controlcenter">

<div id="content">
    <div class="cc-header">
        <a href="../../index.php" class="logo">
            <img src="../../assets/img/logo_small.png" alt="Logo">
        </a>

        <div class="header-right">
            <a href="../php/logout.inc.php">Ausloggen</a>
        </div>
    </div>

    <div class="cc-badges">

        <div class="info-badge">
            <div class="left">
                <i class="fas fa-wallet"></i>
            </div>

            <div class="right">
                <h2>Umsatz</h2>
                <p id=""> 3.980€</p>
            </div>
        </div>

        <div class="info-badge">
            <div class="left">
                <i class="fas fa-portrait"></i>
            </div>

            <div class="right">
                <h2>Eingeloggt als</h2>
                <p><?= $_SESSION['uid'] ?></p>
            </div>
        </div>

        <div class="info-badge">
            <div class="left">
                <i class="fas fa-mail-bulk"></i>
            </div>

            <div class="right">
                <h2>Gepostete Feeds</h2>
                <?php
                if ($result = $conn->query("SELECT * FROM feeds")) {
                    $row_cnt = $result->num_rows;
                    echo '<p>' . $row_cnt . ' Feeds</p>';
                    $result->close();
                }

                ?>
            </div>
        </div>

        <div class="info-badge">
            <div class="left">
                <i class="fas fa-key"></i>
            </div>

            <div class="right">
                <h2>Anzahl Accounts</h2>
                <?php
                if ($result = $conn->query("SELECT * FROM users")) {
                    $row_cnt = $result->num_rows;
                    echo '<p>' . $row_cnt . ' Benutzer</p>';
                    $result->close();
                }

                ?>
            </div>
        </div>
    </div>

    <h1>ControlCenter</h1>
    <h3>Benutzer</h3>

    <div class="cc-management">
        <a href="#" id="toggleBtn-addUser" class="group-btn green">
            <span><i class="fas fa-user-plus"></i></span>
            Benutzer hinzufügen
        </a>

        <a href="#" id="toggleBtn-editUser" class="group-btn blue">
            <span><i class="fas fa-user-cog"></i></span>
            Benutzer bearbeiten
        </a>
    </div>

    <div id="toggle-addUser" style="display:none; margin-top: 30px">

        <?php
        if (isset($_GET['1error'])) {
            if ($_GET['1error'] == "empty") {
                echo '<p style="color: crimson;">Bitte fülle alle Felder aus.</p>';
            } else if ($_GET['1error'] == "invaliduid") {
                echo '<p style="color: crimson;">Der Name darf nur auf Buchstaben und Zahlen bestehen.</p>';
            } else if ($_GET['1error'] == "passwordcheck") {
                echo '<p style="color: crimson;">Die Passwörter stimmen nicht überein.</p>';
            } else if ($_GET['1error'] == "usertaken") {
                echo '<p style="color: crimson;">Benutzername bereits belegt.</p>';
            } else if ($_GET['1error'] == "sqlerror") {
                echo '<p style="color: crimson;">Datenbankfehler. Bitte Administrator kontaktieren.</p>';
            }
        } else if (isset($_GET['1success'])) {
            if ($_GET['1success'] == "added") {
                echo '<p style="color: limegreen;">Benutzer wurde erfolgreich hinzugefügt.</p>';
            }
        }
        ?>

        <form action="../php/adduser.inc.php" method="post">
            <label for="uid">Benutzername</label>
            <input type="text" id="uid" name="uid" placeholder="Benutzername">

            <label for="pwd">Passwort</label>
            <input type="password" id="pwd" name="pwd" placeholder="Passwort">

            <label for="pwd">Passwort wiederholen</label>
            <input type="password" id="pwd-repeat" name="pwd-repeat" placeholder="Passwort wiederholen">

            <input type="submit" name="submit-adduser" value="Benutzer erstellen">
        </form>
    </div>

    <div id="toggle-editUser" style="display:none; margin-top: 30px">

        <?php
        if (isset($_GET['2error'])) {
            if ($_GET['2error'] == "empty") {
                echo '<p style="color: crimson;">Bitte gebe ein Passwort ein, auf welches das Aktuelle geändert werden soll.</p>';
            } else if ($_GET['1error'] == "sqlerror") {
                echo '<p style="color: crimson;">Datenbankfehler. Bitte Administrator kontaktieren.</p>';
            }
        } else if (isset($_GET['2success'])) {
            if ($_GET['2success'] == "pwdchanged") {
                echo '<p style="color: limegreen;">Passwort wurde erfolgreich geändert.</p>';
            }
        } else if (isset($_GET['3success'])) {
            if ($_GET['3success'] == "removed") {
                echo '<p style="color: limegreen;">Benutzer wurde erfolgreich entfernt.</p>';
            }
        }
        ?>
        <table>
            <tr>
                <th>ID</th>
                <th>Benutzername</th>
                <th>Erstellt am</th>
                <th>Optionen</th>
            </tr>

            <?php
            $sql = "SELECT * FROM users";
            $result = $conn->query($sql);
            $resultCheck = $result->num_rows;

            if ($resultCheck > 0) {
                while ($row = $result->fetch_assoc()) {
                    $phpdate = strtotime($row['created']);
                    $date = date('d.m.Y', $phpdate) . ", um " . date('H:i', $phpdate) . " Uhr";
                    if ($row['userid'] === 'admin') {
                        echo '
                    <tr>
                    <td>' . $row['id'] . '</td>
                    <td>' . $row['userid'] . '</td>
                    <td>' . $date . '</td>
                    <td><form action="../php/editpwd.inc.php" method="post"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="password" name="newpwd" placeholder="Neues Passwort"><input type="submit" name="submit-editpwd" value="Passwort ändern"></form>
                    <form><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removeuser" value="Benutzer löschen" disabled></form></tr>';
                    } else {
                        echo '
                    <tr>
                    <td>' . $row['id'] . '</td>
                    <td>' . $row['userid'] . '</td>
                    <td>' . $date . '</td>
                    <td><form action="../php/editpwd.inc.php" method="post"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="password" name="newpwd" placeholder="Neues Passwort"><input type="submit" name="submit-editpwd" value="Passwort ändern"></form>
                    <form action="../php/removeuser.inc.php" method="post"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removeuser" value="Benutzer löschen"></form></td>
                    </tr>';
                    }
                }
            }
            ?>
        </table>
    </div>

    <h1>Feeds</h1>
    <h3>Management</h3>

    <div class="cc-management">
        <a href="#" id="toggleBtn-addFeed" class="group-btn yellow">
            <span><i class="fas fa-pencil-alt"></i></span>
            Neuen Feed verfassen
        </a>
    </div>

    <div id="toggle-addFeed" style="display:none; margin-top: 30px">

        <?php
        if (isset($_GET['4error'])) {
            if ($_GET['4error'] == "emptylabel") {
                echo '<p style="color: crimson;">Bitte wähle ein Thema für den Feed aus.</p>';
            } else if ($_GET['4error'] == "empty") {
                echo '<p style="color: crimson;">Bitte fülle alle Felder aus.</p>';
            } else if ($_GET['4error'] == "sqlerror") {
                echo '<p style="color: crimson;">Datenbankfehler. Bitte Administrator kontaktieren.</p>';
            }
        } else if (isset($_GET['4success'])) {
            if ($_GET['4success'] == "added") {
                echo '<p style="color: limegreen;">Feed wurde erfolgreich auf der Hauptseite gepostet.</p>';
            }
        }
        ?>

        <form action="../php/addfeed.inc.php" method="post">

            <label for="label">Allgemeines</label>
            <select id="label" name="label">
                <option class="option" value="0">(Keine Auswahl)</option>
                <option class="option" value="Ankündigung">Ankündigung</option>
                <option class="option" value="Update">Update</option>
                <option class="option" value="Sonstiges">Sonstiges</option>
            </select>

            <?php
            if (isset($_GET['title'])) {
                echo '<input type="text" id="title" name="title" placeholder="Titel des Feeds" value="' . $_GET['title'] . '">';
            } else {
                echo '<input type="text" id="title" name="title" placeholder="Titel des Feeds">';
            }
            ?>

            <label for="message">Nachricht</label>
            <?php
            if (isset($_GET['title'])) {
                echo '<textarea maxlength="8000" rows="8" id="message" name="message" placeholder="Inhalt des Feeds">' . $_GET['message'] . '"</textarea>';
            } else {
                echo '<textarea maxlength="8000" rows="8" id="message" name="message" placeholder="Inhalt des Feeds"></textarea>';
            }
            ?>

            <input type="submit" name="submit-addfeed" value="Feed posten">
        </form>
    </div>

    <h1>Kontakt-Formular</h1>
    <h3>Anfragen</h3>
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
       <input type="text" name="email" class="form-control" placeholder="'.$row['email'].'">
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

<h1> Abhaken </h1>
<h3>Hake erledigte Anfragen ab</h3>


  <form action="../../manager/updateManager.php" method="post">
            <label for="uid">ID der Anfrage</label>
            <input type="text" id="id" name="id" placeholder="ID">
            <input type="submit" name="submit" value="Senden">
        </form>

<h1> Lizenzsystem </h1>
<h3>Anlegen von Lizenzen</h3>

<form action="../../manager/lizenzManager.php" method="post">
            <label for="lizenz">Lizenz-Key</label>
            <input type="text" id="lizenz" name="lizenz" placeholder="XXX.XXX.XXX.XXX">

            <label for="email">E-Mail</label>
            <input type="text" id="email" name="email" placeholder="max@mustermann.de">

            <label for="name">Name</label>
            <input type="text" id="name" name="name" placeholder="Max Mustermann">

            <label for="produkt">Produkt</label>
            <input type="text" id="produkt" name="produkt" placeholder="Produktname">
            
            <label for="bestellnummer">Bestellnummer</label>
            <input type="text" id="bestellnummer" name="bestellnummer" placeholder="#XXXX">

            <input type="submit" name="submit" value="Lizenz erstellen">
        </form>
<h1> Lizenzsystem </h1>
<h3>Aktive Lizenzen</h3>

<?php
foreach($mysql->query($lizenzen) as $row) {

  echo '

  <br>
  <br>
<form>
<fieldset disabled>
     <div class="form-row">
    <div class="form-group col-md-2">
    <label for="id" class="text-white">ID</label>
         <input type="text" name="id" class="form-control" placeholder="'.$row['ID'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">Lizenz</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['lizenz'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">Name</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['name'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">Email</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['email'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">IP</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['ip'].'">
    </div>

    <div class="form-group col-md-6">
    <label for="email" class="text-white">Datum</label>
       <input type="text" name="email" class="form-control" placeholder="'.$row['datum'].'">
    </div>
    
    <div class="form-group col-md-2">
    <label for="id" class="text-white">Bestellnummer</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['bestellnummer'].'">
    </div>

    <div class="form-group col-md-2">
    <label for="id" class="text-white">Produkt</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['produkt'].'">
    </div>


    </div>
</fieldset>
</form>



  ';

}
?>
<br>
<br>
<br>
</div>

<script src="../assets/js/playercount.js"></script>
<script src="../assets/js/toggleControlCenter.js"></script>

</body>
</html>