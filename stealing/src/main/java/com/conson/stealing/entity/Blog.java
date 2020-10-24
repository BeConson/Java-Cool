package com.conson.stealing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 康森
 * @date 2020/9/13
 * @description
 */
@Data
public class Blog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String img;
    private String title;
    private String info;
    private String date;
    private String category;
}
