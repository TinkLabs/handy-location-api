package com.tinklabs.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tinklabs.entity.Currency;
import com.tinklabs.mapper.CurrencyMapper;
import com.tinklabs.service.CurrencyService;
import com.tinklabs.vo.CurrencyVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-15
 **/
@Service
public class CurrencyServiceImpl extends ServiceImpl<CurrencyMapper, Currency> implements CurrencyService {
    @Resource
    private CurrencyMapper currencyMapper;

    @Override
    public CurrencyVo queryCurrency(String localeCode, String countryCode) {
        return currencyMapper.queryCurrency(localeCode, countryCode);
    }

    @Override
    public List<CurrencyVo> queryCurrencyList(String localeCode) {
        return currencyMapper.queryCurrencyList(localeCode);
    }


}
