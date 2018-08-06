package codesquad.dto;

import codesquad.domain.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {

    private String title;
    private String contents;

    public QuestionDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Question toQuestion() {
        Question newQuestion = new Question(title, contents);
        return newQuestion;
    }

}
