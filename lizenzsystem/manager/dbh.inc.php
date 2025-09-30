<?php

    $servername = "localhost";
    $dBUsername = "richtiger-shop";
    $dBPassword = "jdGSru1uayF5lYSU";

    $dBName = "richtiger-shop";

    $conn = mysqli_connect($servername, $dBUsername, $dBPassword, $dBName);

    if (!$conn) {
        die("Connection Fehlgeschlagen: ".mysqli_connect_error());
    }
