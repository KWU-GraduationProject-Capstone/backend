package TransparentDeveloper.backend.jpa.repository;


import TransparentDeveloper.backend.jpa.domain.Chat;
import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatRepositoryTest {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testFindAll(){
        ChatRoom chatRoom = new ChatRoom("롤 5인팟 구해요..");
        chatRoomRepository.save(chatRoom);

        Chat chat1 = new Chat("어? 저요","익명1",chatRoom);
        Chat chat2 = new Chat("저랑 해요","익명1",chatRoom);
        Chat chat3 = new Chat("님 티어요","익명2",chatRoom);
        Chat chat4 = new Chat("티어? 실번데 전전 시즌 골드였음","익명1",chatRoom);
        Chat chat5 = new Chat("꺼지세염..","익명2",chatRoom);

        chatRepository.save(chat1);
        chatRepository.save(chat2);
        chatRepository.save(chat3);
        chatRepository.save(chat4);
        chatRepository.save(chat5);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testFindAll2(){
        ChatRoom chatRoom = new ChatRoom("산책 갈 사람 1/3");
        chatRoomRepository.save(chatRoom);

        Chat chat1 = new Chat("가고싶어요","익명1",chatRoom);
        Chat chat2 = new Chat("진짜 갈거에요?","익명2",chatRoom);
        Chat chat3 = new Chat("네!!","익명1",chatRoom);
        Chat chat4 = new Chat("1시간 걸릴수도 있어요","익명2",chatRoom);
        Chat chat5 = new Chat("안가요~","익명1",chatRoom);
        Chat chat6 = new Chat("...","익명2",chatRoom);
        Chat chat7 = new Chat("장난 장난 ㅋㅋ","익명1",chatRoom);
        Chat chat8 = new Chat("갑니다.","익명2",chatRoom);

        chatRepository.save(chat1);
        chatRepository.save(chat2);
        chatRepository.save(chat3);
        chatRepository.save(chat4);
        chatRepository.save(chat5);
        chatRepository.save(chat6);
        chatRepository.save(chat7);
        chatRepository.save(chat8);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testFindAll3(){
        ChatRoom chatRoom = new ChatRoom("데이트 할 사람 구함ㅋㅋ");
        chatRoomRepository.save(chatRoom);

        Chat chat1 = new Chat("저요!!","익명1",chatRoom);
        Chat chat2 = new Chat("님 남자?","익명2",chatRoom);
        Chat chat3 = new Chat("ㅇㅇ 님 여자?","익명1",chatRoom);
        Chat chat4 = new Chat("남자!","익명2",chatRoom);
        Chat chat5 = new Chat("ㅅㄱ","익명1",chatRoom);

        chatRepository.save(chat1);
        chatRepository.save(chat2);
        chatRepository.save(chat3);
        chatRepository.save(chat4);
        chatRepository.save(chat5);

    }
}