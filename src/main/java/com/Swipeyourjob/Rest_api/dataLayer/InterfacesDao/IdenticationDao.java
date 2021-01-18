package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;

public interface IdenticationDao {
    public WebUser registerWebUser(String username, String password, String firstname, String lastname, int companyid);
}
