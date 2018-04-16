package com.patterns.bookstore.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class UserPurchaseHistory {

    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String shipping_address;
    private String payment_details;
    private Set<Role> roles;
    private List<String> purchaseHistory;
  /*  private Set<Book> orderHistory;*/

    
    
    public UserPurchaseHistory() {
		super();
	}

	public UserPurchaseHistory(Long id, String username, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public UserPurchaseHistory(Long id, String username, String password, String passwordConfirm) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public UserPurchaseHistory(Long id, String username, String shipping_address, List<String> purchaseHistory) {
		super();
		this.id = id;
		this.username = username;
		this.shipping_address = shipping_address;
		this.purchaseHistory = purchaseHistory;
	}
/*	public User(Long id, String username, String password, String passwordConfirm, String shipping_address,
			String payment_details, Set<Role> roles, List<Book> shoppingCart, Set<Book> orderHistory) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.shipping_address = shipping_address;
		this.payment_details = payment_details;
		this.roles = roles;
		this.shoppingCart = shoppingCart;
		this.orderHistory = orderHistory;
	}*/

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getPayment_details() {
		return payment_details;
	}

	public void setPayment_details(String payment_details) {
		this.payment_details = payment_details;
	}

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
/*	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "user_books", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	public List<Book> getPurchaseHistory(){
		return purchaseHistory;
	}*/
    
    
    
	public void setPurchaseHistory(List<String> purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}

	@Column
    @ElementCollection(targetClass=String.class)
	public List<String> getPurchaseHistory() {
		return purchaseHistory;
	}
	
	/*public Set<Book> getOrderHistory(){
		return orderHistory;
	}
	
	public void setOrderHistory(Set<Book> orderHistory) {
		this.orderHistory = orderHistory;
	}*/
	
	public void saveBookToPurchaseHistory(String book) {
		purchaseHistory.add(book);
	}

	/*
	public void removeBookFromShoppingCart(Book book) {
		shoppingCart.remove(book);
	}
	
	public void clearShoppingCart() {
		shoppingCart.clear();
	}*/
}
