package com.zzw.demo.user.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
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
 * @since 2018-07-12
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private Long id;
	/**
	 * @TableLogic 逻辑删除
	 */
	@TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String sex;
    @TableField("we_chat")
    private String weChat;
    private String status;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
