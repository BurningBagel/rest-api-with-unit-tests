package com.example.beerapi.builder;


import com.example.beerapi.dto.BeerDTO;
import com.example.beerapi.enums.BeerType;
import lombok.Builder;

@Builder
public class BeerDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Bud Light";

    @Builder.Default
    private String brand = "Budweiser";

    @Builder.Default
    private int max = 50;

    @Builder.Default
    private int quantity = 10;

    @Builder.Default
    private BeerType type = BeerType.LAGER;

    public BeerDTO toBeerDTO(){
        return new BeerDTO(id,name,brand,max,quantity,type);
    }
}
