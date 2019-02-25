package com.tinklabs.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tinklabs.entity.Country;
import com.tinklabs.vo.CountryVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @description:
 * @author: Landin
 * @create: 2018-12-30 16:53
 **/
public interface CountryMapper extends BaseMapper<Country> {
     CountryVo queryCountry(@Param("localeCode") String localeCode, @Param("countryCode")String countryCode);
     List<CountryVo> queryCountryList(@Param("localeCode") String localeCode);
}
