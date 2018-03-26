
package com.netflorist.Service;

import com.netflorist.Model.BankDetails;
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
    
    
    public void saveBank(BankDetails bankD){
        bankDRep.save(bankD);
    }
    
    private static List<BankDetails> banks;
    
    public List<BankDetails> findAll(){
        banks = new ArrayList<>();
      bankDRep.findAll().forEach(banks::add);
      return banks;
    }
    
    public BankDetails pay(String bankType,String accNo, String pin)
    {
        BankDetails bank = null;
        List<BankDetails> bankList = findAll();
        for(int i = 0 ; i < bankList.size() ; i++)
        {
           if(bankList.get(i).getBankType().equalsIgnoreCase(bankType) && bankList.get(i).getAccNo().equalsIgnoreCase(accNo) && bankList.get(i).getSecretPin().equals(pin)){
               bank = bankList.get(i);
               break;
           }else{
               
           }
        }
        return bank;
    }
}


