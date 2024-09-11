/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.Dto.customerDto;
import edu.ijse.mvc.Dto.itemDto;
import edu.ijse.mvc.model.customerModel;
import java.util.ArrayList;
import java.sql.SQLException;


/**
 *
 * @author Umesh Induwara
 */
public class customerController {
    
    private final customerModel CUSTOMER_MODEL;

    public customerController() {
        this.CUSTOMER_MODEL = new customerModel();
    }

    public ArrayList<customerDto> getAllItems() throws SQLException, ClassNotFoundException{
        ArrayList<customerDto> customerDtos = CUSTOMER_MODEL.getAll();
        return customerDtos;
    }

    public String saveCustomer(customerDto customerDto) throws SQLException, ClassNotFoundException{
        String resp = CUSTOMER_MODEL.save(customerDto);
        return resp;
    }
    
    public String updateCustomer(customerDto customerDto) throws SQLException, ClassNotFoundException{
        String resp = CUSTOMER_MODEL.Update(customerDto);
        return resp;
    }
    
    public customerDto searchCustomer(String CustId) throws SQLException, ClassNotFoundException{
        customerDto dto = CUSTOMER_MODEL.getCustomer(CustId);
        return dto;
    }
    
    public String deleteCustomer(String CustId) throws SQLException, ClassNotFoundException{
        String del = CUSTOMER_MODEL.clearCustomer(CustId);
        return del;
    }

   
}
