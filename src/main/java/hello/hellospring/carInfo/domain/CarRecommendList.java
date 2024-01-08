package hello.hellospring.carInfo.domain;

import lombok.Data;

@Data
public class CarRecommendList {
    private Long carCode;
    private String masterCarName;
    private Long masterCarOrder;
    private boolean masterCarRecommend;
    //car_price
    private String carLeasePrice;
    private String carRentPrice;

    //car_img
    private String carImg;
    private String carBrandImg;

}
