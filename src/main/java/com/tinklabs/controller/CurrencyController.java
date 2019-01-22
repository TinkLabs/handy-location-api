package com.tinklabs.controller;

import com.tinklabs.common.LocationCodeEnum;
import com.tinklabs.corecommonbase.exception.BusinessException;
import com.tinklabs.corecommonbase.response.RestResponse;
import com.tinklabs.dto.CurrencyDto;
import com.tinklabs.resolver.CustomLocaleResolver;
import com.tinklabs.service.CurrencyService;
import com.tinklabs.vo.CurrencyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
    @Autowired
    private CustomLocaleResolver localResolver;
    @Autowired
    protected HttpServletRequest request;
    /**
    * description:
    * @return com.tinklabs.corecommonbase.response.RestResponse<com.tinklabs.vo.CurrencyVo>
    * @param  countryCode
    * @author Landin
    * @date 2019-01-21
    */
    @ResponseBody
    @GetMapping("/currency")
    public RestResponse<CurrencyVo> queryCurrency(String countryCode){
        if(StringUtils.isBlank(countryCode)){
            throw new BusinessException(LocationCodeEnum.COUNTRY_CODE_EMPTY.getCode(),LocationCodeEnum.COUNTRY_CODE_EMPTY.getMessage());
        }
        String localeCode = localResolver.getLocaleCode(request);
        RestResponse<CurrencyVo> result = new RestResponse<>();
        CurrencyVo currency = currencyService.queryCurrency(localeCode, countryCode);
        result.setData(currency);
        return result;
    }
    /**
    * description:
    * @return com.tinklabs.corecommonbase.response.RestResponse<com.tinklabs.dto.CurrencyDto>
    * @param
    * @author Landin
    * @date 2019-01-22
    */
    @ResponseBody
    @GetMapping("/currencys")
    public RestResponse<CurrencyDto> queryCurrencyList(){
        String localeCode = localResolver.getLocaleCode(request);
        RestResponse<CurrencyDto> result = new RestResponse<>();
        CurrencyDto currencyDto = new CurrencyDto();
        List<CurrencyVo> currencyList = currencyService.queryCurrencyList(localeCode);
        currencyDto.setLocaleCode(localeCode);
        currencyDto.setCurrencyList(currencyList);
        result.setData(currencyDto);
        return result;
    }
}
