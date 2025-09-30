<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
session_start();
if (isset($_SESSION['loggedin'])) {
    session_destroy();
    header('Location: ../index.php?success=loggedout');
} else {
    header('Location: ../index.php');
}