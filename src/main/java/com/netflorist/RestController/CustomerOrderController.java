package com.netflorist.RestController;

import com.netflorist.Model.CustomerOrder;
import com.netflorist.Service.CustomersOrderService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.POST, value = "/placeOrder")
    public CustomerOrder saveOrder(@RequestBody CustomerOrder customerOrder) {
        customerOrderService.saveCustomerOrder(customerOrder);
        return customerOrder;
    }

    @RequestMapping(value = "/customerOrder/all", method = RequestMethod.GET)
    public List<CustomerOrder> findAllcustomerOrders() {

        customerOrdersList = customerOrderService.findAllcustomerOrders();

        return customerOrdersList;
    }

    //Update Order Status using order id

    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus")
    //@RequestBody converts JSON format to java object
    //@PathVariable - identifies the path pattern used in URL for incoming data
    public void updateStatus(@RequestBody CustomerOrder status) {
        customerOrderService.updateStatus(status);
    }

    
    @RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("orderId") Integer orderId) {
//        System.out.println("=========== " + orderId);

//        customerOrderService.deleteOrder(orderId);

//        System.out.println("=========== " + message);
//        return message;
        return customerOrderService.deleteOrder(orderId);
    }

   
}
