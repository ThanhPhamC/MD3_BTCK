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

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private ICatalogService catalogService = new CatalogServiceIpm();
    private IProductService productService = new ProductServiceIpm();
    private IColorService colorService = new ColorServiceIpm();
    private ISizeService sizeService = new SizeServiceIpm();
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("Detail")) {
            List<Sizes> sizesList = sizeService.getSizeByProductId(Integer.parseInt(request.getParameter("productId")));
            List<Colors> colorsList = colorService.getColorByProductId(Integer.parseInt(request.getParameter("productId")));
            ProductViewsAdmin pr = (ProductViewsAdmin) productService.searchById(Integer.parseInt(request.getParameter("productId")));
            List<ProductDetail> proList = productService.getDetailById(Integer.parseInt(request.getParameter("productId")));
            request.setAttribute("colorList", colorsList);
            request.setAttribute("sizeList", sizesList);
            request.setAttribute("pro", pr);
            request.setAttribute("proList", proList);
            request.getRequestDispatcher("views/user/product-details.jsp").forward(request, response);
        } else if (action != null && action.equals("getByCatId")) {
            int catalogId = Integer.parseInt(request.getParameter("catId"));
            List<CatalogForCreat> listCat = catalogService.getCatRoot();
            List<ProductDetail> productDetails = productService.getProductByCatId(catalogId);
            request.setAttribute("catId", catalogId);
            request.setAttribute("ListByCatId", productDetails);
            request.setAttribute("listCat", listCat);
            request.getRequestDispatcher("views/user/shop.jsp").forward(request, response);
        } else {
            getAll(request, response);
        }
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CatalogInfo> catalogInfoList = catalogService.findAll();
        List<ProductDisplay> productDisplays = productService.findAll();
        request.setAttribute("catlist", catalogInfoList);
        request.setAttribute("productList", productDisplays);
        request.getRequestDispatcher("views/user/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("getQuantity")) {
            ProductDetail pDetail = new ProductDetail();
            Sizes sizes = new Sizes();
            Colors colors= new Colors();
            sizes.setSizeId(Integer.parseInt(request.getParameter("sizeId")));
            pDetail.setSizes(sizes);
            colors.setColoId(Integer.parseInt(request.getParameter("colorId")));
            pDetail.setColors(colors);
            pDetail.setProductId(Integer.parseInt(request.getParameter("productId")));
            List<ProductDetail> proList = productService.getDetailById(Integer.parseInt(request.getParameter("productId")));
            for (ProductDetail pd : proList) {
//                if (pd.getSizeId()==pDetail.getSizeId()&&pd.getColorId()==pDetail.getColorId()&&pd.getProductId()==pDetail.getProductId()){
//                    pDetail.setQuantityDetail(pd.getQuantityDetail());
//                    break;
//                }
                if (pd.getSizes().getSizeId()==pDetail.getSizes().getSizeId()&&pd.getColors().getColoId()==pDetail.getColors().getColoId()&&pd.getProductId()==pDetail.getProductId()){
                    pDetail.setQuantityDetail(pd.getQuantityDetail());
                    break;
                }

            }
             String json= GSON.toJson(pDetail);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("Content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }
    }
}
