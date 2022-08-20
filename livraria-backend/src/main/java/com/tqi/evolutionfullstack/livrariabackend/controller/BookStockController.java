package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.DTO.BookDTO;
import com.tqi.evolutionfullstack.livrariabackend.DTO.BookListDTO;
import com.tqi.evolutionfullstack.livrariabackend.DTO.BookStockDTO;
import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookStockRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import com.tqi.evolutionfullstack.livrariabackend.service.BookStockService;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book_stock")
public class BookStockController {

    @Autowired
    private BookStockRepository bookStockRepository;

    @Autowired
    BookStockService bookStockService;

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookStock>> findAll() {
        List<BookStock> list = bookStockService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity saveBookStock(@RequestBody BookStockDTO dto) {
        try {
            BookStock bookStock = returnDTO(dto);
            bookStock = bookStockService.save(bookStock);
            return ResponseEntity.ok(bookStock);
        }  catch (BookstoreRulesException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private BookStock returnDTO(BookStockDTO dto) {
        BookStock bookStock = new BookStock();

        List<Book> book = bookService
                .getBookById(dto.getId())
                .orElseThrow( () -> new BookstoreRulesException("Livro não encontrado."));

        bookStock.setBookId(convertToList(book));
        bookStock.setCostPrice(dto.getCostPrice());
        bookStock.setSellPrice(dto.getSellPrice());
        bookStock.setQuantity(dto.getQuantity());

        return bookStock;
    }

    public static List<BookListDTO> convertToList(List<Book> books) {
        return books.stream().map(book -> {
            return new BookListDTO(book.getId());
        }).collect(Collectors.toList());
    }
}
