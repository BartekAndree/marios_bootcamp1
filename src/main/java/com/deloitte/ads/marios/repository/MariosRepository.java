package com.deloitte.ads.marios.repository;

import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MariosRepository extends CrudRepository<Marios, Long> {

    List<Marios> findByReceiver(User user);

    List<Marios> findBySender(User user);

    List<Marios> findByReceiverOrSender(User receiver, User sender);
}
