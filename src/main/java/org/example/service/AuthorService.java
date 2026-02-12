package org.example.service;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepo;

    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author save(Author author) {
        return authorRepo.save(author);
    }

    public Author find(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public void delete(Long id) {
        authorRepo.deleteById(id);
    }

    public List<Author> findPagedSorted(int page, int size) {
        return authorRepo.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).getContent();
    }
}
