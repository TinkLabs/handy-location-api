package com.tinklabs.service;

import com.tinklabs.vo.CityVo;
import java.util.List;

/**
* description:
* @author Landin
* @date 2019/1/15
*/
public interface CityService {
    /**
    * description:
    * @return java.util.List<com.tinklabs.vo.CityDto>
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019/1/16
    */
    List<CityVo> queryCityList(String localeCode, String countryCode);
}
