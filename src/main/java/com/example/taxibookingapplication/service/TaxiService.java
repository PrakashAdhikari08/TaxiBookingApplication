package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Status;
import com.example.taxibookingapplication.domain.Taxi;
import com.example.taxibookingapplication.repo.TaxiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            if(taxiList.get(i).getStatus().equals(Status.OCCUPIED))
                occupiedList.add(taxiList.get(i));
        }
        return occupiedList;
    }

    public void getBookedTaxi(String taxiId){
        List<Taxi> taxiList = getAllAvailable();
        List<Taxi> bookedTaxiList = new ArrayList<>();
        System.out.println("Enter Yes for booking or No to Cancel");
        Scanner scanner = new Scanner(System.in);
        if(scanner.equals("Yes") )
            book();
        else
            cancel();

    }

    public String book(){
        taxi.setStatus(Status.OCCUPIED);
        Taxi bookTaxi = taxiRepository.save(taxi);
        return "taxi booked";
    }

    public String cancel(){
        Taxi bookTaxi = taxiRepository.save(taxi);
        return "taxi booking cancelled";

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
