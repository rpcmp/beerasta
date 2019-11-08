package com.beerasta.service;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.repository.ItemRepository;
import com.beerasta.repository.specificaion.ItemSpecification;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No item with id " + id));
    }

    public Item deleteBookedItem(User user,
                                 Long itemId) throws NotFoundException {
        Item item = itemRepository.findOne(itemId);
        log.info(item.toString());
        item.getVisitors().remove(user);
        itemRepository.save(item);
        return item;
    }

    public Item deletePersonalItem(User user, Long itemId) throws NotFoundException {
        return itemRepository.removeByOwnerAndId(user, itemId);
    }

    public List<Item> getBookedItems(User user) throws NotFoundException {
        log.info(user.toString());
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(i -> {
            if (i.getVisitors().stream().anyMatch(v -> v.equals(user))) {
                result.add(i);
            }
        });
        return result;
    }

    public List<Item> getPersonalItems(User user) throws NotFoundException {
        log.info(user.toString());
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(i -> {
            if (i.getOwner().equals(user)) {
                result.add(i);
            }
        });
        return result;
    }

    public Item addBookedItem(User user,
                              Long itemId) {
        Item item = itemRepository.findOne(itemId);
        item.getVisitors().add(user);
        log.info(item.toString());
        itemRepository.save(item);
        return item;
    }

    public Item addPersonalItem(User user,
                                Item item) {
        item.setOwner(user);
        return itemRepository.save(item);
    }

}
