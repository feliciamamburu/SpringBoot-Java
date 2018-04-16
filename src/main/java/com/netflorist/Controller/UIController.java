package com.netflorist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author 
 */
@Controller
public class UIController {
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
        return "home";
    }
    
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(){
        return "register";
    }
   
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
   
    @RequestMapping(value="/admin",method=RequestMethod.GET)
    public String admin(){
        return "admin";
    }
    
    @RequestMapping(value="/addProduct",method=RequestMethod.GET)
    public String addProduct(){
        return "addProduct";
    }
   
    @RequestMapping(value="/products",method=RequestMethod.GET)
    public String productsView(){
        return "products";
    }
    
    @RequestMapping(value="/adminProducts",method = RequestMethod.GET)
    public String adminViewProduct(){
        return "adminProducts";
    }
    
//    @RequestMapping(value="/cart",method=RequestMethod.GET)
//    public String cartView(){
//        return "cart";
//    }
      @RequestMapping(value="/usersList",method=RequestMethod.GET)
    public String useView(){
        return "usersList";
    }
       @RequestMapping(value="/checkout",method=RequestMethod.GET)
    public String checkoutView(){
        return "checkout";
    }
      @RequestMapping(value="/supplier",method=RequestMethod.GET)
    public String supplierView(){
        return "supplier";
    }
       @RequestMapping(value="/driver",method=RequestMethod.GET)
    public String driverView(){
        return "driver";
    }
    @RequestMapping(value="/guest",method=RequestMethod.GET)
    public String guestView(){
        return "guest";
    }
 
 @RequestMapping(value="/customerOrder",method=RequestMethod.GET)
    public String customerOrderView(){
        return "customerOrder";
    }
     @RequestMapping(value="/updateProduct",method=RequestMethod.GET)
    public String updateProductView(){
        return "updateProduct";
    }
   
    
  @RequestMapping(value="/viewOrder",method=RequestMethod.GET)
    public String viewOrderView(){
        return "viewOrder";
    }
   
  
}
