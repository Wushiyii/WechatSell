package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.Repository.GirlRepository;
import com.example.demo.enums.ResultEnums;
import com.example.demo.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(12);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(15);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws GirlException {
        Girl girl = girlRepository.findOne(id);
        if(girl.getAge() < 10){
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        }else if(girl.getAge() >= 10 && girl.getAge() < 16){
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }else{
            throw new GirlException(ResultEnums.UNIVERSITY);
        }
    }
}
