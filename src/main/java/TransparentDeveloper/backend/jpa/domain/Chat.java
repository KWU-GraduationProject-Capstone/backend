package TransparentDeveloper.backend.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chat {
    @Id @GeneratedValue
    @Column(name = "chat_id")
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    // 추후에 Member table로 빼야한다.
    private String sender;

    public Chat(String content, String sender, ChatRoom chatRoom) {
        this.content = content;
        this.sender = sender;
        setChatRoom(chatRoom);
    }

    public Chat() {
    }

    // 연관관계 메서드
    private void setChatRoom(ChatRoom chatRoom){
        this.chatRoom = chatRoom;
        chatRoom.getChats().add(this);
    }
}
