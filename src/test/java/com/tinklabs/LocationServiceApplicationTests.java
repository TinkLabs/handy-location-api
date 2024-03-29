package com.tinklabs;

import com.tinklabs.mapper.CurrencyMapper;
import com.tinklabs.vo.CurrencyVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceApplicationTests {
    @Resource
    private CurrencyMapper currencyMapper;
    @Test
    public void contextLoads() {
        List<CurrencyVo> currencyList = currencyMapper.queryCurrencyList("CN");
    }

}

