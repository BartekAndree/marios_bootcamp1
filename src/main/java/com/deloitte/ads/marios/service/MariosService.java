package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.repository.MariosRepository;
import com.deloitte.ads.marios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MariosService {

    private final MariosRepository mariosRepository;
    private final UserRepository userRepository;

    @Autowired
    public MariosService(MariosRepository mariosRepository, UserRepository userRepository) {
        this.mariosRepository = mariosRepository;
        this.userRepository = userRepository;
    }

    public Marios findMariosById(Long mariosId) {
        Optional<Marios> marios = mariosRepository.findById(mariosId);
        return marios.orElse(null);
    }

    public Set<MariosDTO> getAllMarios() {
        Iterable<Marios> marios = mariosRepository.findAll();
        Set<MariosDTO> mariosSet = new HashSet<>();
        marios.forEach(mario -> mariosSet.add(MariosDTO.mariosEntityToMariosDTO(mario)));
        return mariosSet;
    }

    public void addMarios(MariosDTO mariosDTO) {
        Marios marios = new Marios();
        User sender = userRepository.findByUuid(mariosDTO.getSenderId()).orElse(null);
        User receiver = userRepository.findByUuid(mariosDTO.getReceiverId()).orElse(null);

        if (sender != null && receiver != null && sender != receiver) {
            marios.setType(mariosDTO.getType());
            marios.setComment(mariosDTO.getComment());
            marios.setSender(sender);
            marios.setReceiver(receiver);
            mariosRepository.save(marios);
        }
    }

    public void deleteMarios(Long mariosId) {
        Optional<Marios> marios = mariosRepository.findById(mariosId);
        marios.ifPresent(mariosRepository::delete);
    }

    public void addMariosByInitializer(Marios marios) {
        mariosRepository.save(marios);
    }
}
