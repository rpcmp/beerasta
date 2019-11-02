package com.beerasta.web.rest;

import com.beerasta.domain.User;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    @GetMapping("/booked")
    public ResponseEntity<Object> getBookedItems(@AuthenticationPrincipal UserDetails userDetails) throws NotFoundException {
        return ResponseEntity.ok(userService.getBookedItems(userDetails.getUsername()));
    }

    @GetMapping("/personal")
    public ResponseEntity<Object> getPersonalItems(@AuthenticationPrincipal UserDetails userDetails) throws NotFoundException {
        return ResponseEntity.ok(userService.getPersonalItems(userDetails.getUsername()));
    }

    @DeleteMapping("/booked")
    public ResponseEntity<Object> deleteBookedItem(@AuthenticationPrincipal UserDetails userDetails,
                                                   @RequestParam Long itemId) throws NotFoundException {
        User user = userService.findByUsername(userDetails.getUsername());
        log.info(user.toString());
        User result = userService.deleteBookedItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/personal")
    public ResponseEntity<Object> deletePersonalItem(@AuthenticationPrincipal UserDetails userDetails,
                                                     @RequestParam Long itemId) throws NotFoundException {
        User user = userService.findByUsername(userDetails.getUsername());
        log.info(user.toString());
        User result = userService.deletePersonalItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/booked")
    public ResponseEntity<Object> addBookedItem(@AuthenticationPrincipal UserDetails userDetails,
                                                @RequestParam Long itemId) throws NotFoundException {
        User user = userService.findByUsername(userDetails.getUsername());
        log.info(user.toString());
        User result = userService.addBookedItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/personal")
    public ResponseEntity<Object> addPersonalItem(@AuthenticationPrincipal UserDetails userDetails,
                                                  @RequestParam Long itemId) throws NotFoundException {
        User user = userService.findByUsername(userDetails.getUsername());
        log.info(user.toString());
        User result = userService.addPersonalItem(user, itemId);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

}
