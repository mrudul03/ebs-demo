package com.microservices.book.contract;

import com.microservices.book.repository.BookEntity;

public class BookResource {
	
	private String id;
    private String name;

    public BookResource(BookEntity book) {
        this.id = book.getId().toString();
        this.name = book.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
