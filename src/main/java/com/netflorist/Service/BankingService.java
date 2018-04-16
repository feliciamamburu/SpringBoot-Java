
package com.netflorist.Service;

import com.netflorist.Model.BankDetail;
import com.netflorist.Repositories.BankingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class BankingService {
    
    @Autowired
    BankingRepository bankDRep;
    
    
    public void saveBank(BankDetail bankD){
        bankDRep.save(bankD);
    }
    
    private static List<BankDetail> banks;
    
    public List<BankDetail> findAll(){
        banks = new ArrayList<>();
      bankDRep.findAll().forEach(banks::add);
      return banks;
    }
    
    public BankDetail pay(String bankType,String accNo, String pin)
    {
        BankDetail bank = null;
        List<BankDetail> bankList = findAll();
        for(int i = 0 ; i < bankList.size() ; i++)
        {
           if(bankList.get(i).getBankType().equalsIgnoreCase(bankType) && bankList.get(i).getAccNo().equalsIgnoreCase(accNo) && bankList.get(i).pin().equals(pin)){
               bank = bankList.get(i);
               break;
           }else{
               
           }
        }
        return bank;
    }
}


