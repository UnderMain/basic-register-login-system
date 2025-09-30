<?php
session_start();
if (isset($_POST["submit"])) {

    require 'dbh.inc.php';


    $name = $_SESSION['name'];
    $email = $_SESSION['email'];
    $uuid = $_SESSION['uuid'];

$thema = $_POST["Thema"];
$nachricht = $_POST["Nachricht"];
$status = 0;



if (empty($thema) || empty($nachricht)) {
    header("Location: ../ticket-schreiben.php?error=emptyFields&msg=$nachricht&thema=$thema");
    exit();
}else {
  $sql = "SELECT status FROM ticket WHERE uuid=? AND status=?";
  $stmt = mysqli_stmt_init($conn);

  if (!mysqli_stmt_prepare($stmt, $sql)) {
        header("Location: ../ticket-schreiben.php?error=sqlError");
        exit();
  }else {

    mysqli_stmt_bind_param($stmt, "si", $uuid, $status);
    mysqli_stmt_execute($stmt);
    mysqli_stmt_store_result($stmt);
    $resultCheck = mysqli_stmt_num_rows($stmt);

    if ($resultCheck > 0) {
    header("Location: ../ticket-schreiben.php?error=bereitsTicket");
    exit();
    }else {

      $sql1 = "INSERT INTO ticket (user, uuid, nachricht, thema) VALUES (?, ?, ?, ?)";
      $stmt1 = mysqli_stmt_init($conn);

      if(!mysqli_stmt_prepare($stmt1, $sql1)) {
          header("Location: ../ticket-schreiben.php?error=sqlError");
          exit();
      }else {

        mysqli_stmt_bind_param($stmt1, "ssss", $name, $uuid, $nachricht, $thema);
        mysqli_stmt_execute($stmt1);
        mysqli_stmt_store_result($stmt1);
        header("Location: ../ticket-schreiben.php?success=y");
        exit();

      }
    }
  }
}

}else {

header("Location: ../ticket-schreiben.php?fehler");
exit();

}
