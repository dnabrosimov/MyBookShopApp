package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public List<Author> getAuthorsByLetter(char letter) {

        String query = "SELECT * FROM authors WHERE last_name LIKE '"+letter+"%'";

        List<Author> authors = jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setFullName(rs.getString("first_name") + " " + rs.getString("last_name"));
            return author;
        });
        authors.sort(Comparator.comparing(Author::getLastName));
    return new ArrayList<>(authors);
    }

//    public List<Author> getAuthorsA() { return new ArrayList<>(getAuthorsByLetter("A")); }
//    public List<Author> getAuthorsB() { return new ArrayList<>(getAuthorsByLetter("B")); }
//    public List<Author> getAuthorsC() { return new ArrayList<>(getAuthorsByLetter("C")); }
//    public List<Author> getAuthorsD() { return new ArrayList<>(getAuthorsByLetter("D")); }
//    public List<Author> getAuthorsE() { return new ArrayList<>(getAuthorsByLetter("E")); }
//    public List<Author> getAuthorsF() { return new ArrayList<>(getAuthorsByLetter("F")); }
//    public List<Author> getAuthorsG() { return new ArrayList<>(getAuthorsByLetter("G")); }
//    public List<Author> getAuthorsH() { return new ArrayList<>(getAuthorsByLetter("H")); }
//    public List<Author> getAuthorsI() { return new ArrayList<>(getAuthorsByLetter("I")); }
//    public List<Author> getAuthorsJ() { return new ArrayList<>(getAuthorsByLetter("J")); }
//    public List<Author> getAuthorsK() { return new ArrayList<>(getAuthorsByLetter("K")); }
//    public List<Author> getAuthorsL() { return new ArrayList<>(getAuthorsByLetter("L")); }
//    public List<Author> getAuthorsM() { return new ArrayList<>(getAuthorsByLetter("M")); }
//    public List<Author> getAuthorsN() { return new ArrayList<>(getAuthorsByLetter("N")); }
//    public List<Author> getAuthorsO() { return new ArrayList<>(getAuthorsByLetter("O")); }
//    public List<Author> getAuthorsP() { return new ArrayList<>(getAuthorsByLetter("P")); }
//    public List<Author> getAuthorsQ() { return new ArrayList<>(getAuthorsByLetter("Q")); }
//    public List<Author> getAuthorsR() { return new ArrayList<>(getAuthorsByLetter("R")); }
//    public List<Author> getAuthorsS() { return new ArrayList<>(getAuthorsByLetter("S")); }
//    public List<Author> getAuthorsT() { return new ArrayList<>(getAuthorsByLetter("T")); }
//    public List<Author> getAuthorsU() { return new ArrayList<>(getAuthorsByLetter("U")); }
//    public List<Author> getAuthorsV() { return new ArrayList<>(getAuthorsByLetter("V")); }
//    public List<Author> getAuthorsW() { return new ArrayList<>(getAuthorsByLetter("W")); }
//    public List<Author> getAuthorsX() { return new ArrayList<>(getAuthorsByLetter("X")); }
//    public List<Author> getAuthorsY() { return new ArrayList<>(getAuthorsByLetter("Y")); }
//    public List<Author> getAuthorsZ() { return new ArrayList<>(getAuthorsByLetter("Z")); }



}
