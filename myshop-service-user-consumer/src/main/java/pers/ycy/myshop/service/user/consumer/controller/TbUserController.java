package pers.ycy.myshop.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.ycy.myshop.commons.domain.TbUser;
import pers.ycy.myshop.service.user.api.TbUserService;
import pers.ycy.myshop.statics.backend.dto.DataTableDTO;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "user")
public class TbUserController {
    @Reference(version = "${services.versions.user.v1}")
    private TbUserService tbUserService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user/list";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public DataTableDTO<TbUser> page(HttpServletRequest request, TbUser tbUser) {

        int draw = getHsrInt(request,"draw");
        int length = getHsrInt(request,"length");
        int start = getHsrInt(request,"start");

        // 封装 Datatables 需要的结果
        PageInfo<TbUser> pageInfo = tbUserService.page(start, length);
        DataTableDTO<TbUser> dataTableDTO = new DataTableDTO<>();
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