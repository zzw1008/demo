package com.zzw.demo.user.service.impl;

import com.zzw.demo.user.entity.User;
import com.zzw.demo.user.dao.UserMapper;
import com.zzw.demo.user.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzw
 * @since 2018-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
