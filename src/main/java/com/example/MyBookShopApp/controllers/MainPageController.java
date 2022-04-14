package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookService.getBooksData());
        model.addAttribute("searchPlaceholder", "new search placeholder");
        model.addAttribute("serverTime", new Date());
        model.addAttribute("placeholderTextPart2", "SERVER");
        model.addAttribute("messageTemplate", "searchbar.placeholder2" );
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model){
//        model.addAttribute("bookData", bookService.getBooksData());
        return "/genres/index";
    }
//    @GetMapping("/authors")
//    public String authorsPage(Model model){
//        String[] letters = {"A","B","C","D","E","F",
//                            "G","H","I","J","K","L",
//                            "M","N","O","P","Q","R",
//                            "S","T","U","V","W","X",
//                            "Y","Z"};
//
//         for (int i=0; i< letters.length; i++){
//            model.addAttribute("authorData"+letters[i],authorService.getAuthorsByLetter(letters[i]));
//        }
//        return "/authors/index";
//    }

    @GetMapping("/authors")
    public String authorsPage(Model model){
        for (char  i='A'; i<='Z'; i++){
            model.addAttribute("authorData"+i,authorService.getAuthorsByLetter(i));
        }
        return "/authors/index";
    }

}
