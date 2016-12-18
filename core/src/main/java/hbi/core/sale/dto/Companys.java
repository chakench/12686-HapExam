package hbi.core.sale.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by chenhe on 2016/12/15.
 *  公司实体类
 */
@Table(name="hap_org_companys")
public class Companys {
    @Id
    @GeneratedValue
    private Long companyId;   //公司ID
    @Column
    private String companyNumber;   //公司编号
    @Column
    private String companyName;   //公司名称
    @Column
    private String enabledFlag;  //启用标识
    @Column
    private Date creationDate;    //创建日期
    @Column
    private Long createdBy;   //创建者
    @Column
    private Long lastUpdatedBy;  //更新者
    @Column
    private Date lastUpdateDate;  //更新日期
    @Column
    private Long lastUpdateLogin;  //更新者登录ID
    @Transient
    private List<Customers> customersList;
    @Transient
    private List<OrderHeaders> orderHeadersList;
    @Transient
    private List<OrderLines> orderLinesList;
    @Transient
    private List<InventoryItem> inventoryItems;
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    public List<OrderHeaders> getOrderHeadersList() {
        return orderHeadersList;
    }

    public void setOrderHeadersList(List<OrderHeaders> orderHeadersList) {
        this.orderHeadersList = orderHeadersList;
    }

    public List<OrderLines> getOrderLinesList() {
        return orderLinesList;
    }

    public void setOrderLinesList(List<OrderLines> orderLinesList) {
        this.orderLinesList = orderLinesList;
    }

    public List<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    @Override
    public String toString() {
        return "Companys{" +
                "companyId=" + companyId +
                ", companyNumber='" + companyNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
