package codesquad.service;

import codesquad.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AnswerService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public void create(Long questionId, Answer newAnswer) {
        Question savedQuestion = questionRepository.findById(questionId).get();
        savedQuestion.createAnswer(newAnswer);
//        answerRepository.save(newAnswer);
    }

    @Transactional
    public void delete(User loginUser, Long id) {
        Answer savedAnswer = answerRepository.findById(id).get();
        savedAnswer.delete(loginUser);
        answerRepository.delete(savedAnswer);
    }
}
