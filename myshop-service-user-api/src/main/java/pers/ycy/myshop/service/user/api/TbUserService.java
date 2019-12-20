package pers.ycy.myshop.service.user.api;

import com.github.pagehelper.PageInfo;
import pers.ycy.myshop.commons.domain.TbUser;

import java.util.List;

public interface TbUserService {
    /**
     * 查询所有用户
     * @return 所有用户信息
     */
    List<TbUser> selectAll();

    /**
     * 分页
     * @param pageNum 页码
     * @param pageSize 一页量
     * @return 分页内容
     */
    PageInfo<TbUser> page(int pageNum, int pageSize);
}
