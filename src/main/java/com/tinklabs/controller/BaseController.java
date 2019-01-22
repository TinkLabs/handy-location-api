package com.tinklabs.controller;


import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    public Page getPage() {
        int current = 0;
        int size = 10;
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        if (StringUtils.isNotBlank(currentPage)) {
            current = Integer.parseInt(currentPage);
        }
        if (StringUtils.isNotBlank(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        return new Page(current, size);
    }
    public String getLocaleCode(){
        String localeCode = request.getHeader("Accept-Language");
        if(StringUtils.isBlank(localeCode)){
            localeCode = "en";
        }
        return localeCode;
    }
}
