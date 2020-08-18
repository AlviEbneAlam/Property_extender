package com.example.property_extender.Property;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Properties")
public class Property {

    @Id
    private int id;
    private String name;
    private String code;
    /*private String type;
    private int length;
    private String clientId;
    private String createdBy;
    private Long createdAt;
    private Long LastUpdatedAt;
    private String LastUpdatedBy;
    private String description;
    private String comments;
    private String extra;
    private String constraint;*/

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /*public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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

    public void setLastUpdatedAt(Long lastUpdatedAt) {
        LastUpdatedAt = lastUpdatedAt;
    }

    public String getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        LastUpdatedBy = lastUpdatedBy;
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

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }
*/



    public Property(int id, String name, String code/*, String type*//*,
                    int length, String clientId, String createdBy,
                    Long createdAt, Long LastUpdatedAt, String LastUpdatedBy,
                    String description, String comments, String extra, String constraint*/) {

        this.id = id;
        this.name = name;
        this.code = code;
        /*this.type = type;
        this.length = length;
        this.clientId = clientId;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.LastUpdatedAt = LastUpdatedAt;
        this.LastUpdatedBy = LastUpdatedBy;
        this.description = description;
        this.comments = comments;
        this.extra = extra;
        this.constraint = constraint;*/

    }


}
