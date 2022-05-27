package com.sonamik.bank.repo;

import com.sonamik.bank.entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuerRepo extends JpaRepository<Issuer,Long> {
}
