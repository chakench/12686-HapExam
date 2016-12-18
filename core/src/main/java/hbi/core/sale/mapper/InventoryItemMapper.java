package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.InventoryItem;
import org.springframework.stereotype.Repository;

/**
 * Created by chenhe on 2016/12/18.
 */
@Repository("inventoryItemMapper")
public interface InventoryItemMapper extends Mapper<InventoryItem> {
}
