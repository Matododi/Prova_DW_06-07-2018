<%-- 
    Document   : listaAutor
    Created on : 06/07/2018, 09:18:05
    Author     : a1712233
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <title>Lista Autor</title>
    </head>
    <body>
        <header>
            <table>
                <tr>
                    <td>
                        <img src ="logo.png">
                    </td>
                </tr>
            </table>
            <a href="cadastroAutor.jsp">Cadastro do Autor </a>
        </header>
        <h1 align="center">LISTA DE AUTOR</h1>
        
        <table width="100%" border="2px" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" style="width: 100%;">
                                    <thead>
                                        <tr role="row">
                                            <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="ID Produto" style="width: 170px;">ID Autor</th>
                                            <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-label="Preço do produto" style="width: 206px;">Nome</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        ${resultadoAutor}
                                    </tbody>
                                </table>
    </body>
</html>
