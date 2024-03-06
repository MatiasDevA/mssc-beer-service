package com.example.msscbeerservice.Mapper;


import com.example.msscbeerservice.domain.Beer;
import com.example.msscbeerservice.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO BeerToBeerDTO(Beer beer);

    Beer BeerDTOToBeer(BeerDTO beerDTO);
}
