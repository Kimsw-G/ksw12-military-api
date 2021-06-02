package com.example.ksw12militaryapi.service;

import com.example.ksw12militaryapi.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MilitaryAPIServiceImpl implements MilitaryAPIService{

        private static final String MND_URL = "https://openapi.mnd.go.kr";

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
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    Gson gson;


//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
//        restTemplate.getMessageConverters().add(converter);
//        return restTemplate;
//    }

    public static <T> HttpEntity<T> setHeaders(){
        
        HttpHeaders headers = new HttpHeaders();

        return new HttpEntity<T>(headers);
    }

    @Override
    public MndSaleMasterKingDTO getMndSaleInfo(Integer startIndex, Integer endIndex) {
        RestTemplate restTemplate = restTemplateBuilder.build();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
//        headers.setContentType(MediaType.APPLICATION_JSON);


/*
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        restTemplate.setMessageConverters(messageConverters);
*/

        String url = String.format("%s%s%s%s/%d/%d",MND_URL,KEY,TYPE,MND_SALE,startIndex,endIndex);

//        MndSaleMasterKingDTO dto = restTemplate.getForObject(url,MndSaleMasterKingDTO.class);
        HttpEntity<String> httpEntity = setHeaders();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

       // MndSaleMasterKingDTO result = restTemplate.getForObject(url, MndSaleMasterKingDTO.class);

        System.out.println("URL : "+url + ": URL END");
        String data = responseEntity.getBody();
        MndSaleMasterKingDTO mndSaleMasterKingDTO = null;

        mndSaleMasterKingDTO = gson.fromJson(data,MndSaleMasterKingDTO.class);

        System.out.println(mndSaleMasterKingDTO.getDS_MND_ENLSTMN_DCNT_BEF_INF().getList_total_count());


        return mndSaleMasterKingDTO;
    }



}
