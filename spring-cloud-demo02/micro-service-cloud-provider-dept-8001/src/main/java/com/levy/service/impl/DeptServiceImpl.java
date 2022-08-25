package com.levy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.levy.domain.Dept;
import com.levy.mapper.DeptMapper;
import com.levy.service.DeptService;

/**
 * 服务提供者提供的服务实现
 *
 * @author liwei515
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

  @Autowired
  private DeptMapper deptMapper;

  @Override
  public Dept get(Integer deptNo) {
    return deptMapper.selectByPrimaryKey(deptNo);
  }

  @Override
  public List<Dept> selectAll() {
    return deptMapper.getAll();
  }
}
