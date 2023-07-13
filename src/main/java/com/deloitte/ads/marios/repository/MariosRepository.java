package com.deloitte.ads.marios.repository;

import com.deloitte.ads.marios.entity.Marios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MariosRepository extends CrudRepository<Marios, Long> {

}
