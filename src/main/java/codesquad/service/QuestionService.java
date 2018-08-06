package codesquad.service;

import codesquad.domain.Question;
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

    public Question show(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 질문이 존재하지 않습니다."));
    }
}
