package com.tinklabs.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-22
 **/
@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    List<Locale> LOCALES = Arrays.asList(
            new Locale("cn"),
            new Locale("en"),
            new Locale("zh","HK"),
            new Locale("zh","TW"),
            new Locale("ja"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        headerLang = headerLang.replace("_","-");
        if("zh-CN".equals(headerLang)){
            headerLang = "cn";
        }
        return headerLang == null || headerLang.isEmpty()
                ? Locale.getDefault()
                : (Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES) == null ? Locale.getDefault() : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES));
    }
    public String getLocaleCode(HttpServletRequest request){

        return resolveLocale(request).getLanguage();
    }

}
