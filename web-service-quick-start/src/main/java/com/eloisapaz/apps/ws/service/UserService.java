package com.eloisapaz.apps.ws.service;

import com.eloisapaz.apps.ws.model.request.UserDetailsRequestModel;
import com.eloisapaz.apps.ws.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
