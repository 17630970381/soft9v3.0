package com.cqupt.software_9.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cqupt.software_9.entity.Diseases;
import com.cqupt.software_9.entity.Symp;
import com.cqupt.software_9.service.Request.Query;

import java.util.List;

public interface SympService {



    List<Symp> getAllsymp();

}