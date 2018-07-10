package com.zzw.demo.problem.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zzw.demo.problem.entity.Problem;
import com.zzw.demo.problem.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String select(){
		return String.valueOf ( problemService.selectById ( 10L ) );
	}

	@GetMapping("/test")
	public String test(){
		String str = String.valueOf (problemService.selectList ( new EntityWrapper<Problem> ().eq("id", "10") ));
		return str;
	}
}

