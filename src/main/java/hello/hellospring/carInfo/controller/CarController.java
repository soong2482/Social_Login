package hello.hellospring.carInfo.controller;


import hello.hellospring.carInfo.domain.CarDetailList;
import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.domain.CarRecommendList;
import hello.hellospring.carInfo.domain.Update.UpdateCarOrder;
import hello.hellospring.carInfo.domain.Update.UpdateRecommendCar;
import hello.hellospring.carInfo.service.CarService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    //SELECT-----------------------------------------------------------------------------------------
    @GetMapping("listCar")
    @ResponseBody
    public List<CarList> ListCar(){
        return carService.getHomeList();
    }

    @GetMapping("DetailListCar")
    @ResponseBody
    public List<CarDetailList> DetailListCar(@RequestParam(name = "Car_Name") String Car_Name)
    {
        return carService.getDetailList(Car_Name);
    }

    @GetMapping("RecommendListCar")
    @ResponseBody
    public List<CarRecommendList> recommendLists(){return carService.getRecommendList();}

    //UPDATE----------------------------------------------------------------------------------------
    @GetMapping("UpdateCarOrder")
    @ResponseBody
    public String UpdateCarOrder(@RequestBody UpdateCarOrder updateCarOrder)
    {
        Long First_Car_Code = updateCarOrder.getFirstCarCode();
        Long Second_Car_Code = updateCarOrder.getSecondCarCode();
        Long First_Car_Order = updateCarOrder.getFirstCarOrder();
        Long Second_Car_Order = updateCarOrder.getSecondCarOrder();
        return carService.UpdateCarOrder(First_Car_Code,Second_Car_Code,First_Car_Order,Second_Car_Order);
    }
    @GetMapping("UpdateRecommendCar")
    @ResponseBody
    public String UpdateRecommendCar(@RequestBody UpdateRecommendCar updateRecommendCar)
    {
        Long Car_Code = updateRecommendCar.getCarCode();
        return carService.UpdateRecommendCar(Car_Code);
    }
}
