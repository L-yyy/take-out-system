package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController("userShopController")
@Slf4j
@Api(tags = "店铺相关接口")//必须要写tags= 否则swagger显示不出来
@RequestMapping("/user/shop")
public class ShopController {
    @Resource
    private RedisTemplate redisTemplate;

    public static final String KEY = "SHOP_STATUS";

    /*
     * 获取店铺状态
     * */
    @ApiOperation("获取店铺状态")
    @GetMapping("/status")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取到的店铺营业状态为；{}", status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }

}
