/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diskcatalog.helpers;

import java.io.PrintWriter;

/**
 *
 * @author CHATHURA
 */
public class HtmlFragments {

    public void printHeader(PrintWriter out, String title) {
        StringBuffer header = new StringBuffer();

        // Head
        header.append("<html><head lang=\"en\"><meta charset=\"UTF-8\">");
        header.append("<title>").append(title).append("</title>");
        header.append("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\" />");
        header.append("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/styles.css\" />");
        header.append("</head><body>");

        // Navigation Menu
        header.append("<div class=\"navbar-fixed\">");
        header.append("<nav class=\"teal\">");
        header.append("<div class=\"container\">");
        header.append("<div class=\"nav-wrapper\">");
        header.append("<a href=\"index.html\" class=\"brand-logo\"><img src=\"images/logo.png\" alt=\"logo\"/></a>");
        header.append("<ul id=\"nav-mobile\" class=\"right side-nav\">");

        header.append("<li><a href=\"AddCD.html\">");
        header.append("<i class=\"mdi-content-add-circle-outline left\"></i>");
        header.append("<b>ADD NEW&nbsp;&nbsp;&nbsp;</b>\n</a>\n</li>");

        header.append("<li><a href=\"#\">");
        header.append("<i class=\"mdi-action-search left\"></i>");
        header.append("<b>SEARCH&nbsp;&nbsp;&nbsp;</b></a></li>");

        header.append("<li><a href=\"#\">");
        header.append("<i class=\"mdi-editor-mode-edit left\"></i>");
        header.append("<b>MANAGE&nbsp;&nbsp;&nbsp;</b></a></li>");

        header.append("</ul>");
        header.append("<a class=\"button-collapse\" href=\"#\" data-activates=\"nav-mobile\">");
        header.append("<i class=\"mdi-navigation-menu\"></i></a>");
        header.append("</div></div></nav></div>");
        
        out.print(header);
    }
    
    public void printHeader(PrintWriter out){
        printHeader(out, null);
    }
    
    public void printFlotingButton(PrintWriter out) {
        StringBuffer floting_button = new StringBuffer();
        
        floting_button.append("<div class=\"container\">");
        floting_button.append("<div class=\"home-btn\">");
        floting_button.append("<a href=\"index.html\" class=\"btn-floating btn-large waves-effect waves-light teal darken-2 btn tooltipped\" data-position=\"left\" data-delay=\"30\" data-tooltip=\"Home\">");
        floting_button.append("<i class=\"mdi-action-home\"></i></a>");
        floting_button.append("</div></div>");
        
        out.print(floting_button);
    }

    public void printFooter(PrintWriter out) {
        StringBuffer footer = new StringBuffer();
        
        footer.append("<script type=\"text/javascript\" src=\"js/jquery-2.1.1.min.js\"></script>");
        footer.append("<script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>");
        footer.append("<script type=\"text/javascript\" src=\"js/scripts.js\"></script>");
        footer.append("</body></html>");
        
        out.print(footer);
    }
}
