<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords"
          content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/views/img/icons/icon-48x48.png"/>

    <link rel="canonical" href="https://demo-basic.adminkit.io/"/>


    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/style.css" type="text/css">

    <title>AdminKit Demo - Bootstrap 5 Admin Template</title>

    <link href="<%=request.getContextPath()%>/views/css/app.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="index.jsp">
                <span class="align-middle">AdminKit</span>
            </a>

            <ul class="sidebar-nav">
                <li class="sidebar-header">
                    Pages
                </li>
                <li class="sidebar-item ">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/views/admin/index.jsp">
                        <i class="align-middle" data-feather="grid"></i> <span class="align-middle">Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/CatalogServlet">
                        <i class="align-middle" data-feather="grid"></i> <span class="align-middle">Category</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/ProductServlet">
                        <i class="align-middle" data-feather="square"></i> <span class="align-middle">Product</span>
                    </a>
                </li> <li class="sidebar-item">
                <a class="sidebar-link" href="<%=request.getContextPath()%>/views/admin/sizes.jsp">
                    <i class="align-middle" data-feather="square"></i> <span class="align-middle">Sizes</span>
                </a>
            </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="user.jsp">
                        <i class="align-middle" data-feather="user"></i> <span class="align-middle">User</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="user.jsp">
                        <i class="align-middle" data-feather="user"></i> <span class="align-middle">Contact</span>
                    </a>
                </li>

            </ul>
        </div>
    </nav>


    <div class="main">
        <jsp:include page="topmenu.jsp"></jsp:include>
        <main class="content">
            <div class="container-fluid p-0">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Product Detail</h3>
                        <nav class="navbar navbar-expand-lg bg-light">
                            <div class="container-fluid">
                                <form class="d-flex" role="search">
                                    <input class="form-control me-2 fst-italic" type="search"
                                           placeholder="Enter product's name... "
                                           aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </div>
                        </nav>
                    </div>
                    <!-- /.card-header -->

                    <section class="product-details spad">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="product__details__pic">
                                        <div class="product__details__pic__left product__thumb nice-scroll">
                                            <a class="pt active" href="#x">
                                                <img src="<%=request.getContextPath()%>/views/img/product/details/thumb-1.jpg"
                                                     alt="">
                                            </a>
                                            <a class="pt" href="#">
                                                <img src="<%=request.getContextPath()%>/views/img/product/details/thumb-2.jpg"
                                                     alt="">
                                            </a>
                                            <a class="pt" href="#">
                                                <img src="<%=request.getContextPath()%>/views/img/product/details/thumb-3.jpg"
                                                     alt="">
                                            </a>
                                            <a class="pt" href="#">
                                                <img src="<%=request.getContextPath()%>/views/img/product/details/thumb-4.jpg"
                                                     alt="">
                                            </a>
                                        </div>
                                        <div class="product__details__slider__content">
                                            <div class="product__details__pic__slider owl-carousel">
                                                <img data-hash="product-1" class="product__big__img"
                                                     src="<%=request.getContextPath()%>/views/img/product/details/product-1.jpg"
                                                     alt="">
                                                <img data-hash="product-2" class="product__big__img"
                                                     src="<%=request.getContextPath()%>/views/img/product/details/product-3.jpg"
                                                     alt="">
                                                <img data-hash="product-3" class="product__big__img"
                                                     src="<%=request.getContextPath()%>/views/img/product/details/product-2.jpg"
                                                     alt="">
                                                <img data-hash="product-4" class="product__big__img"
                                                     src="<%=request.getContextPath()%>/views/img/product/details/product-4.jpg"
                                                     alt="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="product__details__text">
                                        <h3>Essential structured blazer
                                            <span>Brand: SKMEIMore Men Watches from SKMEI</span></h3>
                                        <div class="rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <span>( 138 reviews )</span>
                                        </div>
                                        <div class="product__details__price">$ 75.0 <span>$ 83.0</span></div>
                                        <p>Nemo enim ipsam voluptatem quia aspernatur aut odit aut loret fugit, sed quia
                                            consequuntur
                                            magni lores eos qui ratione voluptatem sequi nesciunt.</p>
                                        <div class="product__details__widget">
                                            <ul>
                                                <li>
                                                    <span>Available color:</span>
                                                    <div class="color__checkbox">
                                                        <label for="red">
                                                            <input type="radio" name="color__radio" id="red" checked>
                                                            <span class="checkmark"></span>
                                                        </label>
                                                        <label for="black">
                                                            <input type="radio" name="color__radio" id="black">
                                                            <span class="checkmark black-bg"></span>
                                                        </label>
                                                        <label for="grey">
                                                            <input type="radio" name="color__radio" id="grey">
                                                            <span class="checkmark grey-bg"></span>
                                                        </label>
                                                    </div>
                                                </li>
                                                <li>
                                                    <span>Available size:</span>
                                                    <div class="size__btn">
                                                        <label for="xs-btn" class="active">
                                                            <input type="radio" id="xs-btn">
                                                            xs
                                                        </label>
                                                        <label for="s-btn">
                                                            <input type="radio" id="s-btn">
                                                            s
                                                        </label>
                                                        <label for="m-btn">
                                                            <input type="radio" id="m-btn">
                                                            m
                                                        </label>
                                                        <label for="l-btn">
                                                            <input type="radio" id="l-btn">
                                                            l
                                                        </label>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="product__details__tab">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Specification</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Reviews
                                                    ( 2 )</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                                <h6>Description</h6>
                                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut
                                                    loret fugit, sed
                                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi
                                                    nesciunt loret.
                                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si.
                                                    Nemo enim ipsam
                                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit,
                                                    sed quia ipsu
                                                    consequuntur magni dolores eos qui ratione voluptatem sequi
                                                    nesciunt. Nulla
                                                    consequat massa quis enim.</p>
                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
                                                    commodo ligula eget
                                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis
                                                    parturient montes,
                                                    nascetur ridiculus mus. Donec quam felis, ultricies nec,
                                                    pellentesque eu, pretium
                                                    quis, sem.</p>
                                            </div>
                                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                                <h6>Specification</h6>
                                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut
                                                    loret fugit, sed
                                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi
                                                    nesciunt loret.
                                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si.
                                                    Nemo enim ipsam
                                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit,
                                                    sed quia ipsu
                                                    consequuntur magni dolores eos qui ratione voluptatem sequi
                                                    nesciunt. Nulla
                                                    consequat massa quis enim.</p>
                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
                                                    commodo ligula eget
                                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis
                                                    parturient montes,
                                                    nascetur ridiculus mus. Donec quam felis, ultricies nec,
                                                    pellentesque eu, pretium
                                                    quis, sem.</p>
                                            </div>
                                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                                <h6>Reviews ( 2 )</h6>
                                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut
                                                    loret fugit, sed
                                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi
                                                    nesciunt loret.
                                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si.
                                                    Nemo enim ipsam
                                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit,
                                                    sed quia ipsu
                                                    consequuntur magni dolores eos qui ratione voluptatem sequi
                                                    nesciunt. Nulla
                                                    consequat massa quis enim.</p>
                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
                                                    commodo ligula eget
                                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis
                                                    parturient montes,
                                                    nascetur ridiculus mus. Donec quam felis, ultricies nec,
                                                    pellentesque eu, pretium
                                                    quis, sem.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>


                    <!-- /.card-body -->
                </div>
            </div>
        </main>
   <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>
