package com.blog.blog.repositories;

import com.blog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel
 * @version 1.0
 * @date 27.01.2023 23:46
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
