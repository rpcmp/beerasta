package com.beerasta.service;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.repository.ItemRepository;
import com.beerasta.repository.specificaion.ItemSpecification;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems(String name,
                                  Integer levelAlco,
                                  String time) {
        ItemSpecification itemSpecification = new ItemSpecification()
                .setLevelAlco(levelAlco)
                .setName(name)
                .setTime(time);
        return itemRepository.findAll(itemSpecification);
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No item with id " + id));
    }

    public Item deleteItem(Long id,
                           User user) {
        return itemRepository.deleteByIdAndUser(id, user);
    }

}
