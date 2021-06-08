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

        taxiDto.setTaxiNumber(taxi.getTaxiNumber());
        taxiDto.setType(String.valueOf(taxi.getType()));
//        taxiDto.setStatus(taxi.getStatus());
//        taxiDto.setUser(taxi.getUser());
        return taxiDto;

    }


    public static  Taxi toTaxiEntity(TaxiDto taxiDto){
        Taxi taxi = new Taxi();
        taxi.setTaxiNumber(taxiDto.getTaxiNumber());
        taxi.setType(Type.valueOf(taxiDto.getType()));
//        taxi.setStatus(String.valueOf(taxi.getStatus()));
//        taxi.setUser(User.valueOf(taxi.getUser()));
        return taxi;
    }

    public static List<TaxiDto> toTaxiDtoList (List<Taxi> taxis){
        List<TaxiDto> taxiDtoList = new ArrayList<>();
        taxis.forEach(
                taxi -> taxiDtoList.add(toTaxiDto(taxi))
        );
        return taxiDtoList;
    }

}
