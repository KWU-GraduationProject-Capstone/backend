package TransparentDeveloper.backend.jpa.domain.dtos;

import TransparentDeveloper.backend.jpa.domain.Chat;
import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatRoomDetailDto {
    private Long id;
    private String title;
    private List<ChatDto> chats;
    public ChatRoomDetailDto(ChatRoom chatRoom) {
        id = chatRoom.getId();
        title = chatRoom.getTitle();
        chats = GetChatDto(chatRoom.getChats());
    }

    private List<ChatDto> GetChatDto(List<Chat> chats){
        List<ChatDto> chatDtos = new ArrayList<>();
        for (Chat chat : chats) {
            chatDtos.add(new ChatDto(chat));
        }
        return chatDtos;
    }
}
