package com.hmdp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Autowired
    private ShopTypeMapper shopTypeMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result queryPlus() {
        List<String> shopTypesJson = stringRedisTemplate.opsForList().range("cache:shop_type", 0, -1);
        if(CollectionUtil.isNotEmpty(shopTypesJson)){
            List<ShopType> shopTypes = JSONUtil.toList(shopTypesJson.get(0), ShopType.class);
          /*  for (String shopTypeJson : shopTypesJson) {
                ShopType shop = JSONUtil.toBean(shopTypeJson, ShopType.class);
                shopTypes.add(shop);
            }*/
            return Result.ok(shopTypes);
        }
        /*List<ShopType> shopTypes = shopTypeMapper.select();*/
        List<ShopType> shopTypes = query().orderByAsc("sort").list();
        if(CollectionUtil.isEmpty(shopTypes)){
            return Result.fail("系统错误!");
        }
        String jsonStr = JSONUtil.toJsonStr(shopTypes);
        redisTemplate.opsForList().leftPushAll("cache:shop_type", jsonStr);
        return Result.ok(shopTypes);
    }
}
