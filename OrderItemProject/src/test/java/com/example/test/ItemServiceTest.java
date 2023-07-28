package com.example.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.Item;
import com.example.exception.ItemNotFoundException;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testGetItemById_Success() {
        Long itemId = 1L;
        Item item = new Item();
        item.setItemId(itemId);
        when(itemRepository.findById(itemId)).thenReturn(Optional.of(item));

        Item result = itemService.getItemById(itemId);

        assertNotNull(result);
        assertEquals(itemId, result.getItemId());
        verify(itemRepository, times(1)).findById(itemId);
    }

    @Test
    public void testGetItemById_ItemNotFound() {
        Long itemId = 2L;
        when(itemRepository.findById(itemId)).thenReturn(Optional.empty());

        assertThrows(ItemNotFoundException.class, () -> itemService.getItemById(itemId));

        verify(itemRepository, times(1)).findById(itemId);
    }

   
}

