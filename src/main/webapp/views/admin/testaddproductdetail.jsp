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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
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
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
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
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/ColorServlet">
                        <i class="align-middle" data-feather="square"></i> <span class="align-middle">Color</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/SizeServlet">
                        <i class="align-middle" data-feather="square"></i> <span class="align-middle">Sizes</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/UserServlet">
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
                            <div class="container-fluid">
                                <p style="margin-top: 10px" class="btn btn-primary" > Product Name</p>
                            </div>
                        </div>
                        <div class="card-header" style="display: inline-flex;margin: 20px ; align-items: center">
                            <div style="width: 45%; margin-top: 20px; margin-left:  20px; ">
                                <div class="input-group mb-3" style="display: inline-flex;">
                                    <div class="input-group " style="width: 47%">
                                        <label class="input-group-text" for="inputGroupSelect02"><i
                                                class="bi bi-aspect-ratio"></i></label>
                                        <select class="form-select" id="inputGroupSelect02">
                                            <option>Choose size...</option>
                                            <c:forEach items="${listSize}" var="size">
                                                <option value="${size.sizeId}">${size.sizeName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="input-group " style="width: 47%; margin-left: 6%">
                                        <label class="input-group-text" for="inputGroupSelect01"><i
                                                class="bi bi-palette"></i></label>
                                        <select class="form-select" name="colorProductDetail" id="inputGroupSelect01">
                                            <option>Choose color...</option>
                                            <c:forEach items="${listColor}" var="color">
                                                <option value="${color.coloId}">${color.colorName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="discountDetail"><i
                                            class="bi bi-arrow-down-right-square"></i></span>
                                    <input style="" type="text" name="discountDetail" class="form-control"
                                           placeholder="Discount bonus..."
                                           aria-label="Sizing example input"
                                           aria-describedby="inputCatalogName">
                                </div>
                            </div>
                            <div style=" width: 45%; margin-top: 20px; margin-left:  65px; ">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id=""><i class="bi bi-cash-coin"></i></span>
                                    <input style="" type="text" name="importPrice" class="form-control"
                                           placeholder="Enter export price product detail..."
                                           aria-label="Sizing example input"
                                           aria-describedby="inputCatalogName">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="">
                                        <div class="container-fluid">
                                            <button type="submit" class="btn btn-primary"> Add new Product</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <div style="  border-radius: 5px; margin: 20px ">
                        <table id="example1" class="table table-bordered table-striped text-center">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>NameColor</th>
                                <th>HexColor</th>
                                <th colspan="2">Color</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody id="content">
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>
<script>CKEDITOR.replace("description") </script>
<script src="<%=request.getContextPath()%>/views/js/app.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

    $('#submitForm').submit(function (event) {
        $.ajax({
            // method: $(this).attr('method'),
            // url: $(this).attr('action'),
            // data: $(this).serialize(),
            method: $(this).attr('method'),
            url: $(this).attr('action'),
            enctype: $(this).attr('enctype'),
            data: new FormData(this),
            cache: false, // do not cache this request
            contentType: false, // prevent missing boundary string
            processData: false, // do not transform to query string
            timeout: 60000,
            xhr: function () {
                var xhr = $.ajaxSettings.xhr();
                if (xhr.upload) {
                    xhr.upload.addEventListener('progress', progressHandler, false);
                }
                return xhr;
            },
        }).done(function (response) {
            $('#result').val(response);
        });
        event.preventDefault();
    });

    function progressHandler(event) {
        var percent = 0;
        var position = event.loaded || event.position;
        var total = event.total;
        if (event.lengthComputable) {
            percent = Math.ceil(position / total * 100);
        }
        console.log('Uploading ', percent + '%');
    }

</script>

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