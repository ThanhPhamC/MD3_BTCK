package project.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.model.emtity.*;
import project.model.service.ICatalogService;
import project.model.service.IColorService;
import project.model.service.IProductService;
import project.model.service.ISizeService;
import project.model.serviceIpm.CatalogServiceIpm;
import project.model.serviceIpm.ColorServiceIpm;
import project.model.serviceIpm.ProductServiceIpm;
import project.model.serviceIpm.SizeServiceIpm;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceIpm();
    private static final Gson GSON = new GsonBuilder().create();
    private ICatalogService catalogService = new CatalogServiceIpm();
    private IColorService colorService = new ColorServiceIpm();
    private ISizeService sizeService = new SizeServiceIpm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("AddNew")) {
        } else if (action != null && action.equals("addNewProduct")) {
            List<CatalogInfo> catLists = catalogService.getCatCreatProduct();
            List<Colors> colorsList = colorService.findForCreatProduct();
            List<Sizes> sizesList = sizeService.findSizeForCreatProduct();
            request.setAttribute("listSize", sizesList);
            request.setAttribute("listColor", colorsList);
            request.setAttribute("listCat", catLists);
            request.getRequestDispatcher("views/admin/newProduct.jsp").forward(request, response);
        } else if (action != null && action.equals("Update")) {
            ProductViewsAdmin product = (ProductViewsAdmin) productService.searchById(Integer.parseInt(request.getParameter("productId")));
            List<ProductDetail> proList = productService.getDetailById(Integer.parseInt(request.getParameter("productId")));
            request.setAttribute("pro", product);
            request.setAttribute("proList", proList);
            List<CatalogForCreat> catLists = catalogService.getCatCreatProduct();
            List<Colors> colorsList = colorService.findForCreatProduct();
            List<Sizes> sizesList = sizeService.findSizeForCreatProduct();
            request.setAttribute("listSize", sizesList);
            request.setAttribute("listColor", colorsList);
            request.setAttribute("listCat", catLists);
            request.getRequestDispatcher("views/admin/updateProduct.jsp").forward(request, response);
        } else if (action != null && action.equals("SearchByName")) {
            List<ProductViewsAdmin> prolist = productService.searchByName(request.getParameter("proName"));
            for (ProductViewsAdmin pr : prolist) {
                loadtData(request,response,pr);
            }
        } else {
            findAll(request, response);
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("listAll", productList);
        request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Creat")) {
            ProductViewsAdmin pr = new ProductViewsAdmin();
            Catalog catalog = new Catalog();
            pr.setProductName(request.getParameter("newProductName"));
            catalog.setCatalogId(Integer.parseInt(request.getParameter("newCatalogParent")));
            pr.setCatalog(catalog);
//            pr.setCatalogId(Integer.parseInt(request.getParameter("newCatalogParent")));
            pr.setTittle(request.getParameter("newProductTitle"));
            pr.setDiscount(Integer.parseInt(request.getParameter("discount")));
            pr.setImportPrice(Float.parseFloat(request.getParameter("importPrice")));
            pr.setDescriptions(request.getParameter("description"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pr.setCreatDate(sdf.parse(request.getParameter("createdDate")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String name = request.getParameter("newProductName");
            String pathFolderImg = "/Users/phamthanh/Desktop/rikkei/projectFinal/src/main/webapp/imgProduct";
            File file = new File(pathFolderImg);
            if (!file.exists()) {
                file.mkdir();
            }
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImg")) {
                    pr.setProductImg(part.getSubmittedFileName());
                } else if (part.getName().equals("subImg")) {
                    pr.getListImg().add(part.getSubmittedFileName());
                }
                part.write(pathFolderImg + File.separator + part.getSubmittedFileName());
            }
            boolean result = productService.save(pr);
            if (result) {
                Product product = (Product) productService.getLastIndex();
                String json = GSON.toJson(product);
                response.setCharacterEncoding("UTF-8");
                response.setStatus(200);
                response.setHeader("Content-Type", "application/json");
                Writer out = response.getWriter();
                out.write(json);
                out.flush();
            }
        } else if (action != null && action.equals("CreatDetail")) {
            ProductDetail pDetail = new ProductDetail();
            Sizes sizes =new Sizes();
            Colors colors=new Colors();
            colors.setColoId(Integer.parseInt(request.getParameter("colorProductDetail")));
            sizes.setSizeId(Integer.parseInt(request.getParameter("sizeProductDetail")));
            pDetail.setSizes(sizes);
            pDetail.setColors(colors);
            pDetail.setQuantityDetail(Integer.parseInt(request.getParameter("quantityDetail")));
            pDetail.setExportPrice(Float.parseFloat(request.getParameter("exportPrice")));
            pDetail.setDiscountDetail(Integer.parseInt(request.getParameter("discountDetail")));
            pDetail.setProductId(Integer.parseInt(request.getParameter("productId")));
            boolean result = productService.saveDetail(pDetail);
            if (result) {
                List<ProductDetail> prolist = productService.getDetailById(pDetail.getProductId());
                for (ProductDetail prd : prolist) {
                    loadProductDetailData(request, response, prd);
                }
            }
        } else if (action != null && action.equals("Delete")) {
            List<Product> productList = productService.searchByName(request.getParameter("nameDelete"));
            Product pr = productList.get(0);
            boolean result = productService.delete(pr.getProductId());
            if (result) {
                findAll(request, response);
            }
        } else if (action != null && action.equals("Update")) {
            ProductViewsAdmin pr = new ProductViewsAdmin();
            Catalog catalog = new Catalog();
            pr.setProductId(Integer.parseInt(request.getParameter("proId")));
            pr.setProductName(request.getParameter("newProductName"));
            catalog.setCatalogId(Integer.parseInt(request.getParameter("newCatalogParent")));
            pr.setCatalog(catalog);
//            pr.setCatalogId(Integer.parseInt(request.getParameter("newCatalogParent")));
            pr.setTittle(request.getParameter("newProductTitle"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pr.setCreatDate(sdf.parse(request.getParameter("createdDate")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            pr.setImportPrice(Float.parseFloat(request.getParameter("importPrice")));
            pr.setDiscount(Integer.parseInt(request.getParameter("discount")));
            pr.setProductStatus(Integer.parseInt(request.getParameter("updateStatus")));
            String pathFolderImg = "/Users/phamthanh/Desktop/rikkei/projectFinal/src/main/webapp/imgProduct";
            File file = new File(pathFolderImg);
            for (Part part : request.getParts()) {
                if (part.getName().equals("proImg")) {
                      pr.setProductImg(part.getSubmittedFileName());
                } else if (part.getName().equals("subImg")) {
                    pr.getListImg().add(part.getSubmittedFileName());
                }
                part.write(pathFolderImg + File.separator + part.getSubmittedFileName());
            }
            boolean result = productService.update(pr);
            if (result) {
                findAll(request, response);
            }
        }
    }

    public void loadProductDetailData(HttpServletRequest request, HttpServletResponse response, ProductDetail detail) throws IOException {
        Writer out = response.getWriter();
        out.write(" <tr>\n" +
                "                                        <td>" + detail.getProductName() + "</td>\n" +
                "                                        <td>" + detail.getExportPrice() + "</td>\n" +
                "                                        <td>" + detail.getDiscountDetail() + "</td>\n" +
                "                                        <td>" + detail.getQuantityDetail() + "</td>\n" +
                "                                        <td>" + detail.getColors().getColorName() + "</td>\n" +
                "                                        <td>" + detail.getSizes().getSizeName() + "</td>\n" +
                "                                        <td>" + detail.isDetailStatus() + "</td>\n" +
                "                                    </tr>");
        out.flush();
    }

    public void loadtData(HttpServletRequest request, HttpServletResponse response, ProductViewsAdmin pr) throws IOException {
        Writer out = response.getWriter();

        out.write(" <tr>\n" +
                "                                    <td><a style=\"text-decoration: none; color: black \"\n" +
                "                                           href=\"<%=request.getContextPath()%>/ProductServlet?action=Detail&&productId=" + pr.getProductId() + "\">" + pr.getProductName() + "</a>\n" +
                "                                    </td>\n" +
                "\n" +
                "                                    <td><img style=\"width:100px; height:100px \"\n" +
                "                                             src=\""+request.getContextPath()+"/imgProduct/"+pr.getProductImg()+"\" alt=\"\">\n" +
                "                                    </td>\n" +
                "                                    <td>" + pr.getCreatDate() + "</td>\n" +
                "                                    <td>" + pr.getImportPrice() + "</td>\n" +
                "                                    <td>" + pr.getExportPrice() + "</td>\n" +
                "                                    <td>" + pr.getQuantity() + "</td>\n" +
                "                                    <td>\n" +
                "                                        <div style=\"display: inline-flex\">" + pr.getStarPoint() + "<i class=\"bi bi-star-fill\"\n" +
                "                                                                                             style=\"color: #fcd53c\"></i>(" + pr.getTotalStart() + ")\n" +
                "                                        </div>\n" +
                "                                    </td>\n" +
                "                                    <td>" + pr.getCatalog().getCatalogName() + "</td>\n" +
                "                                    <td> " + (pr.getProductStatus() == 0 ? "Active" : pr.getProductStatus() == 1 ? "Out Stock" : "In Active") + "</td>\n" +
                "                                    <td>\n" +
                "                                        <a href=\"<%=request.getContextPath()%>/ProductServlet?action=Update&&productId=" + pr.getProductId() + "\">\n" +
                "                                            <button type=\"button\" class=\"btn btn-outline-primary\"><i\n" +
                "                                                    class=\"bi bi-pencil-square\"></i></button>\n" +
                "                                        </a>\n" +
                "                                        <button type=\"button\" id=\"delete\" class=\"btn btn-outline-danger\"\n" +
                "                                                data-bs-toggle=\"modal\" data-bs-target=\"#deleteProduct\"\n" +
                "                                                data-whatever=\"" + pr.getProductName() + "\"><i class=\"bi bi-journal-x\"></i>\n" +
                "                                        </button>\n" +
                "                                    </td>\n" +
                "                                </tr>");
    }
}
