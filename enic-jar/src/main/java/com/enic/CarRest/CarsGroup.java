package com.enic.CarRest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsGroup {
    private String carName;
    private String price;
    private String price_tag;

}
