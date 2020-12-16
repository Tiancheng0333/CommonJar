package com.enic.RestClientTest.vo;

import java.util.Date;
import java.util.List;

public class OrderHeadVo {

    @Override
    public String toString() {
        return "OrderHeadVo{" +
                "orderId=" + orderId +
                ", orderSource=" + orderSource +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderStatusCode='" + orderStatusCode + '\'' +
                ", resourceStatus='" + resourceStatus + '\'' +
                ", remark='" + remark + '\'' +
                ", isShowInsurance=" + isShowInsurance +
                ", routeTypeDesc='" + routeTypeDesc + '\'' +
                ", productTypeDesc='" + productTypeDesc + '\'' +
                ", saleType=" + saleType +
                ", orderChannel=" + orderChannel +
                ", salerId=" + salerId +
                ", salerName='" + salerName + '\'' +
                ", salerNameAndHandOver='" + salerNameAndHandOver + '\'' +
                ", salerManagerName='" + salerManagerName + '\'' +
                ", clearTime=" + clearTime +
                ", promClearTime=" + promClearTime +
                ", addTime=" + addTime +
                ", producterId=" + producterId +
                ", producterName='" + producterName + '\'' +
                ", producterManagerName='" + producterManagerName + '\'' +
                ", confirmSalerNameList=" + confirmSalerNameList +
                ", confirmSalerIdList=" + confirmSalerIdList +
                ", confirmManagerNameList=" + confirmManagerNameList +
                ", confirmSalerId=" + confirmSalerId +
                ", confirmSalerName='" + confirmSalerName + '\'' +
                ", confirmManagerId=" + confirmManagerId +
                ", confirmManagerName='" + confirmManagerName + '\'' +
                ", hotelTypeFlag=" + hotelTypeFlag +
                ", filghtItemOwnerId=" + filghtItemOwnerId +
                ", filghtItemOwnerName='" + filghtItemOwnerName + '\'' +
                ", filghtItemManagerName='" + filghtItemManagerName + '\'' +
                ", filghtPackageOwnerId=" + filghtPackageOwnerId +
                ", filghtPackageOwnerName='" + filghtPackageOwnerName + '\'' +
                ", filghtPackageManagerName='" + filghtPackageManagerName + '\'' +
                ", complaintSalerId=" + complaintSalerId +
                ", complaintsName='" + complaintsName + '\'' +
                ", storeSalerId=" + storeSalerId +
                ", storeSalerName='" + storeSalerName + '\'' +
                ", displaySignAfter=" + displaySignAfter +
                ", stmOrderStatus='" + stmOrderStatus + '\'' +
                ", signStatus=" + signStatus +
                ", isSignChange=" + isSignChange +
                ", beforeChangeStatus='" + beforeChangeStatus + '\'' +
                ", isInstallment=" + isInstallment +
                ", groupId=" + groupId +
                ", signNum='" + signNum + '\'' +
                ", productDeadlineTime='" + productDeadlineTime + '\'' +
                ", visaResiverEndTime='" + visaResiverEndTime + '\'' +
                ", connectShowFlag=" + connectShowFlag +
                ", visaShowFlag=" + visaShowFlag +
                ", custLevel=" + custLevel +
                ", isNiuPlus=" + isNiuPlus +
                ", custMaintainPerson='" + custMaintainPerson + '\'' +
                ", orderOnlineChangeFlag=" + orderOnlineChangeFlag +
                ", custTel='" + custTel + '\'' +
                ", custId=" + custId +
                ", custType=" + custType +
                ", temaiCampaignName='" + temaiCampaignName + '\'' +
                ", explosion=" + explosion +
                ", isTwophaseOrder=" + isTwophaseOrder +
                ", productClassId=" + productClassId +
                ", hasDumplicatedOrder=" + hasDumplicatedOrder +
                ", sourcePartner=" + sourcePartner +
                ", canShowNewOperatorList=" + canShowNewOperatorList +
                ", recommendedTag=" + recommendedTag +
                ", mstEmployeeName='" + mstEmployeeName + '\'' +
                ", mstEmployeeTel='" + mstEmployeeTel + '\'' +
                ", isMstOrder=" + isMstOrder +
                ", mstStoreName='" + mstStoreName + '\'' +
                '}';
    }

    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 订单来源
     */
    private Integer orderSource;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * order status code
     */
    private String orderStatusCode;

