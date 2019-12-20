package pers.ycy.myshop.service.content.api;

import com.github.pagehelper.PageInfo;
import pers.ycy.myshop.commons.domain.TbContent;

public interface TbContentService {
    PageInfo<TbContent> page(int offset, int length, TbContent tbContent);
}
