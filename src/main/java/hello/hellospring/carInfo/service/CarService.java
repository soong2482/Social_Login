package hello.hellospring.carInfo.service;

import hello.hellospring.carInfo.domain.CarDetailList;
import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.domain.CarRecommendList;
import hello.hellospring.carInfo.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;
    //SELECT----------------------------------------------------------------------------------------
    //Home List CAR
    public List<CarList> getHomeList() {
        log.info("HomeList selected.");
        List<CarList> homeList = carMapper.HomeListCar();
        log.info("result Home List size : {}", homeList.size());
        return homeList;
    }
    //Detail CAR
    public List<CarDetailList> getDetailList(String Car_Name){
        log.info("Detail Selected.");
        List<CarDetailList> DetailList = carMapper.DetailListCar(Car_Name);
        log.info("Select Detail :{ }",Car_Name);
        return DetailList;
    }
    //Recommend List
    public List<CarRecommendList> getRecommendList(){
        log.info("Recommend Selected");
        List<CarRecommendList> recommendLists = carMapper.RecommendListCar();
        log.info("result Recommend List size :{}",recommendLists.size());
        return recommendLists;
    }


    //Update----------------------------------------------------------------------------------------
    //Update CarOrder
    public String UpdateCarOrder(Long First_Car_Code,Long Second_Car_Code,Long First_Car_Order,Long Second_Car_Order) {
        log.info("Update Car_Order");
        String Message = "Success Change Car_order "+First_Car_Code+"Num "+Second_Car_Code+"Change";
        carMapper.UpdateCarOrder(First_Car_Code,Second_Car_Order);
        carMapper.UpdateCarOrder(Second_Car_Code,First_Car_Order);
        log.info(Message);
        return "Success";
    }
    public String UpdateRecommendCar(Long Car_Code){
        log.info("Update Recommend Car");
        carMapper.UpdateRecommendCar(Car_Code);
        log.info("Change Recommend Car:{}",Car_Code);
        return "Success";
    }
}

