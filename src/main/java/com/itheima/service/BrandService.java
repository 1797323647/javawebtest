package com.itheima.service;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加brand数据
     *
     * @param brand
     */
    void addBrand(Brand brand);

    int deleteById(int id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") int[] ids);

    /**
     * 修改brand数据
     *
     * @param
     * @return
     */
    int updateById(Brand brand);

}
