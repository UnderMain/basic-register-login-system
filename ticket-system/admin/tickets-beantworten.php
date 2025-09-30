

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/10d059be6c.js" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <title></title>
  </head>
  <body class="bg-primary">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="container-fluid">
              <div class="container">
      <div class="jumbotron bg-dark">



        <center>
        <span class="mb-0" class="text-white"><i class="fas fa-pen"></i> <u>Ticket beantworten</span></u>
        <small id="emailHelp" class="form-text text-muted">Du brauchst die ID und die Email des Tickets zum beantworten</small>
        <br>
        <br>
        </center>


        <form class="text-white" method="post" action="../manager/antwortManager.php">
           <div class="form-row">

          <div class="form-group col-md-6">
          <label for="id">ID vom Ticket</label>
               <input type="text" name="id" class="form-control" placeholder="ID">
          </div>

          <div class="form-group col-md-6">
          <label for="email">Email vom Ticket</label>
             <input type="email" name="email" class="form-control" placeholder="Email">
          </div>

          <div class="form-group col-md-12">
              <label for="antwort">Deine Antwort</label>
              <textarea class="form-control" name="antwort" rows="3"></textarea>
          </div>

           <div class="form-group col-md">
           <label for="antwort"></label>
           <button type="submit" class="btn btn-primary btn-lg btn-block" name="submit"><i class="fas fa-sign-in-alt"></i> Abschicken</button>
           </div>
          </div>
      </form>

    </div>
      </div>
    </div>
  </body>
</html>
