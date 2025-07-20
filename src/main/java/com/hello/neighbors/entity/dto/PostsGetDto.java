package com.hello.neighbors.entity.dto;

import java.util.List;

public class PostsGetDto {
    private List<PostDto> posts;

    ///////////// Getters and Setters ////////////////////

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
}
