package org.zerock.board.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.board.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
