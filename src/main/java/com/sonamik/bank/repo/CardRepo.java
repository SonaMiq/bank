package com.sonamik.bank.repo;

import com.sonamik.bank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.Set;

public interface CardRepo extends JpaRepository<Card,Long> {

     Optional<Card> findCardByCardNumber(String cardNumber);


    Set<Card> findCardByCardHolderId(Long cardHolderId);
}
