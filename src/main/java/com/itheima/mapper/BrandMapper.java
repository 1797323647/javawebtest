package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有数据
     *
     * @return 返回装有所有数据的list集合
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加brand数据
     *
     * @param brand
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addBrand(Brand brand);

    /**
     * 根据id删除brand对象
     *
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    int deleteById(@Param("id") Integer id);

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
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    int updateById(Brand brand);
}
