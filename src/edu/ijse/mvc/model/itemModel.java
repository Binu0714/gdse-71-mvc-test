/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;
import edu.ijse.mvc.Dto.itemDto;
import edu.ijse.mvc.db.DBConnection;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Umesh Induwara
 */
public class itemModel {

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
     public ArrayList<itemDto> getAll() throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<itemDto> itemDtos = new ArrayList<>();
        
        while(rst.next()){
            itemDto itemDto = new itemDto();
            itemDto.setItemCode(rst.getString("ItemCode"));
            itemDto.setDescription(rst.getString("Description"));
            itemDto.setPackSize(rst.getString("PackSize"));
            itemDto.setUnitPrice(rst.getDouble("UnitPrice"));
            itemDto.setQoh(rst.getInt("QtyOnHand"));
            
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
    
    public String save(itemDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getItemCode());
        statement.setString(2, dto.getDescription());
        statement.setString(3, dto.getPackSize());
        statement.setDouble(4, dto.getUnitPrice());
        statement.setInt(5, dto.getQoh());
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
        
    }
    
    public String Update(itemDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?";
         
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, dto.getDescription());
        statement.setString(2, dto.getPackSize());
        statement.setDouble(3, dto.getUnitPrice());
        statement.setInt(4, dto.getQoh());
        statement.setString(5, dto.getItemCode());
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
    }
    
     public itemDto getItem(String itemCode) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemCode);
        
        ResultSet rst = statement.executeQuery();
        
        if(rst.next()){
            itemDto itemDto = new itemDto();
            itemDto.setItemCode(rst.getString("ItemCode"));
            itemDto.setDescription(rst.getString("Description"));
            itemDto.setPackSize(rst.getString("PackSize"));
            itemDto.setUnitPrice(rst.getDouble("UnitPrice"));
            itemDto.setQoh(rst.getInt("QtyOnHand"));
            
            return itemDto;
        }
        return null;
    }
     
     public String clearItem(String itemCode) throws SQLException, ClassNotFoundException{
       Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemCode);

        int affectedRows = statement.executeUpdate();
        return affectedRows > 0 ? "Success" : "Fail";

   }

}
