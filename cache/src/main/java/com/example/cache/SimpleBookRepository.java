package com.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
    @Override
    @Cacheable("books")
    public book getByIsbn(String isbn) {
      simulateSlowService();
      return new book(isbn, "Some book");
    }
  
    // Don't do this at home
    private void simulateSlowService() {
      try {
        long time = 3000L;
        Thread.sleep(time);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
    }

}