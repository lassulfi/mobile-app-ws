package com.lassulfi.app.ws.userservice;

import com.lassulfi.app.ws.ui.model.request.UserDetailsRequestModel;
import com.lassulfi.app.ws.ui.model.response.UserRest;

public interface UserService {

	UserRest createUser(UserDetailsRequestModel userDetails);
}
