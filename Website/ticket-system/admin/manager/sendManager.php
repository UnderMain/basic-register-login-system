<?php

if (isset($_POST["submit"])) {

    require '../db-con.php';
    require '../config.php';


$name = $_POST["name"];
$email = $_POST["email"];

$thema = $_POST["Thema"];
$status = "1";

$msg = $_POST["Nachricht"];


if (empty($name) || empty($email || empty($msg))) {
    header("Location: ../ticket.php?error=emptyFields&name=$name&msg=$msg&thema=$thema&email=$email");
    exit();
}elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    header("Location: ../ticket.php?error=invalidEmail&name=$name&msg=$msg&thema=$thema");
    exit();

}else {

$sql1 = "INSERT INTO ticket (Name, Email, Nachricht, Thema, Status) VALUES (?, ?, ?, ?, ?)";
$stmt = mysqli_stmt_init($mysql);

if(!mysqli_stmt_prepare($stmt, $sql1)) {
    header("Location: ../ticket.php?error=sqlError");
    exit();
}else {

    mysqli_stmt_bind_param($stmt, "ssssi", $name, $email, $msg, $thema, $status);
    mysqli_stmt_execute($stmt);
    mysqli_stmt_store_result($stmt);




    header("Location: ../success.php?success=y");
    exit();

}

}

}else {

header("Location: ../index.php?fehler");
exit();

}


