package codesquad.dto;

import codesquad.domain.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QuestionDto {

    private String title;
    private String contents;

    public QuestionDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public QuestionDto toDto(Question savedQuestion) {
        this.title = savedQuestion.getTitle();
        this.contents = savedQuestion.getContents();
        return this;
    }

    public Question toQuestion() {
        Question newQuestion = new Question(title, contents);
        return newQuestion;
    }

}
