package com.enic.CarRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
    private String origin;
    private String agentPrice;
    private String seriesName;
    private String seriesType;
    private List<CarsGroup> carsGroup;
    private String wgPicUrl;
    private String wgName;
    private String nsPicUrl;
    private String nsName;

    @Override
    public String toString() {
        String item="";
        for (CarsGroup group : carsGroup) {
            item+="["+group.getCarName()+"售价为"+group.getPrice()+"]";
        }
        return seriesName+"是一款"+origin+seriesType+",目前售价在["+agentPrice+"]之间," +
                "目前有"+carsGroup.size()+"受欢迎的车型。分别是"+item+"。[外观图片地址]:"+wgPicUrl+";[内饰图片地址]:"
                +nsPicUrl;
    }
}
