package com.zzw.demo.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * Description:
 * controller层返回值
 * @version 1.0
 * @Author zzw
 * @Date: 2018/6/13 20:18
 */
@Component
@Data
@Accessors(chain = true)
public class Result {
	/**
	 * 返回代码
	 */
	private Integer code;

	/**
	 * 提示信息
	 */
	private String message;

	/**
	 * 返回内容
	 */
	private Object response;


	public static Result success(Object response){
		Result result = new Result ().setCode (ResultEnum.SUCCESS.getCode ()).setMessage ( ResultEnum.SUCCESS.getMsg
				()).setResponse ( JSONObject.toJSONString (response));
		return result;
	}

	public static Result fail(ResultEnum resultEnum,Object response){
		Result result = new Result ().setCode (resultEnum.getCode ()).setMessage ( resultEnum.getMsg
				()).setResponse (JSONObject.toJSONString (response));
		return result;
	}
}
