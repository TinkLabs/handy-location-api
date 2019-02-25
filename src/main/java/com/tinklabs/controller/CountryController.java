package com.tinklabs.controller;

import com.tinklabs.common.LocationCodeEnum;
import com.tinklabs.corecommonbase.exception.BusinessException;
import com.tinklabs.corecommonbase.response.RestResponse;
import com.tinklabs.dto.CountryDto;
import com.tinklabs.resolver.CustomLocaleResolver;
import com.tinklabs.service.CountryService;
import com.tinklabs.vo.CountryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CountryController extends BaseController{
    @Autowired
    private CountryService countryService;
    @Autowired
    private CustomLocaleResolver localResolver;
    @Autowired
    protected HttpServletRequest request;
    @ResponseBody
    @RequestMapping("/hello")
    public RestResponse<String> hello() throws BusinessException {
        RestResponse<String> result = new RestResponse<>();
        log.info("test trace id {}");
        result.setData("success.");
        return result;
    }
    /**
    * description:
    * @return com.tinklabs.corecommonbase.response.RestResponse<com.tinklabs.dto.CountryDto>
    * @param
    * @author Landin
    * @date 2019-01-21
    */
    @ResponseBody
    @GetMapping("/countries")
    public RestResponse<CountryDto> queryCountryList(){
            String localeCode = localResolver.getLocaleCode(request);
            RestResponse<CountryDto> result = new RestResponse<>();
            CountryDto countryDto = new CountryDto();
            List<CountryVo> countryList = countryService.queryCountryList(localeCode);
            countryDto.setLocaleCode(localeCode);
            countryDto.setCountryList(countryList);
            result.setData(countryDto);
            return result;
    }
    /**
    * description:
    * @return com.tinklabs.corecommonbase.response.RestResponse<com.tinklabs.vo.CountryVo>
    * @param countryCode
    * @author Landin
    * @date 2019-01-22
    */
    @ResponseBody
    @GetMapping("/countries/{countryCode}")
    public RestResponse<CountryVo> queryCountry(@PathVariable String countryCode){
        if(StringUtils.isBlank(countryCode)){
            throw new BusinessException(LocationCodeEnum.COUNTRY_CODE_EMPTY.getCode(),LocationCodeEnum.COUNTRY_CODE_EMPTY.getMessage());
        }
        String localeCode = localResolver.getLocaleCode(request);
        if(countryService.queryCountryCount(localeCode, countryCode) < 1){
            throw new BusinessException(LocationCodeEnum.COUNTRY_CODE_NOT_EXIST.getCode(),LocationCodeEnum.COUNTRY_CODE_NOT_EXIST.getMessage());

        }
        RestResponse<CountryVo> result = new RestResponse<>();
        CountryVo countryVo = countryService.queryCountry(localeCode, countryCode);
        result.setData(countryVo);
        return result;
    }
}
