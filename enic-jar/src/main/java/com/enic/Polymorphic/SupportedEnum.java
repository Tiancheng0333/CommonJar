package com.enic.Polymorphic;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SupportedEnum {

    /**
     * 默认支持所有类型业务处理
     */
    DEFAULT_CAL(SupportedEnum.getDefaultCal()),

    /**
     * 支持三角形计算
     */
    CAL_FOR_TRIANGLE(SupportedEnum.getSupportedForTriangle()),

    /**
     * 过滤 避免基类也处理业务
     */
    FACED(null);

    private List<GraphicalEnum> graphicalEnums;


    private SupportedEnum(List<GraphicalEnum> graphicalEnums) {
        this.graphicalEnums = graphicalEnums;
    }

    static List<GraphicalEnum> getDefaultCal() {
        return Arrays.asList(new GraphicalEnum[]{GraphicalEnum.CAL_FOR_RECTANGLE, GraphicalEnum.CAL_FOR_SQUARE, GraphicalEnum.CAL_FOR_TRIANGLE});
    }

    static List<GraphicalEnum> getSupportedForTriangle() {
        return Arrays.asList(new GraphicalEnum[]{GraphicalEnum.CAL_FOR_TRIANGLE});
    }

    /**
     * 计算实现的具体业务类的支持方法集
     *
     * @return
     */
    public List<Integer> getSupportedResTypeNums() {
        if (StringUtils.isEmpty(graphicalEnums)) {
            return new ArrayList<Integer>(0);
        }
        List<Integer> supportSize = new ArrayList<>(graphicalEnums.size());
        for (GraphicalEnum anEnum : graphicalEnums) {
            supportSize.add(anEnum.getClassId());
        }
        return supportSize;
    }

    public boolean isSupported(Integer classId) {
        if (null == classId) {
            return false;
        }
        return getSupportedResTypeNums().contains(classId);
    }
}
