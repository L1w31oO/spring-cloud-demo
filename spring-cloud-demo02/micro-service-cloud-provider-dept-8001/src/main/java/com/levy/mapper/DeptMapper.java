package com.levy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.levy.domain.Dept;

/**
 * 服务台提供者的数据交互接口
 *
 * @author liwei515
 */
@Mapper
public interface DeptMapper {

  /**
   * 根据主键部门号获取部门数据
   *
   * @param deptNo 部门号
   * @return 部门
   */
  Dept selectByPrimaryKey(Integer deptNo);

  /**
   * 获取所有部门数据
   *
   * @return 部门列表
   */
  List<Dept> getAll();
}
