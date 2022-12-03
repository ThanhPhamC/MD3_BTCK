<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Au Register Forms by Colorlib</title>

    <!-- Icons font CSS-->
    <link href="<%=request.getContextPath()%>/views/vendor/mdi-font-register/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="<%=request.getContextPath()%>/views/vendor/font-awesome-4.7-register/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="<%=request.getContextPath()%>/views/vendor/select2-register/select2.min.css" rel="stylesheet" media="all">
    <link href="<%=request.getContextPath()%>/views/vendor/datepicker-register/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="<%=request.getContextPath()%>/views/css/main-register.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Registration Form</h2>
                    <form method="POST" action="<%=request.getContextPath()%>/UserServlet">
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Full name</label>
                                    <input class="input--style-4" type="text" name="fullName"/>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Address</label>
                                    <input class="input--style-4" type="text" name="address"/>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Birthday</label>
                                    <div class="input-group-icon">
                                        <input class="input--style-4 js-datepicker" type="date" name="birthday"/>

                                    </div>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Gender</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Male
                                            <input type="radio" value="true" checked="checked" name="gender">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">Female
                                            <input type="radio" value="false" name="gender">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Email</label>
                                    <input class="input--style-4" type="email" name="email">
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Phone Number</label>
                                    <input class="input--style-4" type="text" name="phone">
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">User Login</label>
                                    <input class="input--style-4" type="text" name="userLogin">
                                </div>
                            </div>
                        </div><div class="row row-space">
                        <div class="col-2">
                            <div class="input-group">
                                <label class="label">PassWord</label>
                                <input class="input--style-4" type="text" name="password">
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group">
                                <label class="label">Comfirm pass</label>
                                <input class="input--style-4" type="text" name="email">
                            </div>
                        </div>
                    </div>
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" name="action" value="Creat" onclick="Checkvalidate()" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="<%=request.getContextPath()%>/views/vendor/jquery-register/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="<%=request.getContextPath()%>/views/vendor/select2-register/select2.min.js"></script>
    <script src="<%=request.getContextPath()%>/views/vendor/datepicker-register/moment.min.js"></script>
    <script src="<%=request.getContextPath()%>/views/vendor/datepicker-register/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="<%=request.getContextPath()%>/views/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->