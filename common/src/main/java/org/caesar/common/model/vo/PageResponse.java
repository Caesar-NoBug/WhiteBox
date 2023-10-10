package org.caesar.common.model.vo;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * //分页查询响应
 * @param <T> 结果类型
 * data: 查询结果
 * totalSize: 匹配的结果总数
 */
@Data
public class PageResponse<T> {
    private List<T> data;
    private int totalSize;
}
