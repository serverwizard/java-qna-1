package codesquad.web;

import codesquad.domain.Answer;
import codesquad.domain.User;
import codesquad.service.AnswerService;
import codesquad.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("")
    public String create(@PathVariable Long questionId, Answer newAnswer, HttpSession session) {
        User loginUser = (User) SessionUtils.getSessionedUser(session);
        if(loginUser == null)
            throw new IllegalArgumentException();

        answerService.create(questionId, newAnswer);
        return String.format("redirect:/questions/%d", questionId);
    }
}