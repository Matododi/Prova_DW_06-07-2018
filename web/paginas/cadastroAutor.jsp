<%-- 
    Document   : cadastroAutor
    Created on : 06/07/2018, 09:47:45
    Author     : a1712233
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <title>Cadastro de cliente</title>
        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/paginas/cabecalho.html" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center" valign="middle">	
                    <header>
                        <nav>
                            <img src="logo.png" alt="logo">
                        </nav>
                        <div>
                            <table border="3">
                            </table>
                        </div>
                    </header>
                </td>
            </tr>
            
        </table>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cadastro</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Tipo
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="${pageContext.request.contextPath}/autor">
                                        <div class="form-group">
                                            <label>ID</label>
                                            <input class="form-control" name="idAutor">
                                        </div>
                                        <div class="form-group">
                                            <label>Autor</label>
                                            <input class="form-control" name="nomeAutor">
                                        </div>
                                        <button type="submit" class="btn btn-default">Enviar dados</button>
                                        <button type="reset" class="btn btn-default">Apagar dados</button>
                                    </form>
                                </div>
    </body>
</html>