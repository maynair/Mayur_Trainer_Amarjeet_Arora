package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.BillingAddress;
import com.model.Customer;
import com.model.ShippingAddress;
import com.model.User;
import com.service.AuthoritiesService;
import com.service.BillingAddressService;
import com.service.CartService;
import com.service.CustomerService;
import com.service.ShippingAddressService;
import com.service.UserService;
import com.model.Authorities;
import com.model.Cart;

@Controller
public class UserController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BillingAddressService billingAddressService;

	@Autowired
	private ShippingAddressService shippingAddressService;

	@Autowired
	private AuthoritiesService authoritiesService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customer/registration")
	public ModelAndView getRegistrationForm() {
		Customer customer = new Customer();
		User user = new User();
		BillingAddress ba = new BillingAddress();
		ShippingAddress sa = new ShippingAddress();
		customer.setShippingAddress(sa);
		customer.setBillingAddress(ba);
		customer.setUsers(user);

		return new ModelAndView("register", "customer", customer);
	}

	// to insert the data

	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer, Model model,
			BindingResult result) {
		if (result.hasErrors())
			return "register";
		customerService.addCustomer(customer);
		model.addAttribute("registrationSuccess", "Registered Successfully. Login using username and password");
		return "login";
	}

	/*
	 * @RequestMapping(value="/customer/registration",method=RequestMethod.POST)
	 * public String registerCustomerPost(@Valid@ModelAttribute("customer")Customer
	 * customer,BindingResult result, @RequestParam(name="update",required=false)
	 * String update,@RequestParam(name="oldUserId",required=false)String oldUserId
	 * ,Model model,javax.servlet.http.HttpServletRequest request){
	 * 
	 * if (result.hasErrors()) { return "registerCustomer"; }
	 * 
	 * List<Customer> customerList=customerService.getAllCustomers();
	 * 
	 * for (Customer customer2 : customerList) {
	 * 
	 * if
	 * (customer2.getCustomerEmailAddress().equals(customer.getCustomerEmailAddress(
	 * ))) { model.addAttribute("emailMsg","Email already exists"); return
	 * "registerCustomer"; }
	 * 
	 * if (customer2.getFirstName().equals(customer.getFirstName())) {
	 * model.addAttribute("usernameMsg","Username already exists"); return
	 * "registerCustomer"; } }
	 * 
	 * //System.out.println("--------------------------update:"+
	 * update+" ------------"+oldUserId);
	 * 
	 * if (update!=null && update.equalsIgnoreCase("update")) { Customer
	 * oldCustomer=customerService.getCustomerById(oldUserId);
	 * 
	 * customer.getBillingAddress().setBillingAddressId(oldCustomer.
	 * getBillingAddress().getBillingAddressId());
	 * customer.getShippingAddress().setShippingAddressId(oldCustomer.
	 * getShippingAddress().getShippingAddressId());
	 * billingAddressService.addBillingAddress(customer.getBillingAddress());
	 * shippingAddressService.addShippingAddress(customer.getShippingAddress());
	 * 
	 * 
	 * String oldUsername=oldCustomer.getFirstName();
	 * 
	 * oldCustomer.setBillingAddress(customer.getBillingAddress());
	 * oldCustomer.setShippingAddress(customer.getShippingAddress());
	 * oldCustomer.setEnabled(true);
	 * oldCustomer.setBillingAddress(customer.getBillingAddress());
	 * oldCustomer.setShippingAddress(customer.getShippingAddress());
	 * oldCustomer.setFirstName(customer.getFirstName());
	 * oldCustomer.setPassword(customer.getPassword());
	 * oldCustomer.setCustomerEmailAddress(customer.getCustomerEmailAddress());
	 * oldCustomer.setFirstName(customer.getFirstName());
	 * oldCustomer.setCustomerPhone(customer.getCustomerPhone());
	 * 
	 * 
	 * customerService.addCustomer(oldCustomer);
	 * 
	 * User users=userService.getUserById(oldUsername); users.setUserId(oldUserId);
	 * users.setEnabled(true); users.setPassword(oldCustomer.getPassword());
	 * users.setUsername(oldCustomer.getFirstName());
	 * 
	 * userService.addUser(users);
	 * 
	 * 
	 * Authorities
	 * authorities=authoritiesService.findAuthoritiesByusername(oldUsername);
	 * authorities.setAuthorities("ROLE_USER");
	 * authorities.setUsername(oldCustomer.getFirstName());
	 * 
	 * 
	 * 
	 * authoritiesService.addAuthorities(authorities);
	 * 
	 * 
	 * Cart cart=oldCustomer.getCart(); cart.setCustomer(oldCustomer);
	 * cart.setTotalPrice(0);
	 * 
	 * cartService.addCart(cart);
	 * 
	 * oldCustomer.setCart(cart); customerService.addCustomer(oldCustomer);
	 * 
	 * 
	 * autoLogin(oldCustomer,request);
	 * 
	 * return "updateCustomerSuccess";
	 * 
	 * }
	 * 
	 * else { billingAddressService.addBillingAddress(customer.getBillingAddress());
	 * shippingAddressService.addShippingAddress(customer.getShippingAddress());
	 * 
	 * customer.setEnabled(true); customerService.addCustomer(customer);
	 * 
	 * User users=new User(); users.setUserId(customer.getCustomerId());
	 * users.setEnabled(true); users.setPassword(customer.getPassword());
	 * users.setUsername(customer.getFirstName());
	 * 
	 * userService.addUser(users);
	 * 
	 * 
	 * Authorities authorities=new Authorities();
	 * authorities.setAuthorities("ROLE_USER");
	 * authorities.setUsername(customer.getFirstName());
	 * 
	 * authoritiesService.addAuthorities(authorities);
	 * 
	 * 
	 * Cart cart=new Cart(); cart.setCustomer(customer); cart.setTotalPrice(0);
	 * 
	 * cartService.addCart(cart);
	 * 
	 * customer.setCart(cart); customerService.addCustomer(customer);
	 * 
	 * 
	 * autoLogin(customer,request);
	 * 
	 * }
	 * 
	 * return "registerCustomerSuccess"; }
	 * 
	 * 
	 * 
	 * private void autoLogin(Customer customer,HttpServletRequest request) {
	 * 
	 * String username=customer.getFirstName(); String
	 * password=customer.getPassword(); // generate session if one doesn't exist
	 * request.getSession(); Authentication authentication=new
	 * UsernamePasswordAuthenticationToken(username, password);
	 * SecurityContextHolder.getContext().setAuthentication(authentication); }
	 * 
	 * 
	 * 
	 * @RequestMapping("/customer/update") public String customerUpdate(){
	 * 
	 * return "updateCustomer"; }
	 * 
	 * 
	 * @RequestMapping(value="/customer/update",method=RequestMethod.POST) public
	 * String customerUpdatePost(@RequestParam("username")String
	 * username,@RequestParam("password")String password,Model model){
	 * 
	 * Customer customer=customerService.findCustomerByusernameAndpassword(username,
	 * password);
	 * 
	 * if (customer==null) {
	 * 
	 * return "updateCustomer"; }
	 * 
	 * model.addAttribute("customer",customer);
	 * 
	 * 
	 * model.addAttribute("update","update"); return "registerCustomer"; }
	 */

}
