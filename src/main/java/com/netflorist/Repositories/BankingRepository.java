
package com.netflorist.Repositories;

import com.netflorist.Model.BankDetail;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 
 */
public interface BankingRepository extends CrudRepository<BankDetail, Long>{
     // @Query - Used when I want to generate my own query
	@Query("SELECT l FROM BankDetail l WHERE l.bankDetailId = :bankDetailId")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<BankDetail> findByBankDetailId(@Param("bankDetailId") int bankDetailId);
        public BankDetail findByBankDetailId(Integer deliveryId);
}
