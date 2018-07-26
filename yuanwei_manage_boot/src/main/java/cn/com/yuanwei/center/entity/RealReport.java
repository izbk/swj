package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;
public class RealReport implements Serializable {
    private Integer id;
    
    @Excel(name="企业代码",isImportField="true")
    private String enterpriseCode;

    @Excel(name="限上企业名称",isImportField="true")
    private String enterpriseName;

    @Excel(name="销售额(千元)",isImportField="true")
    private String sales;

    @Excel(name="零售额(千元)",isImportField="true")
    private String retailSales;

    @Excel(name="所属年度",isImportField="true")
    private Integer year;

//    @Excel(name="所属月份")
    private Integer month;

    @Excel(name="数据日期",format="yyyy/MM/dd",isImportField="true")
    private Date createTime;
    
    private Integer startMonth;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getRetailSales() {
        return retailSales;
    }

    public void setRetailSales(String retailSales) {
        this.retailSales = retailSales;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseCode=").append(enterpriseCode);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", sales=").append(sales);
        sb.append(", retailSales=").append(retailSales);
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public RealReport() {
		super();
	}

	public RealReport(String enterpriseCode, String enterpriseName, String sales, String retailSales, Integer year,
			Integer month, Date createTime) {
		super();
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.sales = sales;
		this.retailSales = retailSales;
		this.year = year;
		this.month = month;
		this.createTime = createTime;
	}
    
}