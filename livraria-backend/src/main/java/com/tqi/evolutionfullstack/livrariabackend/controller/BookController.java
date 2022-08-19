package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.DTO.BookDTO;
import com.tqi.evolutionfullstack.livrariabackend.exception.RulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveBook(@RequestBody BookDTO dto) {
        try {
            Book book = returnDTO(dto);
            book = service.SaveBook(book);
            return ResponseEntity.ok(book);
        } catch (RulesException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id")
    public ResponseEntity updateBook(@PathVariable("id") Long id, @RequestBody BookDTO dto) {
        return service.getBookById(id).map( entity -> {
            try {
                Book book = returnDTO((dto));
                book.setId(entity.getId());
                service.updateBook(book);
                return ResponseEntity.ok(book);
            } catch (RulesException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }).orElseGet( () -> new ResponseEntity("Livro não encontrado.", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id")
    public ResponseEntity deleteBook( @PathVariable("id") Long id) {
        return service.getBookById(id).map( entity -> {
            service.deleteBook(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet( () -> new ResponseEntity("Livro não encontrado.", HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity listBook(@RequestParam("id") Long id ) {
        Book book = new Book();
        book.setId(id);
        Optional<Book> result  = service.getBookById(id);
        if (result.isEmpty())
            return ResponseEntity.badRequest().body("Livro não encontrado.");
        else
            book.setId(book.getId());

        List<Book> books = service.listBook(book);
        return ResponseEntity.ok(books);
    }

    private Book returnDTO(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublisher(dto.getPublisher());
        book.setImg(dto.getImg());
        book.setPublishedYear(dto.getPublishedYear());
        book.setCostPrice(dto.getCostPrice());
        book.setSellPrice(dto.getSellPrice());

        return book;
    }

//    @GetMapping
//    public ResponseEntity<List<Book>> findAll() {
//        List<Book> list = service.findall();
//        return ResponseEntity.ok().body(list);
//    }
//    @PostMapping
//    public void save(@RequestBody Book objBook){
//        service.save(objBook);
//    }
//
//    @GetMapping("/{id}")
//    public Book findById(@PathVariable Long id) {
//        var bookOptional = repository.findById(id);
//        if (bookOptional.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return bookOptional.get();
//    }
}
