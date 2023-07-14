package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.dto.UserDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.repository.MariosRepository;
import com.deloitte.ads.marios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private MariosRepository mariosRepository;
    @Autowired
    public UserService(UserRepository userRepository, MariosRepository mariosRepository) {
        this.userRepository = userRepository;
        this.mariosRepository = mariosRepository;
    }

    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }
    public Set<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        Set<User> userSet = new HashSet<>();
        users.forEach(userSet::add);
        return userSet;
    }
    public void addUser(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null) {
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            userRepository.save(user);
        }
    }

    public List<Marios> getUserReceivedMarios(Long userId) {
        User user = findUserById(userId);
        return mariosRepository.findByReceiver(user);
    }
    public List<Marios> getUserGivenMarios(Long userId) {
        User user = findUserById(userId);
        return mariosRepository.findBySender(user);
    }
    public List<Marios> getUserAllMarios(Long userId) {
        User user = findUserById(userId);
        return mariosRepository.findByReceiverOrSender(user, user);
    }
    public void addMariosByInitializer(User user) {
        userRepository.save(user);
    }
}