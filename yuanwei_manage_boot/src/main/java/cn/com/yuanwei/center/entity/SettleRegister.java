package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SettleRegister implements Serializable {
    private Integer id;

    private String idNumber;

    private String name;

    private Integer sex;

    private Integer age;

    private String political;

    private String nativePlace;

    private Integer nation;

    private String mobile;

    private String email;

    private String address;

    private String pic;

    private String businessSubject;

    private String legalPerson;

    private String businessLicense;

    private Integer companyType;

    private BigDecimal businessIncome;

    private String businessPlace;

    private Integer settledPlatform;

    private String shopName;

    private String shopUrl;

    private String creditRating;

    private String companyWebsite;

    private String category;

    private String averageMonthlySales;

    private Integer applicationRoom;

    private String applicationArea;

    private Integer equipmentSource;

    private String businessScope;

    private Integer teamNumber;

    private Integer joinAssociation;

    private String projectIntroduction;

    private Integer status;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getBusinessSubject() {
        return businessSubject;
    }

    public void setBusinessSubject(String businessSubject) {
        this.businessSubject = businessSubject == null ? null : businessSubject.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public BigDecimal getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(BigDecimal businessIncome) {
        this.businessIncome = businessIncome;
    }

    public String getBusinessPlace() {
        return businessPlace;
    }

    public void setBusinessPlace(String businessPlace) {
        this.businessPlace = businessPlace == null ? null : businessPlace.trim();
    }

    public Integer getSettledPlatform() {
        return settledPlatform;
    }

    public void setSettledPlatform(Integer settledPlatform) {
        this.settledPlatform = settledPlatform;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl == null ? null : shopUrl.trim();
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating == null ? null : creditRating.trim();
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite == null ? null : companyWebsite.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getAverageMonthlySales() {
        return averageMonthlySales;
    }

    public void setAverageMonthlySales(String averageMonthlySales) {
        this.averageMonthlySales = averageMonthlySales == null ? null : averageMonthlySales.trim();
    }

    public Integer getApplicationRoom() {
        return applicationRoom;
    }

    public void setApplicationRoom(Integer applicationRoom) {
        this.applicationRoom = applicationRoom;
    }

    public String getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(String applicationArea) {
        this.applicationArea = applicationArea == null ? null : applicationArea.trim();
    }

    public Integer getEquipmentSource() {
        return equipmentSource;
    }

    public void setEquipmentSource(Integer equipmentSource) {
        this.equipmentSource = equipmentSource;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public Integer getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }

    public Integer getJoinAssociation() {
        return joinAssociation;
    }

    public void setJoinAssociation(Integer joinAssociation) {
        this.joinAssociation = joinAssociation;
    }

    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction == null ? null : projectIntroduction.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", political=").append(political);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", nation=").append(nation);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", pic=").append(pic);
        sb.append(", businessSubject=").append(businessSubject);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", companyType=").append(companyType);
        sb.append(", businessIncome=").append(businessIncome);
        sb.append(", businessPlace=").append(businessPlace);
        sb.append(", settledPlatform=").append(settledPlatform);
        sb.append(", shopName=").append(shopName);
        sb.append(", shopUrl=").append(shopUrl);
        sb.append(", creditRating=").append(creditRating);
        sb.append(", companyWebsite=").append(companyWebsite);
        sb.append(", category=").append(category);
        sb.append(", averageMonthlySales=").append(averageMonthlySales);
        sb.append(", applicationRoom=").append(applicationRoom);
        sb.append(", applicationArea=").append(applicationArea);
        sb.append(", equipmentSource=").append(equipmentSource);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", teamNumber=").append(teamNumber);
        sb.append(", joinAssociation=").append(joinAssociation);
        sb.append(", projectIntroduction=").append(projectIntroduction);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}