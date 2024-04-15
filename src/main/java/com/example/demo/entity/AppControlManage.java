package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.JsonbTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "app_control_manage", autoResultMap = true)
@AllArgsConstructor
@NoArgsConstructor
public class AppControlManage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 关联渠道
     */
    @TableField("channel")
    private String channel;

    /**
     * 控制项
     */
    @TableField(value = "content", typeHandler = JsonbTypeHandler.class)
    private Object content;

    /**
     * 说明
     */
    @TableField("description")
    private String description;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
