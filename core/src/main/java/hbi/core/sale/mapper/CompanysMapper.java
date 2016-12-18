package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chenhe on 2016/12/15.
 */
@Repository("companysMapper")
public interface CompanysMapper extends Mapper<Companys>{
    //查询订单信息
    List<OrderInfo> findAll(OrderInfo orderInfo);
    //根据公司名字查找公司id
    Long findCompanyIdByName(String companyName);
}
