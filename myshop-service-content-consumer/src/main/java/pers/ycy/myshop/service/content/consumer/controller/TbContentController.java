package pers.ycy.myshop.service.content.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.ycy.myshop.commons.domain.TbContent;
import pers.ycy.myshop.service.content.api.TbContentService;
import pers.ycy.myshop.statics.backend.dto.DataTableDTO;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "content", method = RequestMethod.GET)
public class TbContentController {

    @Reference(version = "${services.versions.content.v1}")
    private TbContentService tbContentService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "content/list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content/form";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public DataTableDTO<TbContent> page(HttpServletRequest request, TbContent tbContent) {

        int draw = getHsrInt(request, "draw");
        int length = getHsrInt(request, "length");
        int start = getHsrInt(request, "start");

        // 封装 Datatables 需要的结果
        PageInfo<TbContent> pageInfo = tbContentService.page(start, length, tbContent);
        DataTableDTO<TbContent> dataTableDTO = new DataTableDTO<>();
        dataTableDTO.setData(pageInfo.getList());
        dataTableDTO.setDraw(draw);
        dataTableDTO.setRecordsTotal(pageInfo.getTotal());
        dataTableDTO.setRecordsFiltered(pageInfo.getTotal());

        return dataTableDTO;
    }

    private int getHsrInt(HttpServletRequest request, String param) {
        String parameter = request.getParameter(param);
        return parameter == null ? 0 : Integer.parseInt(parameter);
    }

}
