package com.web;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by KimYJ on 2017-07-12.
 */
@RunWith(SpringRunner.class) //@RunWtih 어노테이션을 사용하면 JUnit에 내장 된 러너를 사용하는 대신 어노테이션에 정의된 클래스를 호출합니다. 또한, JUnit의 확장기능을 지정하여 각각의 테스트시 독립적인 어플리케이션 컨텍스트 보장합니다.
@DataJpaTest //스프링 부트에서 JPA 테스트위한 전영 어노테이션, 첫 설계시 엔티티간의 관계 설정 및 기능 테스트를 가능하게 도와준다. 또한, 단위 테스트가 끝날때 마다 자동 롤백을 해주어 한 층 편리한 JPA 테스트가 가능
public class JpaMappingTest {
    private final String boardTestTitle = "테스트";
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;


    @Before //테스트 진행전 실행될 메소드 지정
    public void init() {
        User user = userRepository.save(User.builder()
                .name("havi")
                .password("test")
                .email(email)
                .createdDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title(boardTestTitle)
                .subTitle("서브 타이틀")
                .content("컨텐츠")
                .boardType(BoardType.free)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .user(user).build());
    }

    @Test //실제 테스트가 진행될 메소드를 지정
    public void 제대로_생성_됐는지_테스트() {
        User user = userRepository.findByEmail(email); //init()에서 저장된 user의 email로 검색
        assertThat(user.getName(), is("havi")); //각각의 필드들이 저장된 값과 실제로 일치하는지 검사
        assertThat(user.getPassword(), is("test"));
        assertThat(user.getEmail(), is(email));

        Board board = boardRepository.findByTitle(boardTestTitle); //init()에서 저장된 board의 테스트용 제목을 사용하여 검색
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getSubTitle(), is("서브 타이틀"));
        assertThat(board.getContent(), is("컨텐츠"));
        assertThat(board.getBoardType(), is(BoardType.free));
    }

}
