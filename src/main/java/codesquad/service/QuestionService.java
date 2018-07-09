package codesquad.service;

import codesquad.domain.Question;
import codesquad.domain.QuestionRepository;
import codesquad.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public void update(User loginUser, Question updatedQuestion, Long id) {
        Question question = questionRepository.findById(id).get();
        question.update(loginUser, updatedQuestion);
    }

    @Transactional
    public void delete(User loginUser, Long id) {
        Question question = questionRepository.findById(id).get();
        question.delete(loginUser);
    }
}
