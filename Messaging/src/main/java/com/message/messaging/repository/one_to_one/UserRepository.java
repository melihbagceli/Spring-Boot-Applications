package com.message.messaging.repository.one_to_one;

import com.message.messaging.entity_deneme.one_to_one.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