    /**
     * resource status
     */
    private String resourceStatus;

    
    /**
     * 接单备注
     */
    private String remark;
    
    /**
     * is show insurance
     */
    private boolean isShowInsurance;

    /**
     * 线路类型描述
     */
    private String routeTypeDesc;

    /**
     * 产品类型
     * @see
     */
    private String productTypeDesc;

    /**
     * 售卖形式
     */
    private int saleType;

    /**
     * 下单渠道
     */
    private Integer orderChannel;

    /**
     * 专属客服id
     */
    private Integer salerId;

    /**
     * 专属客服姓名
     */
    private String salerName;

    /**
     * 专属客服姓名并已经交接给谁
     */
    private String salerNameAndHandOver;

    /**
     * 客服经理姓名
     */
    private String salerManagerName;

    /**
     * 订单清位时间
     */
    private Date clearTime;

	/**
     * 促销清位时间
     */
    private Date promClearTime;
    
    /**
     * 订单下单时间
     */
    private Date addTime;

    /**
     * 产品专员id
     */
    private int producterId;

    /**
     * 产品专员
     */
    private String producterName;

    /**
     * 产品经理
     */
    private String producterManagerName;

    /**
     * 确认专员  (兼容老数据使用，新的转用运营专员字段)
     */
    private List<String> confirmSalerNameList;

    /**
     * 确认专员 id 列表 (兼容老数据使用，新的转用运营专员字段)
     */
    private List<Integer> confirmSalerIdList;

    /**
     * 确认经理 id 列表 (兼容老数据使用，新的转用运营经理字段)
     */
    private List<String> confirmManagerNameList;
    
    /**
     * 运营专员ID
     */
    private Integer confirmSalerId;
    
    /**
     * 运营专员
     */
    private String confirmSalerName;
    
    /**
     * 运营经理id
     */
    private Integer confirmManagerId;
    
    /**
     * 运营经理
     */
    private String confirmManagerName;
    
    /**
     * 酒店类型标识（0 非散客酒店，1 国内散客酒店，2 国际散客酒店）
     */
    private int hotelTypeFlag;
    

	/**
     * 机票专员id(散客票)
     */
    private Integer filghtItemOwnerId;

    /**
     * 机票专员(散客票)
     */
    private String filghtItemOwnerName;

    /**
     * 机票经理(散客票)
     */
    private String filghtItemManagerName;
    
    /**
     * 机票专员id(团队票)
     */
    private Integer filghtPackageOwnerId;

    /**
     * 机票专员(团队票)
     */
    private String filghtPackageOwnerName;

    /**
     * 机票经理(团队票)
     */
    private String filghtPackageManagerName;

    /**
     * 投诉处理人id
     */
    private int complaintSalerId;

    /**
     * 投诉处理人
     */
    private String complaintsName;

    /**
     * 门市客服id
     */
    private int storeSalerId;

    /**
     * 门市客服
     */
    private String storeSalerName;

    /**
     * 是㫘显示签约后变更按钮
     */

    private int displaySignAfter;

    /**
     * 当前订单的状态code
     */
    private String stmOrderStatus;

    /** 是否已经签约 */
    private Integer signStatus;

    /**
     * 是否是签约后变更
     */
    private Boolean isSignChange = false;
        
    private String beforeChangeStatus;
    
    /**
     * 是否首付出发  0为否 1为是
     */
    private Integer isInstallment = 0;
    
    /**
     * 自组团号
     */
    private Integer groupId;

    /*合同编号*/
    private String signNum;

