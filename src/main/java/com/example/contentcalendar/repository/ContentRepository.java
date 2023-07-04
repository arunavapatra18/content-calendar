package com.example.contentcalendar.repository;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    // Query Derivation
    List<Content> findAllByTitleContains(String keyword);

    // Custom Query
    @Query("""
        SELECT * FROM Content
        WHERE status = :status 
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
