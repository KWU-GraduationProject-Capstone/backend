package TransparentDeveloper.backend.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ChatRoom {
    @Id @GeneratedValue
    @Column(name = "chat_room_id")
    private Long id;
    private String title;

    public ChatRoom() {
    }

    public ChatRoom(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "chatRoom",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Chat> chats = new ArrayList<>();
}
