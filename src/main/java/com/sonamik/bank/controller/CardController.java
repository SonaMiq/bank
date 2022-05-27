package com.sonamik.bank.controller;

import com.sonamik.bank.entity.Card;
import com.sonamik.bank.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/card")
public class CardController {

   private final CardService cardService;

   CardController(CardService cardService){
       this.cardService=cardService;
   }

   @PostMapping({"/new/{cardHolderID}"})
   @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@PathVariable("cardHolderID")Long CHId,@Valid  @RequestBody Card card){

       cardService.createCard(CHId,card);
    }

    @GetMapping({"/get/{id}"})
    @ResponseStatus(HttpStatus.FOUND)
    public Card getCard(@PathVariable("id")Long id){
      return cardService.findCardById(id);
    }
    @PostMapping("/active/{id}")
    public void activateCard(@PathVariable("id")Long id){
       cardService.activateCard(id);
    }
    @PostMapping("/block/{id}")
    public void blockCard(@PathVariable("id")Long id){
        cardService.blockCard(id);
    }
    @DeleteMapping({"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){cardService.delete(id);}
}

