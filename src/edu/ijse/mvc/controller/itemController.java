/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;


import edu.ijse.mvc.Dto.itemDto;
import edu.ijse.mvc.model.itemModel;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Umesh Induwara
 */
public class itemController {
     private final itemModel ITEM_MODEL;

    public itemController() {
        this.ITEM_MODEL = new itemModel();
    }
    
    public ArrayList<itemDto> getAllItems() throws SQLException, ClassNotFoundException{
        ArrayList<itemDto> itemDtos = ITEM_MODEL.getAll();
        return itemDtos;
    }
    
    public String saveItem(itemDto itemDto) throws SQLException, ClassNotFoundException{
        String resp = ITEM_MODEL.save(itemDto);
        return resp;
    }
    
    public String updateItem(itemDto itemDto) throws SQLException, ClassNotFoundException{
        String resp = ITEM_MODEL.Update(itemDto);
        return resp;
    }
    
     public itemDto searchItem(String itemCode) throws SQLException, ClassNotFoundException{
        itemDto dto = ITEM_MODEL.getItem(itemCode);
        return dto;
    }
     
     public String deleteItem(String itemCode) throws SQLException, ClassNotFoundException{
        String del = ITEM_MODEL.clearItem(itemCode);
        return del;
    }

}
