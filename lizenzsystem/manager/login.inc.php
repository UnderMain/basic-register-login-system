<?php
if (isset($_POST['submit'])) {
    require 'dbh.inc.php';
    include_once 'class-phpass.php';
    $email = $_POST['uid'];
    $password = $_POST['pwd'];
    $hash = new PasswordHash(8, true);
    if(empty($email) || empty($password)) {
        header("Location: ../index.php?error=emptyfields");
        exit();
    }else{

      $sql = "SELECT * FROM wp_users WHERE user_email=?;";
      $stmt = mysqli_stmt_init($conn);
      if (!mysqli_stmt_prepare($stmt, $sql)) {
          header("Location: ../index.php?error=sqlError");
          exit();
      }else{
        mysqli_stmt_bind_param($stmt, "s", $email);
        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);
          if ($row = mysqli_fetch_assoc($result)) {
            $check = $hash->CheckPassword($password, $row['user_pass']);
            if($check){
              session_start();
              session_regenerate_id();

              $_SESSION['name'] = $row['user_login'];
              $_SESSION['id'] = $row['ID'];
              $_SESSION['email'] = $row['user_email'];
              $_SESSION['loggedin'] = TRUE;


              header("Location: ../controlpanel.php?loginSuccess");
              exit();
            }else{

            }
            echo $row['user_pass'];
          }
        echo"4";
      }


    }
}
