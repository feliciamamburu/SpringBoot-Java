
package com.netflorist.Repositories;

import com.netflorist.Model.ProductsCopy;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author
 */

public interface ProductCopyRepository extends CrudRepository<ProductsCopy, Integer>{
       // @Query - Used when I want to generate my own query
	@Query("SELECT l FROM ProductsCopy l WHERE l.product_id = :product_id")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<ProductsCopy> viewByProductId(@Param("product_id") int product_id);

}
