package TransparentDeveloper.backend.jpa.controller;

import TransparentDeveloper.backend.jpa.domain.ChatRoom;
import TransparentDeveloper.backend.jpa.domain.dtos.ChatRoomDetailDto;
import TransparentDeveloper.backend.jpa.domain.dtos.ChatRoomDto;
import TransparentDeveloper.backend.jpa.repository.ChatRoomRepository;
import TransparentDeveloper.backend.jpa.service.ChatRoomService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatRoomApiController {
    private final ChatRoomService chatRoomService;
    private final ChatRoomRepository chatRoomRepository;

    @Data
    private static class TempData{
        private String title;
    }

    // 채팅방 생성
    @PostMapping("/api/chatRoom/new")
    public ResponseEntity addNewChatRoom(@RequestBody TempData data){
        chatRoomService.createChatRoom(new ChatRoom(data.getTitle()));
        return new ResponseEntity(HttpStatus.OK);
    }

    // 채팅방 리스트 조회
    @GetMapping("/api/chatRooms")
    public List<ChatRoomDto> showChatRoomList(){
        List<ChatRoom> chatRoomAll = chatRoomService.findChatRoomAll();
        List<ChatRoomDto> result = new ArrayList<>();
        for (ChatRoom chatRoom : chatRoomAll) {
            result.add(new ChatRoomDto(chatRoom));
        }
        return result;
    }

    // 채팅방 조회
    @GetMapping("/api/chatRoom/{chat_room_id}")
    public ChatRoomDetailDto showChatRoomDetail(@PathVariable("chat_room_id")Long id){
        log.info("showChatRoomDetail chatRoom : {}",id);
        ChatRoom chatRoom = chatRoomRepository.find(id);
        return new ChatRoomDetailDto(chatRoom);
    }

    // 채팅방 삭제
    @DeleteMapping("/api/chatRoom/{chat_room_id}")
    public ResponseEntity removeChatRoom(@PathVariable("chat_room_id")Long id){
        log.info("removeChatRoom chatRoom : {}",id);
        chatRoomService.deleteChatRoom(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
