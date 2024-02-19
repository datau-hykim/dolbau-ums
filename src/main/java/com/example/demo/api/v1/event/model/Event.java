package com.example.demo.api.v1.event.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@ToString
@Document(indexName = "event")
public class Event {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Text)
    private String contents;
}
