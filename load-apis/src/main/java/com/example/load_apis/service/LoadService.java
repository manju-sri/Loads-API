package com.example.load_apis.service;

import com.example.load_apis.exception.LoadDetailsNotFoundException;
import com.example.load_apis.exception.ShipperIdNotFoundException;
import com.example.load_apis.model.Load;
import com.example.load_apis.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    LoadRepository loadRepository;
    public String addLoad(Load load) {
        load.setShipperId(UUID.randomUUID().toString());
        Load load1 = loadRepository.save(load);
        return "loads details added successfully";
    }

    public List<Load> getLoadByShipperId(String shipperId) {

        List<Load> loadList = loadRepository.findByShipperId(shipperId);
        if(loadList.isEmpty()){
            throw new ShipperIdNotFoundException("Invalid Shipper Id");
        }
        return loadList;
    }

    public Load getLoadById(Integer id) {

        Optional<Load> load = loadRepository.findById(id);
        if(load.isEmpty()){
            throw new LoadDetailsNotFoundException("Invalid Load Id");
        }
        return load.get();
    }

    public String updateLoadDetails(Integer id, Load load) {

        Optional<Load> load1 = loadRepository.findById(id);
        Load load2 = load1.get();
        load2.setLoadingPoint(load.getLoadingPoint());
        load2.setUnloadingPoint(load.getUnloadingPoint());
        load2.setProductType(load.getProductType());
        load2.setTruckType(load.getTruckType());
        load2.setNoOfTrucks(load.getNoOfTrucks());
        load2.setWeight(load.getWeight());
        load2.setDate(load.getDate());

        loadRepository.save(load2);
        return "Load Details Updated Successfully";
    }

    public String deleteLoadDetailsById(Integer id) {
       Optional<Load> load = loadRepository.findById(id);
        if(load.isEmpty()){
            throw new LoadDetailsNotFoundException("Invalid Load Id");
        }
       loadRepository.delete(load.get());

        return "Successfully Deleted Load Details Of Respected Load Id";
    }
}
