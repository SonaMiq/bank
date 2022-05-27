package com.sonamik.bank.service;

import com.sonamik.bank.entity.Card;
import com.sonamik.bank.entity.CardHolder;
import com.sonamik.bank.entity.CardStatus;
import com.sonamik.bank.exeption.ResursNotFound;
import com.sonamik.bank.repo.CardHolderRepo;
import com.sonamik.bank.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepo cardRepo;
    @Autowired
    CardHolderRepo cardHolderRepo;

    public void createCard(long CHId, Card card) {
        Optional<CardHolder> cardHolder = cardHolderRepo.findById(CHId);
        if (cardHolder.isEmpty()) {
            throw new ResursNotFound("Card Holder with " + CHId + " not found");
        }

        card.setCardHolder(cardHolder.get());
        cardRepo.save(card);
    }

    public Card findCardById(long id) {
        return cardRepo.findById(id).get();
    }

    public void activateCard(Long id) {
        Card card = cardRepo.findById(id).get();
        card.setStatus(CardStatus.ACTIVE);
        cardRepo.save(card);
    }

    public void blockCard(Long id) {
        Card card = cardRepo.findById(id).get();
        card.setStatus(CardStatus.BLOCKED);
        cardRepo.save(card);
    }
    public void delete(Long id){
        cardRepo.delete(cardRepo.findById(id).get());

    }
}
