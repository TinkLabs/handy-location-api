package com.tinklabs.service;

import com.tinklabs.vo.CountryVo;
import java.util.List;

/**
* description:
* @author Landin
* @date 2019/1/15
*/
public interface CountryService {
    /**
    * description:
    * @return java.util.List<com.tinklabs.entity.Country>
    * @param localeCode
    * @author Landin
    * @date 2019-01-21
    */
    List<CountryVo> queryCountryList(String localeCode);
    /**
    * description:
    * @return com.tinklabs.vo.CountryVo
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019-01-21
    */
    CountryVo queryCountry(String localeCode, String countryCode);
}
