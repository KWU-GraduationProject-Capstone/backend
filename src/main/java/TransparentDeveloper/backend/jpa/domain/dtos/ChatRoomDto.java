package TransparentDeveloper.backend.jpa.domain.dtos;

import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import lombok.Data;

@Data
public class ChatRoomDto {
    private Long id;
    private String title;
    public ChatRoomDto(ChatRoom chatRoom) {
        id = chatRoom.getId();
        title = chatRoom.getTitle();
    }
}
