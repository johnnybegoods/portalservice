/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
public interface ItemResource {
    // Example: Returning more than one Item
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    List<Item> getItems();
}