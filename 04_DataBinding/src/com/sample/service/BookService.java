package com.sample.service;

import java.util.List;

import com.sample.model.Book;
import com.sample.model.Category;

public interface BookService {

	List<Category> getAllCategories();

	Category getCategory(int id);

	List<Book> getAllBooks();

	Book save(Book book);

	Book update(Book book);

	Book get(long id);

	long getNextId();

}
