package pers.ycy.myshop.commons.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import pers.ycy.myshop.commons.domain.TbContentCategory;
import pers.ycy.myshop.commons.utils.RedisCache;
import tk.mybatis.mapper.MyMapper;
@CacheNamespace(implementation = RedisCache.class)
public interface TbContentCategoryMapper extends MyMapper<TbContentCategory> {
}