package com.example.demo.api.v1.event.repository;

import org.springframework.data.domain.Page;
import com.example.demo.api.v1.event.model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ElasticsearchRepository<Event, Long> {
    @Query("{\"match\": {\"title\": \"?0\"}}}")
    Page<Event> findByTitle(String title, Pageable pageable);

    Page<Event> findByTitleOrContentsLike(String title, String contents, Pageable pageable);
}
