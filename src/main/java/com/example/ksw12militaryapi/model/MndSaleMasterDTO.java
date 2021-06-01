package com.example.ksw12militaryapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MndSaleMasterDTO {
    private int list_total_count;
    private List<MndSaleDTO> row;
}
