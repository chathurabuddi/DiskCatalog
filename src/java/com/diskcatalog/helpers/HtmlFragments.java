package com.diskcatalog.helpers;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author CHATHURA
 * 
 * HtmlFragments class to reduce the redundant codes in servlets.
 */
public class HtmlFragments {
    
    /**
     * Prints the HTML header with the navigation bar.
     * This fragment should be used in the top of the page and
     * it is necessary to use the printFooter() method at the bottom of the page.
     * @param out PrintWriter object that used in current servlet
     * @param title String title of the page
     */
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

        header.append("<li><a href=\"AddCDView\">");
        header.append("<i class=\"mdi-content-add-circle-outline left\"></i>");
        header.append("<b>ADD NEW&nbsp;&nbsp;&nbsp;</b>\n</a>\n</li>");

        header.append("<li><a href=\"SearchCDView\">");
        header.append("<i class=\"mdi-action-search left\"></i>");
        header.append("<b>SEARCH&nbsp;&nbsp;&nbsp;</b></a></li>");

        header.append("<li><a href=\"ManageCDView\">");
        header.append("<i class=\"mdi-editor-mode-edit left\"></i>");
        header.append("<b>MANAGE&nbsp;&nbsp;&nbsp;</b></a></li>");

        header.append("</ul>");
        header.append("<a class=\"button-collapse\" href=\"#\" data-activates=\"nav-mobile\">");
        header.append("<i class=\"mdi-navigation-menu\"></i></a>");
        header.append("</div></div></nav></div>");

