package com.cqupt.software_9.service;

import com.cqupt.software_9.service.Request.onlineUse;
import com.cqupt.software_9.service.Response.OnlineServiceResponse;

public interface OnlineUseService {
   OnlineServiceResponse onlineUse(onlineUse request)throws Exception;
}