<script src="<%=request.getContextPath()%>/views/js/app.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var ctx = document.getElementById("chartjs-dashboard-line").getContext("2d");
        var gradient = ctx.createLinearGradient(0, 0, 0, 225);
        gradient.addColorStop(0, "rgba(215, 227, 244, 1)");
        gradient.addColorStop(1, "rgba(215, 227, 244, 0)");
        // Line chart
        new Chart(document.getElementById("chartjs-dashboard-line"), {
            type: "line",
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "Sales ($)",
                    fill: true,
                    backgroundColor: gradient,
                    borderColor: window.theme.primary,
                    data: [
                        2115,
                        1562,
                        1584,
                        1892,
                        1587,
                        1923,
                        2566,
                        2448,
                        2805,
                        3438,
                        2917,
                        3327
                    ]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                tooltips: {
                    intersect: false
                },
                hover: {
                    intersect: true
                },
                plugins: {
                    filler: {
                        propagate: false
                    }
                },
                scales: {
                    xAxes: [{
                        reverse: true,
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }],
                    yAxes: [{
                        ticks: {
                            stepSize: 1000
                        },
                        display: true,
                        borderDash: [3, 3],
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }]
                }
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Pie chart
        new Chart(document.getElementById("chartjs-dashboard-pie"), {
            type: "pie",
            data: {
                labels: ["Chrome", "Firefox", "IE"],
                datasets: [{
                    data: [4306, 3801, 1689],
                    backgroundColor: [
                        window.theme.primary,
                        window.theme.warning,
                        window.theme.danger
                    ],
                    borderWidth: 5
                }]
            },
            options: {
                responsive: !window.MSInputMethodContext,
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                cutoutPercentage: 75
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Bar chart
        new Chart(document.getElementById("chartjs-dashboard-bar"), {
            type: "bar",
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "This year",
                    backgroundColor: window.theme.primary,
                    borderColor: window.theme.primary,
                    hoverBackgroundColor: window.theme.primary,
                    hoverBorderColor: window.theme.primary,
                    data: [54, 67, 41, 55, 62, 45, 55, 73, 60, 76, 48, 79],
                    barPercentage: .75,
                    categoryPercentage: .5
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        gridLines: {
                            display: false
                        },
                        stacked: false,
                        ticks: {
                            stepSize: 20
                        }
                    }],
                    xAxes: [{
                        stacked: false,
                        gridLines: {
                            color: "transparent"
                        }
                    }]
                }
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var markers = [{
            coords: [31.230391, 121.473701],
            name: "Shanghai"
        },
            {
                coords: [28.704060, 77.102493],
                name: "Delhi"
            },
            {
                coords: [6.524379, 3.379206],
                name: "Lagos"
            },
            {
                coords: [35.689487, 139.691711],
                name: "Tokyo"
            },
            {
                coords: [23.129110, 113.264381],
                name: "Guangzhou"
            },
            {
                coords: [40.7127837, -74.0059413],
                name: "New York"
            },
            {
                coords: [34.052235, -118.243683],
                name: "Los Angeles"
            },
            {
                coords: [41.878113, -87.629799],
                name: "Chicago"
            },
            {
                coords: [51.507351, -0.127758],
                name: "London"
            },
            {
                coords: [40.416775, -3.703790],
                name: "Madrid "
            }
        ];
        var map = new jsVectorMap({
            map: "world",
            selector: "#world_map",
            zoomButtons: true,
            markers: markers,
            markerStyle: {
                initial: {
                    r: 9,
                    strokeWidth: 7,
                    stokeOpacity: .4,
                    fill: window.theme.primary
                },
                hover: {
                    fill: window.theme.primary,
                    stroke: window.theme.primary
                }
            },
            zoomOnScroll: false
        });
        window.addEventListener("resize", () => {
            map.updateSize();
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var date = new Date(Date.now() - 5 * 24 * 60 * 60 * 1000);
        var defaultDate = date.getUTCFullYear() + "-" + (date.getUTCMonth() + 1) + "-" + date.getUTCDate();
        document.getElementById("datetimepicker-dashboard").flatpickr({
            inline: true,
            prevArrow: "<span title=\"Previous month\">&laquo;</span>",
            nextArrow: "<span title=\"Next month\">&raquo;</span>",
            defaultDate: defaultDate
        });
    });
</script>
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