    /*材料截止收取時間*/
    private String productDeadlineTime;
 
    /**
     * 签证材料接受截止时间
     */
    private String visaResiverEndTime;
    
    /**
     * 联运资源是不是展示
     */
    private Boolean connectShowFlag  = false;
    
    /**
     * 签证资源是不是展示
     */
    private Boolean visaShowFlag  = false;
    /**
     * 会员等级
     */
    private Integer custLevel;
    /**
     * 是否是有效的黑卡会员   1 是 0 不是
     */
    private Integer isNiuPlus;
    /**
     * 会员维护人
     */
    private String custMaintainPerson;

    private Boolean orderOnlineChangeFlag = false;
    
    /**
     * 手机号
     */
    private String custTel;
    
    /**
     * 会员id
     */
    private Integer custId;

    /**
     * 会员类型
     */
    private Integer custType;

    /**
     * 特卖类型
     */
    private String temaiCampaignName;
    /**
     * 爆款标识     0 不是 1 是
     */
    private Integer explosion;

    /**
     * 是否是二次预约订单 0 不是 1 是
     */
    private Integer isTwophaseOrder;
    
    /**
     * 产品品类id
     */
    private Integer productClassId;

    /**
     * 重单标志  true有重单  false没有重单
     */
    private Boolean hasDumplicatedOrder;

    /**
     * 外渠道类型
     */
    private Integer sourcePartner;

    /**
     * 是否能够显示新的运营列表
     */
    private boolean canShowNewOperatorList = false;

    /**
     * 是否推荐客人使用首付出发
     * 0:未推荐,1:已推荐
     */
    private Integer recommendedTag = 0;

    /**
     * 合作店店员姓名
     */
    private String mstEmployeeName;

    /**
     * 合作店店员手机号
     */
    private String mstEmployeeTel;

    /**
     * 是不是合作店订单标识
     */
    private Boolean isMstOrder = false;

    /**
     * 合作店店名
     * @return
     */
    private String mstStoreName;

    public String getMstStoreName() {
        return mstStoreName;
    }

    public void setMstStoreName(String mstStoreName) {
        this.mstStoreName = mstStoreName;
    }

    public Boolean getIsMstOrder() {
        return isMstOrder;
    }

    public void setIsMstOrder(Boolean isMstOrder) {
        this.isMstOrder = isMstOrder;
    }

    public String getMstEmployeeName() {
        return mstEmployeeName;
    }

    public void setMstEmployeeName(String mstEmployeeName) {
        this.mstEmployeeName = mstEmployeeName;
    }

    public String getMstEmployeeTel() {
        return mstEmployeeTel;
    }

    public void setMstEmployeeTel(String mstEmployeeTel) {
        this.mstEmployeeTel = mstEmployeeTel;
    }

    public Integer getRecommendedTag() {
        return recommendedTag;
    }

    public void setRecommendedTag(Integer recommendedTag) {
        this.recommendedTag = recommendedTag;
    }

    public Integer getCustType() {
        return custType;
    }

    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    public boolean isCanShowNewOperatorList() {
        return canShowNewOperatorList;
    }

    public void setCanShowNewOperatorList(boolean canShowNewOperatorList) {
        this.canShowNewOperatorList = canShowNewOperatorList;
    }
    public Date getPromClearTime() {
        return promClearTime;
    }

    public void setPromClearTime(Date promClearTime) {
        this.promClearTime = promClearTime;
    }

	public String getTemaiCampaignName() {
		return temaiCampaignName;
	}

	public void setTemaiCampaignName(String temaiCampaignName) {
		this.temaiCampaignName = temaiCampaignName;
	}

	public Integer getExplosion() {
		return explosion;
	}

	public void setExplosion(Integer explosion) {
		this.explosion = explosion;
	}

    public Integer getIsTwophaseOrder() {
        return isTwophaseOrder;
    }

    public void setIsTwophaseOrder(Integer isTwophaseOrder) {
        this.isTwophaseOrder = isTwophaseOrder;
    }

