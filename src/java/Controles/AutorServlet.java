/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOAutor;
import DAOs.DAOLivro;
import Entidades.Autor;
import Entidades.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a1712020
 */
@WebServlet(name = "AutorServlet", urlPatterns = {"/autor"})
public class AutorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DAOAutor daoAutor = new DAOAutor();
    Autor autor = new Autor();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nomeAutor = "";
        int idAutor = 0;
        try (PrintWriter out = response.getWriter()) {
            nomeAutor = request.getParameter("nomeAutor");
            idAutor = Integer.parseInt(request.getParameter("idAutor"));
            autor.setIdAutor(idAutor);
            autor.setNome(nomeAutor);
            daoAutor.inserir(autor);

            String resultado = "";
            
            resultado = listaProdutosCadastrados();
            request.getSession().setAttribute("resultadoAutor", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/listaAutor.jsp");
        }
    }

    protected String listaProdutoNome(String nomeAutor) {
        DAOAutor autor = new DAOAutor();
        String tabela = "";
        List<Autor> lista = autor.listByNome(nomeAutor);
        for (Autor l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdAutor()+ "</td>"
                    + "<td>" + l.getNome()+ "</td>"
                    + "</tr>";
        }
        
        return tabela;
    }

    protected String listaProdutosCadastrados() {
        DAOAutor autor = new DAOAutor();
        String tabela = "";
        List<Autor> lista = autor.listInOrderId();
        for (Autor l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdAutor()+ "</td>"
                    + "<td>" + l.getNome()+ "</td>"
                    + "</tr>";
        }

        return tabela;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
