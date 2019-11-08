package com.beerasta.web.rest;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.service.ItemService;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserResource {

    private final UserService userService;
    private final ItemService itemService;

    @GetMapping("/booked")
    public ResponseEntity<Object> getBookedItems(@RequestParam("username") String username) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        return ResponseEntity.ok(itemService.getBookedItems(user));
    }

    @GetMapping("/personal")
    public ResponseEntity<Object> getPersonalItems(@RequestParam("username") String username) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        return ResponseEntity.ok(itemService.getPersonalItems(user));
    }

    @DeleteMapping("/booked")
    public ResponseEntity<Object> deleteBookedItem(@RequestParam("username") String username,
                                                   @RequestParam("itemId") Long itemId) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        Item result = itemService.deleteBookedItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/personal")
    public ResponseEntity<Object> deletePersonalItem(@RequestParam("username") String username,
                                                     @RequestParam("itemId") Long itemId) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        Item result = itemService.deletePersonalItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/booked")
    public ResponseEntity<Object> addBookedItem(@RequestParam("username") String username,
                                                @RequestParam("itemId") Long itemId) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        Item result = itemService.addBookedItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/personal")
    public ResponseEntity<Object> addPersonalItem(@RequestParam("username") String username,
                                                  @RequestBody Item item) throws NotFoundException {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        Item result = itemService.addPersonalItem(user, item);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

}
