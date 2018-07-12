package com.zzw.demo.util;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.lang.reflect.ParameterizedType;

/**
 * Description:
 *
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/12 13:29
 */
public class EntityUtil <T extends Model>{
	public EntityUtil(){

	}

	public Class<T> getTClass(){
		Class<T> tClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return tClass;
	}

	public String getField(String fieldName) throws NoSuchFieldException {
		TableField anno = this.getTClass().getDeclaredField(fieldName).getAnnotation(TableField.class);
		return anno != null ? anno.value() : fieldName;
	}
}
