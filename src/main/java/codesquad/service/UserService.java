package codesquad.service;

import codesquad.domain.User;
import codesquad.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional // JPA의 변경감지를 위해 사용
    public void update(User loginUser, User user, Long id) {
        User savedUser = userRepository.findById(id).get();
        savedUser.update(loginUser, user);
    }
}
