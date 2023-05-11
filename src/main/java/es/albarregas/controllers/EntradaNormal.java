/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesus
 */
@WebServlet(name = "EntradaNormal", urlPatterns = {"/EntradaNormal"})
public class EntradaNormal extends HttpServlet {

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
        Usuario usuario = new Usuario();
        Enumeration<String> controles = request.getParameterNames();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        while(controles.hasMoreElements()) {
            String control = controles.nextElement();
            String valor = request.getParameter(control);
            switch(control) {
                case "idUsuario":
                    usuario.setIdUsuario(Short.parseShort(valor));
                    break;
                case "nombre":
                    usuario.setNombre(valor);
                    break;
                case "fecha":
                {
                    try {
                        usuario.setFecha(formato.parse(valor));
                    } catch (ParseException ex) {
                        System.out.println("Algo pasa con la fecha");
                        Logger.getLogger(EntradaNormal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case "tipo":
                    
                    switch(valor) {
                        case "NIF":
                            usuario.setTipo(Usuario.tipoId.NIF);
                            break;
                        case "NIE":
                            usuario.setTipo(Usuario.tipoId.NIE);
                            break;
                        case "Pasaporte":
                            usuario.setTipo(Usuario.tipoId.Pasaporte);
                            break;
                    }
                case "identificador":
                    usuario.setIdentificador(valor);
                    break;
            }
        }
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("salida.jsp").forward(request, response);
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
