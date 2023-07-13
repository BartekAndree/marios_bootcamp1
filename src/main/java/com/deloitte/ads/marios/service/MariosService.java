package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.repository.MariosRepository;
import com.deloitte.ads.marios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class MariosService {
    @Autowired
    private MariosRepository mariosRepository;
    @Autowired
    private UserRepository userRepository;


    public void init(){
        User u1 = userRepository.findById(1L).get();
        User u2 = userRepository.findById(1L).get();
        User u3 = userRepository.findById(1L).get();
        User u4 = userRepository.findById(1L).get();

        Marios m1 = new Marios(1L, "Good job", "You are the best", u1, u2);
        Marios m2 = new Marios(2L, "Thanks", "You are the best", u1, u3);
        Marios m3 = new Marios(3L, "Nice to have you", "You are the best", u1, u4);
        Marios m4 = new Marios(4L, "Good job", "You are the best", u2, u1);
        Marios m5 = new Marios(5L, "Thanks", "You are the best", u2, u3);
        mariosRepository.save(m1);
        mariosRepository.save(m2);
        mariosRepository.save(m3);
        mariosRepository.save(m4);
        mariosRepository.save(m5);
    }

    public void addMarios(MariosDTO mariosDTO) {
        Optional<User> sender = userRepository.findById(mariosDTO.getSenderId());
        Optional<User> receiver = userRepository.findById(mariosDTO.getReceiverId());

        if (sender.isPresent() && receiver.isPresent() && sender != receiver && mariosDTO.getType() != null) {
            Marios marios = new Marios(
                    mariosDTO.getType(),
                    mariosDTO.getComment(),
                    sender.get(),
                    receiver.get());
            sender.get().addGivenMarios(marios);
            receiver.get().addGivenMarios(marios);
            userRepository.save(sender.get());
            userRepository.save(receiver.get());
            mariosRepository.save(marios);
        }
    }

    public Iterable<Marios> getAllMarios() {
        return mariosRepository.findAll();
    }

    public Marios findMariosById(Long mariosId) {
        Optional<Marios> marios = mariosRepository.findById(mariosId);
        return marios.orElse(null);
    }
}
