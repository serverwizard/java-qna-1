package codesquad.controller;

import codesquad.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public String home(Model model) {
        log.info("questionRepository.findAll() : {}", questionRepository.findAll());
        model.addAttribute("questions", questionRepository.findAll());
        return "/index";
    }
}
