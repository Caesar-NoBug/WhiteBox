package org.caesar.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

//TODO: 自动生成文章摘要、标签
//TODO: 把文章加入到检索服务中

/**
 * 
 * @TableName article
 */
@TableName(value ="article")
@Data
@FieldNameConstants
public class ArticlePO implements Serializable{

    /**
     * 文章主键
     */
    @TableId
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章摘要
     */
    private String digest;

    /**
     *  文章类型
     */
    private Integer type;

    /**
     * 文章标签
     */
    private String tag;

    /**
     * 创建者id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Boolean isDelete = false;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}