package hbi.core.sale.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.OrderInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenhe on 2016/12/15.
 */
public interface ICompanysService extends IBaseService<Companys>,ProxySelf<ICompanysService>{
    //查询订单信息
    List<OrderInfo> findAll(OrderInfo orderInfo);
    //向excel中填充数据
    List<Map<String, Object>> createExcelRecord(List<OrderInfo> list) ;
    //根据公司名字查找公司id
    Long findCompanyIdByName(String companyName);
}
