<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>

<body>
<!-- Page Preloder -->
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__close">+</div>
    <ul class="offcanvas__widget">
        <li><span class="icon_search search-switch"></span></li>
        <li><a href="#"><span class="icon_heart_alt"></span>
            <div class="tip">2</div>
        </a></li>
        <li><a href="#"><span class="icon_bag_alt"></span>
            <div class="tip">2</div>
        </a></li>
    </ul>
    <div class="offcanvas__logo">
        <a href="<%=request.getContextPath()%>/views/user/index.jsp"><img
                src="<%=request.getContextPath()%>/views/img/logo.png" alt=""></a>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="offcanvas__auth">
        <a href="#">Login</a>
        <a href="#">Register</a>
    </div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-3 col-lg-2">
                <div class="header__logo">
                    <a href="<%=request.getContextPath()%>/views/user/index.jsp"><img
                            src="<%=request.getContextPath()%>/views/img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-xl-6 col-lg-7">
                <nav class="header__menu">
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/views/user/index.jsp">Home</a></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/shop.jsp">Women’s</a></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/shop.jsp">Men’s</a></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/shop.jsp">KID’s</a></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/blog.jsp">Blog</a></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/contact.jsp">Contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__right">
                    <div class="header__right__auth">
                        <a href="<%=request.getContextPath()%>/views/user/login.jsp">Login</a>
                        <a href="<%=request.getContextPath()%>/views/user/register.jsp">Register</a>
                    </div>
                    <ul class="header__right__widget">
                        <li><span class="icon_search search-switch"></span></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/wishlist.jsp<%="/views/user/login.jsp"%>"><span
                                class="icon_heart_alt"></span>
                            <div style=" display: ${sessionScope.userName.fullName==null? 'none':''}  "
                                 class="tip">${sessionScope.listCartDetail.size()}</div>
                        </a></li>
                        <li><a href="<%=request.getContextPath()%>/views/user/shop-cart.jsp"><span
                                class="icon_bag_alt"></span>
                            <div style=" display: ${sessionScope.userName.fullName==null? 'none':''}  "
                                 class="tip">${sessionScope.listCartDetail.size()}</div>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="canvas__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>
<!-- Header Section End -->

<!-- Breadcrumb Begin -->
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__links">
                    <a href="<%=request.getContextPath()%>/views/user/index.jsp"><i class="fa fa-home"></i> Home</a>
                    <span>Shopping cartDetail</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Shop Cart Section Begin -->
<section class="shop-cartDetail spad">
    <div class="container">
        <form action="<%=request.getContextPath()%>/CartServlet"
              method="post">
        <div class="row">
            <div class="col-lg-12">
                <div class="shop__cart__table">
                        <table>
                            <thead>
                            <tr>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody id="content">
                            <c:forEach items="${sessionScope.listCartDetail}" var="cdt">
                                <tr>
                                    <td class="cart__product__item">
                                        <img style="width:80px; height:100px"
                                             src="<%=request.getContextPath()%>/imgProduct/${cdt.productDetail.productImg}"
                                             alt="">
                                        <div class="cart__product__item__title">
                                            <h6>${cdt.productDetail.productName}</h6>
                                            <h6 style="margin-top: 5px">Size: ${cdt.productDetail.sizes.sizeName}
                                                Color:${cdt.productDetail.colors.colorName} </h6>
                                        </div>
                                    </td>
                                    <td class="cart__price">${cdt.priceCurent}</td>
                                    <td class="cart__quantity">
                                        <div class="pro-qty">
                                            <input type="number" name="quantity" min="1"
                                                   value="${cdt.detailCartquantity}">
                                        </div>
                                    </td>
                                    <td class="cart__total">${cdt.detailCartquantity*cdt.priceCurent}</td>
                                    <td class=" cart__close"><a class="btn btn-outline-danger" href="<%=request.getContextPath()%>/CartServlet?action=deleteCDetail&&dId=${cdt.cartDetailId}&&dtPrice=${cdt.detailCartquantity*cdt.priceCurent}"  ><i class="bi bi-x-circle"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="cart__btn">
                    <a style="width: 220px;height: 47px;background-color: #f6c216; border-radius: 5px; color: #090909;" href="<%=request.getContextPath()%>/views/user/shop.jsp">Continue Shopping</a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div  class="cart__btn update__btn">
                    <button type="submit" name="action" value="UpdateCart" class="btn-primary btn" style="width: 220px;height: 47px" ><span style="color: #f1f1f1;"
                            class="icon_loading"></span> Update cartDetail</button>
                </div>
            </div>
        </div>
        </form>
        <div class="row">
            <div class="col-lg-6">
                <div class="discount__content">
                    <h6>Discount codes</h6>
                    <form action="#">
                        <input type="text" placeholder="Enter your coupon code">
                        <button type="submit" class="site-btn">Apply</button>
                    </form>
                </div>
            </div>
            <div class="col-lg-4 offset-lg-2">
                <div class="cart__total__procced">
                    <h6>Cart total</h6>
                    <ul>
                        <li>Subtotal <span>${total}</span></li>
                        <li>Total <span>${total}</span></li>
                    </ul>
                    <a href="<%=request.getContextPath()%>/CartServlet?action=checkOutCart" class="primary-btn">Proceed to
                        checkout</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Cart Section End -->

