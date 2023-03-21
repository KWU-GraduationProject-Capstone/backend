package TransparentDeveloper.backend.jpa.repository;

import TransparentDeveloper.backend.jpa.domain.Chat;
import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatRepository {
    @PersistenceContext
    EntityManager em;
    public Long save(Chat chat) {
        em.persist(chat);
        return chat.getId();
    }
    public List<Chat> findAll(Long chat_room_id) {
        return em.createQuery("select c from Chat c where c.chatRoom.id in :chat_room_id",Chat.class)
                .setParameter("chat_room_id",chat_room_id).getResultList();
    }
}
