
package com.netflorist.Service;

import com.netflorist.Model.Users;
import com.netflorist.Repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository useRepo;
    
    public void addUser(Users use){
        useRepo.save(use);
    }
    
    
    public List<Users> getUsers(){
        List<Users> use = new ArrayList<>();
        useRepo.findAll().forEach(use::add);
        return use;
    }
    
    public Users login(String username,String password){
        Users user =  null;
        String status = null;
          List<Users> users = getUsers();
          for(int i = 0;i< users.size();i++){
              if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
                  status = "You have successfully Logged In";
                  user = users.get(i);
                  break;
              }else{
                  status = "Invalid Credentials";
              }
          }
          return user;
    }
     
    
}
