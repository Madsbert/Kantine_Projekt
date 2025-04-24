package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Items;
import org.example.kantine_projekt.Domains.Order;
import org.example.kantine_projekt.Foundation.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderDB implements OrderDBInterface {

    /**
     * Makes a new order
     * @return
     */
    @Override
    public void makeOrder(LocalDateTime dateTime) {
        String sp = "{call make_order(?)}";
        Connection conn = DBConnection.getConnection();
        try(CallableStatement cstmt = conn.prepareCall(sp)) {
            // Konverter LocalDateTime til SQL Timestamp
            Timestamp sqlTimestamp = Timestamp.valueOf(dateTime);
            cstmt.setTimestamp(1, sqlTimestamp);
            cstmt.execute();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("something went wrong in  makeOrder");
        }
    }

    /**
     *
     * @param order
     * @param item
     */
    @Override
    public void addItemToOrder(Order order, Items item) {
        //String sql = "Insert Into tblOrderItem (fldOrderID, fldItemID, fldQunatity) VALUES (?,?,?) ";
        Connection conn = DBConnection.getConnection();
        try {
          //  CallableStatement cstmt = conn.prepareCall(sql);
            //cstmt.setInt(1, Items.);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("something went wrong in  addItemToOrder");
        }

    }

    /**
     * Get an order via an ID
     * @param orderId
     * @return
     */
    @Override
    public Order getOrder(int orderId) {
        return null;
    }
}
