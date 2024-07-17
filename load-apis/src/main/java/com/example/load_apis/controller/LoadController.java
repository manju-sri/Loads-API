package com.example.load_apis.controller;

import com.example.load_apis.model.Load;
import com.example.load_apis.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    LoadService loadService;

    @PostMapping("/post")
    public ResponseEntity addLoad(@RequestBody Load load){
        try {
           String response = loadService.addLoad(load);
           return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getLoadDetailsByShipperId")
    public ResponseEntity getLoadDetailsByShipperId(@RequestParam("shipperId") String shipperId){

        try{
            List<Load> loadList = loadService.getLoadByShipperId(shipperId);
            return new ResponseEntity(loadList,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getLoadDetailsById")
    public ResponseEntity getLoadDetailsById(@RequestParam("id") Integer id){

        try{
            Load load = loadService.getLoadById(id);
            return new ResponseEntity(load,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateLoadDetails")
    public ResponseEntity updateLoadDetails(@RequestParam("id") Integer id, @RequestBody Load load){

        try{
            String res = loadService.updateLoadDetails(id,load);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteLoadDetailsByShipperId")
    public ResponseEntity deleteLoadDetailsById(@RequestParam("id") Integer id){

        try{
            String result = loadService.deleteLoadDetailsById(id);
            return new ResponseEntity(result,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
