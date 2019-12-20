package pers.ycy.myshop.service.content.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.myshop.commons.domain.TbContent;
import pers.ycy.myshop.commons.mapper.TbContentMapper;
import pers.ycy.myshop.service.content.api.TbContentService;

@Service(version = "${services.versions.content.v1}")
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public PageInfo<TbContent> page(int offset, int length, TbContent tbContent) {
        PageHelper.offsetPage(offset,length);

        return new PageInfo<>(tbContentMapper.select(tbContent));
    }
}
