package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 这个Mapper是创建来服务删除菜品的，查询当前菜品是否绑定了套餐
 */
@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应的套餐id
     * @param dishIds
     * @return
     */
    //select setmeal_id from setmeal_dish where dish in (1,2,3,4)
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

}