    public String getStmOrderStatus() {
        return stmOrderStatus;
    }

    public void setStmOrderStatus(String stmOrderStatus) {
        this.stmOrderStatus = stmOrderStatus;
    }

    public int getDisplaySignAfter() {
        return displaySignAfter;
    }

    public void setDisplaySignAfter(int displaySignAfter) {
        this.displaySignAfter = displaySignAfter;
    }

    /**
     * @return the orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderSource
     */
    public Integer getOrderSource() {
        return orderSource;
    }

    /**
     * @param orderSource the orderSource to set
     */
    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the routeTypeDesc
     */
    public String getRouteTypeDesc() {
        return routeTypeDesc;
    }

    /**
     * @param routeTypeDesc the routeTypeDesc to set
     */
    public void setRouteTypeDesc(String routeTypeDesc) {
        this.routeTypeDesc = routeTypeDesc;
    }

    /**
     * @return the productTypeDesc
     */
    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    /**
     * @param productTypeDesc the productTypeDesc to set
     */
    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
    }

    /**
     * @return the saleType
     */
    public int getSaleType() {
        return saleType;
    }

    /**
     * @param saleType the saleType to set
     */
    public void setSaleType(int saleType) {
        this.saleType = saleType;
    }

    /**
     * @return the orderChannel
     */
    public Integer getOrderChannel() {
        return orderChannel;
    }

    /**
     * @param orderChannel the orderChannel to set
     */
    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }

    /**
     * @return the salerId
     */
    public Integer getSalerId() {
        return salerId;
    }

    /**
     * @param salerId the salerId to set
     */
    public void setSalerId(Integer salerId) {
        this.salerId = salerId;
    }

    /**
     * @return the salerName
     */
    public String getSalerName() {
        return salerName;
    }

    /**
     * @param salerName the salerName to set
     */
    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    /**
     * @return the salerManagerName
     */
    public String getSalerManagerName() {
        return salerManagerName;
    }

    /**
     * @param salerManagerName the salerManagerName to set
     */
    public void setSalerManagerName(String salerManagerName) {
        this.salerManagerName = salerManagerName;
    }

    /**
     * @return the clearTime
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     * @param clearTime the clearTime to set
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
    }

    /**
     * @return the producterId
     */
    public int getProducterId() {
        return producterId;
    }

    /**
     * @param producterId the producterId to set
     */
    public void setProducterId(int producterId) {
        this.producterId = producterId;
    }

    /**
     * @return the producterName
     */
    public String getProducterName() {
        return producterName;
    }

    /**
     * @param producterName the producterName to set
     */
    public void setProducterName(String producterName) {
        this.producterName = producterName;
    }

    /**
     * @return the producterManagerName
     */
    public String getProducterManagerName() {
        return producterManagerName;
    }

    /**
     * @param producterManagerName the producterManagerName to set
     */
    public void setProducterManagerName(String producterManagerName) {
        this.producterManagerName = producterManagerName;
    }

    /**
     * @return the confirmSalerNameList
     */
    public List<String> getConfirmSalerNameList() {
        return confirmSalerNameList;
    }

    /**
     * @param confirmSalerNameList the confirmSalerNameList to set
     */
    public void setConfirmSalerNameList(List<String> confirmSalerNameList) {
        this.confirmSalerNameList = confirmSalerNameList;
    }

    /**
     * @return the confirmSalerIdList
     */
    public List<Integer> getConfirmSalerIdList() {
        return confirmSalerIdList;
    }

    /**
     * @param confirmSalerIdList the confirmSalerIdList to set
     */
    public void setConfirmSalerIdList(List<Integer> confirmSalerIdList) {
        this.confirmSalerIdList = confirmSalerIdList;
    }

    /**
     * @return the confirmManagerNameList
     */
    public List<String> getConfirmManagerNameList() {
        return confirmManagerNameList;
    }

    /**
     * @param confirmManagerNameList the confirmManagerNameList to set
     */
    public void setConfirmManagerNameList(List<String> confirmManagerNameList) {
        this.confirmManagerNameList = confirmManagerNameList;
    }

    /**
     * @return the complaintSalerId
     */
    public int getComplaintSalerId() {
        return complaintSalerId;
    }

    /**
     * @param complaintSalerId the complaintSalerId to set
     */
    public void setComplaintSalerId(int complaintSalerId) {
        this.complaintSalerId = complaintSalerId;
    }

    /**
     * @return the complaintsName
     */
    public String getComplaintsName() {
        return complaintsName;
    }

    /**
     * @param complaintsName the complaintsName to set
     */
    public void setComplaintsName(String complaintsName) {
        this.complaintsName = complaintsName;
    }

    /**
     * @return the storeSalerId
     */
    public int getStoreSalerId() {
        return storeSalerId;
    }

    /**
     * @param storeSalerId the storeSalerId to set
     */
    public void setStoreSalerId(int storeSalerId) {
        this.storeSalerId = storeSalerId;
    }

    /**
     * @return the storeSalerName
     */
    public String getStoreSalerName() {
        return storeSalerName;
    }

    /**
     * @param storeSalerName the storeSalerName to set
     */
    public void setStoreSalerName(String storeSalerName) {
        this.storeSalerName = storeSalerName;
    }

    /**
     * @return the isShowInsurance
     */
    public boolean isShowInsurance() {
        return isShowInsurance;
    }

    /**
     * @param isShowInsurance the isShowInsurance to set
     */
    public void setShowInsurance(boolean isShowInsurance) {
        this.isShowInsurance = isShowInsurance;
    }

    /**
     * @return the orderStatusCode
     */
    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    /**
     * @param orderStatusCode the orderStatusCode to set
     */
    public void setOrderStatusCode(String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    /**
     * @return the resourceStatus
     */
    public String getResourceStatus() {
        return resourceStatus;
    }

    /**
     * @param resourceStatus the resourceStatus to set
     */
    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public String getSalerNameAndHandOver() {
        return salerNameAndHandOver;
    }

    public void setSalerNameAndHandOver(String salerNameAndHandOver) {
        this.salerNameAndHandOver = salerNameAndHandOver;
    }

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the isSignChange
	 */
	public Boolean getIsSignChange() {
		return isSignChange;
	}

	/**
	 * @param isSignChange the isSignChange to set
	 */
	public void setIsSignChange(Boolean isSignChange) {
		this.isSignChange = isSignChange;
	}

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public String getBeforeChangeStatus() {
        return beforeChangeStatus;
    }

    public void setBeforeChangeStatus(String beforeChangeStatus) {
        this.beforeChangeStatus = beforeChangeStatus;
    }

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getFilghtItemOwnerName() {
		return filghtItemOwnerName;
	}

	public void setFilghtItemOwnerName(String filghtItemOwnerName) {
		this.filghtItemOwnerName = filghtItemOwnerName;
	}

	public String getFilghtItemManagerName() {
		return filghtItemManagerName;
	}

	public void setFilghtItemManagerName(String filghtItemManagerName) {
		this.filghtItemManagerName = filghtItemManagerName;
	}

	public String getFilghtPackageOwnerName() {
		return filghtPackageOwnerName;
	}

	public void setFilghtPackageOwnerName(String filghtPackageOwnerName) {
		this.filghtPackageOwnerName = filghtPackageOwnerName;
	}

	public String getFilghtPackageManagerName() {
		return filghtPackageManagerName;
	}

	public void setFilghtPackageManagerName(String filghtPackageManagerName) {
		this.filghtPackageManagerName = filghtPackageManagerName;
	}

	public Integer getConfirmSalerId() {
		return confirmSalerId;
	}

	public void setConfirmSalerId(Integer confirmSalerId) {
		this.confirmSalerId = confirmSalerId;
	}

	public String getConfirmSalerName() {
		return confirmSalerName;
	}

	public void setConfirmSalerName(String confirmSalerName) {
		this.confirmSalerName = confirmSalerName;
	}

	public String getConfirmManagerName() {
		return confirmManagerName;
	}

	public void setConfirmManagerName(String confirmManagerName) {
		this.confirmManagerName = confirmManagerName;
	}

	public Integer getFilghtItemOwnerId() {
		return filghtItemOwnerId;
	}

	public void setFilghtItemOwnerId(Integer filghtItemOwnerId) {
		this.filghtItemOwnerId = filghtItemOwnerId;
	}

	public Integer getFilghtPackageOwnerId() {
		return filghtPackageOwnerId;
	}

	public void setFilghtPackageOwnerId(Integer filghtPackageOwnerId) {
		this.filghtPackageOwnerId = filghtPackageOwnerId;
	}

	/**
	 * @return the isInstallment
	 */
	public Integer getIsInstallment() {
		return isInstallment;
	}

	/**
	 * @param isInstallment the isInstallment to set
	 */
	public void setIsInstallment(Integer isInstallment) {
		this.isInstallment = isInstallment;
	}

 
	public String getVisaResiverEndTime() {
		return visaResiverEndTime;
	}

	public void setVisaResiverEndTime(String visaResiverEndTime) {
		this.visaResiverEndTime = visaResiverEndTime;
	}

	public Boolean getVisaShowFlag() {
		return visaShowFlag;
	}

	public void setVisaShowFlag(Boolean visaShowFlag) {
		this.visaShowFlag = visaShowFlag;
	}

 
    public String getSignNum() {
        return signNum;
    }

    public void setSignNum(String signNum) {
        this.signNum = signNum;
    }

    public String getProductDeadlineTime() {
        return productDeadlineTime;
    }

    public void setProductDeadlineTime(String productDeadlineTime) {
        this.productDeadlineTime = productDeadlineTime;
    }

	public Integer getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(Integer custLevel) {
		this.custLevel = custLevel;
	}

	public Integer getIsNiuPlus() {
		return isNiuPlus;
	}

	public void setIsNiuPlus(Integer isNiuPlus) {
		this.isNiuPlus = isNiuPlus;
	}

	public String getCustMaintainPerson() {
		return custMaintainPerson;
	}

	public void setCustMaintainPerson(String custMaintainPerson) {
		this.custMaintainPerson = custMaintainPerson;
	}
    
    
    
    public int getHotelTypeFlag() {
		return hotelTypeFlag;
	}

	public void setHotelTypeFlag(int hotelTypeFlag) {
		this.hotelTypeFlag = hotelTypeFlag;
	}

	public Integer getConfirmManagerId() {
		return confirmManagerId;
	}

	public void setConfirmManagerId(Integer confirmManagerId) {
		this.confirmManagerId = confirmManagerId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getCustTel() {
		return custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
    
	

    public Boolean getOrderOnlineChangeFlag() {
        return orderOnlineChangeFlag;
    }

    public void setOrderOnlineChangeFlag(Boolean orderOnlineChangeFlag) {
        this.orderOnlineChangeFlag = orderOnlineChangeFlag;
    }

	public Integer getProductClassId() {
		return productClassId;
	}

	public void setProductClassId(Integer productClassId) {
		this.productClassId = productClassId;
	}

	public Boolean getConnectShowFlag() {
		return connectShowFlag;
	}

	public void setConnectShowFlag(Boolean connectShowFlag) {
		this.connectShowFlag = connectShowFlag;
	}
    
	public Boolean getHasDumplicatedOrder() {
		return hasDumplicatedOrder;
	}

	public void setHasDumplicatedOrder(Boolean hasDumplicatedOrder) {
		this.hasDumplicatedOrder = hasDumplicatedOrder;
	}
    
    public Integer getSourcePartner() {
        return sourcePartner;
    }

    public void setSourcePartner(Integer sourcePartner) {
        this.sourcePartner = sourcePartner;
    }

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

}
