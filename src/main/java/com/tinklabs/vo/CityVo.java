package com.tinklabs.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.tinklabs.entity.City;
import com.tinklabs.entity.Country;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-16
 **/
@Data
@NoArgsConstructor
@ToString
public class CityVo {
    private Integer geonameId;
    private String subdivisionISOCode;
    private String subdivision1Name;
    private String subdivision2ISOCode;
    private String subdivision2Name;
    private String cityName;
    private String metroCode;
    private String timeZone;
}
