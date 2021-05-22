<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="navbar.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="now" class="java.util.Date" />


<div class="container-wrapper">

	<div class="container">

		<div class="page-header title">
			<h1>Order</h1>

			<p class="lead">Order ,customer and product list</p>
		</div>


		<div class="container">

			<div class="row">



				<form:form commandName="order" class="form-horizontal">

					<div
						class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">



						<div class="text-center">
							<h1>Receipt</h1>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Shipping Address</strong><br />
									${order.cart.customer.shippingAddress.address} <br />
									${order.cart.customer.shippingAddress.city},
									${order.cart.customer.shippingAddress.state} <br />
									${order.cart.customer.shippingAddress.country},
									${order.cart.customer.shippingAddress.zipcode} <br />
								</address>
							</div>
						</div>


						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Billing Address</strong><br />
									${order.cart.customer.billingAddress.address} <br />
									${order.cart.customer.billingAddress.city},
									${order.cart.customer.billingAddress.state} <br />
									${order.cart.customer.billingAddress.country},
									${order.cart.customer.billingAddress.zipcode} <br />
								</address>
							</div>
						</div>

						<div class="row">

							<table class="table table-hover">

								<thead>
									<tr>
										<th>Product</th>
										<th>#</th>
										<th class="text-center">Price</th>
										<th class="text-center">Total</th>
									</tr>

								</thead>

								<tbody>

									<c:forEach var="cartItem" items="${order.cart.cartItem}">
										<tr>
											<td style="text-align: center"><em>${cartItem.product.productName}</em></td>
											<td style="text-align: center">${cartItem.quality}</td>
											<td style="text-align: center">${cartItem.product.productPrice}</td>
											<td style="text-align: center">${cartItem.price}</td>
										</tr>
									</c:forEach>
									<tr>
										<td></td>
										<td></td>
										<td class="text-right">
											<h4>
												<string> Grand Total: </string>
											</h4>
										</td>
										<td class="text-center text-danger">
											<h4>
												<strong>${order.cart.totalPrice}</strong>
											</h4>
										</td>
									</tr>
								</tbody>


							</table>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>