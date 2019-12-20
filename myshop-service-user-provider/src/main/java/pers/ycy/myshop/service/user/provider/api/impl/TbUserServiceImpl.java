package pers.ycy.myshop.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.myshop.commons.domain.TbUser;
import pers.ycy.myshop.commons.mapper.TbUserMapper;
import pers.ycy.myshop.service.user.api.TbUserService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "${services.versions.user.v1}")
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;


    @Override
    public List<TbUser> selectAll() {
        return tbUserMapper.selectAll();
    }

    @Override
    public PageInfo<TbUser> page(int pageNum, int pageSize) {

        Example example = new Example(TbUser.class);
        PageHelper.offsetPage(pageNum,pageSize);
        return new PageInfo<>(tbUserMapper.selectByExample(example));
    }
}
