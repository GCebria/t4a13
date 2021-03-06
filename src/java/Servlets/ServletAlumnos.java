/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.AlumnoBean;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAlumnos extends HttpServlet {

    ArrayList<AlumnoBean> _listado = new ArrayList<AlumnoBean>();

    @Override
    public void init() {
        AlumnoBean _alumno1 = new AlumnoBean("Gerard", "Cebria", "Leon", "35597712Z");
        AlumnoBean _alumno2 = new AlumnoBean("Marc", "San Juan", "Fernando", "35597713S");
        AlumnoBean _alumno3 = new AlumnoBean("Maria", "Perez", "Olivares", "11111111A");

        _listado.add(_alumno1);
        _listado.add(_alumno2);
        _listado.add(_alumno3);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/muestraDatosAlumno.jsp");
        RequestDispatcher rd2 = this.getServletContext().getRequestDispatcher("/errorDNI.jsp");

        for (AlumnoBean a : _listado) {
            if (dni.equalsIgnoreCase(a.getDni())) {
                request.setAttribute("alumno", a);
            } else {
                request.setAttribute("dni", dni);
                rd2.forward(request, response);
            }
        }
        rd.forward(request, response);
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
