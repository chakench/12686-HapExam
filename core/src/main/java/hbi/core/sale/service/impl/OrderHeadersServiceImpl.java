package hbi.core.sale.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.dto.OrderLines;
import hbi.core.sale.mapper.CompanysMapper;
import hbi.core.sale.mapper.OrderHeadersMapper;
import hbi.core.sale.mapper.OrderLinesMapper;
import hbi.core.sale.service.IOrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenhe on 2016/12/16.
 */
@Service("orderHeadersService")
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderHeadersService{
    @Resource(name = "orderHeadersMapper")
    private OrderHeadersMapper orderHeadersMapper;
    @Resource(name="orderLinesMapper")
    private OrderLinesMapper orderLinesMapper;
    @Resource(name="companysMapper")
    private CompanysMapper companysMapper;
    /**
     * 新增订单 (订单头，订单行)
     * @param orderHeaders
     * @param orderLines
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addOrder(OrderHeaders orderHeaders,List<OrderLines> orderLines,String companyName,String customerName) {
        for(OrderLines order:orderLines){
            System.out.print("--------------------"+orderLines);
            order.setCompanyId(companysMapper.findCompanyIdByName(companyName));
            order.setHeaderId(orderHeadersMapper.findMaxId()+1);
            order.setLineNumber(orderLinesMapper.selectMaxLineNumber()+1);
            orderLinesMapper.addOrderLine(order);
        }
        HashMap map =new HashMap();
        map.put("orderNumber",orderHeaders.getOrderNumber());
        map.put("companyName",companyName);
        map.put("customerName",customerName);
        map.put("orderDate",orderHeaders.getOrderDate());
        orderHeadersMapper.addOrderHeader(map);
    }

    /**
     * 根据订单号查询订单信息
     * @param orderNumber
     * @return
     */
    @Override
    public List<OrderInfo> findAllOrderLines(String orderNumber) {
        return orderHeadersMapper.findOrders(orderNumber);
    }

    /**
     * 删除订单行
     * @param orderLines
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteByLineNum(List<OrderLines> orderLines) {
        for(OrderLines order:orderLines){
            orderLinesMapper.deleteByLineNum(order);
        }
    }
}
