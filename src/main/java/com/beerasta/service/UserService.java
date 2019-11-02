package com.beerasta.service;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.repository.UsersRepository;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final ItemService itemService;

    public User findByUsername(String userName) throws NotFoundException {
        return usersRepository.findByUsername(userName)
                .orElseThrow(() -> new NotFoundException("No user with username " + userName));
    }

    public User save(User user) {
        return usersRepository.save(user);
    }

    public List<Item> getBookedItems(String userName) throws NotFoundException {
        User user = findByUsername(userName);
        log.info(user.toString());
        return user.getBookedItems();
    }

    public List<Item> getPersonalItems(String userName) throws NotFoundException {
        User user = findByUsername(userName);
        log.info(user.toString());
        return user.getPersonalItems();
    }

    public User deleteBookedItem(User user, Long itemId) throws NotFoundException {
        Item item = itemService.getItemById(itemId);
        log.info(item.toString());
        List<Item> bookedItems = user.getBookedItems();
        bookedItems.remove(item);
        user.setBookedItems(bookedItems);
        return usersRepository.save(user);
    }

    public User deletePersonalItem(User user, Long itemId) throws NotFoundException {
        Item item = itemService.getItemById(itemId);
        log.info(item.toString());
        List<Item> personalItems = user.getPersonalItems();
        personalItems.remove(item);
        user.setPersonalItems(personalItems);
        return usersRepository.save(user);
    }

    public User addBookedItem(User user, Long itemId) {
        Item item = itemService.getItemById(itemId);
        log.info(item.toString());
        List<Item> bookedItems = user.getBookedItems();
        bookedItems.add(item);
        user.setBookedItems(bookedItems);
        return usersRepository.save(user);
    }

    public User addPersonalItem(User user, Long itemId) {
        Item item = itemService.getItemById(itemId);
        log.info(item.toString());
        List<Item> personalItems = user.getPersonalItems();
        personalItems.add(item);
        user.setPersonalItems(personalItems);
        return usersRepository.save(user);
    }
}
