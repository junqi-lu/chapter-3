package com.example.chapter3.homework;

import java.util.ArrayList;

public class Item {

    private String title;

    public String getTitle() {
        return title;
    }

    public Item(String mtitle) {
        mtitle = title;
    }

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Item 1"));
        items.add(new Item("Item 2"));
        items.add(new Item("Item 3"));
        return items;
    }
}
