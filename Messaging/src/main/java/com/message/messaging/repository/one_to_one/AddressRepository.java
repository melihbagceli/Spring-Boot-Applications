package com.message.messaging.repository.one_to_one;

import com.message.messaging.entity_deneme.one_to_one.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
    Address save(Address address);
}
