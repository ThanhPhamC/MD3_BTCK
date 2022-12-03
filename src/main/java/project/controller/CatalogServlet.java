package project.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.model.emtity.Catalog;
import project.model.emtity.CatalogForCreat;
import project.model.emtity.CatalogInfo;
import project.model.service.ICatalogService;
import project.model.serviceIpm.CatalogServiceIpm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private ICatalogService catalogService = new CatalogServiceIpm();
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("GetById")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Catalog cat = (Catalog) catalogService.searchById(catalogId);
            String json = GSON.toJson(cat);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("Content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        } else if (action != null && action.equals("SearchByName")) {
            List<CatalogInfo> catalogInfoList = catalogService.searchByName(request.getParameter("catalogName"));
            for (CatalogInfo cat : catalogInfoList) {
                    loadData(request,response,cat);
            }
        } else if (action != null && action.equals("addNewProduct")) {
            List<CatalogForCreat> catLists = catalogService.getCatCreatProduct();
            request.setAttribute("listCat", catLists);
            request.getRequestDispatcher("views/admin/newProduct.jsp").forward(request, response);
        } else {
            findAll(request, response);
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CatalogInfo> catalogInfoList = catalogService.findAll();
        List<CatalogForCreat> catalogForCreats = catalogService.getCatalogForCreat();
        request.setAttribute("listInfo", catalogInfoList);
        request.setAttribute("listCreat", catalogForCreats);
        request.getRequestDispatcher("views/admin/category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Creat")) {
            Catalog cat = new Catalog();
            cat.setCatalogName(request.getParameter("newCatalogName"));
            cat.setDescriptions(request.getParameter("newDescriptions"));
            cat.setParentId(Integer.parseInt(request.getParameter("newCatalogParent")));
            boolean result = catalogService.save(cat);
            if (result) {
                findAll(request, response);
            }
        } else if (action != null & action.equals("Delete")) {
            String inputValue = request.getParameter("deleteCat");
            String[] arrStr = inputValue.split("\\\"");
            String name = arrStr[1].trim();
            CatalogForCreat cat = (CatalogForCreat) catalogService.searchForDelete(name);
            boolean result = catalogService.delete(cat.getCatalogId());
            if (result) {
                findAll(request, response);
            }
        } else if (action != null & action.equals("Update")){
            Catalog catalog = new Catalog();
            catalog.setCatalogId(Integer.parseInt(request.getParameter("updateCatalogId")));
            catalog.setCatalogName(request.getParameter("updateCatalogName"));
            catalog.setDescriptions(request.getParameter("updateDescriptions"));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("updateStatus")));
            catalog.setParentId(Integer.parseInt(request.getParameter("updateCatalogParent")));
            boolean result = catalogService.update(catalog);
            if (result) {
                findAll(request, response);
            }
        }
    }

    public void loadData(HttpServletRequest request, HttpServletResponse response, CatalogInfo cat) throws ServletException, IOException {
        Writer out = response.getWriter();
        out.write(" <tr style=\"color: black\">\n" +
                "                                    <td>" + cat.getCatalogId() + "</td>\n" +
                "                                    <td>" + cat.getCatalogName() + "</td>\n" +
                "                                    <td>" + cat.getDescriptions() + "</td>\n" +
                "                                    <td>" + (cat.getParentName() == null ? "Root" : cat.getParentName()) + "</td>\n" +
                "                                    <td>" + (cat.isCatalogStatus() ? "Active" : "In Active") + "</td>\n" +
                "                                    <td>\n" +
                "                                        <button type=\"button\" id=\"update\" class=\"btn btn-outline-primary\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#updateCatalog\"\n" +
                "                                                data-whatever=\"" + cat.getCatalogId() + "\"><i class=\"bi bi-pencil-square\"></i>\n" +
                "                                        </button>\n" +
                "                                    </td>\n" +
                "                                    <td>\n" +
                "                                        <button type=\"button\" id=\"delete\" class=\"btn btn-outline-danger\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#deleteCatalog\"\n" +
                "                                                data-whatever=\"" + cat.getCatalogName() + "\"><i class=\"bi bi-journal-x\"></i>\n" +
                "                                        </button>\n" +
                "                                    </td>\n" +
                "                                </tr>");

    }


}
