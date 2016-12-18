package hbi.core.sale.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.mapper.CompanysMapper;
import hbi.core.sale.service.ICompanysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenhe on 2016/12/15.
 */
@Service("companysService")
public class CompanysServiceImpl extends BaseServiceImpl<Companys> implements ICompanysService {
    @Autowired
    private CompanysMapper companysMapper;

    /**
     * 查询订单信息
     * @param orderInfo
     * @return
     */
    @Override
    public List<OrderInfo> findAll(OrderInfo orderInfo) {
        return companysMapper.findAll(orderInfo);
    }

    /**
     * 向excel中填充数据
     * @param orderInfos
     * @return
     */
    public List<Map<String, Object>> createExcelRecord(List<OrderInfo> orderInfos) {
       // List<OrderInfo> orderInfos=findAll(order);
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        OrderInfo orderInfo=null;
        for (int j = 0; j < orderInfos.size(); j++) {
            orderInfo=orderInfos.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("orderNumber", orderInfo.getOrderNumber());
            mapValue.put("companyName", orderInfo.getCompanyName());
            mapValue.put("customerName", orderInfo.getCustomerName());
            mapValue.put("orderDate", orderInfo.getOrderDate());
            mapValue.put("orderStatus", orderInfo.getOrderStatus());
            mapValue.put("totalPrice", orderInfo.getTotalPrice());
            listmap.add(mapValue);
        }
        return listmap;
    }

    /**
     * 根据公司名字查找公司id
     * @param companyName
     * @return
     */
    @Override
    public Long findCompanyIdByName(String companyName) {
        return companysMapper.findCompanyIdByName(companyName);
    }
}
