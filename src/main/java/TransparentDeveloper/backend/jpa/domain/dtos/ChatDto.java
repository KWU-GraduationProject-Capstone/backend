package TransparentDeveloper.backend.jpa.domain.dtos;

import TransparentDeveloper.backend.jpa.domain.Chat;
import lombok.Data;

@Data
public class ChatDto {
    private String sender;
    private String content;

    public ChatDto(Chat chat) {
        this.sender = chat.getSender();
        this.content = chat.getContent();
    }
}
