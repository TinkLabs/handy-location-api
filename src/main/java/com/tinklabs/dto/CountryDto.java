package com.tinklabs.dto;

import com.tinklabs.vo.CountryVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-15
 **/
@Data
@NoArgsConstructor
@ToString
public class CountryDto {
    private String localeCode;
    private List<CountryVo> countryList;
}
