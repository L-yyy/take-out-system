package com.sky.service;


import com.sky.dto.SetmealDTO;

public interface SetmealService {

    /**
     * 新增套餐以及其相应菜品
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);
}
