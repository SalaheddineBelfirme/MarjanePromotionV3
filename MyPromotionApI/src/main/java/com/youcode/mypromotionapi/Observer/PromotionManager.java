package com.youcode.mypromotionapi.Observer;

import com.youcode.mypromotionapi.dto.ProductPromotionDto;
import com.youcode.mypromotionapi.entities.Promotion;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PromotionManager {
    private List<EventListenerPromotion> promotionList =new ArrayList<>();

    public  void  subscribe(EventListenerPromotion p){
        promotionList.add(p);
    }
    public  void  unSubscribe(Promotion p){
        promotionList.remove(p);
    }
    public void notifyubscribe(){
        promotionList.forEach(promotion -> promotion.update());
    }
}
