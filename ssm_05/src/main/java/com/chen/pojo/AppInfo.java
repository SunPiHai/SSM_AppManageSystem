package com.chen.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AppInfo {
    private Long id;

    private String softwareName;

    private String apkName;

    private String supportRom;

    private String interfaceLanguage;

    private BigDecimal softwareSize;

    private Date updateDate;

    private Long devId;

    private String appInfo;

    private Long status;

    private Date onSaleDate;

    private Date offSaleDate;

    private Long flatformId;

    private Long downloads;

    private Long createdBy;

    private Date creationDate;

    private Long modifyBy;

    private Date modifyByDate;

    private String logoPicPath;

    private String logoLocPath;

    //和appCategory
//       private Long categoryLevel1;
//    private Long categoryLevel2;
//    private Long categoryLevel3;
    private AppCategory categoryLevel1;
    private AppCategory categoryLevel3;
    private AppCategory categoryLevel2;

    private Long versionId;
    //app_version
    private List<AppVersion> appVersions;
    //最新version
    private AppVersion newAppVersion;
    /**
     * 开发者
     */
    private DevUser devUser;
    /**
     * 修改者
     */
    private DevUser modifyUser;
    /**
     * 创建者
     */
    private DevUser createUser;
    //平台信息
    private DataDictionary flatform;

    private DataDictionary appStatus;

    public DevUser getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(DevUser modifyUser) {
        this.modifyUser = modifyUser;
    }

    public DevUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(DevUser createUser) {
        this.createUser = createUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getSupportRom() {
        return supportRom;
    }

    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public Long getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Long flatformId) {
        this.flatformId = flatformId;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyByDate() {
        return modifyByDate;
    }

    public void setModifyByDate(Date modifyByDate) {
        this.modifyByDate = modifyByDate;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }

    public AppCategory getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(AppCategory categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public AppCategory getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(AppCategory categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public AppCategory getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(AppCategory categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public List<AppVersion> getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(List<AppVersion> appVersions) {
        this.appVersions = appVersions;
    }

    public AppVersion getNewAppVersion() {
        return newAppVersion;
    }

    public void setNewAppVersion(AppVersion newAppVersion) {
        this.newAppVersion = newAppVersion;
    }

    public DevUser getDevUser() {
        return devUser;
    }

    public void setDevUser(DevUser devUser) {
        this.devUser = devUser;
    }

    public DataDictionary getFlatform() {
        return flatform;
    }

    public void setFlatform(DataDictionary flatform) {
        this.flatform = flatform;
    }

    public DataDictionary getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(DataDictionary appStatus) {
        this.appStatus = appStatus;
    }
}