package project.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.model.emtity.*;
import project.model.service.ICartService;
import project.model.service.IProductService;
import project.model.serviceIpm.CartServiceIpm;
import project.model.serviceIpm.ProductServiceIpm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    private static final Gson GSON = new GsonBuilder().create();

    private IProductService productService = new ProductServiceIpm();
    private ICartService<Cart, Integer> cartService = new CartServiceIpm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user = (User) request.getSession().getAttribute("userName");
        if (action != null && action.equals("showCart")) {
            List<CartDetail> detailList = (List<CartDetail>) request.getSession().getAttribute("listCartDetail");
            float total = 0;
            for (CartDetail cat : detailList) {
                total += cat.getDetailCartquantity() * cat.getPriceCurent() * (1 - cat.getDiscount() / 100);
            }
            request.getSession().setAttribute("total", total);
            request.getRequestDispatcher("views/user/shop-cart.jsp").forward(request, response);
        } else if (action != null && action.equals("checkOutCart")) {
            request.getRequestDispatcher("views/user/checkout.jsp").forward(request, response);
        } else if (action != null && action.equals("deleteCDetail")) {
            List<CartDetail> detailList = (List<CartDetail>) request.getSession().getAttribute("listCartDetail");
            float total = (Float) request.getSession().getAttribute("total");
            float carPice = Float.parseFloat(request.getParameter("dtPrice"));
            int cDetailId = Integer.parseInt(request.getParameter("dId"));
            boolean resutl = cartService.deleteCartDetail(cDetailId);
            if (resutl) {
                total = total - carPice;
                List<Cart> liscart = cartService.getListCartDetailByUserId(user.getUserId());
                request.getSession().setAttribute("listCartDetail", liscart);
                request.getSession().setAttribute("total", total);
                request.getRequestDispatcher("views/user/shop-cart.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user = (User) request.getSession().getAttribute("userName");
        if (action != null && action.equals("AddToCart")) {
            ProductDetail pdDetail = new ProductDetail();
            int colorId = Integer.parseInt(request.getParameter("colorId"));
            int sizeId = Integer.parseInt(request.getParameter("sizeId"));
            int quantity = Integer.parseInt(request.getParameter("deTailQuantity"));
            Cart cart = cartService.getLastCartByUerId(user.getUserId());
            List<ProductDetail> proList = productService.getDetailById(Integer.parseInt(request.getParameter("productId")));
            for (ProductDetail pd : proList) {
                if (pd.getColors().getColoId() == colorId && pd.getSizes().getSizeId() == sizeId) {
                    pdDetail = pd;
                    break;
                }
            }
            List<CartDetail> cartList = (List<CartDetail>) request.getSession().getAttribute("listCartDetail");
            boolean check = false;
            for (CartDetail cDetail : cartList) {
                if (cDetail.getProductDetail().getProductDetailId() == pdDetail.getProductDetailId()) {
                    cDetail.setDetailCartquantity(cDetail.getDetailCartquantity() + quantity);
                    cartService.updateCartDetail(cDetail);
                    check = true;
                    break;
                }
            }
            if (!check) {
                CartDetail cartDetail = new CartDetail(cart.getCartId(), pdDetail, quantity);
                cartService.saveCartDetail(cartDetail);

            }
            List<Cart> liscart = cartService.getListCartDetailByUserId(user.getUserId());
            request.getSession().setAttribute("listCartDetail", liscart);
            int count = liscart.size();
            String json = GSON.toJson(count);
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.setHeader("Content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        } else if (action != null && action.equals("UpdateCart")) {
            float total = 0;
            String[] arrQuantity = request.getParameterValues("quantity");
            List<CartDetail> detailList = (List<CartDetail>) request.getSession().getAttribute("listCartDetail");
            for (int i = 0; i < detailList.size(); i++) {
                CartDetail cat = new CartDetail();
                cat = detailList.get(i);
                cat.setDetailCartquantity(Integer.parseInt(arrQuantity[i]));
                cartService.updateCartDetail(cat);
                total += cat.getDetailCartquantity() * cat.getPriceCurent() * (1 - cat.getDiscount() / 100);
            }
            List<Cart> liscart = cartService.getListCartDetailByUserId(user.getUserId());
            request.getSession().setAttribute("listCartDetail", liscart);
            request.getSession().setAttribute("total", total);
            request.getRequestDispatcher("views/user/shop-cart.jsp").forward(request, response);
        }else if (action != null && action.equals("WaitConfirm")) {
            Cart cart = cartService.getLastCartByUerId(user.getUserId());
            cart.setUser(user);
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            String strName = "PC"+df.format(date) + "-" + (int) ((Math.random()) * 1000);
            cart.setCartName(strName);
            cart.setCreatDate(new Date());
            cart.setTotalAmount((Float)request.getSession().getAttribute("total"));
            cart.setNote(request.getParameter("noteOder"));

        }
    }


}
