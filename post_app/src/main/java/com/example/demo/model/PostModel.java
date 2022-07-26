package com.example.demo.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostModel {
    @NotNull(message = "Id of post can not be empty!")
    private String postId;
    @NotNull(message = "Can not be empty!")
    private  String clientId;
    @NotNull(message = "Can not be empty!")
    private String PostRecipentId;
    private String postItem;
    private String status;
}
