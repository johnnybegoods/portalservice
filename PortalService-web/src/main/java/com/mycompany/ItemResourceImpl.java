/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.Item;
import com.mycompany.ItemResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;
 
// Set the path, version 1 of API
@Path("/v1/item")
public class ItemResourceImpl implements ItemResource{
 
    public List<Item> getItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(100, "Widget", "A basic widget"));
        items.add(new Item(200, "SuperWidget", "A super widget"));
        items.add(new Item(300, "UberSuperWidget", "A uber super widget"));
 
        return items;
    }
}