package com.sonamik.bank.controller;

import com.sonamik.bank.entity.Card;
import com.sonamik.bank.entity.CardHolder;
import com.sonamik.bank.service.CardHolderService;
import com.sonamik.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/cardHolder")
public class CardHolderController {

    @Autowired
    CardHolderService cardHolderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCardHolderController(@Valid @RequestBody CardHolder cardHolder){
        cardHolderService.create(cardHolder);
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public CardHolder getCardHolder(@PathVariable("id")Long id){
       return cardHolderService.findCardHolder(id);
    }
    @GetMapping ("/cards/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Set<Card> getAllCards(@PathVariable("id")Long id){
        return cardHolderService.findCardsByCardHolder(id);
    }
}
