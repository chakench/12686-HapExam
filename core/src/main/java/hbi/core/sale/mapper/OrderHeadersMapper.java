package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.dto.OrderLines;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by chenhe on 2016/12/16.
 */
@Repository("orderHeadersMapper")
public interface OrderHeadersMapper extends Mapper<OrderHeaders>{
    //新增订单头
    int addOrderHeader(Map map);
    //查询订单信息
    List<OrderInfo> findOrders(String orderNumber);
    //查询最大ID
    Long findMaxId();
}
