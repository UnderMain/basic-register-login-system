<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
if (isset($_POST['submit-adduser'])) {
    require 'dbh.inc.php';

    $uid = secureInput($_POST['uid']);
    $password = secureInput($_POST['pwd']);
    $passwordRepeat = secureInput($_POST['pwd-repeat']);

    if (empty($uid)) {
        header("Location: ../cc/index.php?1error=empty");
        exit();
    } else if (empty($password) || empty($passwordRepeat)) {
        header("Location: ../cc/index.php?1error=empty");
        exit();
    } else if (!preg_match("/^[a-zA-Z0-9]*$/", $uid)) {
        header("Location: ../cc/index.php?1error=invaliduid");
        exit();
    } else if ($password !== $passwordRepeat) {
        header("Location: ../cc/index.php?1error=passwordcheck");
        exit();
    } else {
        $stmt = $conn->prepare("SELECT id FROM users WHERE userid=?");
        $stmt->bind_param("s", $uid);

        if (!$stmt->execute()) {
            header("Location: ../cc/index.php?1error=sqlerror");
            exit();
        } else {
            $stmt->store_result();
            $resultCheck = $stmt->num_rows;
            if ($resultCheck > 0) {
                header("Location: ../cc/index.php?1error=usertaken");
                exit();
            } else {
                $stmt = $conn->prepare("INSERT INTO users (userid, password) VALUES (?, ?)");

                $hashedPwd = password_hash($password, PASSWORD_DEFAULT);

                $stmt->bind_param("ss", $uid, $hashedPwd);

                if (!$stmt->execute()) {
                    header("Location: ../cc/index.php?1error=sqlerror");
                    exit();
                } else {
                    header("Location: ../cc/index.php?1success=added");
                    exit();
                }
            }
        }
    }
} else {
    header("Location: ../index.php");
    exit();
}