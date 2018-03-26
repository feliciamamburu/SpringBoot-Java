/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.exceptions;

/**
 *
 * @author User
 */
public class DataNotFoundException extends RuntimeException{
    
      private static final long serialVersionUID = 1L;
    
    public DataNotFoundException(String message)
    {
        super(message);
    }
} // end of code

