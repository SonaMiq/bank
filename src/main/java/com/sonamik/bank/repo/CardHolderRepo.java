package com.sonamik.bank.repo;

import com.sonamik.bank.entity.Card;
import com.sonamik.bank.entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CardHolderRepo extends JpaRepository<CardHolder,Long> {

}
