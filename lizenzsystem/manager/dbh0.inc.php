<?php

    $servername = "undermain.de";
    $dBUsername = "lizenz";
    $dBPassword = "lizenz";

    $dBName = "lizenz";

    $mysql = mysqli_connect($servername, $dBUsername, $dBPassword, $dBName);

    if (!$conn) {
        die("Connection Fehlgeschlagen: ".mysqli_connect_error());
    }
