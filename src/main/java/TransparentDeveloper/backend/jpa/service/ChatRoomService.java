package TransparentDeveloper.backend.jpa.service;

import TransparentDeveloper.backend.jpa.domain.Chat;
import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import TransparentDeveloper.backend.jpa.repository.ChatRepository;
import TransparentDeveloper.backend.jpa.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    /*
     * ChatRoom 개설
     */
    @Transactional
    public void createChatRoom(ChatRoom chatRoom){
        chatRoomRepository.save(chatRoom);
    }

    /*
     * ChatRoom 리스트 조회
     */
    public List<ChatRoom> findChatRoomAll(){
        return chatRoomRepository.findAll();
    }

    /*
     * ChatRoom 삭제
     */
    public void deleteChatRoom(Long chatRoomId){
        ChatRoom chatRoom = chatRoomRepository.find(chatRoomId);
        if (chatRoom == null){
            log.info("안된다.");
        }
        else{
            log.info("good");
        }
        chatRoomRepository.remove(chatRoom);
    }
}
