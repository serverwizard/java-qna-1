package domain;

import codesquad.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    /**
     * done
     * 회원정보_업데이트_비밀번호_일치
     * 회원정보_업데이트_비밀번호_불일치
     */

    @Test
    public void 회원정보_업데이트_비밀번호_일치() {
        User savedUser = new User("javajigi", "test", "슈퍼캡", "javajigi@slipp.net");
        User inputUser = new User("javajigi", "test", "캡", "javajigi@slipp.net");

        savedUser.update(inputUser);

        assertThat(savedUser.getName()).isEqualTo(inputUser.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void 회원정보_업데이트_비밀번호_불일치() {
        User savedUser = new User("javajigi", "test", "슈퍼캡", "javajigi@slipp.net");
        User inputUser = new User("javajigi", "test1", "캡", "javajigi@slipp.net");

        savedUser.update(inputUser);

        assertThat(savedUser.getName()).isEqualTo(inputUser.getName());
    }
}

