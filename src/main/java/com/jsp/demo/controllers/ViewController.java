package com.jsp.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jsp.demo.dto.PostDto;
import com.jsp.demo.entity.Post;
import com.jsp.demo.repository.PostRepository;
import com.jsp.demo.serviceInterfaces.PostService;
import com.jsp.demo.converters.PostConverter;
import com.jsp.demo.dto.ResponseStructure;

@Controller
@RequestMapping("/posts")
public class ViewController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    // Home - list posts
    @GetMapping({"", "/"})
    public String listPosts(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    // Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("postDto", new PostDto());
        return "createPost";
    }

    // Handle create
    @PostMapping("")
    public String createPost(@ModelAttribute PostDto postDto, Model model) {
        Post post = postConverter.convert(postDto);
        ResponseStructure<Post> resp = postService.savePost(post, postDto.getUsername());
        return "redirect:/posts";
    }

    // View single post
    @GetMapping("/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        ResponseStructure<Post> resp = postService.fetchPostById(id);
        Post p = resp != null ? resp.getData() : null;
        model.addAttribute("post", p);
        return "viewPost";
    }

    // Show edit form
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Post> opt = postRepository.findById(id);
        if (!opt.isPresent()) {
            return "redirect:/posts";
        }
        Post p = opt.get();
        PostDto dto = new PostDto(p.getTitle(), p.getDescription(), p.getUser()!=null?p.getUser().getUsername():null);
        model.addAttribute("post", p);
        model.addAttribute("postDto", dto);
        return "editPost";
    }

    // Handle update
    @PostMapping("/{id}")
    public String updatePost(@PathVariable int id, @ModelAttribute PostDto postDto) {
        Optional<Post> opt = postRepository.findById(id);
        if (!opt.isPresent()) {
            return "redirect:/posts";
        }
        Post existing = opt.get();
        existing.setTitle(postDto.getTitle());
        existing.setDescription(postDto.getDescription());
        postRepository.save(existing);
        return "redirect:/posts/" + id;
    }

    // Delete
    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable int id) {
        postService.deletePostById(id);
        return "redirect:/posts";
    }
}
