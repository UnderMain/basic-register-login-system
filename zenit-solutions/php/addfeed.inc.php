<!-- Copyright © 2019 Nicolas Proske (pume) - Alle Rechte vorbehalten. -->

<?php
if (isset($_POST['submit-addfeed'])) {
    require 'dbh.inc.php';

    $label = secureInput($_POST['label']);
    $title = secureInput($_POST['title']);
    $message = urlencode($_POST['message']);

    if ($label === '0') {
        header("Location: ../cc/index.php?4error=emptylabel&title=" . $title . "&message=" . $message);
        exit();
    } else if (empty($title) || empty($message)) {
        header("Location: ../cc/index.php?4error=empty&title=" . $title . "&message=" . $message);
        exit();
    } else {
        $stmt = $conn->prepare("INSERT INTO feeds (label, title, message) VALUES (?, ?, ?)");

        $stmt->bind_param("sss", $label, $title, $message);

        if (!$stmt->execute()) {
            header("Location: ../cc/index.php?4error=sqlerror");
            exit();
        } else {
            header("Location: ../cc/index.php?4success=added");
            exit();
        }
    }
} else {
    header("Location: ../index.php");
    exit();
}