package hbi.core.sale.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chenhe on 2016/12/15.
 *  销售订单行实体类
 */
@Table(name="hap_om_order_lines")
public class OrderLines implements Serializable{
    @Id
    @GeneratedValue
    private Long lineId;    //订单行ID
    @Column
    private Long headerId;   //订单头ID
    @Column
    private Long lineNumber;   //行号
    @Column
    private Long inventoryItemId;   //产品ID
    @Column
    private Long orderdQuantity;   //数量
    @Column
    private String orderQuantityUom;   //产品单位
    @Column
    private Long unitSellingPrice;   //销售单价
    @Column
    private String description;   //备注
    @Column
    private Long companyId;    //公司ID
    @Transient
    private Long totalPrice;  //单行总价

    @Transient
    private String itemDescription;
    @Transient
    private String itemCode;
    @Transient
    private Companys companys;
    @Transient
    private Customers customers;
    @Transient
    private InventoryItem inventoryItem;
    @Transient
    private OrderHeaders orderHeaders;
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getOrderdQuantity() {
        return orderdQuantity;
    }

    public void setOrderdQuantity(Long orderdQuantity) {
        this.orderdQuantity = orderdQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public Long getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Long unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Companys getCompanys() {
        return companys;
    }

    public void setCompanys(Companys companys) {
        this.companys = companys;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public OrderHeaders getOrderHeaders() {
        return orderHeaders;
    }

    public void setOrderHeaders(OrderHeaders orderHeaders) {
        this.orderHeaders = orderHeaders;
    }

    @Override
    public String toString() {
        return "OrderLines{" +
                "lineId=" + lineId +
                ", headerId=" + headerId +
                ", lineNumber=" + lineNumber +
                ", inventoryItemId=" + inventoryItemId +
                ", orderdQuantity=" + orderdQuantity +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", description='" + description + '\'' +
                ", companyId=" + companyId +
                ", totalPrice=" + totalPrice +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", companys=" + companys +
                ", customers=" + customers +
                ", inventoryItem=" + inventoryItem +
                ", orderHeaders=" + orderHeaders +
                '}';
    }
}
