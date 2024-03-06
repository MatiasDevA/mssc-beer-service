package com.example.msscbeerservice.Mapper;

import com.example.msscbeerservice.domain.Beer;
import com.example.msscbeerservice.domain.Beer.BeerBuilder;
import com.example.msscbeerservice.model.BeerDTO;
import com.example.msscbeerservice.model.BeerDTO.BeerDTOBuilder;
import com.example.msscbeerservice.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T15:40:30-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDTO BeerToBeerDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDTO.version( beer.getVersion().intValue() );
        }
        beerDTO.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDTO.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDTO.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDTO.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDTO.upc( beer.getUpc() );
        beerDTO.price( beer.getPrice() );

        return beerDTO.build();
    }

    @Override
    public Beer BeerDTOToBeer(BeerDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDTO.getId() );
        if ( beerDTO.getVersion() != null ) {
            beer.version( beerDTO.getVersion().longValue() );
        }
        beer.createdDate( dateMapper.asTimestamp( beerDTO.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimestamp( beerDTO.getLastModifiedDate() ) );
        beer.beerName( beerDTO.getBeerName() );
        if ( beerDTO.getBeerStyle() != null ) {
            beer.beerStyle( beerDTO.getBeerStyle().name() );
        }
        beer.upc( beerDTO.getUpc() );
        beer.price( beerDTO.getPrice() );

        return beer.build();
    }
}
