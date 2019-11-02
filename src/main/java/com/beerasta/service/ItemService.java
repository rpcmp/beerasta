package com.beerasta.service;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.repository.ItemRepository;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllByUserId(User user) throws NotFoundException {
        return itemRepository.findByUser(user);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No item with id " + id));
    }

}
