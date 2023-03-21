package TransparentDeveloper.backend.websocket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    String sender; //송신자
    String content; //메시지 내용
    String chatRoomId; //채팅 id

    public Message(){}
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }
}
