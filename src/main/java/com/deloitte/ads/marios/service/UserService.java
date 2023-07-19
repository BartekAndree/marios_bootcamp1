package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.dto.PublicUserDTO;
import com.deloitte.ads.marios.dto.UserDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.repository.MariosRepository;
import com.deloitte.ads.marios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MariosRepository mariosRepository;

    @Autowired
    public UserService(UserRepository userRepository, MariosRepository mariosRepository) {
        this.userRepository = userRepository;
        this.mariosRepository = mariosRepository;
    }

    public User findUserByUuid(UUID userUuid) {
        Optional<User> user = userRepository.findByUuid(userUuid);
        return user.orElse(null);
    }

    public UserDTO showUser(UUID userUuid) {
        User user = findUserByUuid(userUuid);
        if (user != null) {
            return new UserDTO(user.getFirstName(), user.getLastName(), user.getUuid(), user.getEmail(), user.getUserName());
        }
        return null;
    }

    public Set<PublicUserDTO> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        Set<PublicUserDTO> userSet = new HashSet<>();
        users.forEach(user -> userSet.add(new PublicUserDTO(user.getUuid(), user.getUserName())));
        return userSet;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        Optional<User> user1 = userRepository.findByUserName(userDTO.getUserName());
        if (userDTO.getFirstName() != null
                && userDTO.getLastName() != null
                && validateEmail(userDTO.getEmail())
                && userDTO.getUserName() != null
                && user1.isEmpty()) {
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserName());
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);
        }
        Optional<User> userCreated = userRepository.findByUserName(userDTO.getUserName());
        return userCreated.orElse(null);
    }

    public void deleteUser(UUID userUuid) {
        Optional<User> user = userRepository.findByUuid(userUuid);
        user.ifPresent(userRepository::delete);
    }

    public List<MariosDTO> getUserReceivedMarios(UUID userUuid) {
        User user = findUserByUuid(userUuid);
        List<Marios> marios = mariosRepository.findByReceiver(user);
        List<MariosDTO> mariosDTOList = new ArrayList<>();
        marios.forEach(mario -> mariosDTOList.add(MariosDTO.mariosEntityToMariosDTO(mario)));
        return mariosDTOList;
    }

    public List<MariosDTO> getUserGivenMarios(UUID userUuid) {
        User user = findUserByUuid(userUuid);
        List<Marios> marios = mariosRepository.findBySender(user);
        List<MariosDTO> mariosDTOList = new ArrayList<>();
        marios.forEach(mario -> mariosDTOList.add(MariosDTO.mariosEntityToMariosDTO(mario)));
        return mariosDTOList;
    }

    public List<MariosDTO> getUserAllMarios(UUID userUuid) {
        User user = findUserByUuid(userUuid);
        List<Marios> marios = mariosRepository.findByReceiverOrSender(user, user);
        List<MariosDTO> mariosDTOList = new ArrayList<>();
        marios.forEach(mario -> mariosDTOList.add(MariosDTO.mariosEntityToMariosDTO(mario)));
        return mariosDTOList;
    }


    private boolean validateEmail(String email) {
        return Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$").matcher(email).matches();
    }

    public void addMariosByInitializer(User user) {
        userRepository.save(user);
    }
}
