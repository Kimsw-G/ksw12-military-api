package com.example.ksw12militaryapi.service;

import com.example.ksw12militaryapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MilitaryAPIServiceImpl implements MilitaryAPIService{

        private static final String MND_URL = "http://openapi.mnd.go.kr";

    // API URL 적기
    // 이거는 고정
    private static final String KEY = "/3938313633333537323131313732313334";
    private static final String TYPE = "/json";
    // 해당 SERVICE들
    // //
    private static final String MND_SALE = "/DS_MND_ENLSTMN_DCNT_BEF_INF";
    private static Integer startIndex;
    private static Integer endIndex;

    // START_INDEX, END_INDEX 도 있음

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public static <T> HttpEntity<T> setHeaders(){
        
        HttpHeaders headers = new HttpHeaders();

        return new HttpEntity<T>(headers);
    }

    @Override
    public MndSaleMasterKingDTO getMndSaleInfo(Integer startIndex, Integer endIndex){
        RestTemplate restTemplate = restTemplateBuilder.build();

        String url = String.format("%s%s%s%s/%d/%d",MND_URL,KEY,TYPE,MND_SALE,startIndex,endIndex);
        HttpEntity<MndSaleMasterKingDTO> httpEntity = setHeaders();

        ResponseEntity<MndSaleMasterKingDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null
                ,MndSaleMasterKingDTO.class);


        return responseEntity.getBody();
    }

}
