package pers.ycy.myshop.service.search.api;

import pers.ycy.myshop.service.search.domain.TbItemResult;

import java.util.List;

public interface SearchService {
    /**
     * 搜索商品
     * @param query 关键字
     * @param page 页码
     * @param rows 笔数
     * @return 结果
     */
    List<TbItemResult> search(String query, int page, int rows);
}