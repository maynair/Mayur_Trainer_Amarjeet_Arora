<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="navbar.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Order Page</h1>

            <p class="lead">Here is all Customer order list!</p>
        </div>
  <c:set  var="sl" value="1"/>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>SL No.</th>
                <th>Name</th>
                <!-- <th>Customer Id</th> -->
                <th>Phone</th>
               <!--  <th>Username</th>
                <th>Enabled</th>
                <th>Orderdetails</th> -->
                
                <th>Operation</th>
                
            </tr>
            </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${sl}</td>
                    <td>${order.customer.firstName}</td>
                    <%--  <td>${order.customer.customerId}</td>  --%>
                    <td>${order.customer.customerPhone}</td>
                    <%--  <td>${order.customer.emailId}</td> --%>
                    <%-- <td>${order.customer.enabled}</td> --%>
                    
                    <td><a class="btn btn-info" href=" <spring:url value="/admin/customerOrder/productList/${order.customerOrderId}"/>">See Receipt</a></td>
                    <td><a class="btn btn-danger" href=" <spring:url value="/admin/customerOrder/deleteOrder/${order.customerOrderId}"/>">Clear Order</a></td>
                    <c:set  var="sl" value="${sl+1}"/>
                </tr>
            </c:forEach>
        </table>
</div>
</div>
<%@ include file="footer.jsp"%>
