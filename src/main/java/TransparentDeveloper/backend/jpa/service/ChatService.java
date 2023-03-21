package TransparentDeveloper.backend.jpa.service;

import TransparentDeveloper.backend.jpa.domain.Chat;
import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import TransparentDeveloper.backend.jpa.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    /*
     *한번에 Chat 을 저장
     */
    @Transactional
    public void saveChat(Chat... chats){
        for (Chat chat : chats) {
            chatRepository.save(chat);
        }
    }

    /*
     * 어떤 ChatRoom 과 관련된 Chat 한번에 조회하기
     */
    public List<Chat> findChatAllByChatRoomId(Long chatRoomId){
        return chatRepository.findAll(chatRoomId);
    }

}
