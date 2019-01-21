package com.tinklabs.service;

import com.tinklabs.vo.CurrencyVo;

/**
* description:
* @author Landin
* @date 2019/1/15
*/
public interface CurrencyService {
    /**
    * description:
    * @return java.util.List<com.tinklabs.vo.CurrencyDto>
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019/1/16
    */
    CurrencyVo queryCurrency(String localeCode , String countryCode);
}
