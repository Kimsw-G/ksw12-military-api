package com.example.ksw12militaryapi.service;

import com.example.ksw12militaryapi.model.MndSaleMasterDTO;
import com.example.ksw12militaryapi.model.MndSaleMasterKingDTO;

import java.util.List;

public interface MilitaryAPIService {


    MndSaleMasterKingDTO getMndSaleInfo(Integer startIndex, Integer endIndex);
}


