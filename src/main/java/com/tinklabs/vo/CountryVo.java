package com.tinklabs.vo;

import com.baomidou.mybatisplus.annotations.TableField;
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
public class CountryVo {
    private Integer geonameId;
    private String continentCode;
    private String continentName;
    private String countryCode;
    private String countryName;
}
