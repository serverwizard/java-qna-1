package codesquad.service;

import codesquad.domain.Answer;
import codesquad.domain.AnswerRepository;
import codesquad.domain.Question;
import codesquad.domain.QuestionRepository;
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
        newAnswer.setQuestion(savedQuestion);
        answerRepository.save(newAnswer);
    }
}
