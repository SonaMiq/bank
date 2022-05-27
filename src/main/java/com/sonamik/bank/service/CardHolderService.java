package com.sonamik.bank.service;

import com.sonamik.bank.entity.Card;
import com.sonamik.bank.entity.CardHolder;
import com.sonamik.bank.exeption.NotEnough;
import com.sonamik.bank.exeption.ResursNotFound;
import com.sonamik.bank.repo.CardHolderRepo;
import com.sonamik.bank.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;
import java.util.Set;

@Service
public class CardHolderService {
    @Autowired
    CardHolderRepo cardHolderRepo;
    @Autowired
    CardRepo cardRepo;

    public void create(CardHolder cardHolder) {
        cardHolderRepo.save(cardHolder);
    }

    public CardHolder findCardHolder(long id) {
        return cardHolderRepo.findById(id).get();
    }
    public Set<Card> findCardsByCardHolder(Long cardHolderID) {
        return cardRepo.findCardByCardHolderId(cardHolderID);
    }

    public void card2Card(long money, String cardNumberFrom, String cardNumberTo) {
        Optional<Card> cardFrom = cardRepo.findCardByCardNumber(cardNumberFrom);
        Optional<Card> cardTo=cardRepo.findCardByCardNumber(cardNumberTo);
        if(cardFrom.isEmpty()){
            throw new ResursNotFound(cardNumberFrom+" card number does not exist");
        }
        if(cardTo.isEmpty()){
            throw new ResursNotFound(cardNumberTo+" card number does not exist");
        }
        if(cardFrom.get().getBalance()<money){
            throw  new NotEnough("Balance not enough");
        }
        Card cardFr= cardFrom.get();
        Card cardT=cardTo.get();
        cardFr.setBalance(cardFr.getBalance()-money);
        cardT.setBalance(cardT.getBalance()+money);
    }
}
