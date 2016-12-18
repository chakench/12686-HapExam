package hbi.core.sale.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.dto.OrderLines;

import java.util.List;

/**
 * Created by chenhe on 2016/12/16.
 */
public interface IOrderHeadersService extends IBaseService<OrderHeaders>,ProxySelf<IOrderHeadersService> {
    //新增订单
    void addOrder(OrderHeaders orderHeaders,List<OrderLines> orderLines,String companyName,String customerName);

    //查询订单信息
    List<OrderInfo> findAllOrderLines(String orderNumber);

    //删除订单行
    void deleteByLineNum(List<OrderLines> orderLines);
}
