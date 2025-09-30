<?php
if(isset($_POST['tickets'])) {
  header("Location: ../admin/tickets-beantworten.php");
  exit();
}elseif(isset($_POST['offene'])) {
  header("Location: ../admin/tickets.php");
  exit();
}elseif(isset($_POST['beantwortete'])) {
  header("Location: ../admin/beantwortete-tickets.php");
  exit();
}elseif(isset($_POST['profil'])) {
  header("Location: ../admin/profil.php");
  exit();
}elseif(isset($_POST['tickets-anzeigen'])) {
  header("Location: ../tickets.php");
  exit();
}elseif(isset($_POST['ticket-schreiben'])) {
  header("Location: ../ticket-schreiben.php");
  exit();
}elseif(isset($_POST['profiln'])) {
  header("Location: ../profil.php");
  exit();
}elseif(isset($_POST['back'])) {
  header("Location: ../cp.php");
  exit();
}else{
  header("Location: ../index.php");
  exit();
}
