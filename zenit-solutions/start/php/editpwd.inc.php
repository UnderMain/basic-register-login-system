<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
if (isset($_POST['submit-editpwd'])) {
    require 'dbh.inc.php';

    $id = secureInput($_POST['id']);
    $password = secureInput($_POST['newpwd']);

    if (empty($password)) {
        header("Location: ../cc/index.php?2error=empty");
        exit();
    } else {
        $stmt = $conn->prepare("UPDATE users SET password=? WHERE id=?");
        $hashedPwd = password_hash($password, PASSWORD_DEFAULT);
        $stmt->bind_param("si", $hashedPwd, $id);

        if (!$stmt->execute()) {
            header("Location: ../cc/index.php?2error=sqlerror");
            exit();
        } else {
            header("Location: ../cc/index.php?2success=pwdchanged");
            exit();
        }
    }
} else {
    header("Location: ../index.php");
    exit();
}