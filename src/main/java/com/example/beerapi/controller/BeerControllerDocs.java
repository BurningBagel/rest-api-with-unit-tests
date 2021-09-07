package com.example.beerapi.controller;

import com.example.beerapi.dto.BeerDTO;
import com.example.beerapi.exception.BeerAlreadyRegisteredException;
import com.example.beerapi.exception.BeerNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages beer stock")
public interface BeerControllerDocs {

    @ApiOperation(value = "Beer creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Beer successfully created!"),
            @ApiResponse(code = 400, message = "Required fields are missing or wrong field range value")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Returns beer found by passed name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success! Beer found in system."),
            @ApiResponse(code = 404, message = "Beer not found.")
    })
    BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException;

    @ApiOperation(value = "Returns a list of all registered beers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all beers presented.")
    })
    List<BeerDTO> listBeers();

    @ApiOperation(value = "Delete beer with corresponding ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Beer successfully deleted."),
            @ApiResponse(code = 404, message = "Beer not found.")
    })
    void deleteById(@PathVariable Long id) throws BeerNotFoundException;
}
