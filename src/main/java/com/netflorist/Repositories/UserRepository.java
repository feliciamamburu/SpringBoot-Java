
package com.netflorist.Repositories;

import com.netflorist.Model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 
 */
public interface UserRepository extends CrudRepository<Users,Integer>{
    @Query("SELECT c from Users c where c.username = :username AND c.password = :password")
    public List<Users> findByUsernameAndPassword(String Username ,String password );
}
