<?php

$mysqli = new mysqli("localhost","ticket-system",")f->5B_i/T*h", "ticket-system");


if(isset($_POST['submit'])) {

    $name = $_POST["name"];
    $password = $_POST["password"];
    $r_password = $_POST["r_password"];
    $email = $_POST["email"];
    $rang = "admin";
    if ($name == null || $password == null || $r_password == null || $email == null) {
        header("Location: ../register.php?emptyFields");
    } else {
        if($password == $r_password) {

            $c_sql = "SELECT * FROM user WHERE user = '$name'";
            $c_query = $mysqli->query($c_sql);
            if ($c_query->num_rows > 0) {
                header("Location: ../register.php?nameInBenutzung");
            } else {
                $pw = md5($password);
                $sql = "INSERT INTO user(user, email, pw, rang) VALUES ('$name', '$email', '$password', '$rang')";
                $query = $mysqli->query($sql);
                session_start();
                $_SESSION["user_name"] = $name1;
                $_SESSION["user_password"] = $pw;
                $_SESSION["user_rang"] = $rank;


                header("Location: ../../admin/login.php");

            }
            exit;
        } else {
            header("Location: ../register.php?passwordIncorrect");
        }
    }

}