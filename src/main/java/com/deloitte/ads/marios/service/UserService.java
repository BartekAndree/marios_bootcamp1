package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.dto.UserDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void init(){
        User u1 = new User(1L, "Bartek", "Andree");
        User u2 = new User(2L, "Kinga", "Banach");
        User u3 = new User(3L, "Mateusz", "Zwierzlak");
        User u4 = new User(4L, "Bartek", "Szymanski");
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);
    }

    public void addUser(UserDTO userDTO) {
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null) {
            User user = new User(userDTO.getFirstName(), userDTO.getLastName());
            userRepository.save(user);
        }
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Marios> getUserReceivedMarios(Long userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.getReceivedMarios();
        }
        return null;
    }

    public List<Marios> getUserGivenMarios(Long userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.getGivenMarios();
        }
        return null;
    }

    public List<Marios> getUserAllMarios(Long userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.getGivenMarios();
        }
        return null;
    }

    public User findUserById(Long senderId) {
        Optional<User> user = userRepository.findById(senderId);
        return user.orElse(null);
    }
}
