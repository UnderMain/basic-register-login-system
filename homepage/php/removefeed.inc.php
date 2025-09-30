<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
if (isset($_POST['submit-removefeed'])) {
    require 'dbh.inc.php';

    $stmt = $conn->prepare("DELETE FROM feeds WHERE id = ?");
    $stmt->bind_param('i', secureInput($_POST['id']));
    if ($stmt->execute()) {
        $stmt->close();
        header("Location: ../index.php");
        exit();
    } else {
        $stmt->close();
        header("Location: ../index.php?error=sqlerror");
        exit();
    }
} else {
    header("Location: ../index.php");
    exit();
}