        out.print(header);
    }
    
    /**
     * Prints the HTML header with the navigation bar. HTML title will not be set.
     * This fragment should be used in the top of the page and
     * it is necessary to use the printFooter() method at the bottom of the servlet.
     * @param out PrintWriter object that used in current servlet
     */
    public void printHeader(PrintWriter out) {
        printHeader(out, null);
    }
    
    /**
     * Prints the HTML code fragment to show a floating home button
     * @param out PrintWriter object that used in current servlet
     */
    public void printFloatingButton(PrintWriter out) {
        StringBuffer floting_button = new StringBuffer();

        floting_button.append("<div class=\"container\">");
        floting_button.append("<div class=\"home-btn\">");
        floting_button.append("<a href=\"index.html\" class=\"btn-floating btn-large waves-effect waves-light teal darken-2 btn tooltipped\" data-position=\"left\" data-delay=\"30\" data-tooltip=\"Home\">");
        floting_button.append("<i class=\"mdi-action-home\"></i></a>");
        floting_button.append("</div></div>");

        out.print(floting_button);
    }
    
    /**
     * Prints a HTML form with given parameters.
     * Form will be populated automatically with values from given CompactDisk object
     * @param out PrintWriter object that used in current servlet
     * @param form_action String path to a servlet where the filled values should be submitted
     * @param title String title of the form
     * @param button_lable String label should be displayed on the submit button
     * @param compactdisk CompactDisk object to get values to populate the form
     */
    public void printForm(PrintWriter out, String form_action, String title, String button_lable, CompactDisk compactdisk) {
        StringBuffer cd_form = new StringBuffer();

        cd_form.append("<div class=\"container\"><div class=\"row\"><div class=\"col s12\">");
        cd_form.append("<div id=\"cd-add-form\"><div class=\"row\">");
        cd_form.append("<h5 class=\"cd-title white-text teal center-on-small-only\">");
        cd_form.append("<i class=\"small mdi-content-add-circle-outline left hide-on-small-only\"></i> <b>").append(title).append("</b></h5>");
        cd_form.append("<form class=\"col s12 grey lighten-4\" id=\"cd-form\" action=\"").append(form_action).append("\" method=\"post\">");

        cd_form.append("<input id=\"id\" type=\"hidden\" name=\"id\" value=\"").append(compactdisk.getDiskId()).append("\">");

        cd_form.append("<div class=\"row\"><div class=\"input-field col s12\">");
        cd_form.append("<i class=\"mdi-av-queue-music teal-text prefix\"></i>");
        cd_form.append("<input id=\"title\" type=\"text\" name=\"title\" value=\"").append(compactdisk.getDiskTitle()).append("\">");
        cd_form.append("<label for=\"title\">Title</label>");
        cd_form.append("</div></div>");

        cd_form.append("<div class=\"row\"><div class=\"input-field col s12\">");
        cd_form.append("<i class=\"mdi-action-account-circle teal-text prefix\"></i>");
        cd_form.append("<input id=\"artist\" type=\"text\" name=\"artist\" value=\"").append(compactdisk.getDiskArtist()).append("\">");
        cd_form.append("<label for=\"artist\">Artist</label>");
        cd_form.append("</div></div>");

        cd_form.append("<div class=\"row\"><div class=\"input-field col s12\">");
        cd_form.append("<i class=\"mdi-action-language teal-text prefix\"></i>");
        cd_form.append("<input id=\"country\" type=\"text\" name=\"country\"  value=\"").append(compactdisk.getDiskCountry()).append("\">");
        cd_form.append("<label for=\"country\">Country</label>");
        cd_form.append("</div></div>");

        cd_form.append("<div class=\"row\"><div class=\"input-field col s12\">");
        cd_form.append("<i class=\"mdi-maps-local-atm teal-text prefix\"></i>");
        cd_form.append("<input id=\"price\" type=\"text\" name=\"price\" value=\"").append(compactdisk.getDiskPrice()).append("\">");
        cd_form.append("<label for=\"price\">Price</label>");
        cd_form.append("</div></div>");

        cd_form.append("<div class=\"row\"><div class=\"input-field col s12\">");
        cd_form.append("<i class=\"mdi-action-event teal-text prefix\"></i>");
        cd_form.append("<input id=\"year\" type=\"text\" name=\"year\" value=\"").append(compactdisk.getDiskYear()).append("\">");
        cd_form.append("<label for=\"year\">Year</label>");
        cd_form.append("</div></div>");

        cd_form.append("<div class=\"row\"><div class=\"input-field col s12\">");
        cd_form.append("<button class=\"btn teal darken-2 waves-effect waves-light right\" type=\"submit\">");
        cd_form.append(button_lable).append("<i class=\"mdi-content-send right\"></i></button>");
        cd_form.append("</div></div>");

        cd_form.append("</form></div></div></div></div></div>");

        out.print(cd_form);
    }

    /**
     * Prints a empty HTML form with given parameters.
     * @param out PrintWriter object that used in current servlet
     * @param form_action String path to a servlet where the filled values should be submitted
     * @param title String title of the form
     * @param button_lable String label should be displayed on the submit button
     */
    public void printForm(PrintWriter out, String form_action, String title, String button_lable) {
        CompactDisk compact_disk = new CompactDisk();
        printForm(out, form_action, title, button_lable, compact_disk);
    }

    /**
     * Prints a alert message when page loading with given parameters
     * @param out PrintWriter object that used in current servlet
     * @param message String message that should be displayed on the alert
     * @param delay Integer alert display time in milliseconds 
     */
    public void printAlert(PrintWriter out, String message, int delay) {
        StringBuffer alert = new StringBuffer();

        alert.append("<script type=\"text/javascript\">");
        alert.append("function alert(){");
        alert.append("Materialize.toast('").append(message).append("', ").append(delay).append(");");
        alert.append("}onload = alert;");
        alert.append("</script>");

        out.println(alert);
    }

    /**
     * Show the CompactDisk data with a responsive table.
     * Non essential fields will be hides on small screens.
     * @param out PrintWriter object that used in current servlet
     * @param dataSet ArrayList containing CompactDisks which should be displayed
     */
    public void printTable(PrintWriter out, ArrayList<CompactDisk> dataSet) {
        StringBuffer table = new StringBuffer();

        table.append("<div class=\"container\">");
        table.append("<table class=\"bordered hoverable centered\">");
        table.append("<thead><tr>");
        table.append("<th class=\"hide-sm\">Disk ID</th>");
        table.append("<th>Title</th>");
        table.append("<th>Artist</th>");
        table.append("<th class=\"hide-sm\">Country</th>");
        table.append("<th class=\"hide-sm\">Price</th>");
        table.append("<th class=\"hide-xs\">Year</th>");
        table.append("<th>Manage</th>");
        table.append("</tr></thead>");
        table.append("<tbody>");

        for (CompactDisk compactDisk : dataSet) {
            table.append("<tr>");
            table.append("<td class=\"hide-sm\">").append(compactDisk.getDiskId()).append("</td>");
            table.append("<td>").append(compactDisk.getDiskTitle()).append("</td>");
            table.append("<td>").append(compactDisk.getDiskArtist()).append("</td>");
            table.append("<td class=\"hide-sm\">").append(compactDisk.getDiskCountry()).append("</td>");
            table.append("<td class=\"hide-sm\">").append(compactDisk.getDiskPrice()).append("</td>");
            table.append("<td class=\"hide-xs\">").append(compactDisk.getDiskYear()).append("</td>");
            table.append("<td><a href=\"UpdateCDView?diskid=").append(compactDisk.getDiskId()).append("\">Update</a> | <a href=\"DeleteCD?diskid=").append(compactDisk.getDiskId()).append("\">Delete</a></td>");
            table.append("</tr>");
        }

        table.append("</tbody></table></div>");
        out.println(table);
    }

    /**
     * Prints the HTML footer with external JavaScript files.
     * This fragment should be used in the bottom of the page and
     * it is necessary to use the printHeader() method at the top of the page.
     * @param out PrintWriter object that used in current servlet
     */
    public void printFooter(PrintWriter out) {
        StringBuffer footer = new StringBuffer();

        footer.append("<script type=\"text/javascript\" src=\"js/jquery-2.1.1.min.js\"></script>");
        footer.append("<script type=\"text/javascript\" src=\"js/materialize.js\"></script>");
        footer.append("<script type=\"text/javascript\" src=\"js/scripts.js\"></script>");
        footer.append("</body></html>");

        out.print(footer);
    }
}
