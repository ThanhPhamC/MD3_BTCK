<%--
  Created by IntelliJ IDEA.
  User: phamthanh
  Date: 26/11/2022
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="sidebar" class="sidebar js-sidebar">
    <div class="sidebar-content js-simplebar">
        <a class="sidebar-brand" href="index.jsp">
            <span class="align-middle">AdminKit</span>
        </a>

        <ul class="sidebar-nav">
            <li class="sidebar-header">
                Pages
            </li>
            <li class="sidebar-item active">
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
