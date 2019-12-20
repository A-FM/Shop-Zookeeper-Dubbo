package pers.ycy.myshop.service.search.provider.mapper;

import org.springframework.stereotype.Repository;
import pers.ycy.myshop.service.search.domain.TbItemResult;

import java.util.List;

@Repository
public interface TbItemResultMapper {
    List<TbItemResult> selectAll();
}