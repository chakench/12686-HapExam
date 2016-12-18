package hbi.core.sale.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.Customers;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.service.ICompanysService;
import org.apache.xpath.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenhe on 2016/12/15.
 */
@RestController
public class CompanysController extends BaseController {
    @Autowired
    private ICompanysService companysService;

    /**
     * 查询订单信息，分页显示
     * @param request
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = "/findAll")
    public ResponseData search(HttpServletRequest request, OrderInfo orderInfo) {
        IRequest iRequest = createRequestContext(request);
        System.out.printf("orderInfo****"+orderInfo);
        List<OrderInfo> list=companysService.findAll(orderInfo);
        request.getSession().setAttribute("excelData",list);
        return new ResponseData(list);
    }
}
