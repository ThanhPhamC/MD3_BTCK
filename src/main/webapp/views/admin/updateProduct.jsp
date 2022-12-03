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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
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
                </li>
                <li class="sidebar-item">
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
        <main class="content">
            <div class="container-fluid p-0">
                <div class="card">


                    <div class="card-header">
                        <h3 class="card-title">Update Product</h3>
                        <nav class="navbar navbar-expand-lg bg-light">
                            <div class="container-fluid">
                                <div class="d-flex">
                                    <input class="form-control me-2 fst-italic" type="search"
                                           placeholder="Enter product's name... "
                                           aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </div>
                                <a class="navbar-brand">
                                    <a href="#" onclick="document.getElementById('updateProduct').submit();"
                                       class="btn btn-warning"> Update Product</a>
                                </a>
                            </div>
                        </nav>
                    </div>
                    <section class="product-details spad">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="product__details__pic">
                                        <div class="product__details__pic__left product__thumb nice-scroll">
                                            <c:forEach items="${pro.listImg}" var="img">
                                                <a class="pt active" href="#">
                                                    <img src="<%=request.getContextPath()%>/imgProduct/${img}"
                                                         alt="">
                                                </a>
                                            </c:forEach>
                                        </div>
                                        <div class="product__details__slider__content">
                                            <div class="product__details__pic__slider owl-carousel">
                                                <img class="product__big__img"
                                                     src="<%=request.getContextPath()%>/imgProduct/${pro.productImg}"
                                                     alt="">
                                                <c:forEach items="${pro.listImg}" var="img">
                                                    <img class="product__big__img"
                                                         src="<%=request.getContextPath()%>/imgProduct/${img}"
                                                         alt="">
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="product__details__text">
                                        <div class="container-fluid p-0">
                                            <form id="updateProduct" method="post"
                                                  action="<%=request.getContextPath()%>/ProductServlet?action=Update"
                                                  enctype="multipart/form-data">
                                                <div class="card">
                                                    <div style=" width: 100%;display: inline-flex; align-items: center">
                                                        <div style="width: 90%; margin-top: 20px; margin-left:  20px; ">
                                                            <div class="input-group mb-3 ">
                                                                         <span class="input-group-text btn btn-primary"
                                                                               id="newProductName"><i
                                                                                 class="bi bi-pencil"></i></span>
                                                                <input type="hidden" name="proId"
                                                                       value="${pro.productId}">
                                                                <input style="" type="text"
                                                                       value="${pro.productName}"
                                                                       name="newProductName" class="form-control"
                                                                       placeholder="Product name..."
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName">
                                                            </div>
                                                            <div class="input-group mb-3">
                                                                <label class="input-group-text btn btn-primary"
                                                                       for="idParent"><i
                                                                        class="bi bi-list-check"></i></label>
                                                                <select class="form-select" name="newCatalogParent"
                                                                        id="idParent">
                                                                    <option selected value="${pro.catalog.catalogId}">Choose
                                                                        Catalog...
                                                                    </option>
                                                                    <c:forEach items="${listCat}" var="cat">
                                                                        <option value="${cat.catalogId}">${cat.catalogName}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <div class="input-group mb-3">
                                    <span class="input-group-text btn btn-primary" id="newProductTitle"><i
                                            class="bi bi-tags"></i></span>
                                                                <input style="" type="text" value="${pro.tittle}"
                                                                       name="newProductTitle"
                                                                       class="form-control"
                                                                       placeholder="Product Title..."
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName">
                                                            </div>
                                                            <div class="input-group mb-3">
                                <span class="input-group-text btn btn-primary" id="createdDate"><i
                                        class="bi bi-calendar2-check"></i></span>
                                                                <input style="" type="date" value="${pro.creatDate}"
                                                                       name="createdDate" class="form-control"
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName">
                                                            </div>
                                                            <div class="input-group mb-3">
                                    <span class="input-group-text btn btn-primary" id="importPrice"><i
                                            class="bi bi-cash-coin"></i></span>
                                                                <input style="" type="text" name="importPrice"
                                                                       value="${pro.importPrice}"
                                                                       class="form-control"
                                                                       placeholder="Enter import price product... "
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName">
                                                            </div>
                                                            <div class="input-group mb-3" style="display: inline-flex;">
                                                                <div class="input-group " style="width: 47%">
                                                                <span class="input-group-text  btn btn-primary"><i
                                                                        class="bi bi-arrow-down-right-square"></i></span>
                                                                    <input style="" type="text" name="discount"
                                                                           value="${pro.discount}"
                                                                           class="form-control"
                                                                           placeholder="Discount..."
                                                                           aria-label="Sizing example input"
                                                                           aria-describedby="inputCatalogName">
                                                                </div>
                                                                <div class="input-group "
                                                                     style="width: 47%; margin-left: 6%">
                                                                <span class="input-group-text  btn btn-primary "><i
                                                                        class="bi bi-toggles"></i></span>
                                                                    <select class="form-control" name="updateStatus"
                                                                            id="updateStatus">
                                                                        <option value="${pro.productStatus}">Choice
                                                                            Status...
                                                                        </option>
                                                                        <option value="0">Active</option>
                                                                        <option value="1">Out stock</option>
                                                                        <option value="2">In active</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="input-group mb-3">
                                                                    <span class="input-group-text btn btn-primary"
                                                                          id="file1"><i
                                                                            class="bi bi-newspaper"></i></span>
                                                                <input style="" type="text" name="description"
                                                                       value="${pro.descriptions}"
                                                                       class="form-control" placeholder="Description..."
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName">
                                                            </div>
                                                            <div class="input-group mb-3">
                                                            <span class="input-group-text btn btn-primary"><i
                                                                    class="bi bi-images"></i></span>
                                                                <input style="" type="file" name="proImg"
                                                                       class="form-control"
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName">
                                                                <input name="oldImg" type="hidden" value="${pro.productImg}">
                                                            </div>
                                                            <div class="input-group mb-3">
                                                            <span class="input-group-text btn btn-primary"><i
                                                                    class="bi bi-images"></i></span>
                                                                <input style="" type="file" name="subImg"
                                                                       class="form-control"
                                                                       aria-label="Sizing example input"
                                                                       aria-describedby="inputCatalogName" multiple>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <form id="submitFormDetail" name="submitFormDetail"
                                          action="<%=request.getContextPath()%>/ProductServlet?action=CreatDetail"
                                          method="post">
                                        <input type="hidden" value="${pro.productId}" name="productId">
                                        <div class="card-header"
                                             style=" display:  inline-flex;margin-bottom: 20px ; align-items: center">
                                            <div style="width: 45%; margin-top: 20px; margin-left:  20px; ">
                                                <div class="input-group mb-3" style="display: inline-flex;">
                                                    <div class="input-group " style="width: 47%">
                                                        <label class="input-group-text" for="inputGroupSelect02"><i
                                                                class="bi bi-aspect-ratio"></i></label>
                                                        <select class="form-select" name="sizeProductDetail"
                                                                id="inputGroupSelect02">
                                                            <option>Choose size...</option>
                                                            <c:forEach items="${listSize}" var="size">
                                                                <option value="${size.sizeId}">${size.sizeName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="input-group " style="width: 47%; margin-left: 6%">
                                                        <label class="input-group-text" for="inputGroupSelect01"><i
                                                                class="bi bi-palette"></i></label>
                                                        <select class="form-select" name="colorProductDetail"
                                                                id="inputGroupSelect01">
                                                            <option>Choose color...</option>
                                                            <c:forEach items="${listColor}" var="color">
                                                                <option value="${color.coloId}">${color.colorName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="input-group mb-3" style="display: inline-flex;">
                                                    <div class="input-group " style="width: 47%">
                                                        <span class="input-group-text"><i
                                                                class="bi bi-cash-coin"></i></span>
                                                        <input style="" type="text" name="exportPrice"
                                                               class="form-control"
                                                               placeholder="Export price..."
                                                               aria-label="Sizing example input"
                                                               aria-describedby="inputCatalogName">
                                                    </div>
                                                    <div class="input-group " style="width: 47%; margin-left: 6%">
                                                        <span class="input-group-text"><i
                                                                class="bi bi-sort-numeric-down"></i></span>
                                                        <input style="" type="text" name="quantityDetail"
                                                               class="form-control"
                                                               placeholder="Quantity detail..."
                                                               aria-label="Sizing example input"
                                                               aria-describedby="inputCatalogName">
                                                    </div>
                                                </div>
                                            </div>
                                            <div style=" width: 50%; margin-top: 20px; margin-left:  65px; ">
                                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="discountDetail"><i
                                            class="bi bi-arrow-down-right-square"></i></span>
                                                    <input style="" type="text" name="discountDetail" value="0"
                                                           class="form-control"
                                                           placeholder="Discount bonus..."
                                                           aria-label="Sizing example input"
                                                           aria-describedby="inputCatalogName">
                                                </div>
                                                <div class="input-group mb-3" style="display: inline-flex;">
                                                    <div class="container-fluid " style="width: 45%;">
                                                        <button type="submit" class="btn btn-primary"> Update orr Add Detail
                                                        </button>

                                                    </div>
                                                    <div class="container-fluid " style="width: 45%;">
                                                        <a href="<%=request.getContextPath()%>/ProductServlet?action=addNewProduct">
                                                            <button type="button" class="btn btn-warning"> Add new product
                                                            </button>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <div id="content">
                                        <div style="  border-radius: 5px; ">
                                            <table id="example1"
                                                   class="table table-bordered border-primary table-hover table-striped text-center">
                                                <thead class="table-dark">
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Export Price</th>
                                                    <th>Discount Detail</th>
                                                    <th>Quantity</th>
                                                    <th>Color</th>
                                                    <th>Size</th>
                                                    <th>Status</th>
                                                </tr>
                                                </thead>
                                                <tbody id="showDetail">
                                                <c:forEach items="${proList}" var="detail">
                                                    <tr>
                                                        <td>${pro.productName}</td>
                                                        <td>${detail.exportPrice}</td>
                                                        <td>${detail.discountDetail}%</td>
                                                        <td> ${detail.quantityDetail}</td>
                                                        <td> ${detail.colors.colorName}</td>
                                                        <td> ${detail.sizes.sizeName}</td>
                                                        <td> ${detail.detailStatus}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

    $('#submitFormDetail').submit(function (event) {
        $.ajax({
            method: $(this).attr('method'),
            url: $(this).attr('action'),
            data: $(this).serialize(),
        }).done(function (response) {
            alert("done")
            var row = document.getElementById("showDetail");
            row.innerHTML = response;
        });
        event.preventDefault();


    });


</script>

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