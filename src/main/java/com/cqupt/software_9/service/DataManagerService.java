package com.cqupt.software_9.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.software_9.entity.DataManager;
import com.cqupt.software_9.entity.TableManager;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface DataManagerService extends IService<DataManager> {
   List<DataManager> getDatawithoutresult();
   PageInfo<DataManager> getDatawithoutresult(int page,int pageSize);


}