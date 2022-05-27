package com.sonamik.bank.repo;

import com.sonamik.bank.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
