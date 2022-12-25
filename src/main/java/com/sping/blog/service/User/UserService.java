package com.sping.blog.service.User;

import com.sping.blog.dto.User.UserFormDTO;
import com.sping.blog.entity.User;
import com.sping.blog.repository.User.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User joinUser(UserFormDTO userFormDTO) {
        User user = new User();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        log.info("helo");
        user.setPassword(passwordEncoder.encode(userFormDTO.getPassword()));
        user.setName(userFormDTO.getName());
        user.setNickname(userFormDTO.getNickname());
        user.setEmail(userFormDTO.getEmail());
        user.setPhone(userFormDTO.getPhone());

        userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User getById(Long id) {
        return userRepository.findById(id);
    }

    public User userDelete(Long id) {
        User user = getById(id);
        if (user == null) {
          return null;
        }
        userRepository.deleteUser(user);
        return user;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        }
        log.info("not found by email");
        return null;
    }
}
