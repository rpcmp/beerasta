package com.beerasta.service;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.repository.ItemRepository;
import com.beerasta.repository.specificaion.ItemSpecification;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems(String name,
                                  Integer levelAlco,
                                  String time,
                                  User user) {
        ItemSpecification itemSpecification = new ItemSpecification()
                .setLevelAlco(levelAlco)
                .setName(name)
                .setTime(time);
        List<Item> removeList = new ArrayList<>();
        List<Item> items = itemRepository.findAll(itemSpecification);
        items.forEach(i -> {
            if (i.getVisitors().stream().anyMatch(v -> v.equals(user))) {
                removeList.add(i);
            }
        });
        items.removeAll(removeList);
        return items;
    }

    public List<Item> getAllItemsByUser() {
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No item with id " + id));
    }

}
