package com.info.arvorebinaria.model.enums;

public class OrderEnum {

    public enum Order{
        POS("PÓS ORDEM"),
        IN("IN ORDEM"),
        PRE("PRÉ ORDEM");

        private String label;

        public String getLabel(){
            return label;
        }


        Order(String label){
            this.label = label;
        }
    }

}
