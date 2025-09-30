<?php
$mysqli = new mysqli("localhost","ticket-system",")f->5B_i/T*h", "ticket-system");

if(isset($_POST['submit'])) {
    $name = $_POST["name"];
    $password = $_POST["password"];
    if ($name == '' || $password == '') {
        header("Location: ../index.php?emptyFields");
    } else {
        $sql = "SELECT * FROM user WHERE user = '$name' AND pw = '$password'";
        $query = $mysqli->query($sql);
        if ($query->num_rows > 0) {
            session_start();
            $data = $query->fetch_array();
            $_SESSION["user_name"] = $data["user"];
            $_SESSION["user_password"] = $data["pw"];
            $_SESSION["user_rang"] = $data["rang"];
            $_SESSION["user_email"] = $data["email"];

            header("Location: ../control-panel.php");
            exit;
        } else {
            header("Location: ../index.php?error");
        }
    }
}
