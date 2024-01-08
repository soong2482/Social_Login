package hello.hellospring.carInfo.mapper;

import hello.hellospring.carInfo.domain.CarDetailList;
import hello.hellospring.carInfo.domain.CarList;
import hello.hellospring.carInfo.domain.CarRecommendList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarMapper {

    List<CarList> HomeListCar();
    List<CarDetailList> DetailListCar(String Car_Name);
    List<CarRecommendList> RecommendListCar();


    void UpdateCarOrder(Long Car_Code,Long Car_Order);
    void UpdateRecommendCar(Long Car_Code);
}
