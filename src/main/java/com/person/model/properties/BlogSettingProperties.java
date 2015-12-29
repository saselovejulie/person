package com.person.model.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//src/main/resources/properties/site.setting.properties

@Component
public class BlogSettingProperties {

    @Value("#{siteSettingProperties['site.blog.url']}")
    private String siteUrl;
    @Value("#{siteSettingProperties['site.blog.cdnPath']}")
    private String cdnPath;
    @Value("#{siteSettingProperties['site.blog.cdnLibPath']}")
    private String cdnLibPath;
    @Value("#{siteSettingProperties['site.manage.static']}")
    private String manageStatic;

    public String getCdnPath() {
        return cdnPath;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getCdnLibPath() {
        return cdnLibPath;
    }

    public String getManageStatic() {
        return manageStatic;
    }
}
