package project.controller;

import project.model.emtity.Cart;
import project.model.emtity.User;
import project.model.service.ICartService;
import project.model.service.IUserService;
import project.model.serviceIpm.CartServiceIpm;
import project.model.serviceIpm.UserServiceIpm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private IUserService<User, Integer> userService = new UserServiceIpm();
    private ICartService<Cart,Integer> cartService= new CartServiceIpm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("Login")) {
            String requestPageContext = request.getParameter("pageRequestLogin");
            request.setAttribute("requestLogin", requestPageContext);
            request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
        } else if (action != null && action.equals("LogOut")) {
            String requestPageContext = request.getParameter("pageRequestLogin");
            request.getSession().invalidate();
            request.getRequestDispatcher(requestPageContext).forward(request, response);
        } else {
            getAll(request, response);
        }
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.findAll();
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("views/admin/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Creat")) {
            User user = new User();
            user.setFullName(request.getParameter("fullName"));
            user.setAddressUser(request.getParameter("address"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthDate(sdf.parse(request.getParameter("birthday")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setGender(Boolean.parseBoolean(request.getParameter("gender")));
            user.setEmail(request.getParameter("email"));
            user.setPhoneUser(request.getParameter("phone"));
            user.setUserName(request.getParameter("userLogin"));
            user.setPassWords(request.getParameter("password"));
            boolean result = userService.save(user);
            if (result ) {
                String notify = "Đăng  kí thành công";
                request.setAttribute("notify", notify);
                request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
            } else {
                String notify = "Đăng kí thất bại!";
                request.setAttribute("notify", notify);
                request.getRequestDispatcher("views/user/register.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("Login")) {
            String userLogin = request.getParameter("username");
            String pass = request.getParameter("pass");
            User user = userService.checkLogin(userLogin, pass);
            if (user.getUserName() == null){
                request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
                request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
            } else {
                List<Cart> liscart= cartService.getListCartDetailByUserId(user.getUserId());
                request.getSession().setAttribute("listCartDetail",liscart);
                request.getSession().setAttribute("userName", user);
                String requestURL = request.getParameter("pageRequestLogin");
                request.getSession().setAttribute("userOnline", userLogin);
                request.getRequestDispatcher(requestURL).forward(request, response);
            }
        } else if (action != null && action.equals("Delete")) {
            {
                boolean result = userService.delete(Integer.parseInt(request.getParameter("nameDelete")));
                if (result) {
                    getAll(request, response);
                }
            }

        }


    }
}
