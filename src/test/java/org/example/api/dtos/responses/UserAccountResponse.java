package org.example.api.dtos.responses;
import org.example.api.dtos.Book;

import java.util.List;

public class UserAccountResponse {
    public String userId;
    public List<Book> books;
    public String code;
    public String message;
    public String username;
}