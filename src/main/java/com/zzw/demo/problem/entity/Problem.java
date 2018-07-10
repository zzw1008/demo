package com.zzw.demo.problem.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzw
 * @since 2018-07-09
 */
@TableName("problem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Problem extends Model<Problem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * @TableLogic 逻辑删除
     */
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;
    @TableField("gmt_create")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;
    private String title;
    private String type;
    private String tag;
    private String analysis;
    private String answer;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
