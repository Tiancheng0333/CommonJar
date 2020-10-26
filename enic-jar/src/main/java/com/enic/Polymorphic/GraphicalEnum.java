package com.enic.Polymorphic;


public enum GraphicalEnum {

    /**
     * 业务处理分类
     */
    CAL_FOR_TRIANGLE(1, "三角形"),

    CAL_FOR_SQUARE(2, "正方形"),

    CAL_FOR_RECTANGLE(3, "长方形");

    private Integer classId;

    private String graphical;

    private GraphicalEnum(Integer classId, String graphical) {
        this.classId = classId;
        this.graphical = graphical;
    }

    public static void main(String[] args) {
        System.out.println(new String("rectangle").toUpperCase());
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getGraphical() {
        return graphical;
    }

    public void setGraphical(String graphical) {
        this.graphical = graphical;
    }
}
