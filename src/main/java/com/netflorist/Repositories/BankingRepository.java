
package com.netflorist.Repositories;

import com.netflorist.Model.BankDetails;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 
 */
public interface BankingRepository extends CrudRepository<BankDetails, Long>{
     // @Query - Used when I want to generate my own query
	@Query("SELECT l FROM BankDetails l WHERE l.bankDetailId = :bankDetailId")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<BankDetails> findByBankDetailId(@Param("bankDetailId") int bankDetailId);
}
