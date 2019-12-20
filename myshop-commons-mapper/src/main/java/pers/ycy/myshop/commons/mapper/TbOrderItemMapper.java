package pers.ycy.myshop.commons.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import pers.ycy.myshop.commons.domain.TbOrderItem;
import pers.ycy.myshop.commons.utils.RedisCache;
import tk.mybatis.mapper.MyMapper;
@CacheNamespace(implementation = RedisCache.class)
public interface TbOrderItemMapper extends MyMapper<TbOrderItem> {
}