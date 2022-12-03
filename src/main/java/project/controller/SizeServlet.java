package project.controller;

import project.model.emtity.Sizes;
import project.model.service.ISizeService;
import project.model.serviceIpm.SizeServiceIpm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "SizeServlet", value = "/SizeServlet")
public class SizeServlet extends HttpServlet {
    private ISizeService sizeService = new SizeServiceIpm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("SearchByName")) {
            List<Sizes> sizesList = sizeService.searchByName(request.getParameter("sizeName"));
            for (Sizes s : sizesList) {
                loadSizeData(request,response,s);
            }
        }else {
            findALl(request, response);
        }
    }

    public void findALl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sizes> sizesList = sizeService.findAll();
        request.setAttribute("listSize", sizesList);
        request.getRequestDispatcher("views/admin/sizes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("addNewSize")) {
            Sizes sizes = new Sizes();
            sizes.setSizeName(request.getParameter("newSize"));
            boolean result = sizeService.save(sizes);
            if (result) {
                List<Sizes> sizesList = sizeService.searchByName(sizes.getSizeName());
                Sizes sizes1 = sizesList.get(0);
                loadSizeData(request, response, sizes1);
            }
        } else if (action != null && action.equals("Delete")) {
            List<Sizes> sizesList = sizeService.searchByName(request.getParameter("deleteSizeName"));
            Sizes sizes = sizesList.get(0);
            boolean result = sizeService.delete(sizes.getSizeId());
            if (result) {

                findALl(request, response);
            }
        } else if (action != null && action.equals("Update")) {
            Sizes sizes = new Sizes();
            sizes.setSizeId(Integer.parseInt(request.getParameter("newSizeId")));
            sizes.setSizeName(request.getParameter("newSizeName"));
            sizes.setSizeStatus(Boolean.parseBoolean(request.getParameter("updateStatus")));
            boolean result = sizeService.update(sizes);
            if (result) {
                findALl(request, response);
            }
        }
    }

    public void loadSizeData(HttpServletRequest request, HttpServletResponse response, Sizes sizes) throws ServletException, IOException {
        Writer out = response.getWriter();
        out.write("<tr>\n" +
                "                                    <td> " + sizes.getSizeId() + " </td>\n" +
                "                                    <td>" + sizes.getSizeName() + "</td>\n" +
                "                                    <td>" + (sizes.getSizeStatus()? "Active":"In active") + "</td>\n" +
                "                                    <td>\n" +
                "                                        <button type=\"button\"  id=\"update\"\n" +
                "                                                class=\"btn btn-outline-primary\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#updateColor\"\n" +
                "                                                data-whatever=\"" + sizes.getSizeName() + "\"><i class=\"bi bi-pencil-square\"></i>\n" +
                "                                        </button>\n" +
                "                                        <button type=\"button\" id=\"delete\" class=\"btn btn-outline-danger\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#deleteColor\"\n" +
                "                                                data-whatever=\"" + sizes.getSizeName() + "\"><i class=\"bi bi-journal-x\"></i>\n" +
                "                                        </button>\n" +
                "                                        <input type=\"hidden\" id=\"oldSizeId\" value=\"" + sizes.getSizeId() + "\">\n" +
                "                                        <input type=\"hidden\" id=\"oldSizeName\" value=\"" + sizes.getSizeName() + "\">\n" +
                "                                        <input type=\"hidden\" id=\"oldSizeStatus\" value=\"" + sizes.getSizeStatus() + "\">\n" +
                "                                    </td>\n" +
                "                                </tr>");
    }
}
