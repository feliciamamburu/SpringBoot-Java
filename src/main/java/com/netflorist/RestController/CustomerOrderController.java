
package com.netflorist.RestController;

import com.netflorist.Model.CustomerOrder;
import com.netflorist.Service.CustomersOrderService;
import com.netflorist.exceptions.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
public class CustomerOrderController {
    
    
    @Autowired
    private CustomersOrderService customerOrderService;
    
    private List<CustomerOrder> customerOrdersList = new ArrayList<>();
    
    @RequestMapping(method = RequestMethod.POST,value = "/placeOrder")
    public CustomerOrder saveOrder(@RequestBody CustomerOrder customerOrder)
    {
        customerOrderService.saveCustomerOrder(customerOrder);
        return customerOrder;
    }
    
    
    
@RequestMapping(value="/customerOrder/all",method=RequestMethod.GET)
    public List<CustomerOrder>findAllcustomerOrders(){
        
        customerOrdersList= customerOrderService.findAllcustomerOrders();
        
        return  customerOrdersList;
    }  
    
    
    //Update Order Status using order id
    @RequestMapping(value = "/updateStatus/{orderId}/{status}", method = RequestMethod.PUT)
    @ResponseBody
    public int updateStatus(@PathVariable int orderId, @PathVariable String status )
    {
       int updated = customerOrderService.updateStatus(orderId, status);
       if(updated != 1)
       {
           throw new DataNotFoundException("Order Status could not be Updated...");
       }
       return updated;
    }
    

    
//    dateProducts(int productId, int quantity);
    
    
//     @RequestMapping(value="/customerOrder/updateStatus",method=RequestMethod.POST)
//     public void updateStatus(@RequestBody CustomerOrder  customerOrders){
//         
//         customerOrderService.updateStatus(customerOrders);
//         
//     }
}
