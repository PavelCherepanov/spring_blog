package com.blog.blog.controllers;

import com.blog.blog.LocalDate;
import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pavel
 * @version 1.0
 * @date 26.01.2023 12:34
 */
@RestController
@RequestMapping(path = "api/v1/blog")
@CrossOrigin
public class BlogRestController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @PostMapping
    public void addNewPost(@RequestBody Post post){
        LocalDate localDate = new LocalDate();
        post.setPublicationDate(localDate.getNowDate());
        post.setViews(1);
        postRepository.save(post);
    }
    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        if (postRepository.existsById(postId)){
            throw new IllegalStateException("student with id "+ postId + " does not exists");
        }
        postRepository.deleteById(postId);
    }

    @PutMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long postId,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String anons,
                           @RequestParam(required = false) String fullText){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalStateException("student with id" + postId + "does not exists"));
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
    }
}
