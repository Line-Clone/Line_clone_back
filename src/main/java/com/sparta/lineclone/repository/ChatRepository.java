package com.sparta.lineclone.repository;

import com.sparta.lineclone.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Optional<Chat> findByRoomId(String roomId);

    boolean findBySender(String nickname);

}
