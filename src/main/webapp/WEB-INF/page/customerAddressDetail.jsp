<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="navbar.jsp"%>

<div class="container-wrapper">
    <div class="container">
    
    <form:form commandName="order" class="form-horizontal">
        <div class="page-header">
            <h1>Customer Shipping Address & Billing Address Page</h1>

            <p class="lead">Here is address of ${customer.customerId}</p>
        </div>
    
      <h1>Shipping Address</h1>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>ZipCode</th>                
            </tr>
            </thead>
            <%--  <c:forEach items="${customers}" var="customer">  --%>
                <tr>
                    <td>${order.cart.customer.shippingAddress.address} </td>
                    <td>${order.cart.customer.shippingAddress.city}</td>
                    <td>${order.cart.customer.shippingAddress.state} </td>
                    <td>${order.cart.customer.shippingAddress.country}</td>
                    <td>${order.cart.customer.shippingAddress.zipcode}</td>
                </tr>
     <%--      </c:forEach>  --%>
        </table>
              
        <h1>Billing Address</h1>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                 <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>ZipCode</th>
                
            </tr>
            </thead>
            
                <tr>
                    <td>${order.cart.customer.billingAddress.address}</td>
                    <td>${order.cart.customer.billingAddress.city}</td>
                    <td>${order.cart.customer.billingAddress.state}</td>
                    <td>${order.cart.customer.billingAddress.country}</td>
                    <td>${order.cart.customer.billingAddress.zipcode}</td>
                </tr>
           
        </table>
        	</form:form>
        </div>
        </div>
        <br><br>	
<%@ include file="footer.jsp"%>