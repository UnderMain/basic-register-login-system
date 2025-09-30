<?php
    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\Exception;
    
    require 'PHPMailer/src/Exception.php';
    require 'PHPMailer/src/PHPMailer.php';
    require 'PHPMailer/src/SMTP.php';
    require '../config.php';
    require 'sendManager.php';

    $mail = new PHPMailer();
        $mail->isSMTP();
        $mail->Host = $SMTPServer;
        $mail->SMTPAuth = true;
        $mail->Username = $ServerEmail;
        $mail->Password = $ServerEmailPasswort;

        $mail->setFrom($ServerEmail, $ServerName);
        $mail->addAddress($email, "Dein Ticket");

        $mail->isHTML(true);
        $mail->Subject = $thema;
        $mail->Body = $msg;

        if($mail->send()){
            header("Location: ../index.php?succesfull");
        } else {
            header("Location: ../index.php?unsuccesfull");
        }
    