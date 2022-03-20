package com.company;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Book implements Comparable<Book> {
    private final String title;
    private final int page;
    private final String author;
    private final int publishDate;

    public Book(String title, int page, String author, int publishDate) {
        this.title = title;
        this.page = page;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book book) {
        return this.getTitle().compareTo(book.getTitle());
    }

    public int getPage() {
        return page;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Kutu Adam 1", 1234567, "Kobe Abe 1", 2003);
        Book book2 = new Book("Kutu Adam 3", 1236, "Kobe Abe 3", 2002);
        Book book3 = new Book("Kutu Adam 2", 1233, "Kobe Abe 2", 2001);
        Book book4 = new Book("Kutu Adam 4", 14, "Kobe Abe 4", 2000);
        Book book5 = new Book("Kutu Adam 5", 125, "Kobe Abe 5", 1999);

        Set<Book> bookSet = new TreeSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        System.out.println("Title,");

        for (Book book : bookSet) {
            System.out.println("Name : " + book.getTitle() + " - " + book.getAuthor());
        }

        Set<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPage() - b2.getPage();
            }
        });

        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);

        System.out.println("\nPage Number,");

        for (Book book : books2) {
            System.out.println("Name : " + book.getTitle() + " - " + book.getPage());
        }

    }
}
