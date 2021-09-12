package com.example.beerapi.service;


import com.example.beerapi.dto.BeerDTO;
import com.example.beerapi.entity.Beer;
import com.example.beerapi.exception.BeerAlreadyRegisteredException;
import com.example.beerapi.exception.BeerNotFoundException;
import com.example.beerapi.exception.BeerStockExceededException;
import com.example.beerapi.mapper.BeerMapper;
import com.example.beerapi.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(beerDTO.getName());
        Beer beer = beerMapper.toModel(beerDTO);
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }

    public BeerDTO findByName(String name) throws BeerNotFoundException {
        Beer foundBeer = beerRepository.findByName(name)
                .orElseThrow(()->new BeerNotFoundException(name));
        return beerMapper.toDTO(foundBeer);

    }

    public List<BeerDTO> listAll(){
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BeerNotFoundException{
        verifyIfExists(id);
        beerRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BeerAlreadyRegisteredException{
        Optional<Beer> optSavedBeer = beerRepository.findByName(name);
        if (optSavedBeer.isPresent()){
            throw new BeerAlreadyRegisteredException(name);
        }
    }

    private Beer verifyIfExists(Long id) throws BeerNotFoundException{
        return beerRepository.findById(id)
                .orElseThrow(()->new BeerNotFoundException(id));
    }

    public BeerDTO increment(Long id, int toIncrement) throws BeerNotFoundException, BeerStockExceededException{
        Beer targetBeer = verifyIfExists(id);
        int quantityAfter = toIncrement + targetBeer.getQuantity();
        if(quantityAfter <= targetBeer.getMax()){
            targetBeer.setQuantity(targetBeer.getQuantity()+toIncrement);
            Beer incrementedStock = beerRepository.save(targetBeer);
            return beerMapper.toDTO(incrementedStock);
        }
        throw new BeerStockExceededException(id,toIncrement);
    }
}
