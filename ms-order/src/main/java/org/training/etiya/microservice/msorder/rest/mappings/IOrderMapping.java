package org.training.etiya.microservice.msorder.rest.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.training.etiya.microservice.msorder.rest.models.MealRest;
import org.training.etiya.microservice.msorder.rest.models.OrderRest;
import org.training.etiya.microservice.msorder.service.models.Meal;
import org.training.etiya.microservice.msorder.service.models.Order;

import java.util.List;

@Mapper
public interface IOrderMapping {
    IOrderMapping ordermapper = Mappers.getMapper(IOrderMapping.class);

    Order toOrder(OrderRest orderRest);

    List<Order> toOrderList(List<OrderRest> orderRest);

    List<OrderRest> toOrderRestList(List<Order> order);

    Meal toMeal(MealRest mealRest);

    OrderRest toOrderRest(Order order);

    MealRest toMealRest(Meal meal);

}
