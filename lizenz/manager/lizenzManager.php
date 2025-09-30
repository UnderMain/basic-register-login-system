<?php
session_start();
if (isset($_POST["submit"])) {

    require 'dbh.inc.php';


    $name = $_POST['name'];
    $email = $_POST['email'];
    $produkt = $_POST['produkt'];
    $bestellnummer = $_POST['bestellnummer'];
    $lizenz = $_POST['lizenz'];



if (empty($name) || empty($email) || empty($produkt) || empty($bestellnummer) || empty($lizenz)) {
    header("Location: ../index.php?error=emptyFields");
    exit();
}else {

      $sql1 = "INSERT INTO lizenz (lizenz, name, email, datum, bestellnummer, produkt) VALUES (?, ?, ?, ?, ?, ?)";
      $stmt1 = mysqli_stmt_init($conn);

      if(!mysqli_stmt_prepare($stmt1, $sql1)) {
          header("Location: ../index.php?error=sqlError");
          exit();
      }else {

        $datum = date("d.m.Y");
        $uhrzeit = date("H:i");

        $DU = $datum." - ".$uhrzeit." Uhr";
        mysqli_stmt_bind_param($stmt1, "ssss", $lizenz, $name, $email, $DU, $bestellnummer, $produkt);
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
