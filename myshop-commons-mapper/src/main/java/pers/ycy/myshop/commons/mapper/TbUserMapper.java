package pers.ycy.myshop.commons.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import pers.ycy.myshop.commons.domain.TbUser;
import pers.ycy.myshop.commons.utils.RedisCache;
import tk.mybatis.mapper.MyMapper;
@CacheNamespace(implementation = RedisCache.class)
public interface TbUserMapper extends MyMapper<TbUser> {
}