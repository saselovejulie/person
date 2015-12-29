package com.person.model.base;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Arrays;

@Document(collection = "blog")
public class BlogModel {

    @Id
    private String id;
    private String title;
    private String date;
    private String updateDate;
    private String description;
    private String[] types;
    private String[] tags;
    private String documentSaveLink;
    private String documentViewLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getDocumentSaveLink() {
        return documentSaveLink;
    }

    public void setDocumentSaveLink(String documentSaveLink) {
        this.documentSaveLink = documentSaveLink;
    }

    public String getDocumentViewLink() {
        return documentViewLink;
    }

    public void setDocumentViewLink(String documentViewLink) {
        this.documentViewLink = documentViewLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BlogModel{" +
                "id:'" + id + '\'' +
                ", title:'" + title + '\'' +
                ", date:'" + date + '\'' +
                ", updateDate:'" + updateDate + '\'' +
                ", types:" + Arrays.toString(types) +
                ", tags:" + Arrays.toString(tags) +
                ", documentSaveLink:'" + documentSaveLink + '\'' +
                ", documentViewLink:'" + documentViewLink + '\'' +
                '}';
    }
}
