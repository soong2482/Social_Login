package hello.hellospring.carInfo.domain;

import lombok.Data;

@Data
public class CarDetailList {
    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;
    private boolean masterCarRecommend;
    //car_price
    private String carLeasePrice;
    private String carRentPrice;

    //car_trim
    private String carTrimName;
    private String carTrimPrice;

    //car option
    private String carOption;
    private String carOptionLeasePrice;

    //car_img
    private String carImg;
    private String carBrandImg;
}
