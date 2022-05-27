package com.sonamik.bank.service;

import com.sonamik.bank.entity.Issuer;
import com.sonamik.bank.repo.IssuerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuerService {
    @Autowired
    IssuerRepo issuerRepo;

    public void createIssuer(Issuer issuer){
        issuerRepo.save(issuer);
    }
    public void deleteIssuer(Issuer issuer){
        issuerRepo.delete(issuer);
    }
    public void updateIssuer(Long id,Issuer issuer){
        Issuer iss=issuerRepo.findById(id).get();
        iss.setBankCode(issuer.getBankCode());
        iss.setBankName(issuer.getBankName());
        iss.setType(issuer.getType());
        issuerRepo.save(iss);
    }
    public Issuer findIssuerById(long id){
        return issuerRepo.findById(id).get();
    }
}
