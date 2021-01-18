package com.Swipeyourjob.Rest_api.domain.Companyinfo;

public class Company {
    public int Companyid;
    public String desc;
    public String name;
    public String webUrl;
    public String companyLogo;

    public Company(int companyid, String desc, String name, String webUrl, String companyLogo) {
        Companyid = companyid;
        this.desc = desc;
        this.name = name;
        this.webUrl = webUrl;
        this.companyLogo = companyLogo;
    }

    public int getCompanyid() {
        return Companyid;
    }

    public void setCompanyid(int companyid) {
        Companyid = companyid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }
}
