package com.betterhy.common.db.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * myapp_comment
 * @author
 */
@Data
public class MyappComment implements Serializable {
    private Integer commentId;

    private Integer storyId;

    private String commentContent;

    private Date addTime;

    private static final long serialVersionUID = 1L;
}