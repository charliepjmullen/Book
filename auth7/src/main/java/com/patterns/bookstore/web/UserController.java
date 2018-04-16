package com.patterns.bookstore.web;

 
import com.patterns.bookstore.model.Book;
import com.patterns.bookstore.model.Discount;
import com.patterns.bookstore.model.Review;
import com.patterns.bookstore.model.User;
import com.patterns.bookstore.model.UserPurchaseHistory;
import com.patterns.bookstore.purchasingFacade.OrderServiceFacade;
import com.patterns.bookstore.purchasingFacade.OrderServiceFacadeImpl;
import com.patterns.bookstore.purchasingPrototype.CloneFactory;
import com.patterns.bookstore.repository.BookRepository;
import com.patterns.bookstore.repository.ReviewRepository;
import com.patterns.bookstore.repository.UserPurchaseHistoryRepository;
import com.patterns.bookstore.repository.UserRepository;
import com.patterns.bookstore.service.BookService;
import com.patterns.bookstore.service.SecurityService;
import com.patterns.bookstore.service.UserService;
import com.patterns.bookstore.validator.UserValidator;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired 
    private UserRepository userRepository;
    
    @Autowired
    private ReviewRepository reviewRepository;
   
    @Autowired
    private UserPurchaseHistoryRepository userPurchaseHistoryRepository;
    
    private OrderProcessController orderProcessController;
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
    	
    	 Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
         String username = loggedInUser.getName(); // Authentication for 
         User user = userRepository.findByUsername(username);
    	
         String result;
         
         if(user.getUsername().equals("bookstore_Admin")) {
        	 result = "adminwelcome";
        }
        
        else{
        	result = ("welcome");
        	}

        return result;
        
       
    }
    
    @RequestMapping(value = "viewallbooks", method = RequestMethod.GET)
    public String bookList(@Valid Book book, Model model) {
    	List<Book> booksList = new ArrayList<>();
    	booksList = bookRepository.findAll();
    	
    	model.addAttribute("booksList", booksList);
    	
    	return "bookList";
    }
    
    @RequestMapping(value = "adminviewallbooks", method = RequestMethod.GET)
    public String adminbookList(@Valid Book book, Model model) {
    	List<Book> booksList = new ArrayList<>();
    	booksList = bookRepository.findAll();
    	
    	model.addAttribute("booksList", booksList);
    	
    	return "adminviewallbooks";
    }
    
    @RequestMapping(value = " /updatequantityform/{bookId}", method=RequestMethod.GET)
    public String updateQuantityForm(@PathVariable("bookId")Long id, Model model) {

      
      //Retrieve book
      Book book = bookRepository.findById(id);
      Long bookId = book.getId();
      String title = book.getTitle();
      String author = book.getAuthor();
      String category = book.getCategory();
      double price = book.getPrice();
      String image = book.getImage();
      
      model.addAttribute("bookId", bookId);
      model.addAttribute("title", title);
      model.addAttribute("author", author);
      model.addAttribute("category", category);
      model.addAttribute("price", price);
      model.addAttribute("image", image);
  
      return "updatequantityform";
    }
    
    
    @RequestMapping(value="/updatequantity/{title}", method=RequestMethod.GET)
    public String updateBookQuantity(@Valid Book book, @RequestParam("quantity") int quantity, @PathVariable("title")String  book_title,  Model model) {
    	
        book = bookRepository.findByTitle(book_title);
    	book.setQuantity(quantity);
    	System.out.println(book_title + " quantity updated by: " + quantity);
    	
    	bookRepository.save(book);
    	
    
    	
    	return "bookupdated";
    }
    
    
    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(@Valid Book book, Model model, BindingResult result) {
    	

        return "addbook";
    }
    
    
    @RequestMapping(value = " /shoppingcart/{bookId}", method=RequestMethod.GET)
    public String shoppingCart(@PathVariable("bookId")Long id, Model model) {

      // This gets the currently logged in user
      Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
      String username = loggedInUser.getName(); // Authentication for 
      User user = userRepository.findByUsername(username);

      System.out.println(username);
      
      //Retrieve book
      Book book = bookRepository.findById(id);
      String title = book.getTitle();
      
      System.out.println(username + "saved" + "Book: " + title);

      // This will add the book to the user's booklist
      user.saveBookToShoppingCart(book);
      userRepository.save(user);

      return "bookAddedToShoppingCart";
    }
    
    @RequestMapping(value = "/viewShoppingCart", method = RequestMethod.GET)
    public String viewShoppingCart(@Valid Book book, Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName(); // Authentication for 
        User user = userRepository.findByUsername(username);
        
        List<Book> shoppingCart = user.getShoppingCart();
        
        model.addAttribute("shoppingCart", shoppingCart);
        
		return "shoppingcart";
    	
    }
    
    @RequestMapping(value = " /deletebook/{bookId}", method=RequestMethod.GET)
    public String removeBookFromShoppingCart(@PathVariable("bookId")Long id, Model model) {
    	
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName(); // Authentication for 
        User user = userRepository.findByUsername(username);
        
        
        Book book = bookRepository.findById(id);
        
        user.removeBookFromShoppingCart(book);
        List<Book> shoppingCart = user.getShoppingCart();
        userRepository.save(user);
        
        String title = book.getTitle();
        System.out.println(username + "removed" + "Book: " + title);
        
        model.addAttribute("shoppingCart", shoppingCart);
        
		return "bookDeleted";
    }
    
    @RequestMapping(value = " /checkout", method=RequestMethod.GET)
    public String checkout(Model model) {

      // This gets the currently logged in user
      Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
      String username = loggedInUser.getName(); // Authentication for 
      User user = userRepository.findByUsername(username);

      List<Book> checkout = user.getShoppingCart();
      double total = 0;
      double price;
      

      for(Book b: checkout) {
    	   price = b.getPrice();
    	   total += price;
      }
      //System.out.println(total);

      model.addAttribute("total", total);

      return "checkout";
    }
    
    @RequestMapping(value = "/book/{bookId}", method=RequestMethod.GET)
    public String bookReviews(@PathVariable("bookId")Long id, Model model) {
    	
        Book book = bookRepository.findById(id);
        Long bookId = book.getId();
        String title = book.getTitle();
        String author = book.getAuthor();
        String category = book.getCategory();
        double price = book.getPrice();
        String image = book.getImage();
        List<Review> review = book.getReviews();
        
        model.addAttribute("bookId", bookId);
        model.addAttribute("title", title);
        model.addAttribute("author", author);
        model.addAttribute("category", category);
        model.addAttribute("price", price);
        model.addAttribute("image", image);
        model.addAttribute("review", new Review());
        
        
		return "bookview";
    }
    
    @RequestMapping(value="/addreview/{title}", method=RequestMethod.GET)
    public String addReview(@Valid Review review, @RequestParam("comment") String comment, @PathVariable("title")String  book_title,  Model model) {
    		
      	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName(); // Authentication for 
        User user = userRepository.findByUsername(username);
    	
    	review.setBook_title(book_title);
    	review.setUsername(username);
    	  
    	reviewRepository.save(review);
    	System.out.println("Reveiw:" + review);
    	
    	Book book = bookRepository.findByTitle(book_title);
    	book.addReviewToBook(review);
    	bookRepository.save(book);
    	
    	System.out.println(username + " just said " + review.getComment() + " about " + book_title);
    	
    	List<Review> books = book.getReviews();
    	System.out.println(books);
    	model.addAttribute("books", books);
    	
    	return "reviewpage";
    }
    
   @RequestMapping(value  ="/displayreview/{title}", method = RequestMethod.GET)
    public String reviewpage(@Valid Review review, @PathVariable("title")String  book_title,  Model model) {
    	
    	Book book = bookRepository.findByTitle(book_title);
    
    	List<Review> books = book.getReviews();
    	
    	model.addAttribute("books", books);
    	return "reviewpage";
    }
    
    @RequestMapping(value="addbook", method=RequestMethod.GET)
    public String addBook(Book book, @RequestParam("title") String title,
            						 @RequestParam("author") String author, 
            						 @RequestParam("price") double price, 
            						 @RequestParam("category") String category, 
            						 @RequestParam("image") String image, 
            						 @RequestParam("quantity") int quantity) {
    	
    	bookRepository.save(book);
      
    	return "bookAddedToDB";
    }
    

    
    @RequestMapping(value="/searchfunction", method=RequestMethod.GET)
    @ResponseBody
    public List<Book> searchbooks()
    {
    	   
    	List<Book> searchresults = bookRepository.findAll();	   
    	return searchresults;   
    }
    
    @RequestMapping(value="/showbooks", method=RequestMethod.GET)
    public String printSearchResults() {
        
        return "bookList";

    }
    
    @RequestMapping(value="viewOrders", method=RequestMethod.GET)
    public String viewAllOrders(Model model) {
    	
    	List<UserPurchaseHistory> purchaseHistory = userPurchaseHistoryRepository.findAll();
    	
    	model.addAttribute("purchaseHistory", purchaseHistory);
    	
    	return "customerOrders";
    }
    
    @RequestMapping(value="payment", method=RequestMethod.GET)
    public String paymentPage() {
    	
    	return "paymentPage";
    }
    
    @RequestMapping(value="paymentDetails", method=RequestMethod.GET)
    @ResponseBody
    public String payment(@RequestParam("shipping") String shipping,
    		              @RequestParam("creditcard") String creditcard,
    		              @RequestParam("expirydate") String expirydate,
    		              @RequestParam("carddetails") int carddetails,
    		              @RequestParam("cvv") int cvv) {
    	
    	
    	System.out.println("Shipping Address: " + shipping + "\n" +
    			           "Credit Card Type: " + creditcard + "\n" +
    			           "Expiry Date: " + expirydate + "\n" +
    			           "Card Number: " + carddetails + "\n" +
    			           "CVV: " + cvv + "\n");
    	
    	User user = new User();
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName(); // Authentication for 
        user = userRepository.findByUsername(username);
        
        user.setShipping_address(shipping);
        
  
        List<Book> shoppingcart = user.getShoppingCart();
        
        for(Book book: shoppingcart) {
	        OrderProcessController controller=new OrderProcessController();
	        controller.facade=new OrderServiceFacadeImpl();
	        controller.orderProduct(book.getId());
	        int newQuantity = book.getQuantity() - 1;
        	book.setQuantity(newQuantity);
	        boolean result=controller.orderFulfilled;
	        System.out.println(result);
        }
        
        System.out.println("Stock Updated");

        
        CloneFactory userCloner = new CloneFactory();
        
        // Creates new instance of User
        
        
        User userClone = (User) userCloner.getClone(user);
        
        UserPurchaseHistory userPurchaseHistory = new UserPurchaseHistory();
        
        
       
        System.out.println("");
         
        List<String> purchaseHistoryList = new ArrayList<String>();
        
        
        for(Book book: shoppingcart) {
        	String booktitle = book.getTitle();
        	purchaseHistoryList.add(booktitle);
        }
        
        user.clearShoppingCart();
        System.out.println("Shopping cart cleared");
        userPurchaseHistory.setUsername(userClone.getUsername());
        userPurchaseHistory.setShipping_address(userClone.getShipping_address());
        userPurchaseHistory.setPurchaseHistory(purchaseHistoryList);
         System.out.println(purchaseHistoryList);
     
        userRepository.save(user);
        userPurchaseHistoryRepository.save(userPurchaseHistory);
        
        System.out.println("User 1");
        System.out.println("User : " + System.identityHashCode(System.identityHashCode(user)));
        System.out.println("Username : " + user.getUsername());
        System.out.println("Shopping Cart" + user.getShoppingCart());
        System.out.println("=======================================");
        System.out.println("User : " + System.identityHashCode(System.identityHashCode(userClone)));
        System.out.println("User 2: " + userClone.getUsername());
        System.out.println("Username : " + userClone.getShoppingCart());
        
        
    	return "confirmpage";
    }
    

    
    @RequestMapping(value="customerorders", method=RequestMethod.GET)
    public String customerOrderPage(Model model) {
    	
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName(); // Authentication for 
        User user = userRepository.findByUsername(username);
        
        model.addAttribute("user", user);
    	
    	return "confirmpage";
    }
    
    @RequestMapping(value="/calculatediscount", method=RequestMethod.GET)
    public String DiscountSingletonCalculator(Model model, @RequestParam("code") String code, @RequestParam("price") double price) {
    	
    	
    	Discount dc = Discount.getInstance();
    	Double total = price - (price * 0.10);
    	 
    	if (dc.calculatePrice(code) == true)
    	{
    		System.out.print("Correct Code " + code);
    		System.out.println(total);
    	}
    	else
    	{
    		System.out.print("Wrong Code " + code);
    	}
    	
    	model.addAttribute("total", total);
    	
    	return "paymentPage";

    }
    
    @RequestMapping(value="/paymentpage", method=RequestMethod.GET)
    public String purchasingFacade() {
    	
    
    	return"confirmpage";
    	
    	
    }
    
    
    
}
