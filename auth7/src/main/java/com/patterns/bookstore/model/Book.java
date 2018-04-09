package com.patterns.bookstore.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.patterns.bookstore.model.Review;

@Entity
public class Book {

	private Long id;
	private String title;
	private double price;
	private String author;
	private String category;
	private String image;
	private int quantity;
	private List<Review> reviews;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(Long id, String title, double price, String author, String category, String image, int quantity) {
		this.id= id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
		this.image = image;
		this.quantity = quantity;
	}
	
	public Book(String title, double price, String author, String category, String image, int quantity) {
		
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
		this.image = image;
		this.quantity = quantity;
	}
	
	public Book(Long id, String title, double price, String author, String category) {
		this.id= id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
	}
	
	public Book(Long id, String title, double price, String author, String category, String image, int quantity, List<Review> reviews) {
		this.id= id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
		this.image = image;
		this.quantity = quantity;
		this.reviews = reviews;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "book_reveiws", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "review_id"))
    public List<Review> getReviews(){
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReviewToBook(Review review) {
		reviews.add(review);
	}
	
    

}
