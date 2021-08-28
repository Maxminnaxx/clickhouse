package com.study.clickhouse.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * test_table
 * </p>
 *
 * @author generator
 * @since 2021-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("study.test_table")
@ApiModel(value = "TestTable对象", description = "test_table")
public class TestTable implements Serializable {


    @TableId(value = "id")
    private Integer id;

    @TableField("app_id")
    private String appId;

    @Version
    private String version;

    @TableField("reg_time")
    private LocalDate regTime;


}
