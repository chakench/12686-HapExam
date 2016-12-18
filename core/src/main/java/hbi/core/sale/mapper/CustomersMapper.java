package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.Customers;

import java.util.List;

/**
 * Created by chenhe on 2016/12/15.
 */
public interface CustomersMapper extends Mapper<Customers> {
    //根据公司ID关联查询客户信息
    List<Customers> findCustomer(Long companyId);
}
