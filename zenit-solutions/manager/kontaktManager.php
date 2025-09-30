<?php
session_start();
if (isset($_POST["submit"])) {

    require 'dbh.inc.php';


    $name = $_POST['name'];
    $email = $_POST['email'];
    $text = $_POST['text'];




if (empty($name) || empty($email) || empty($text)) {
    header("Location: ../index.php?error=emptyFields&msg=$text&thema=$name&email=$email");
    exit();
}else {

      $sql1 = "INSERT INTO kontakt (name, email, text, datum) VALUES (?, ?, ?, ?)";
      $stmt1 = mysqli_stmt_init($conn);

      if(!mysqli_stmt_prepare($stmt1, $sql1)) {
          header("Location: ../index.php?error=sqlError");
          exit();
      }else {

        $datum = date("d.m.Y");
        $uhrzeit = date("H:i");

        $DU = $datum." - ".$uhrzeit." Uhr";
        mysqli_stmt_bind_param($stmt1, "ssss", $name, $email, $text, $DU);
        mysqli_stmt_execute($stmt1);
        mysqli_stmt_store_result($stmt1);
        header("Location: ../index.php?success=y");
        exit();

      }
    }



}else {

header("Location: ../index.php?error=noClick");
exit();

}
