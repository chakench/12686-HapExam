package hbi.core.sale.controllers;

import com.hand.hap.system.dto.ResponseData;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.dto.OrderLines;
import hbi.core.sale.service.ICompanysService;
import hbi.core.sale.service.IOrderHeadersService;
import hbi.core.sale.util.DateUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by chenhe on 2016/12/16.
 */
@RestController
public class OrderHeadersController{
    @Resource(name = "orderHeadersService")
    private IOrderHeadersService orderHeadersService;

    /**
     * 获取订单行
     * @param request
     * @param list
     * @return
     */
    @RequestMapping(value = "/addOrderLine")
    private ResponseData allOrderHeader(HttpServletRequest request, @RequestBody List<OrderLines> list){
        HttpSession session=request.getSession();
        session.removeAttribute("data");  //清除缓存
        session.setAttribute("data",list);  //将订单行放入session中
        return new ResponseData(true);
    }

    @RequestMapping(value = "/addOrderHeader")
    private ResponseData allOrderHeader1(HttpServletRequest request,String json){
        boolean f =false;

       //订单头信息
        JSONObject obj=JSONObject.fromObject(json);
        String orderNumber= (String) obj.get("orderNumber");
        String companyName= (String) obj.get("companyName");
        String customerName= (String) obj.get("customerName");
        Date orderDate= DateUtil.StrToDate((String) obj.get("orderDate"));
        //构建订单头对象
        OrderHeaders orderHeaders=new OrderHeaders(orderNumber,orderDate);

        //获取session中的订单行信息
        List<OrderLines> orderLines= (List<OrderLines>) request.getSession().getAttribute("data");
        if(orderLines!=null){
            orderHeadersService.addOrder(orderHeaders,orderLines,companyName,customerName);
        }
        return new ResponseData(f);
    }

    /**
     * 根据订单号查询订单信息
     * @param request
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "/findAllOrders")
    private ResponseData findAllOrders(HttpServletRequest request,String orderNumber){
        System.out.println("sss--"+orderNumber);
        List<OrderInfo> orderInfos=orderHeadersService.findAllOrderLines(orderNumber);
        return new ResponseData(orderInfos);
    }

    /**
     * 删除订单行
     * @param list
     * @return
     */
    @RequestMapping(value = "/deleteOrderLines")
    private ResponseData deleteOrderLines(@RequestBody List<OrderLines> list){
        System.out.print("dele**********");
        orderHeadersService.deleteByLineNum(list);
        return new ResponseData(true);
    }

}
