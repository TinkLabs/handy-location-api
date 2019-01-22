package com.tinklabs.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tinklabs.entity.Currency;
import com.tinklabs.vo.CurrencyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Landin
 * @create: 2018-12-30 16:53
 **/
public interface CurrencyMapper extends BaseMapper<Currency> {
     CurrencyVo queryCurrency(@Param("localeCode") String localeCode ,@Param("countryCode")String countryCode);
     List<CurrencyVo> queryCurrencyList(@Param("localeCode") String localeCode);
}
