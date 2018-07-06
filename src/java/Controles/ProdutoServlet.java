/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOLivro;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produto"})
public class ProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nomeProduto = "";

        try (PrintWriter out = response.getWriter()) {
            nomeProduto = request.getParameter("nomeProduto");

            String resultado = "";
            if (nomeProduto == null || nomeProduto.equals("")) {
                resultado = listaProdutosCadastrados();
            } else {
                resultado = listaProdutoNome(nomeProduto);
            }
            request.getSession().setAttribute("resultado", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/listaProdutos.jsp");
        }
    }

    protected String listaProdutoNome(String nomeProduto) {
        DAOLivro produto = new DAOLivro();
        String tabela = "";
        List<Livro> lista = produto.listByNome(nomeProduto);
        for (Livro l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdLivro()+ "</td>"
                    + "<td>" + l.getPreco() + "</td>"
                    
                    + "<td>" + l.getDescricao() + "</td>"
                    + "<td>" + l.getVendaIdVenda().getIdVenda() + "</td>"
                    + "<td>" + l.getEditoraIdEditora().getNome() + "</td>"
                    + "<td>" + l.getGeneroIdGenero().getNome() + "</td>"
                    + "</tr>";
        }
        
        return tabela;
    }

    protected String listaProdutosCadastrados() {
        DAOLivro produto = new DAOLivro();
        String tabela = "";
        List<Livro> lista = produto.listInOrderId();
        for (Livro l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getIdLivro()+ "</td>"
                    + "<td>" + l.getPreco() + "</td>"
                   
                    + "<td>" + l.getDescricao() + "</td>"
                    + "<td>" + l.getVendaIdVenda().getIdVenda() + "</td>"
                    + "<td>" + l.getEditoraIdEditora().getNome() + "</td>"
                    + "<td>" + l.getGeneroIdGenero().getNome() + "</td>"
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
