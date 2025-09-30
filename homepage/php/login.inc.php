
<?php
if (isset($_POST['submit-login'])) {
    require 'dbh.inc.php';

    if (empty(secureInput($_POST['uid'])) || empty(secureInput($_POST['pwd']))) {
        header("Location: ../cc/login.php?error=empty");
        exit();
    } else {
        if ($stmt = $conn->prepare('SELECT id, password FROM users WHERE userid = ?')) {
            $stmt->bind_param('s', secureInput($_POST['uid']));
            $stmt->execute();
            $stmt->store_result();

            if ($stmt->num_rows > 0) {
                $stmt->bind_result($id, $password);
                $stmt->fetch();
                // Account existiert, Passwort muss verifiziert werden
                if (password_verify(secureInput($_POST['pwd']), $password)) {
                    // Passwort verifiziert, Session für User erstellen
                    session_start();
                    session_regenerate_id();
                    $_SESSION['loggedin'] = TRUE;
                    $_SESSION['uid'] = secureInput($_POST['uid']);
                    $_SESSION['id'] = $id;
                    $stmt->close();
                    header("Location: ../cc/index.php");
                    exit();
                } else {
                    $stmt->close();
                    header("Location: ../cc/login.php?error=incorrect");
                    exit();
                }
            } else {
                $stmt->close();
                header("Location: ../cc/login.php?error=incorrect");
                exit();
            }
        }
    }
} else {
    header("Location: ../index.php");
    exit();
}
