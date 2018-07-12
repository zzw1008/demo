package com.zzw.demo.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zzw.demo.aop.Permission;
import com.zzw.demo.common.SystemConstant;
import com.zzw.demo.exception.Result;
import com.zzw.demo.exception.ResultEnum;
import com.zzw.demo.user.entity.User;
import com.zzw.demo.user.service.UserService;
import com.zzw.demo.util.EntityUtil;
import com.zzw.demo.util.JwtUtil;
import com.zzw.demo.util.RedisUtil;
import com.zzw.demo.util.TokenUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzw
 * @since 2018-07-12
 */
@RestController
@RequestMapping("/api/user")
@Log4j2
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 登录
	 *
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	@Permission(value = "user.login")
	public Result login(@RequestBody JSONObject user) {

		User u;

		Wrapper<User> wrap = null;
		try {
			EntityUtil en = new EntityUtil<User> () {
			};
			wrap = new EntityWrapper<User> ().eq(en.getField("name"), user.getString("userName"));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		u = userService.selectOne(wrap);

		// TODO 执行校验
		if (u == null) {
			return Result.fail ( ResultEnum.Login_ERROR,"账号或密码错误" );
		}

		JSONObject data = new JSONObject();
		data.put("token", createToken(u));
		log.info("登录",data);
		return Result.success(data);
	}

	private String createToken(User u) {
		String token = JwtUtil.sign(JwtUtil.builder().withIssuer(u.getName()).withSubject(u.getPassword ()));
		redisUtil.set(token, u, SystemConstant.DEFAULT_JWT_EXPIRE_TIME);

		return token;
	}

	@PostMapping("/logout")
	@ResponseBody
	@Permission(value = "user.logout")
	public Result logout(HttpServletRequest req) {
		redisUtil.del( TokenUtil.getToken(req));
		return Result.success(req);
	}

	@GetMapping("getInfo")
	@ResponseBody
	@Permission(value = "user.getInfo")
	public Result getInfo(HttpServletRequest req) {
		User u = (User) req.getAttribute(SystemConstant.CACHED_USER_INFO);

		return Result.success(u);
	}

	/**
	 * 根据ID获取用户
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	@Permission(value = "user.get")
	public Result get(@PathVariable int id) {

		return Result.success(userService.selectById(id));
	}


	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@PostMapping("/add")
	@ResponseBody
	@Permission(value = "user.add")
	public Result add(@RequestBody JSONObject user) {

		String userStr = user.getString("user");
		User u = JSONObject.parseObject(userStr, User.class);
		u.setGmtCreate ( LocalDateTime.now () );
		try {
			userService.insert(u);
		}catch (Exception e){
			return Result.fail(ResultEnum.INSERT_ERROR,"插入语句执行错误");
		}
		return Result.success(u);
	}

	/**
	 * 分页查询
	 * @param user
	 * @return
	 */
//	@PostMapping("/queryByCondition")
//	@ResponseBody
//	@Permission(value = "user.query")
//	public Result queryByCondition(@RequestBody JSONObject user) {
//
//		String userStr = user.getString("user");
//		User sysUsers = JSONObject.parseObject(userStr, User.class);
////		List<User> list = userService.selectList (sysUsers);
////		return Result.success(list);
//	}

}

