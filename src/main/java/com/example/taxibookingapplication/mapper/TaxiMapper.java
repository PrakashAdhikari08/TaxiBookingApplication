package com.example.taxibookingapplication.mapper;

import com.example.taxibookingapplication.domain.Status;
import com.example.taxibookingapplication.domain.Taxi;
import com.example.taxibookingapplication.domain.Type;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.dto.TaxiDto;

import java.util.ArrayList;
import java.util.List;

public class TaxiMapper {

    public static TaxiDto toTaxiDto(Taxi taxi) {
        TaxiDto taxiDto = new TaxiDto();

        taxiDto.setId(taxi.getId());
        taxiDto.setTaxiNumber(taxi.getTaxiNumber());
        taxiDto.setStatus(taxi.getStatus());
        taxiDto.setUserId(taxi.getUser().getId());
        taxiDto.setType(taxi.getType());

        return taxiDto;

    }


    public static  Taxi toTaxiEntity(TaxiDto taxiDto){
        Taxi taxi = new Taxi();
        taxi.setTaxiNumber(taxiDto.getTaxiNumber());
        taxi.setType((taxiDto.getType()));
        return taxi;
    }

    public static List<TaxiDto> toDtoList(List<Taxi> taxiList){
        List<TaxiDto> taxiDtoList = new ArrayList<>();
        taxiList.forEach(
                taxi -> taxiDtoList.add(toTaxiDto(taxi))
        );
        return taxiDtoList;
    }

}
