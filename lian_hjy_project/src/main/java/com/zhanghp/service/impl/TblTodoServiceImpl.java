package com.zhanghp.service.impl;

import com.zhanghp.bean.TblTodo;
import com.zhanghp.mapper.TblTodoMapper;
import com.zhanghp.service.base.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author zhanghp
 * @since 2021-09-12
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
