<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="navbar.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">This is the customer management page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Enabled</th>
                <th>Shipping Address & Billing Address</th>
                
            </tr>
            </thead>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.customerEmailAddress}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.enabled}</td>
                    <td><a href=" <spring:url value="/admin/customerManagement/address/${customer.customerId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                    
                </tr>
            </c:forEach>
        </table>
        </div>
        </div>
<%@ include file="footer.jsp"%>