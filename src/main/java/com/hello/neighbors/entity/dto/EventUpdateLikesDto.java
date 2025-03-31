package com.hello.neighbors.entity.dto;

public class EventUpdateLikesDto {

    private Long id;
    private Long likes;

    ///////////// Getters and Setters ////////////////////


    public Long getId() {
        return id;
    }
    public Long getLikes() {
        return likes;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setLikes(Long likes) {
        this.likes = likes;
    }
}
