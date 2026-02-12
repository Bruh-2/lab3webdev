package org.example.controller;

import org.example.entity.Author;
import org.example.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorService.save(author);
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Long id) {
        return authorService.find(id);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
