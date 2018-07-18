package com.zzw.demo.user.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
	@TableField("is_deleted")
	private Integer isDeleted;
	@TableField("gmt_create")
	private LocalDateTime gmtCreate;
	@TableField("gmt_modified")
	private LocalDateTime gmtModified;
	@TableField("created_id")
	private Long createdId;
	@TableField("created_name")
	private String createdName;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 微信号
	 */
	@TableField("we_chat")
	private String weChat;
	/**
	 * 状态：正常、停用
	 */
	private String status;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
