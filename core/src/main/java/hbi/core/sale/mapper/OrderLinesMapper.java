package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.OrderLines;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenhe on 2016/12/17.
 */
@Repository("orderLinesMapper")
public interface OrderLinesMapper extends Mapper<OrderLines> {

    //新增订单行
    int addOrderLine(OrderLines orderLines);
    //查询最大的lineNumber
    Long selectMaxLineNumber();

    //删除订单行
    void deleteByLineNum(OrderLines orderLines);
}
