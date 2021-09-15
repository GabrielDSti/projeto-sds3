package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Seller;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class SaleSuccesDTO implements Serializable {

    private String sellerName;
    private Long visited;
    private Long deals;


    public SaleSuccesDTO() {

    }

    public SaleSuccesDTO(Seller seller, Long visited, Long deals) {
        this.sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
