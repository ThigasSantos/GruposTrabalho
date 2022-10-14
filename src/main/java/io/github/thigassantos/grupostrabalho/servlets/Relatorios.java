package io.github.thigassantos.grupostrabalho.servlets;

import io.github.thigassantos.grupostrabalho.grupos.Grupo;
import io.github.thigassantos.grupostrabalho.pessoa.Pessoa;
import io.github.thigassantos.grupostrabalho.pessoa.PessoaBeanLocal;
import io.github.thigassantos.grupostrabalho.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Tygsv
 */
@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class Relatorios extends HttpServlet {

    @Inject
    PessoaBeanLocal pessoaBean;

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Relatorios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Relatorios Para Resultado das Pesquisas</h1>");

            //Questão 1
            //<editor-fold defaultstate="collapsed" desc="Questão 1">
            out.println("<h2>QUESTÃO 1-a)</h2>");
            List<Pessoa> lista = pessoaBean.buscarTodosQuery();
            out.println("<p><pre>"+Util.toJson(lista)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 1-b)</h2>");
            lista = pessoaBean.buscarTodosTyped();
            out.println("<p><pre>"+Util.toJson(lista)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 1-c)</h2>");
            lista = pessoaBean.buscarTodosNamed();
            out.println("<p><pre>"+Util.toJson(lista)+"</pre></p>"); 
            //</editor-fold>
            
            //Questão 2
            //<editor-fold defaultstate="collapsed" desc="Questão 2">
            out.println("<h2>QUESTÃO 2-a)</h2>");
            List<String> lista2 = pessoaBean.buscarNomeQuery();
            out.println("<p><pre>"+Util.toJson(lista2)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 2-b)</h2>");
            lista2 = pessoaBean.buscarNomeTyped();
            out.println("<p><pre>"+Util.toJson(lista2)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 2-c)</h2>");
            lista2 = pessoaBean.buscarNomeNamed();
            out.println("<p><pre>"+Util.toJson(lista2)+"</pre></p>"); 
            //</editor-fold>

            //Questão 3
            //<editor-fold defaultstate="collapsed" desc="Questão 3">
            out.println("<h2>QUESTÃO 3-a)</h2>");
            List<Object[]> lista3 = pessoaBean.buscarNomeEnderecoQuery();
            out.println("<p><pre>"+Util.toJson(lista3)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 3-b)</h2>");
            lista3 = pessoaBean.buscarNomeEnderecoTyped();
            out.println("<p><pre>"+Util.toJson(lista3)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 3-c)</h2>");
            lista3 = pessoaBean.buscarNomeEnderecoNamed();
            out.println("<p><pre>"+Util.toJson(lista3)+"</pre></p>"); 
            //</editor-fold>
            
            //Questão 4
            //<editor-fold defaultstate="collapsed" desc="Questão 4">
            out.println("<h2>QUESTÃO 4-a)</h2>");
            List<Pessoa> lista4 = pessoaBean.buscarAvenidaQuery();
            out.println("<p><pre>"+Util.toJson(lista4)+"</pre></p>");   
            out.println("<h2>QUESTÃO 4-b)</h2>");
            lista4 = pessoaBean.buscarAvenidaTyped();
            out.println("<p><pre>"+Util.toJson(lista4)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 4-c)</h2>");
            lista4 = pessoaBean.buscarAvenidaNamed();
            out.println("<p><pre>"+Util.toJson(lista4)+"</pre></p>"); 
            //</editor-fold>
            
            //Questão 5
            //<editor-fold defaultstate="collapsed" desc="Questão 5">
            out.println("<h2>QUESTÃO 5-a)</h2>");
            List<Pessoa> lista5 = pessoaBean.buscarNaoPracaQuery();
            out.println("<p><pre>"+Util.toJson(lista5)+"</pre></p>");   
            out.println("<h2>QUESTÃO 5-b)</h2>");
            lista5 = pessoaBean.buscarNaoPracaTyped();
            out.println("<p><pre>"+Util.toJson(lista5)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 5-c)</h2>");
            lista5 = pessoaBean.buscarNaoPracaNamed();
            out.println("<p><pre>"+Util.toJson(lista5)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 6
            //<editor-fold defaultstate="collapsed" desc="Questão 6">
            out.println("<h2>QUESTÃO 6-a)</h2>");
            List<Object[]> lista6 = pessoaBean.buscarNomeTelefoneQuery();
            out.println("<p><pre>"+Util.toJson(lista6)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 6-b)</h2>");
            lista6 = pessoaBean.buscarNomeTelefoneTyped();
            out.println("<p><pre>"+Util.toJson(lista6)+"</pre></p>"); 
            out.println("<h2>QUESTÃO 6-c)</h2>");
            lista6 = pessoaBean.buscarNomeTelefoneNamed();
            out.println("<p><pre>"+Util.toJson(lista6)+"</pre></p>"); 
            //</editor-fold>
            
            //Qustão 7
            //<editor-fold defaultstate="collapsed" desc="Questão 7">
            out.println("<h2>QUESTÃO 7)</h2>");
            List<Pessoa> lista7 = pessoaBean.buscarEntreDatas(LocalDate.of(2001, Month.APRIL, 1), LocalDate.of(2004, Month.APRIL, 30));
            out.println("<p><pre>"+Util.toJson(lista7)+"</pre></p>"); 
            //</editor-fold>
            
            //Qustão 8
            //<editor-fold defaultstate="collapsed" desc="Questão 8">            
            out.println("<h2>QUESTÃO 8-a)</h2>");
            List<Pessoa> lista8 = pessoaBean.buscarDDDParana();
            out.println("<p><pre>"+Util.toJson(lista8)+"</pre></p>");
            out.println("<h2>QUESTÃO 8-b)</h2>");
            lista8 = pessoaBean.buscarDDDRio();
            out.println("<p><pre>"+Util.toJson(lista8)+"</pre></p>");

            
            //</editor-fold>
            
            //Qustão 9
            //<editor-fold defaultstate="collapsed" desc="Questão 9">
            out.println("<h2>QUESTÃO 9)</h2>");
            List<Pessoa> lista9 = pessoaBean.buscarSemTelefone();
            out.println("<p><pre>"+Util.toJson(lista9)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 10
            //<editor-fold defaultstate="collapsed" desc="Questão 10">
            out.println("<h2>QUESTÃO 10)</h2>");
            List<Object[]> lista10 = pessoaBean.buscarQuantosTelefones();
            out.println("<p><pre>"+Util.toJson(lista10)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 11
            //<editor-fold defaultstate="collapsed" desc="Questão 11">
            out.println("<h2>QUESTÃO 11)</h2>");
            List<Grupo> lista11 = pessoaBean.buscarGruposInativos();
            out.println("<p><pre>"+Util.toJson(lista11)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 12
            //<editor-fold defaultstate="collapsed" desc="Questão 12">
            out.println("<h2>QUESTÃO 12)</h2>");
            List<Object[]> lista12 = pessoaBean.buscarLiderGrupos();
            out.println("<p><pre>"+Util.toJson(lista12)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 13
            //<editor-fold defaultstate="collapsed" desc="Questão 13">
            out.println("<h2>QUESTÃO 13)</h2>");
            List<Object[]> lista13 = pessoaBean.buscarMembrosGrupos("Estudo IV");
            out.println("<p><pre>"+Util.toJson(lista13)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 14
            //<editor-fold defaultstate="collapsed" desc="Questão 14">
            out.println("<h2>QUESTÃO 14)</h2>");
            List<Grupo> lista14 = pessoaBean.buscarGruposLider("Beatriz Yana");
            out.println("<p><pre>"+Util.toJson(lista14)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 15
            //<editor-fold defaultstate="collapsed" desc="Questão 15">
            out.println("<h2>QUESTÃO 15)</h2>");
            List<Object[]> lista15 = pessoaBean.buscarGrupoMembro("Cecília Xerxes");
            out.println("<p><pre>"+Util.toJson(lista15)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 16
            //<editor-fold defaultstate="collapsed" desc="Questão 16">
            out.println("<h2>QUESTÃO 16)</h2>");
            List<Grupo> lista16 = pessoaBean.buscarGrupoPedacoNome("II");
            out.println("<p><pre>"+Util.toJson(lista16)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 17
            //<editor-fold defaultstate="collapsed" desc="Questão 17">
            out.println("<h2>QUESTÃO 17)</h2>");
            List<Object[]> lista17 = pessoaBean.buscarGrupoQtdMembros();
            out.println("<p><pre>"+Util.toJson(lista17)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 18
            //<editor-fold defaultstate="collapsed" desc="Questão 18">
            out.println("<h2>QUESTÃO 18)</h2>");
            List<Object[]> lista18 = pessoaBean.buscarGrupoQtdAtuacoes(3l);
            out.println("<p><pre>"+Util.toJson(lista18)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 19
            //<editor-fold defaultstate="collapsed" desc="Questão 19">
            out.println("<h2>QUESTÃO 19)</h2>");
            List<String> lista19 = pessoaBean.buscarMembroDataGrupo(1l, LocalDate.of(2012,1,1));
            out.println("<p><pre>"+Util.toJson(lista19)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 20
            //<editor-fold defaultstate="collapsed" desc="Questão 20">
            out.println("<h2>QUESTÃO 20)</h2>");
            List<Object[]> lista20 = pessoaBean.buscarDataMembroGrupos(LocalDate.of(2012,1,1));
            out.println("<p><pre>"+Util.toJson(lista20)+"</pre></p>");
            out.println("<h2>QUESTÃO 20-c)</h2>");
            lista20 = pessoaBean.buscarDataMembroGrupos(2l, LocalDate.of(2012,1,1));
            out.println("<p><pre>"+Util.toJson(lista20)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 21
            //<editor-fold defaultstate="collapsed" desc="Questão 21">
            out.println("<h2>QUESTÃO 21)</h2>");
            List<Object[]> lista21 = pessoaBean.buscarMembroSemTermino();
            out.println("<p><pre>"+Util.toJson(lista21)+"</pre></p>");
            //</editor-fold>
            
            //Qustão 22
            //<editor-fold defaultstate="collapsed" desc="Questão 22">
            out.println("<h2>QUESTÃO 22)</h2>");
            List<Object[]> lista22 = pessoaBean.buscarLiderMembroGrupo();
            out.println("<p><pre>"+Util.toJson(lista22)+"</pre></p>");
            //</editor-fold>
            
            out.println("</body>");
            out.println("</html>");
        }
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
