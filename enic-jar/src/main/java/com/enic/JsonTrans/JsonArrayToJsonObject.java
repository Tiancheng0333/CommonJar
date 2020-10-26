package com.enic.JsonTrans;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class JsonArrayToJsonObject {
    public static void main(String[] args) {
        String s="[{\"id\":26671,\"tuniuId\":83495887,\"ownerName\":\"赵茜5\",\"oaNameEn\":\"zhaoqian5\",\"nickName\":\"UXVlZW5h\",\"userType\":1,\"headImage\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLic9afODQZKlA4Qj7iaUFxR1dy4ONkHsFicW5aUfnnpyr3d5xXmgtF5wE7UPAYL0dA0HXX31gxIB7lA/132\",\"spaceId\":0,\"vUserId\":0,\"openId\":\"\",\"ownerIdentityPicFront\":\"\",\"ownerIdentityPicReverse\":\"\",\"ownerQualificationPic\":\"\",\"ownerPhone\":\"15125235345\",\"ownerIdentityNo\":\"\",\"updateTime\":\"2020-09-16\",\"pValue\":\"67722\",\"channel\":5,\"uid\":26037,\"earnSecondaryCommission\":0,\"customerServiceAssigned\":0}]";
        List<TUserInfo> tUserInfos = JSONArray.parseArray(s, TUserInfo.class);
        System.out.println(tUserInfos);
    }
}
