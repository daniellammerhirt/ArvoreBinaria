package com.info.arvorebinaria.model.response;

import com.info.arvorebinaria.model.enums.OrderEnum;

public class OrdenacaoResponse {

    private OrderEnum.Order order;

    private String elementos;

    public OrdenacaoResponse(){}

    public OrdenacaoResponse(OrderEnum.Order order, String elementos){
        this.order = order;
        this.elementos = elementos;
    }

    public OrderEnum.Order getOrder() {
        return order;
    }

    public void setOrder(OrderEnum.Order order) {
        this.order = order;
    }

    public String getElementos() {
        return elementos;
    }

    public void setElementos(String elementos) {
        this.elementos = elementos;
    }
}
