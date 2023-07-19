package com.deloitte.ads.marios.repository;

import com.deloitte.ads.marios.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);

    Optional<User> findByUuid(UUID uuid);
}
