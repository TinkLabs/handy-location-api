package com.tinklabs.controller;

import com.tinklabs.common.LocationCodeEnum;
import com.tinklabs.corecommonbase.exception.BusinessException;
import com.tinklabs.corecommonbase.response.RestResponse;
import com.tinklabs.service.CurrencyService;
import com.tinklabs.vo.CurrencyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: Landin
 * @date: 2019-01-15
 **/
@RestController
@Slf4j
@RequestMapping("/v1")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;
    /**
    * description:
    * @return com.tinklabs.corecommonbase.response.RestResponse<com.tinklabs.vo.CurrencyVo>
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019-01-21
    */
    @ResponseBody
    @GetMapping("/currency")
    public RestResponse<CurrencyVo> queryCurrency(String localeCode, String countryCode){
        if(StringUtils.isBlank(localeCode)){
            throw new BusinessException(LocationCodeEnum.LOCALE_CODE_EMPTY.getCode(),LocationCodeEnum.LOCALE_CODE_EMPTY.getMessage());
        }
        if(StringUtils.isBlank(countryCode)){
            throw new BusinessException(LocationCodeEnum.COUNTRY_CODE_EMPTY.getCode(),LocationCodeEnum.COUNTRY_CODE_EMPTY.getMessage());
        }
        RestResponse<CurrencyVo> result = new RestResponse<>();
        CurrencyVo currency = currencyService.queryCurrency(localeCode, countryCode);
        result.setData(currency);
        return result;
    }
}
