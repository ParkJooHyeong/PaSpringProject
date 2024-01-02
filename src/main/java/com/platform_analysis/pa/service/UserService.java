package com.platform_analysis.pa.service;
import com.platform_analysis.pa.model.UserDataEntity;
import com.platform_analysis.pa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDataEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserDataEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void createUser(UserDataEntity user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, UserDataEntity updatedUser) {
        Optional<UserDataEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserDataEntity user = optionalUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            userRepository.save(user);
        }
        // id에 해당하는 사용자가 없으면 예외 처리 또는 다른 작업 수행
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
