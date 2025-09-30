<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
require '../php/dbh.inc.php';

session_start();

if (!isset($_SESSION['loggedin'])) {
    header('Location: login.php');
    exit();
}
?>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>undermain - control</title>
    <link rel="icon" href="../assets/img/favicon.png" type="image/png" />

    <link href="assets/fonts/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <noscript>Bitte nutze einen neueren Browser mit JavaScript Unterstützung!</noscript>

    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="controlcenter">

<div id="content">
    <div class="cc-header">
        <a href="../index.php" class="logo">
            <img src="../assets/img/logo.png" alt="Logo">
        </a>

        <div class="header-right">
            <a href="../php/logout.inc.php">Ausloggen</a>
        </div>
    </div>

    <div class="cc-badges">

        <div class="info-badge">
            <div class="left">
                <i class="fas fa-user-friends"></i>
            </div>

            <div class="right">
                <h2>Spieleranzahl</h2>
                <p id="players"><i class="fa fa-cog fa-spin"></i> Lädt, bitte warten</p>
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

    <div margin-top: 30px">

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
</div>

<script src="../assets/js/playercount.js"></script>
<script src="../assets/js/toggleControlCenter.js"></script>

</body>
</html>