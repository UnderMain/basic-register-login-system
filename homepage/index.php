
<?php
require 'php/dbh.inc.php';
session_start();


if (isset($_GET['success'])) {
  if ($_GET['success'] == "y") {
      $msg = '
<div class="alert alert-success" role="alert">
  <i class="fas fa-info-circle"></i> Deine Nachricht wurde versendet
</div>';
  }
}
if (isset($_GET['error'])) {
  if ($_GET['error'] == "emptyFields") {
      $msg = '
<div class="alert alert-warning" role="alert">
  <i class="fas fa-info-circle"></i> Du hast nicht alle Felder ausgefüllt!
</div>';
  }
  if ($_GET['error'] == "noClick") {
      $msg = '
<div class="alert alert-warning" role="alert">
  <i class="fas fa-info-circle"></i> Nur über die Website!
</div>';
  }
}



?>

<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>undermain</title>

    <link href="assets/fonts/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="icon" href="assets/img/favicon.png" type="image/png" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <noscript>Bitte nutze einen neueren Browser mit JavaScript Unterstützung!</noscript>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/stylee.css">


</head>
<body>

<div id="content">
  <br>
  <br>
  <br>

    <?php echo $msg;?>

    <h1><i class="fas fa-chevron-left"></i><i class="fab fa-sketch"></i> undermain<i class="fas fa-chevron-right"></i></h1>
    <h3>programming on request</h3>
    <hr>


	<h2><i class="fab fa-java"></i> <i class="fab fa-html5"></i> <i class="fab fa-css3-alt"></i> <i class="fab fa-js"></i> <i class="fab fa-python"></i></h2>
    <hr>

	    <h2>Informations-Blatt</h2>
<br>
<br>
	<center><a href="preisliste.pdf" download="information-undermain.pdf" class="btn btn-success btn-lg active"><i class="fas fa-arrow-alt-circle-down"></i> Downloaden</a></center>
    <hr>

    <h2>Kontakt-Formular</h2>
  <div class="container ">
  <div class="container">
<br>
<br>
 <form method="post" action="manager/kontaktManager.php">
  <div class="form-group">
    <label for="Email" class="text-white"><i class="fas fa-envelope"></i> E-Mail</label>
    <input type="email" class="form-control" name="email" placeholder="name@beispiel.de">
  </div>
  <div class="form-group">
    <label for="Name" class="text-white"><i class="fas fa-signature"></i> name</label>
    <input class="form-control" name="name" placeholder="Max Mustermann">
  </div>

  <div class="form-group">
    <label for="exampleFormControlTextarea1" class="text-white"><i class="fas fa-comments"></i> Deine Nachricht</label>
    <textarea class="form-control" name="text" rows="10"></textarea>
  </div>
<br>
  <div class="form-group">
     <label for="antwort"></label>
<br>
    <button type="submit" class="btn btn-secondary btn-lg btn-block" name="submit"><i class="fas fa-check-circle"></i> Abschicken</button>
  </div></form>
</div>
</div>

    <hr>
    <h2>Blog</h2>


    <div class="feeds">
      <div class="container ">
        <?php

        $sql = "SELECT * FROM feeds ORDER BY id DESC limit 25";
        $result = $conn->query($sql);
        $resultCheck = $result->num_rows;

        if ($resultCheck > 0) {
            while ($row = $result->fetch_assoc()) {
                $phpdate = strtotime($row['created']);

                $date = date('d.m.Y', $phpdate) . ", um " . date('H:i', $phpdate) . " Uhr";

                $msg = $row['message'];

                $str = $msg;
                $order = array("%0D%0A");
                $replace = '<br>';
                $message = str_replace($order, $replace, $str);
                $message = urldecode($message);

                $checkDate = date('Y-m-d', $phpdate);
                $checkTime = date('H:i:s', $phpdate);

                $timestamp = strtotime($checkDate . " " . $checkTime);
                if (isset($_SESSION['loggedin'])) {
                    if ($timestamp > time() - 86400) {
                        if ($row['label'] == 'Ankündigung') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small style="color: #00bc00">Neu</small>
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-red">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                            <form action="../php/removefeed.inc.php" method="post" class="feed-remove"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removefeed" value="Feed löschen"></form>
                        </div>
                    </div>

                ';
                        } else if ($row['label'] == 'Update') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small style="color: #00bc00">Neu</small>
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-yellow">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                            <form action="../php/removefeed.inc.php" method="post" class="feed-remove"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removefeed" value="Feed löschen"></form>
                        </div>
                     </div>
                ';
                        } else if ($row['label'] == 'Sonstiges') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small style="color: #00bc00">Neu</small>
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-blue">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                            <form action="../php/removefeed.inc.php" method="post" class="feed-remove"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removefeed" value="Feed löschen"></form>
                        </div>
                     </div>
                ';
                        }
                    } else {
                        if ($row['label'] == 'Ankündigung') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-red">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                            <form action="../php/removefeed.inc.php" method="post" class="feed-remove"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removefeed" value="Feed löschen"></form>
                        </div>
                     </div>
                ';
                        } else if ($row['label'] == 'Update') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-yellow">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                            <form action="../php/removefeed.inc.php" method="post" class="feed-remove"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removefeed" value="Feed löschen"></form>
                        </div>
                     </div>
                ';
                        } else if ($row['label'] == 'Sonstiges') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-blue">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                            <form action="../php/removefeed.inc.php" method="post" class="feed-remove"><input type="hidden" name="id" value="' . $row['id'] . '"><input type="submit" name="submit-removefeed" value="Feed löschen"></form>
                        </div>
                     </div>
                ';
                        }
                    }
                } else { // NOT LOGGED IN
                    if ($timestamp > time() - 86400) {
                        if ($row['label'] == 'Ankündigung') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small style="color: #00bc00">Neu</small>
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-red">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                        </div>
                    </div>

                ';
                        } else if ($row['label'] == 'Update') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small style="color: #00bc00">Neu</small>
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-yellow">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                        </div>
                     </div>
                ';
                        } else if ($row['label'] == 'Sonstiges') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small style="color: #00bc00">Neu</small>
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-blue">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                        </div>
                     </div>
                ';
                        }
                    } else {
                        if ($row['label'] == 'Ankündigung') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-red">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                        </div>
                     </div>
                ';
                        } else if ($row['label'] == 'Update') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-yellow">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                        </div>
                     </div>
                ';
                        } else if ($row['label'] == 'Sonstiges') {
                            echo '
                     <div class="feed">
                        <div class="heading">
                            <small>' . $date . '</small>
                        </div>

                        <div class="feed-content">
                            <span class="badge badge-blue">' . $row['label'] . '</span>
                            <h2>' . $row['title'] . '</h2>
                            <p>' . $message . '</p>
                        </div>
                     </div>
                ';
                        }
                    }
                }
            }
        } else {
            echo '
                     <div class="feed">
                        <div class="feed-content" style="text-align: center">
                            <h2>Keine Feeds gefunden!</h2>
                            <p>In Zukunft wird es hier Neuigkeiten, Ankündigungen und vieles mehr geben.</p>
                        </div>
                     </div>
                ';
        }
        ?>
    </div>
</div>
</div>

<div id="footer">
<div id=content>
<br>
<br>

    <h3>&copy; 2020 undermain</h3>    <center><a href="cc/index.php"><i class="fas fa-cogs"></i></a></center>

<br>
<br>
<br>
<br>

</div>

</div>

<script src="assets/js/playercount.js"></script>
<script src="assets/js/countdown.js"></script>

</body>
</html>
