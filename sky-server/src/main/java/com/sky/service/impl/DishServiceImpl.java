package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    @Override
    @Transactional   //使用事务管理注释需要在启动类开启  @EnableTransactionManagement //开启注解方式的事务管理  才可以跑
    public void saceWithFlavor(DishDTO dishDTO) {

        Dish dish = new Dish();

        BeanUtils.copyProperties(dishDTO, dish);

        //向菜品插入一条数据
        dishMapper.insert(dish);

        //获取insert语句生成的id主键值，在xml中使用了两个属性实现(注意代码顺序和逻辑，添加菜品的时候没有id，所以前面dish没有赋值到id)
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(flavors != null && flavors.size() >= 0){

            flavors.forEach(dishFlavor -> { //dishFlavor是每一次遍历的别名
                dishFlavor.setDishId(dishId);
            });
            //向菜品插入多条数据
            dishFlavorMapper.insertBatch(flavors);
        }

    }
}
