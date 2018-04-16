
package com.netflorist.RestController;

import com.netflorist.Model.BankDetail;
import com.netflorist.Service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
public class BankingController {
    
    @Autowired
    BankingService bankService;
    
    @RequestMapping(value="/bank",method=RequestMethod.POST)
    public void placeBANK(@RequestBody BankDetail bankID){
        bankService.saveBank(bankID);
    }
     
    @RequestMapping(method = RequestMethod.GET, value = "/pay",produces = {MediaType.APPLICATION_JSON_VALUE})
    public BankDetail accessBank(@RequestParam String bankType,String accNo, String pin) {
        return bankService.pay(bankType,accNo, pin);
    }
}
