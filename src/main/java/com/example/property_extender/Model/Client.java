package com.example.property_extender.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clients")
public class Client {

    @Id
    private int id;
    private String name;
    private Long code;
    private String createdBy;
    private Long createdAt;
    private Long LastUpdatedAt;
    private String LastUpdatedBy;
    private String description;
    private String comments;
    private String extra;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLastUpdatedAt() {
        return LastUpdatedAt;
    }

    public void setLastUpdatedAt(Long LastUpdatedAt) {
        LastUpdatedAt = LastUpdatedAt;
    }

    public String getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public void setLastUpdatedBy(String LastUpdatedBy) {
        LastUpdatedBy = LastUpdatedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }


    public Client(int id, String name, Long code, String createdBy,
                  Long createdAt, Long LastUpdatedAt, String LastUpdatedBy,
                  String description, String comments, String extra) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.LastUpdatedAt = LastUpdatedAt;
        this.LastUpdatedBy = LastUpdatedBy;
        this.description = description;
        this.comments = comments;
        this.extra = extra;
    }




}
