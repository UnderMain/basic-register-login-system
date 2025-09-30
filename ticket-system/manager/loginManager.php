<?php

    if(isset($_POST['login-submit'])) {

        require 'dbh.inc.php';

        $mailuid = $_POST['mailuid'];
        $password = $_POST['pwd'];

        if(empty($mailuid) || empty($password)) {
            header("Location: ../index.php?error=emptyfields");
            exit();
        }
        else {
            $sql = "SELECT * FROM user WHERE email=?;";
            $stmt = mysqli_stmt_init($conn);
            if (!mysqli_stmt_prepare($stmt, $sql)) {
                header("Location: ../index.php?error=sqlError");
                exit();
            }
            else {


                mysqli_stmt_bind_param($stmt, "s", $mailuid);
                mysqli_stmt_execute($stmt);
                $result = mysqli_stmt_get_result($stmt);
                if ($row = mysqli_fetch_assoc($result)) {
                    $pwdCheck =  strcmp($password, $row['passwort']);
                    if ($pwdCheck !== 0) {
                        header("Location: ../index.php?error=wrongPassword");
                        exit();
                    }
                    else if ($pwdCheck == 0) {
                        session_start();
                        $_SESSION['name'] = $row['username'];
                        $_SESSION['uuid'] = $row['uuid'];
                        $_SESSION['status'] = $row['status'];
                        $_SESSION['id'] = $row['ID'];
                        $_SESSION['email'] = $row['email'];


                        header("Location: ../cp.php?login=success");
                        exit();

                    }
                    else {
                        header("Location: ../index.php?error=wrongPassword");
                        exit();
                    }
                }
                else {
                    header("Location: ../index.php?error=noUser");
                    exit();
                }

            }
        }


    }
    else {
        header("Location: ../index.php");
        exit();
    }
