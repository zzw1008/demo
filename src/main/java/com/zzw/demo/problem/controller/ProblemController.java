package com.zzw.demo.problem.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zzw.demo.exception.Result;
import com.zzw.demo.exception.ResultEnum;
import com.zzw.demo.problem.entity.Problem;
import com.zzw.demo.problem.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * 根据id查询
	 * @return
	 */
	@GetMapping("/select")
	public Result select(){
		return Result.success (problemService.selectById ( 10L ) );
	}

	@GetMapping("/test")
	public Result test(){
		Wrapper<Problem> problemWrapper = null;
		problemWrapper = new EntityWrapper<Problem> ().eq("id", "10");
		List<Problem> str = problemService.selectList (problemWrapper);
		return Result.fail ( ResultEnum.PARAMETER_ERROR,str);
	}
}

