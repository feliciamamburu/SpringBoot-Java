/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Service;

import com.netflorist.Repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class StatusService {
    
    
      @Autowired
    private StatusRepository orderStatusRepository;
    
    public Object findAllStatus()
    {
        return orderStatusRepository.findAll();
    }  

} // end of code
