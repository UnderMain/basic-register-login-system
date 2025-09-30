<?php
require '../db-con.php';
require '../config.php';

$mysqli = new mysqli("localhost","ticket-system",")f->5B_i/T*h", "ticket-system");
session_start ();
if(isset($_SESSION["user_name"]) && isset($_SESSION["user_password"])) {
    
    $id;
    $name = $_SESSION["user_name"];
    $password = $_SESSION["user_password"];
    $rang = $_SESSION["user_rang"];
    $email = $_SESSION["user_email"];

    $sql = "SELECT * FROM user WHERE user = '$name' AND pw = '$password'";
    $query = $mysqli->query($sql);
    $data = $query->fetch_array();
    if(mysqli_num_rows($query) > 0) {
        $id = $data["ID"];
    } else {
        header("Location: login.php");
        exit;
    }
} else {
    header("Location: login.php");
    exit;
}

if($rang ="admin") {

  $msg = "<p style='color:#AA0000' class='font'>Admin</p>";

}

$stmt0 = "SELECT name, email, nachricht, thema, status, id FROM ticket WHERE status=1 ORDER BY id ASC";
$res = mysqli_query($mysqli, $stmt0);



?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.12.0/js/mdb.min.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.12.0/css/mdb.min.css" rel="stylesheet">


    <title><?php echo $name ?> | Ticket-System</title>
</head>
<body class="font" >
    
<div class="container">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="jumbotron font shadow-lg p-3 mb-5 bg-white rounded border border-dark">
  <h2 class="display-4 text-primary"><center>Tickets</center></h2>
  <br>
  <br>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><?php echo $ServerName ?></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="control-panel.php">Control Panel </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Tickets<span class="sr-only">(current)</span></a>
      </li>
      <?php 
      
      if($rang = 1) {

        echo '
        <li class="nav-item">
          <a class="nav-link" href="ticket-antwort.php">Tickets antworten</a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="team-bearbeiten.php">Team bearbeiten</a>
        </li>';
        }else{
          echo '
        <li class="nav-item">
          <a class="nav-link" href="ticket-antwort.php">Tickets schreiben</a>
        </li>';


      }
      
      ?>
    </ul>
    <form form method="post" action="manager/logoutManager.php">
                <button type="submit" class="btn btn-outline-success float-right">Ausloggen</button>
    </form>
  </div>
</nav>

<?php 
foreach($mysqli->query($stmt0) as $row) {

  echo '

  <br>
  <hr>
  <br>
<form>
<fieldset disabled>
     <div class="form-row">
    <div class="form-group col-md-3">
    <label for="id">ID</label>
         <input type="text" name="id" class="form-control" placeholder="'.$row['id'].'">
    </div>

    <div class="form-group col-md-3">
    <label for="id">Name</label>
         <input type="text" name="name" class="form-control" placeholder="'.$row['name'].'">
    </div>

    <div class="form-group col-md-6">
    <label for="email">Email</label>
       <input type="email" name="email" class="form-control" placeholder="'.$row['email'].'">
    </div>
     
    <div class="form-group col-md-12">
        <label for="antwort">Ticket</label>
        <textarea class="form-control" id="antwort" rows="6" placeholder="'.$row['nachricht'].'"></textarea>
    </div>

    </div>
</fieldset>
</form>
<form>
     <div class="form-group col-md">
     <label for="antwort"></label>
     <button type="submit" class="btn btn-dark btn-lg btn-block">Antworten</button>
     </div>
</form>


  ';
  
}
?>


</div>

</body>
</html>