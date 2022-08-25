package com.levy.service;

import java.util.List;
import com.levy.domain.Dept;

/**
 * 服务提供者提供的服务
 *
 * @author liwei515
 */
public interface DeptService {

  /**
   * 根据主键部门号获取部门数据
   *
   * @param deptNo 部门号
   * @return 部门
   */
  Dept get(Integer deptNo);

  /**
   * 获取所有部门数据
   *
   * @return 部门列表
   */
  List<Dept> selectAll();

}
