/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.RestController;

import com.netflorist.Service.StatusService;
import com.netflorist.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class StatusController {
     @Autowired
      private StatusService orderStatusService;
     
      //gets order status
    @RequestMapping(method = RequestMethod.GET, value = "/findAllStatus")
    @ResponseBody
    public Object viewStatus()
    {
        Object object =  orderStatusService.findAllStatus();
        if(object == null)
        {
            throw new DataNotFoundException("Status could not be found!");
        }
        return object;
    }
     
}
