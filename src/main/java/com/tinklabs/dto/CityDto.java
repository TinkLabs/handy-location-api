package com.tinklabs.dto;

import com.tinklabs.vo.CityVo;
import com.tinklabs.vo.CountryVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-16
 **/
@Data
@NoArgsConstructor
@ToString
public class CityDto {
    private String localeCode;
    private CountryVo country;
    private List<CityVo> cityList;
}
