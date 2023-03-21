package TransparentDeveloper.backend.jpa.repository;

import TransparentDeveloper.backend.jpa.domain.Chat;
import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Slf4j
public class ChatRoomRepository {
    @PersistenceContext
    EntityManager em;

    // 저장
    public Long save(ChatRoom chatRoom){
        em.persist(chatRoom);
        return chatRoom.getId();
    }

    // 채팅 리스트 조회
    // (추후에 MemberId 로 조회 ㄱㄱ)
    public List<ChatRoom> findAll(){
        return em.createQuery("select cr from ChatRoom cr",ChatRoom.class)
                .getResultList();
    }

    public ChatRoom find(Long chatRoomId){
        return em.find(ChatRoom.class, chatRoomId);
    }

    // 삭제
    public void remove(ChatRoom chatRoom){
        log.info("id={}",chatRoom.getId());
        log.info("title={}",chatRoom.getTitle());
        em.remove(chatRoom);
    }
}
