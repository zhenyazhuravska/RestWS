package org.restws.database;

import org.restws.model.Book;
import org.restws.model.Library;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    private static Map<Long, Library> libraries = new HashMap<>();
    private static Map<Long, Book> books = new HashMap<>();

    public static Map<Long, Library> getLibraries() {
        return libraries;
    }
    public static Map<Long, Book> getBooks() {
        return books;
    }
}
