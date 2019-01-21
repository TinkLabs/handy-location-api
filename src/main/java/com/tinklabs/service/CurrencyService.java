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
    * @return com.tinklabs.vo.CurrencyVo
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019-01-21
    */
    CurrencyVo queryCurrency(String localeCode , String countryCode);
}
