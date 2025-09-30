<?php
session_start();
require 'db-con.php';
require 'config.php';


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
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.12.0/css/mdb.min.css" rel="stylesheet">


    <title><?php echo $ServerName ?> | Ticket-System</title>
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
<form class="border border-light p-5" method="post" action="manager/sendManager.php">

    <p class="h4 mb-4 text-center">Ticket schreiben</p>


    <input type="text" name="name" class="form-control mb-4" placeholder="Name">

    <input type="email" name="email" class="form-control mb-4" placeholder="E-mail">

    <label for="defaultSelect">Thema</label>
    <select name="Thema" class="browser-default custom-select mb-4">
        <option value="" disabled="">Wähle eine Option</option>
        <option value="<?php echo $Thema1 ?>" selected="" name="thema1"><?php echo $Thema1 ?></option>
        <option value="<?php echo $Thema2 ?>" name="thema2"><?php echo $Thema2 ?></option>
        <option value="<?php echo $Thema3 ?>" name="thema3"><?php echo $Thema3 ?></option>
        <option value="<?php echo $Thema4 ?>" name="thema4"><?php echo $Thema4 ?></option>
    </select>

    <textarea class="form-control rounded-0" name="Nachricht" rows="3" placeholder="Deine Nachricht"></textarea>
<br>
    <div class="custom-control custom-checkbox mb-4">
        <input type="checkbox" class="custom-control-input" name="kopie">
        <label class="custom-control-label" for="defaultContactFormCopy">Sende mir eine Kopie dieser Nachricht</label>
    </div>

    <button class="btn btn-info btn-block" type="submit" name="submit">Abschicken</button>
</form>


</div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</div>

</body>
</html>