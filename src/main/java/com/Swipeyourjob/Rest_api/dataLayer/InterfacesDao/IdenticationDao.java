package com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao;

import com.Swipeyourjob.Rest_api.domain.Authentication.WebUser;

public interface IdenticationDao {
    public WebUser registerWebUser(String email, String password, int roleid);
}
