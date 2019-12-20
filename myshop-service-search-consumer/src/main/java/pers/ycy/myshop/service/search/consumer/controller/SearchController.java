package pers.ycy.myshop.service.search.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.myshop.service.search.api.SearchService;
import pers.ycy.myshop.service.search.domain.TbItemResult;

import java.util.List;

@RestController
public class SearchController {

    @Reference(version = "${services.versions.search.v1}")
    private SearchService searchService;

    @RequestMapping(value = "search/{query}/{page}/{rows}",method = RequestMethod.GET)
    public List<TbItemResult> search(@PathVariable(required = true) String query,@PathVariable(required = true) int page,@PathVariable(required = true) int rows){
        return searchService.search(query,page,rows);
    }

}
