package org.example.Task1.Book;

public class Book implements Displayable {
    private String nameOfBook;
    private String nameOfAuthor;
    private int yearOfPublication;

    public void setInfoOfBook(String nameOfBook, String nameOfAuthor, int yearOfPublication) {
        this.nameOfAuthor = nameOfAuthor;
        this.nameOfBook = nameOfBook;
        this.yearOfPublication = yearOfPublication;
    }

    public int getYearOfPublication() {
        return this.yearOfPublication;
    }

    public String getNameOfBook() {
        return this.nameOfBook;
    }

    public String getNameOfAuthor() {
        return this.nameOfAuthor;
    }

    @Override
    public void display() {
        System.out.println("Название книги: " +  this.nameOfBook + " " + "Имя Автора: " + this.nameOfAuthor + " " + "Год издания: " + this.yearOfPublication);
    }
}
