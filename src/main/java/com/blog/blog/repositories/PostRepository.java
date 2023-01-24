package com.blog.blog.repositories;

import com.blog.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Pavel
 * @version 1.0
 * @date 19.01.2023 23:39
 */
public interface PostRepository extends CrudRepository<Post, Long> {
}
