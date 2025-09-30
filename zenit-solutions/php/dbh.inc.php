<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php

/*
 * Hier kannst du die MySQL-Daten festlegen, welche für die Website genutzt werden sollen.
 */

$host = secureInput("localhost");
$username = secureInput("website"); // Benutzername
$passwd = secureInput("GILekdWwnLUARZcs"); // Passwort
$dbname = secureInput("website"); // Datenbankname
$port = secureInput("3306");

// ! DO NOT EDIT TO FOLLOWING CODE -->

$conn = new mysqli($host, $username, $passwd, "", $port);

if ($conn->connect_error) {
    die("Verbindung fehlgeschlagen: " . $conn->connect_error);
}

$database_exists = $conn->select_db($dbname);

if (empty($database_exists)) {
    // Create database
    $sql_createdatabase = "CREATE DATABASE $dbname";
    if ($conn->query($sql_createdatabase) === TRUE) {
        echo("<script>console.log('Datenbank \'$dbname\' erfolgreich erstellt.');</script>");

        $conn = new mysqli($host, $username, $passwd, $dbname, $port);
    } else {
        echo("<script>console.log('Datenbank \'$dbname\' wurde nicht erstellt.' . $conn->error);</script>");
    }
}

$sql_1 = "CREATE TABLE users (
id INT(16) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
userid VARCHAR(128) NOT NULL,
password VARCHAR(255) NOT NULL,
created TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";

$sql_2 = "CREATE TABLE feeds (
id INT(16) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
label VARCHAR(128) NOT NULL,
title VARCHAR(255) NOT NULL,
message VARCHAR(8000) NOT NULL,
created TIMESTAMP
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";

$querycheck_1 = "SELECT 1 FROM users";
$querycheck_2 = "SELECT 1 FROM feeds";

$query_result_1 = $conn->query($querycheck_1);
$query_result_2 = $conn->query($querycheck_2);

if ($query_result_1 == FALSE) {
    if ($conn->query($sql_1) === TRUE) {
        echo("<script>console.log('Tabelle users erfolgreich erstellt.');</script>");
    } else {
        echo("<script>console.log('Tabelle users wurde nicht erstellt. ' . $conn->error);</script>");
    }
}

if ($query_result_2 == FALSE) {
    if ($conn->query($sql_2) === TRUE) {
        echo("<script>console.log('Tabelle feeds erfolgreich erstellt.');</script>");
    } else {
        echo("<script>console.log('Tabelle feeds wurde nicht erstellt. ' . $conn->error);</script>");
    }
}


$stmt = $conn->prepare("SELECT * FROM users");

if (!$stmt->execute()) {
    header("Location: ../index.php?error=sqlerror");
    exit();
} else {
    $stmt->store_result();
    $resultCheck = $stmt->num_rows;
    if ($resultCheck === 0) {
        $stmt = $conn->prepare("INSERT INTO users (userid, password) VALUES (?, ?)");
        $stmt->bind_param("ss", $userid, $password);

        $userid = secureInput("admin");
        $password = secureInput(password_hash("admin", PASSWORD_DEFAULT));

        if (!$stmt->execute()) {
            header("Location: ../index.php?error=sqlerror");
            $stmt->close();
            exit();
        } else {
            header("Location: ../index.php");
            $stmt->close();
            exit();
        }
    }
}

function secureInput($y0){$y0=trim($y0);$y0=stripslashes($y0);$y0=htmlspecialchars($y0);return $y0;}