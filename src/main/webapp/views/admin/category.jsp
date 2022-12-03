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
    <link rel="shortcut icon"
          href="<%=request.getContextPath()%>/views/img/icons/icon-48x48.png"/>
    <link rel="canonical" href="https://demo-basic.adminkit.io/"/>
    <title>Catalog Lists</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link href="<%=request.getContextPath()%>/views/css/app.css" rel="stylesheet">
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
                <li class="sidebar-item active">
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
                    <a class="sidebar-link" href="contact.jsp">
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
                        <h3 class="card-title">Category List</h3>
                        <nav class="navbar navbar-expand-lg bg-light">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="#">
                                    <button type="submit" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#newCatalogModal"> Add new Category
                                    </button>
                                </a>
                                <form  class="d-flex" role="search">
                                    <input class="form-control me-2 fst-italic" type="search" oninput="searchByName(this)"
                                           placeholder="Enter category's name... " name="search"
                                           aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">
                                        Search
                                    </button>
                                </form>
                            </div>
                        </nav>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table id="example1"
                               class="table table-bordered table-striped border-primary table-hover table-striped text-center">
                            <thead style=" background-color: #e8bc06; vertical-align: middle;">
                            <tr>
                                <th> ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Parent Name</th>
                                <th>Status</th>
                                <th colspan="2">Actions</th>
                            </tr>
                            </thead>
                            <tbody id="content">
                            <c:forEach items="${listInfo}" var="cat">
                                <tr style="color: black">
                                    <td>${cat.catalogId}</td>
                                    <td>${cat.catalogName}</td>
                                    <td>${cat.descriptions}</td>
                                    <td>${cat.parentName==null ? 'Root':cat.parentName}</td>
                                    <td>${cat.catalogStatus? 'Active ': 'In Active'}</td>
                                    <td>
                                        <button type="button" id="update" class="btn btn-outline-primary"
                                                data-bs-toggle="modal" data-bs-target="#updateCatalog"
                                                data-whatever="${cat.catalogId}"><i class="bi bi-pencil-square"></i>
                                        </button>
                                    </td>
                                    <td>
                                        <button type="button" id="delete" class="btn btn-outline-danger"
                                                data-bs-toggle="modal" data-bs-target="#deleteCatalog"
                                                data-whatever="${cat.catalogName}"><i class="bi bi-journal-x"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <nav aria-label="Page navigation example ">
                        <ul class="pagination float-end mx-4">
                            <li class="page-item disabled">
                                <a class="page-link">Previous</a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                    <!-- /.card-body -->
                    <!-- Modal creat new catalog -->
                    <div class="modal fade" id="newCatalogModal" tabindex="-1" aria-labelledby="newCatalogLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="newCatalogLabel">Creat New</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>

                                    <div class="modal-body">
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="newCatalogName">Catalog Name&nbsp</span>
                                            <input type="text" name="newCatalogName" class="form-control"
                                                   placeholder="Input catalog name"
                                                   aria-label="Sizing example input"
                                                   aria-describedby="inputCatalogName">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text"
                                                  id="newDescriptions">Descriptions &nbsp &nbsp </span>
                                            <input type="text" name="newDescriptions" class="form-control"
                                                   placeholder="Input descriptions "
                                                   aria-label="Sizing example input"
                                                   aria-describedby="inputDescriptions">
                                        </div>
                                        <div class="input-group mb-3">
                                            <label class="input-group-text" for="inputGroupSelect01">Catalog
                                                Parent</label>
                                            <select class="form-select" name="newCatalogParent" id="inputGroupSelect01">
                                                <option selected value="0">Choose...</option>
                                                <c:forEach items="${listCreat}" var="catNew">
                                                    <option value="${catNew.catalogId}">${catNew.catalogName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                        </button>
                                        <input type="submit" name="action" value="Creat" class="btn btn-primary"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- Modal delete catalog-->
                    <div class="modal fade" id="deleteCatalog" tabindex="-1" aria-labelledby="deleteModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="deleteModalLabel">Delete Catalog</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
                                    <div class="modal-body">
                                        <input style="width: 100%" type="text" name="deleteCat" id="deleteCat" readonly>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                        </button>
                                        <input type="submit" name="action" value="Delete" class="btn btn-danger"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Modal update catalog -->
                    <div class="modal fade" id="updateCatalog" tabindex="-1" aria-labelledby="updateCatalogLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="updateCatalogLabel">Update Catalog</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="updateCatalogId">Catalog Id &nbsp &nbsp &nbsp &nbsp</span>
                                            <input type="text" name="updateCatalogId" id="catalogId"
                                                   class="form-control" placeholder="Input catalog id"
                                                   aria-label="Sizing example input" aria-describedby="inputCatalogName"
                                                   readonly>
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text"
                                                  id="updateCatalogName">Catalog Name&nbsp</span>
                                            <input type="text" name="updateCatalogName" id="catalogName"
                                                   class="form-control" placeholder="Input catalog name"
                                                   aria-label="Sizing example input"
                                                   aria-describedby="inputCatalogName">
                                        </div>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="updateDescriptions">Descriptions &nbsp &nbsp </span>
                                            <input type="text" name="updateDescriptions" id="descriptions"
                                                   class="form-control" placeholder="Input descriptions "
                                                   aria-label="Sizing example input"
                                                   aria-describedby="inputDescriptions">
                                        </div>
                                        <div class="input-group mb-3">
                                            <label class="input-group-text" for="updateParentGroup">Catalog
                                                Parent</label>
                                            <select class="form-select" name="updateCatalogParent"
                                                    >
                                                <option id="updateParentGroup" selected >Choose...</option>
                                                <c:forEach items="${listCreat}" var="catNew">
                                                    <option value="${catNew.catalogId}">${catNew.catalogName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="input-group mb-3">
                                            <label class="input-group-text" for="catalogStatusUpdate">Catalog
                                                Status</label>
                                            <select class="form-select" id="catalogStatusUpdate" name="updateStatus">
                                                <option value="true" selected>Active</option>
                                                <option value="false">Inactive</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                        </button>
                                        <input type="submit" name="action" value="Update" class="btn btn-primary"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</div>
<script src="<%=request.getContextPath()%>/views/js/app.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
    $('#deleteCatalog').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-body input').val('Xác nhận xoá " ' + recipient + ' " khỏi danh sách !');
    })
    $('#updateCatalog').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        let recipient = button.data('whatever');
        $.ajax({
            type: 'GET',
            url: '${pageContext.request.contextPath}/CatalogServlet?action=GetById&&catalogId=' + recipient,
            contentType: "charset=utf-8",
            success: function (catalogUpdate) {
                $('#catalogId').val(catalogUpdate.catalogId);
                $('#catalogName').val(catalogUpdate.catalogName);
                $('#descriptions').val(catalogUpdate.descriptions);
                $('#updateParentGroup').val(catalogUpdate.parentId);
                let status = catalogUpdate.catalogStatus.toString();
                $('#catalogStatusUpdate').val(status);
            }
        })

    })
    function searchByName(data) {
        var searchName=data.value;
        $.ajax({
            type:'GET',
            url:'${pageContext.request.contextPath}/CatalogServlet?action=SearchByName&&catalogName='+searchName,
            success:function (dataSearch){
                var row = document.getElementById("content");
                row.innerHTML = dataSearch;
            }
        })

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



</body>

</html>