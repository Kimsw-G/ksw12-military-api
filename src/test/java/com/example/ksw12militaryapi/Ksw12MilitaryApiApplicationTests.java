package com.example.ksw12militaryapi;

import com.example.ksw12militaryapi.model.MndSaleDTO;
import com.example.ksw12militaryapi.model.MndSaleMasterDTO;
import com.example.ksw12militaryapi.model.MndSaleMasterKingDTO;
import com.example.ksw12militaryapi.service.MilitaryAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Ksw12MilitaryApiApplicationTests {

    @Autowired
    MilitaryAPIService militaryAPIService;

    @Test
    void contextLoads() {
        MndSaleMasterKingDTO masterKingDTO = militaryAPIService.getMndSaleInfo(1,5);

        MndSaleMasterDTO masterDTO = masterKingDTO.getDS_MND_ENLSTMN_DCNT_BEF_INF();

        System.out.println(masterDTO.getList_total_count());

        List<MndSaleDTO> saleInfo = masterDTO.getRow();

        for (MndSaleDTO dto:saleInfo) {
            System.out.println(dto.getFnshday());
            System.out.println(dto.getRgn());
        }
    }

}
