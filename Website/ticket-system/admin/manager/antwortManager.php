<?php
$mysqli = new mysqli("localhost","ticket-system",")f->5B_i/T*h", "ticket-system");


require '../../config.php';

if(isset($_POST['submit'])) {
    $email = $_POST["email"];
    $id = $_POST["id"];
    $antwort = $_POST["antwort"];
    $status = 0;

    if(empty($email) || empty($id) || empty($antwort)) {
        header("Location: ../ticket-antwort.php?emptyFields");
        exit();
    }else {

        $sql = "SELECT * FROM ticket WHERE email=? AND id=?";
        $stmt = mysqli_stmt_init($mysqli);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location: ../ticket-antwort.php?sqlError");
            exit();
        }else {

            mysqli_stmt_bind_param($stmt, "si", $email, $id);
            mysqli_stmt_execute($stmt);
            mysqli_stmt_store_result($stmt);
            $rs = mysqli_stmt_num_rows($stmt);

            if($rs > 0) {


                    $sql1 = "UPDATE ticket SET status=?, antwort=? WHERE id='$id' AND email='$email'";
                    $stmt1 = mysqli_stmt_init($mysqli);

                        if(!mysqli_stmt_prepare($stmt1, $sql1)) {

                            header("Location: ../ticket-antwort.php?sqlError");
                            exit();

                        }else {

                            mysqli_stmt_bind_param($stmt1, "is", $status, $antwort);
                            mysqli_stmt_execute($stmt1);
                            header("Location: ../control-panel.php?succesfullAT");
                            exit();

                            require_once 'vendor/autoload.php';

                            $transport = (new Swift_SmtpTransport('smtp.strato.de', 25))
                              ->setUsername('webmaster@510324790.swh.strato-hosting.eu')
                              ->setPassword('undermain123')
                            ;
                            
                            $mailer = new Swift_Mailer($transport);
                            
                            $message = (new Swift_Message('Dein Ticket bei'.$ServerName))
                              ->setFrom(['support@undermain.de' => 'Support'])
                              ->setTo([$email, 'support@undermain.de' => ''])
                              ->setBody($antwort)
                              ;
                            
                            $result = $mailer->send($message);
                        
                        }

            }else {
                header("Location: ../ticket-antwort.php?keinTicket");
                exit();
            }

        }



    }


}
