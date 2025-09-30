<?php

    $servername = "localhost";
    $dBUsername = "ticket-system-mc";
    $dBPassword = "ticket-system-mc";
    $dBName = "ticket-system-mc";

    $conn = mysqli_connect($servername, $dBUsername, $dBPassword, $dBName);

    if (!$conn) {
        die("Connection Fehlgeschlagen: ".mysqli_connect_error());
    }
