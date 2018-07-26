package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class EnterpriseRise implements Serializable {
    private Integer id;

    private BigDecimal enterCompareRise;

    private BigDecimal enterRandomRise;

    private BigDecimal personCompareRise;

    private BigDecimal personRandomRise;

    private BigDecimal reportDifference;

    private BigDecimal forecastDifference;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getEnterCompareRise() {
        return enterCompareRise;
    }

    public void setEnterCompareRise(BigDecimal enterCompareRise) {
        this.enterCompareRise = enterCompareRise;
    }

    public BigDecimal getEnterRandomRise() {
        return enterRandomRise;
    }

    public void setEnterRandomRise(BigDecimal enterRandomRise) {
        this.enterRandomRise = enterRandomRise;
    }

    public BigDecimal getPersonCompareRise() {
        return personCompareRise;
    }

    public void setPersonCompareRise(BigDecimal personCompareRise) {
        this.personCompareRise = personCompareRise;
    }

    public BigDecimal getPersonRandomRise() {
        return personRandomRise;
    }

    public void setPersonRandomRise(BigDecimal personRandomRise) {
        this.personRandomRise = personRandomRise;
    }

    public BigDecimal getReportDifference() {
        return reportDifference;
    }

    public void setReportDifference(BigDecimal reportDifference) {
        this.reportDifference = reportDifference;
    }

    public BigDecimal getForecastDifference() {
        return forecastDifference;
    }

    public void setForecastDifference(BigDecimal forecastDifference) {
        this.forecastDifference = forecastDifference;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterCompareRise=").append(enterCompareRise);
        sb.append(", enterRandomRise=").append(enterRandomRise);
        sb.append(", personCompareRise=").append(personCompareRise);
        sb.append(", personRandomRise=").append(personRandomRise);
        sb.append(", reportDifference=").append(reportDifference);
        sb.append(", forecastDifference=").append(forecastDifference);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}