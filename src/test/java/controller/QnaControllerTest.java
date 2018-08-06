package controller;

import codesquad.QnaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import support.HtmlFormDataBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {QnaApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QnaControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void 질문_목록_조회() {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("title", "제목")
                .addParameter("contents", "내용")
                .build();

        ResponseEntity<String> response = template.postForEntity("/questions", request, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FOUND);
        assertThat(response.getHeaders().getLocation().getPath()).startsWith("/");
    }
}
