<?php 
$mysqli = new mysqli("localhost","user","password", "database");
session_start ();
if(isset($_SESSION["user_name"]) && isset($_SESSION["user_password"])) {
    
    $id;
    $name = $_SESSION["user_name"];
    $password = $_SESSION["user_password"];

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
$msg = "Hallo ".$name."! Du bist nun im Geschützen Bereich!";
?>
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>Control Panel</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <link rel='stylesheet' href='https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.css'>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<form name="frmregister"action="<?= $_SERVER['PHP_SELF'] ?>" method="post" >

    <div class="container">
        <div class="row">
            <div class="Absolute-Center is-Responsive">
                <div id="logo-container"></div>
                <div class="col-sm-12 col-md-10 col-md-offset-1">
                    <br><br><br><br>
                    <center><h1 style="color: #1b1e21; font-weight: bold"><?php echo $msg; ?></h1><br></center>

                </div>
            </div>
        </div>
    </div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src='http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js'></script>
</form>
</body>
</html>
