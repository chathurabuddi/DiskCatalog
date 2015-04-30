/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diskcatalog.servlets;

import com.diskcatalog.helpers.CompactDisk;
import com.diskcatalog.helpers.CompactDiskDAO;
import com.diskcatalog.helpers.CompactDiskJavaDBDAO;
import com.diskcatalog.helpers.HtmlFragments;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CHATHURA
 */
public class SearchCDResultView extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        CompactDisk compactDisk = new CompactDisk();
        
        compactDisk.setDiskTitle(request.getParameter("title"));
        compactDisk.setDiskArtist(request.getParameter("artist"));
        compactDisk.setDiskCountry(request.getParameter("country"));
        compactDisk.setDiskPrice(request.getParameter("price"));
        compactDisk.setDiskYear(request.getParameter("year"));
        
        
        HtmlFragments htmlFragments = new HtmlFragments();
        htmlFragments.printHeader(out, "Search Results");
        htmlFragments.printFloatingButton(out);
        
        CompactDiskDAO compactDiskDAO = new CompactDiskJavaDBDAO();
        htmlFragments.printTable(out, compactDiskDAO.searchCD(compactDisk));
        
        htmlFragments.printFooter(out);
        
        
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
