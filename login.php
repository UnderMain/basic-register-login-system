<?php
$mysqli = new mysqli("localhost","user","password", "database");
$msg = "";
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $name = $_POST["name"];
    $password = $_POST["password"];
    if ($name == '' || $password == '') {
        $msg = "You must enter all fields";
    } else {
        $sql = "SELECT * FROM user WHERE user = '$name' AND pw = '$password'";
        $query = $mysqli->query($sql);
        if ($query->num_rows > 0) {
            session_start();
            $data = $query->fetch_array();
            $_SESSION["user_name"] = $data["user"];
            $_SESSION["user_password"] = $data["pw"];
            header("Location: cp.php");
            exit;
        } else {
            $msg = "Username and password do not match";
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Login</title>
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
                <center><h1 style="color: #1b1e21;  font-weight: bold">LOGIN</h1><br></center>
                <p style="color: red"><?php echo $msg?></p>
                <form action="login.php" id="loginForm">
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control" type="text" name='name' placeholder="name" id="name"/>
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input class="form-control" type="password" name="password" id="password" placeholder="password"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" value="Submit" alt="Submit" title="Submit" class="btn btn-def btn-block">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js'></script>
</form>
</body>
</html>

