package com.tinklabs.dto;

import com.tinklabs.vo.CurrencyVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-15
 **/
@Data
@NoArgsConstructor
@ToString
public class CurrencyDto {
    private String localeCode;
    private List<CurrencyVo> currencyList;
}
