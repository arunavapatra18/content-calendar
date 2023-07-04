package com.example.contentcalendar.repository;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.model.Status;
import com.example.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    // Keeps a collection of data in-memory
    // Not the Spring Data Repository that talks with DB

    private final List<Content> contentList = new ArrayList<>();

    /**
     *  Constructor
     *  */
    public ContentCollectionRepository() {

    }

    /**
     * Method to return the list of content
     * @return List<Content>
     */
    public List<Content> findAll() {
        return contentList;
    }

    /**
     * Method to find content by ID
     * @param id The ID of the content we want to find
     * @return  Optional<Content>
     */
    public Optional<Content> findById(Integer id) {
        return contentList.stream()
                .filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    // Init method is invoked as soon as the ContentController is created and dependency is injected
    @PostConstruct
    private void init() {
        Content content = new Content(
                1,
                "My First Blog Post",
                "My First Blog Post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void update(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
