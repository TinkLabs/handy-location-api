package com.tinklabs.dto;

import com.tinklabs.entity.Country;
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
    private String currencyCode;
    private String currencyName;
    private String symbol;
    private String countryCode;
}
