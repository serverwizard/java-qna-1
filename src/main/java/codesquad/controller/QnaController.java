package codesquad.controller;

import codesquad.domain.Question;
import codesquad.dto.QuestionDto;
import codesquad.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public String create(QuestionDto questionDto) {
        questionService.save(questionDto);
        return "redirect:/";
    }

    @GetMapping("/questions/{id}")
    public String show(@PathVariable Long id, Model model) {
        Question savedQuestion = questionService.show(id);

        QuestionDto questionDto = new QuestionDto();
        model.addAttribute("questionDto", questionDto.toDto(savedQuestion));
        log.info("questionDto.toDto(savedQuestion) : {}", questionDto.toDto(savedQuestion));
        return "/qna/show";
    }
}
