package com.tinklabs.controller;

import com.tinklabs.common.LocationCodeEnum;
import com.tinklabs.corecommonbase.exception.BusinessException;
import com.tinklabs.corecommonbase.response.RestResponse;
import com.tinklabs.dto.CityDto;
import com.tinklabs.service.CityService;
import com.tinklabs.service.CountryService;
import com.tinklabs.vo.CityVo;
import com.tinklabs.vo.CountryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-15
 **/
@RestController
@Slf4j
@RequestMapping("/v1")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    /**
    * description:
    * @return com.tinklabs.corecommonbase.response.RestResponse<java.util.List<com.tinklabs.vo.CityDto>>
    * @param localeCode, countryCode
    * @author Landin
    * @date 2019/1/16
    */
    @ResponseBody
    @GetMapping("/city")
    public RestResponse<CityDto> queryCityList(String localeCode, String countryCode){
        if(StringUtils.isBlank(localeCode)){
            throw new BusinessException(LocationCodeEnum.LOCALE_CODE_EMPTY.getCode(),LocationCodeEnum.LOCALE_CODE_EMPTY.getMessage());
        }
        if(StringUtils.isBlank(countryCode)){
            throw new BusinessException(LocationCodeEnum.COUNTRY_CODE_EMPTY.getCode(),LocationCodeEnum.COUNTRY_CODE_EMPTY.getMessage());
        }
        RestResponse<CityDto> result = new RestResponse<>();
        CityDto cityDto = new CityDto();
        CountryVo countryVo = countryService.queryCountry(localeCode, countryCode);
        List<CityVo> cityList = cityService.queryCityList(localeCode, countryCode);
        cityDto.setLocaleCode(localeCode);
        cityDto.setCountry(countryVo);
        cityDto.setCityList(cityList);
        result.setData(cityDto);
        return result;
    }



}
