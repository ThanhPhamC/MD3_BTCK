package project.controller;

import project.model.emtity.CatalogForCreat;
import project.model.emtity.CatalogInfo;
import project.model.emtity.Colors;
import project.model.service.ICatalogService;
import project.model.service.IColorService;
import project.model.serviceIpm.ColorServiceIpm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "ColorServlet", value = "/ColorServlet")
public class ColorServlet extends HttpServlet {
    private IColorService colorService = new ColorServiceIpm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("SearchByName")) {
            List<Colors> colorsList = colorService.searchByName(request.getParameter("colorName"));
            for (Colors c :colorsList) {
                response.setCharacterEncoding("UTF-8");
                loadData(request,response,c);
            }
        }else {
            findAll(request, response);
        }

    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Colors> colorsList = colorService.findAll();
        request.setAttribute("listColor", colorsList);
        request.getRequestDispatcher("views/admin/color.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("addNewColor")) {
            Colors colors = new Colors();
            colors.setColorName(request.getParameter("newColorName"));
            colors.setColorHex(request.getParameter("newColor"));
            boolean result = colorService.save(colors);
            if (result) {
                List<Colors> colorsList = colorService.searchByName(colors.getColorName());
                Colors colors1 = colorsList.get(0);
                response.setCharacterEncoding("UTF-8");
                loadData(request, response, colors1);
            }
        } else if (action != null && action.equals("Delete")) {
            List<Colors> colorsList = colorService.searchByName(request.getParameter("deleteCol"));
            Colors colors1 = colorsList.get(0);
            boolean result = colorService.delete(colors1.getColoId());
            if (result) {
                findAll(request, response);
            }
        } else if (action != null && action.equals("Update")) {
            Colors colors = new Colors();
            colors.setColorName(request.getParameter("newColorName"));
            colors.setColoId(Integer.parseInt(request.getParameter("newColoId")));
            colors.setColorHex(request.getParameter("updateColor"));
            colors.setColorStatus(Boolean.parseBoolean(request.getParameter("updateStatus")));
            boolean result = colorService.update(colors);
            if (result) {
                findAll(request, response);
            }

        }
    }

    public void loadData(HttpServletRequest request, HttpServletResponse response, Colors colors) throws IOException {
        Writer out = response.getWriter();
        out.write(" <tr>\n" +
                "                                    <td> "+colors.getColoId()+"\n" +
                "                                    </td>\n" +
                "                                    <td>"+colors.getColorName()+"</td>\n" +
                "                                    <td>"+colors.getColorHex()+"</td>\n" +
                "                                    <td>\n" +
                "                                        <i style=\" color:"+colors.getColorHex()+"; font-size:40px  \"\n" +
                "                                           class=\"bi bi-patch-check-fill\"></i>\n" +
                "                                    </td>\n" +
                "                                    <td><input style=\"border:none; border-collapse: collapse; width: 100px\" type=\"color\"\n" +
                "                                               name=\"colors\" value=\""+colors.getColorHex()+"\"></td>\n" +
                "                                    <td>"+colors.isColorStatus()+"</td>\n" +
                "                                    <td>\n" +
                "                                        <button type=\"button\" onclick=\"updateNewColor()\" id=\"update\"\n" +
                "                                                class=\"btn btn-outline-primary\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#updateColor\"\n" +
                "                                                data-whatever=\""+colors.getColorHex()+"\"><i class=\"bi bi-pencil-square\"></i>\n" +
                "                                        </button>\n" +
                "                                        <button type=\"button\" id=\"delete\" class=\"btn btn-outline-danger\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#deleteColor\"\n" +
                "                                                data-whatever=\""+colors.getColorName()+"\"><i class=\"bi bi-journal-x\"></i>\n" +
                "                                        </button>\n" +
                "                                        <input type=\"hidden\" id=\"oldColorName\" value=\""+colors.getColorName()+"\">\n" +
                "                                        <input type=\"hidden\" id=\"oldColorId\" value=\""+colors.getColoId()+"\">\n" +
                "                                        <input type=\"hidden\" id=\"oldHexColor\" value=\""+colors.getColorHex()+"\">\n" +
                "                                        <input type=\"hidden\" id=\"oldColorStatus\" value=\""+colors.isColorStatus()+"\">\n" +
                "                                    </td>\n" +
                "                                </tr>");
        out.flush();
    }
}
