<html>
<head>
    <%@include file="base.jsp"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
    <style type="text/css">
        body, html {
            height: 100%;
        }

        .bg {
            /* The image used */
            background-image: url("https://mdbootstrap.com/img/Photos/Horizontal/Nature/full page/img(20).jpg");

            /* Full height */
            height: 100%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>

</head>
<body >
<div class="bg">
<div class="container mt-3">
    <div class="row">

        <div class="col-md-12">
            <h1 class="text-center mb-3">Welcome to Product  App</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">ProductID</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="p" >
                <tr>
                    <th scope="row">TECHONLY${p.id}</th>
                    <td>${p.name}</td>
                    <td>${p.description}</td>
                    <td class="font-weight-bold">&#8377;${p.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/productcrud/delete/${p.id}"><i class="fa-regular fa-trash-can text-danger" style="font-size: 30px"></i></a>
                        <a href="${pageContext.request.contextPath}/productcrud/update/${p.id}"><i class="fa-sharp fa-solid fa-pen-nib" style="font-size: 30px"></i></a>
                    </td>

                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="container text-center">
                <a href="${pageContext.request.contextPath}/productcrud/add-product" class="btn btn-outline-success">Add Product</a>

            </div>
        </div>

    </div>


</div>
</div>
</body>
</html>
