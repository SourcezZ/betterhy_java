package com.betterhy.db.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * myapp_story
 * @author 
 */
@Data
public class MyappStory implements Serializable {
    private Integer storyId;

    private String title;

    private String content;

    private Date addTime;

    private String commitFlag;

    private static final long serialVersionUID = 1L;
}