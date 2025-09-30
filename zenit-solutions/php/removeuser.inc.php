<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
if (isset($_POST['submit-removeuser'])) {
    require 'dbh.inc.php';

    $stmt = $conn->prepare("DELETE FROM users WHERE id = ?");
    $stmt->bind_param('i', secureInput($_POST['id']));
    if ($stmt->execute()) {
        $stmt->close();
        header("Location: ../cc/index.php?3success=removed");
        exit();
    } else {
        $stmt->close();
        header("Location: ../cc/index.php?3error=sqlerror");
        exit();
    }
} else {
    header("Location: ../index.php");
    exit();
}