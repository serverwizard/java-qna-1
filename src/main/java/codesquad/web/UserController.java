package codesquad.web;

import codesquad.domain.User;
import codesquad.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public String create(User user) {
        log.info("user : {}", user);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/user/list";

    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "/user/profile";
    }

    @GetMapping("/users/{id}/form")
    public String update (@PathVariable Long id,
                        Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "/user/updateForm";
    }

    @Transactional // JPA의 변경감지를 위해 사용
    @PutMapping("/users/{id}/update")
    public String update(@PathVariable Long id,
                         User user) {
        User savedUser = userRepository.findById(id).get();
        savedUser.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/login")
    public String login() {
        return "/user/login";
    }

    @PostMapping("/users/login")
    public String login(String userId, String password, HttpSession session) {
        User user = userRepository.findByUserId(userId);
        user.login(userId, password);
        session.setAttribute("sessionedUser", user);
        return "redirect:/";
    }
}