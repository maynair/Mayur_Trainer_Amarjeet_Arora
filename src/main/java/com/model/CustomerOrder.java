package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customerorder")
public class CustomerOrder implements Serializable {

	private static final long serialVersionUID = -6571020025726257848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerOrderId;

	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	/*
	 * @Column(name = "totalPrice", table = "cart") private double totalPrice;
	 */
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	/*
	 * @Column(name = "fname", table = "customer") private String fname;
	 * 
	 * @Column(name = "lname", table = "customer") private String lname;
	 * 
	 * @Column(name = "custPhone", table = "customer") private String custPhone;
	 * 
	 * @Column(name = "emailId", table = "customer") private String emailId;
	 */
	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;
	
	/*
	 * @Column(name = "shipAddress", table = "shippingAddress") private String
	 * shipAddress;
	 * 
	 * @Column(name = "shipCity", table = "shippingAddress") private String
	 * shipCity;
	 * 
	 * @Column(name = "shipCountry", table = "shippingAddress") private String
	 * shipCountry;
	 * 
	 * @Column(name = "shipState", table = "shippingAddress") private String
	 * shipState;
	 * 
	 * @Column(name = "shipZipcode", table = "shippingAddress") private String
	 * shipZipcode;
	 */

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;
	
	/*
	 * @Column(name = "billAddress", table = "billingAddress") private String
	 * billAddress;
	 * 
	 * @Column(name = "billCity", table = "billingAddress") private String billCity;
	 * 
	 * @Column(name = "billCountry", table = "billingAddress") private String
	 * billCountry;
	 * 
	 * @Column(name = "billState", table = "billingAddress") private String
	 * billState;
	 * 
	 * @Column(name = "billZipcode", table = "billingAddress") private String
	 * billZipcode;
	 */


	/*
	 * public double getTotalPrice() { return totalPrice; }
	 * 
	 * public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice;
	 * }
	 * 
	 * public String getFname() { return fname; }
	 * 
	 * public void setFname(String fname) { this.fname = fname; }
	 * 
	 * public String getLname() { return lname; }
	 * 
	 * public void setLname(String lname) { this.lname = lname; }
	 * 
	 * public String getCustPhone() { return custPhone; }
	 * 
	 * public void setCustPhone(String custPhone) { this.custPhone = custPhone; }
	 * 
	 * public String getEmailId() { return emailId; }
	 * 
	 * public void setEmailId(String emailId) { this.emailId = emailId; }
	 * 
	 * public String getShipAddress() { return shipAddress; }
	 * 
	 * public void setShipAddress(String shipAddress) { this.shipAddress =
	 * shipAddress; }
	 * 
	 * public String getShipCity() { return shipCity; }
	 * 
	 * public void setShipCity(String shipCity) { this.shipCity = shipCity; }
	 * 
	 * public String getShipCountry() { return shipCountry; }
	 * 
	 * public void setShipCountry(String shipCountry) { this.shipCountry =
	 * shipCountry; }
	 * 
	 * public String getShipState() { return shipState; }
	 * 
	 * public void setShipState(String shipState) { this.shipState = shipState; }
	 * 
	 * public String getShipZipcode() { return shipZipcode; }
	 * 
	 * public void setShipZipcode(String shipZipcode) { this.shipZipcode =
	 * shipZipcode; }
	 * 
	 * public String getBillAddress() { return billAddress; }
	 * 
	 * public void setBillAddress(String billAddress) { this.billAddress =
	 * billAddress; }
	 * 
	 * public String getBillCity() { return billCity; }
	 * 
	 * public void setBillCity(String billCity) { this.billCity = billCity; }
	 * 
	 * public String getBillCountry() { return billCountry; }
	 * 
	 * public void setBillCountry(String billCountry) { this.billCountry =
	 * billCountry; }
	 * 
	 * public String getBillState() { return billState; }
	 * 
	 * public void setBillState(String billState) { this.billState = billState; }
	 * 
	 * public String getBillZipcode() { return billZipcode; }
	 * 
	 * public void setBillZipcode(String billZipcode) { this.billZipcode =
	 * billZipcode; }
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