<!-- Instagram Begin -->
<div class="instagram">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg"
                     data-setbg="<%=request.getContextPath()%>/views/img/instagram/insta-1.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg"
                     data-setbg="<%=request.getContextPath()%>/views/img/instagram/insta-2.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg"
                     data-setbg="<%=request.getContextPath()%>/views/img/instagram/insta-3.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg"
                     data-setbg="<%=request.getContextPath()%>/views/img/instagram/insta-4.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg"
                     data-setbg="<%=request.getContextPath()%>/views/img/instagram/insta-5.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg"
                     data-setbg="<%=request.getContextPath()%>/views/img/instagram/insta-6.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Instagram End -->

<!-- Footer Section Begin -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-7">
                <div class="footer__about">
                    <div class="footer__logo">
                        <a href="<%=request.getContextPath()%>/views/user/index.jsp"><img
                                src="<%=request.getContextPath()%>/views/img/logo.png" alt=""></a>
                    </div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                        cilisis.</p>
                    <div class="footer__payment">
                        <a href="#"><img src="<%=request.getContextPath()%>/views/img/payment/payment-1.png" alt=""></a>
                        <a href="#"><img src="<%=request.getContextPath()%>/views/img/payment/payment-2.png" alt=""></a>
                        <a href="#"><img src="<%=request.getContextPath()%>/views/img/payment/payment-3.png" alt=""></a>
                        <a href="#"><img src="<%=request.getContextPath()%>/views/img/payment/payment-4.png" alt=""></a>
                        <a href="#"><img src="<%=request.getContextPath()%>/views/img/payment/payment-5.png" alt=""></a>

                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-5">
                <div class="footer__widget">
                    <h6>Quick links</h6>
                    <ul>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Blogs</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">FAQ</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4">
                <div class="footer__widget">
                    <h6>Account</h6>
                    <ul>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Orders Tracking</a></li>
                        <li><a href="#">Checkout</a></li>
                        <li><a href="#">Wishlist</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-8 col-sm-8">
                <div class="footer__newslatter">
                    <h6>NEWSLETTER</h6>
                    <form action="#">
                        <input type="text" placeholder="Email">
                        <button type="submit" class="site-btn">Subscribe</button>
                    </form>
                    <div class="footer__social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-youtube-play"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                <div class="footer__copyright__text">
                    <p>Copyright &copy;
                        <script>document.write(new Date().getFullYear());</script>
                        All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i>
                        by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                </div>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search End -->

<!-- Js Plugins -->
<script src="<%=request.getContextPath()%>/views/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/jquery.magnific-popup.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/mixitup.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/jquery.countdown.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/jquery.slicknav.js"></script>
<script src="<%=request.getContextPath()%>/views/js/owl.carousel.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/jquery.nicescroll.min.js"></script>
<script src="<%=request.getContextPath()%>/views/js/main.js"></script>
</body>

</html>