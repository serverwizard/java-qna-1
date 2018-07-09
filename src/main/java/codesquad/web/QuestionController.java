package codesquad.web;

import codesquad.domain.Question;
import codesquad.domain.QuestionRepository;
import codesquad.domain.User;
import codesquad.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/questions")
    public String create(Question question, HttpSession session) {
        User loginUser = (User) session.getAttribute("sessionedUser");
        if (loginUser == null) {
            return "/user/login";
        }
        question.create(loginUser);
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/questions/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "/qna/show";
    }

    @GetMapping("/questions/{id}/form")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        return "/qna/updateForm";
    }


    @PutMapping("/questions/{id}")
    public String update(@PathVariable Long id, Question updatedQuestion, HttpSession session) {
        User loginUser = (User) session.getAttribute("sessionedUser");
        questionService.update(loginUser, updatedQuestion, id);
        return "redirect:/";
    }

    @DeleteMapping("/questions/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        User loginUser = (User) session.getAttribute("sessionedUser");
        if (loginUser == null) {
            return "/user/login";
        }
        questionService.delete(loginUser, id);
        return "redirect:/";
    }
}