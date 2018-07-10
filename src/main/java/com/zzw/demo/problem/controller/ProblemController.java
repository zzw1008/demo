package com.zzw.demo.problem.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zzw.demo.exception.Result;
import com.zzw.demo.exception.ResultEnum;
import com.zzw.demo.problem.entity.Problem;
import com.zzw.demo.problem.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzw
 * @since 2018-07-09
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	/**
	 * 保存
	 * @param jsonObject
	 * @return
	 */
	@PostMapping("/insert")
	public Result insert(@RequestBody JSONObject jsonObject){
		System.out.println (jsonObject.toString ());
		Problem problem = jsonObject.toJavaObject (Problem.class);
		problemService.insert (problem);
		return Result.success (problem);
	}

	/**
	 * 根据id查询指定记录
	 * @param id
	 * @return
	 */
	@GetMapping("/select/{id}")
	public Result select(@PathVariable Long id){
		return Result.success (problemService.selectById (id) );
	}

	/**
	 * 更新
	 * @param jsonObject
	 * @param req
	 * @return
	 */
	@PutMapping("/update")
	public Result update(@RequestBody JSONObject jsonObject, HttpServletRequest req){
		Problem problem = jsonObject.toJavaObject (Problem.class);
		problemService.updateById (problem);
		return Result.success (problem);
	}

	/**
	 * 根据id删除
	 * @param jsonObject
	 * @return
	 */
	@DeleteMapping("/delete")
	public Result delete(@RequestBody JSONObject jsonObject){
		Long id = jsonObject.getLong ("id");
		problemService.deleteById (id);
		return Result.success (id);
	}

	@GetMapping("/test")
	public Result test(){
		Wrapper<Problem> problemWrapper = null;
		problemWrapper = new EntityWrapper<Problem> ().eq("id", "10");
		List<Problem> str = problemService.selectList (problemWrapper);
		return Result.fail ( ResultEnum.PARAMETER_ERROR,str);
	}
}

