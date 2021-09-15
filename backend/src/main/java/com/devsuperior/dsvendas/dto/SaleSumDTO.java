package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Seller;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class SaleSumDTO implements Serializable {

    private String sellerName;
    private Double sum;

    public SaleSumDTO() {

    }

    public SaleSumDTO(Seller seller , Double sum) {
        this.sellerName = seller.getName();
        this.sum = sum;
    }
}
