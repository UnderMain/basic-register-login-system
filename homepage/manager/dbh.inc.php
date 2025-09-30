<?php

    $servername = "localhost";
    $dBUsername = "website";
    $dBPassword = "GILekdWwnLUARZcs";
    $dBName = "website";

    $conn = mysqli_connect($servername, $dBUsername, $dBPassword, $dBName);

    if (!$conn) {
        die("Connection Fehlgeschlagen: ".mysqli_connect_error());
    }
