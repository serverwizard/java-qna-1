package codesquad.service;

import codesquad.dto.QuestionDto;
import codesquad.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public void save(QuestionDto questionDto) {
        questionRepository.save(questionDto.toQuestion());
    }
}
