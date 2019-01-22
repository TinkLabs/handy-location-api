package com.tinklabs.service;

import com.tinklabs.vo.CurrencyVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

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
    /**
    * description:
    * @return java.util.List<com.tinklabs.vo.CurrencyVo>
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019-01-22
    */
    List<CurrencyVo> queryCurrencyList(@Param("localeCode") String localeCode);
}
