package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.find(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
