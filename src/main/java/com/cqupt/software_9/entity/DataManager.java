package com.cqupt.software_9.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="data_manager")
@Data
public class DataManager implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String  tablename;
    private String  diseasename;
    private Integer datanumber;
    private String  operators;
    private String  affiliationdatabase;
    private String  tabletype;
    private String  uploadmethod;
    private String  chinesename;
    private LocalDateTime loadtime;
    private String featurenumber;
    private boolean  isProjection;
    
}
