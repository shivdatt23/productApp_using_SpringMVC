
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <%@include file="base.jsp"%>
    <title>${title}</title>
    <style type="text/css">
        body, html {
            height: 100%;
        }

        .bg {
            /* The image used */
            background-image: url("https://mdbootstrap.com/img/Photos/Horizontal/Nature/full page/img(11).jpg");

            /* Full height */
            height: 100%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>

</head>
<body>
<div class="bg">

    <div class="container mt-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center mb-3" >Change product details</h1>
            <form action="${pageContext.request.contextPath}/productcrud/handle-product" method="post">
                <input type="text" name="id" >
                <div class="form-group">
                    <label for="name">Product Name</label>
                    <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name" placeholder="Enter the product name here"
                    >
                </div>

                <div class="form-group">
                    <label for="description">Product Description</label>
                    <textarea class="form-control" name="description" id="description" rows="5" placeholder="Enter the product description"></textarea>
                </div>

                <div class="form-group">
                    <label for="price">Product Price</label>
                    <input type="text" placeholder="Enter Product Price" name="price" class="form-control" id="price" >
                </div>

                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/productcrud/"
                       class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-warning">Update</button>

                </div>
            </form>

        </div>
    </div>
    </div>
</div>
</body>
</html>
