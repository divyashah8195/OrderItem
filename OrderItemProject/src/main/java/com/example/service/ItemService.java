package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.exception.ItemNotFoundException;
import com.example.repository.ItemRepository;


@Service
public class ItemService {

	    @Autowired
	    private ItemRepository itemRepository;

	    public Item createItem(Item item) {
	        return itemRepository.save(item);
	    }

	    public List<Item> getAllItems() {
	        return itemRepository.findAll();
	    }

	    public Item getItemById(Long itemId) {
	        return itemRepository.findById(itemId)
	                .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + itemId));
	    }
	

}
