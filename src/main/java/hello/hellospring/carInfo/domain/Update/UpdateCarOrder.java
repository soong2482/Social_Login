package hello.hellospring.carInfo.domain.Update;

import lombok.Data;

@Data
public class UpdateCarOrder {
    private Long firstCarCode;
    private Long secondCarCode;
    private Long firstCarOrder;
    private Long secondCarOrder;
}
