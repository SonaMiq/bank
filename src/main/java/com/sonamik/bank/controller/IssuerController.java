package com.sonamik.bank.controller;

import com.sonamik.bank.entity.Issuer;
import com.sonamik.bank.service.IssuerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("issuer")
public class IssuerController {
    private final IssuerService issuerService;

    IssuerController(IssuerService issuerService){
        this.issuerService=issuerService;
    }
    @PostMapping({"/new"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createIssuer(@RequestBody Issuer issuer){
        issuerService.createIssuer(issuer);
    }

    @GetMapping({"/get/{id}"})
    @ResponseStatus(HttpStatus.FOUND)
    public Issuer getIssuer(@PathVariable("id") long id){
        return issuerService.findIssuerById(id);
    }

    @DeleteMapping({"/delete/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public  void  delete(@PathVariable("id") long id){
        issuerService.deleteIssuer(issuerService.findIssuerById(id));
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id")long id,@RequestBody Issuer issuer){
        issuerService.updateIssuer(id,issuer);
    }
}

