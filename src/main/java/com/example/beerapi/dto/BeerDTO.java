package com.example.beerapi.dto;

import com.example.beerapi.enums.BeerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {

    private Long id;

    @NotNull
    @Size(max = 200, min = 1)
    private String name;

    @NotNull
    @Size(max = 200, min = 1)
    private String brand;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BeerType type;
}
