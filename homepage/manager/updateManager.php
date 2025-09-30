<?php
session_start();
if (isset($_POST["submit"])) {

    require 'dbh.inc.php';

    $id = $_POST['id'];

    if (empty($id)) {
        header("Location: ../cc/index.php?error=emptyFields&msg=$id");
        exit();
    }else {

      $sql1 = "UPDATE kontakt SET status=0 WHERE ID=?";
      $stmt1 = mysqli_stmt_init($conn);
      if(!mysqli_stmt_prepare($stmt1, $sql1)) {
          header("Location: ../cc/index.php?error=sqlError");
          exit();
      }else {
        mysqli_stmt_bind_param($stmt1, "i", $id);
        mysqli_stmt_execute($stmt1);
        mysqli_stmt_store_result($stmt1);
        header("Location: ../cc/index.php?success=updated");
        exit();
      }

    }

}

















 ?>
