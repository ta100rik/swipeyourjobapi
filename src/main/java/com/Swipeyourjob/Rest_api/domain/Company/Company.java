package com.Swipeyourjob.Rest_api.domain.Company;

public class Company {
    public int company_id;
    public String companylogo;
    public String name;
    public int kvk;

    public Company(int company_id, String companylogo, String name, int kvk) {
        this.company_id = company_id;
        this.companylogo = companylogo;
        this.name = name;
        this.kvk = kvk;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKvk() {
        return kvk;
    }

    public void setKvk(int kvk) {
        this.kvk = kvk;
    }
}
