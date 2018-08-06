package codesquad.controller;

import codesquad.dto.QuestionDto;
import codesquad.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
