package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Status;
import com.example.taxibookingapplication.domain.Taxi;
import com.example.taxibookingapplication.repo.TaxiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.example.taxibookingapplication.domain.Status.OCCUPIED;

@Service
@Slf4j
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Autowired
    private Taxi taxi;
    public List<Taxi> findAll(){
        return taxiRepository.findAll();
    }



    public void registerTaxi (Taxi taxi){
        taxi.setStatus(Status.AVAILABLE);
        taxiRepository.save(taxi);
    }

    public List<Taxi> getAllAvailable( ){
//        List<Taxi> taxiList = taxiRepository.findAll()
//                .stream()
//                .filter(taxi -> taxi.getStatus().equals(Status.AVAILABLE))
//                .collect(Collectors.toList());

        List<Taxi> taxiList = taxiRepository.findAll();

        List<Taxi> availableTaxi = new ArrayList<>();

        for (Taxi taxi: taxiList) {
            if(taxi.getStatus().equals(Status.AVAILABLE))
                availableTaxi.add(taxi);
        }

        return availableTaxi;
    }

    public List<Taxi> getAllOccupied(){
        List<Taxi> taxiList = taxiRepository.findAll();

        List<Taxi> occupiedList = new ArrayList<>();

        for(int i=0; i< taxiList.size();i++)
        {
            if(taxiList.get(i).getStatus().equals(OCCUPIED))
                occupiedList.add(taxiList.get(i));
        }
        return occupiedList;
    }

    public String bookTaxi(Integer taxiId){
       Taxi taxi =  taxiRepository.findById(taxiId).get();

       taxi.setStatus(OCCUPIED);

       taxiRepository.save(taxi);

       return taxi.getTaxiNumber();

    }

    public String cancelTaxi(Integer id) {
        Optional<Taxi> findBookingById = taxiRepository.findById(id);
        if (findBookingById.isPresent()) {
            Taxi taxi = taxiRepository.getById(id);
            taxi.setStatus(Status.AVAILABLE);
            taxiRepository.save(taxi);
            return taxi.getTaxiNumber();
        }
        return "taxi already cancelled";
    }


//    public Status getTaxiStatus(String taxiId){
//        List<Taxi> taxiList = taxiRepository.findById(taxiId);
//        for(Taxi i: taxiList){
//            Taxi taxi = taxiList.get();
//            return taxi.getStatus();
//        }
//        return null;
//    }
}
