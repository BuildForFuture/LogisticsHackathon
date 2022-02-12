package Controller;

import Model.Book;
import Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return "created successfully";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @PutMapping("/single/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return "updated succesfully";
    }

    @DeleteMapping("/single/{id}")
    public String deleteBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.deleteBook(id, book);
        return "deleted succesfully";
    }
}
