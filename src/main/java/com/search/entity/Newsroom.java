package com.search.entity;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;

@Entity(name = "newsroom")
@Indexed
public class Newsroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long newsroomNo;

    private String link;

    @FullTextField(analyzer = "koreanAnalyzer", searchAnalyzer = "koreanAnalyzer")
    private String title;

    @FullTextField(analyzer = "koreanAnalyzer", searchAnalyzer = "koreanAnalyzer")
    private String content;

    public Long getNewsroomNo() {
        return newsroomNo;
    }

    public void setNewsroomNo(Long newsroomNo) {
        this.newsroomNo = newsroomNo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Newsroom{" +
                "newsroomNo=" + newsroomNo +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
