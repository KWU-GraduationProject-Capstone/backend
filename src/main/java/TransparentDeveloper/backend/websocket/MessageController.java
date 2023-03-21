package TransparentDeveloper.backend.websocket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void chatting(Message message) throws Exception{
        String sender = message.getSender();
        String content = message.getContent();
        String chatRoomId = message.getChatRoomId();

        log.info("sender={}",sender);
        log.info("content={}",content);
        log.info("chatting_id={}",chatRoomId);

        // sender,content,chatting_id 가 중 하나라도 없으면 씹음.
        if(sender.isEmpty() && content.isEmpty() && chatRoomId.isEmpty())
            return;

        // * 여기에 저장 로직을 넣을 거임 ㅋㅋ.

        simpMessagingTemplate.convertAndSend(
                "/sub/"+chatRoomId,
                new Message(sender,content)
        );
    }

}
