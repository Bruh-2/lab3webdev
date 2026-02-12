package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public Book find(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
