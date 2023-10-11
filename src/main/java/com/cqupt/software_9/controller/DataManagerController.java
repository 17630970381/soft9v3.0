package com.cqupt.software_9.controller;

import com.cqupt.software_9.common.R;
import com.cqupt.software_9.dao.mysql.CkdManagerMapper;
import com.cqupt.software_9.dao.mysql.CkdTableManagerMapper;
import com.cqupt.software_9.dao.mysql.DataManagerMapper;
import com.cqupt.software_9.dao.mysql.DatabaseManagerMapper;
import com.cqupt.software_9.entity.DataManager;
import com.cqupt.software_9.entity.DatabaseManager;
import com.cqupt.software_9.service.DataManagerService;
import com.cqupt.software_9.service.TableManagerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/DataManager")
public class DataManagerController {
    @Autowired
    private DataManagerService dataManagerService;

    @Autowired
    private TableManagerService tableManagerService;

    private DataManagerMapper dataManagerMapper;

    private CkdManagerMapper ckdManagerMapper;

    private DatabaseManagerMapper databaseManagerMapper;

    private CkdTableManagerMapper ckdTableManagerMapper;

    public DataManagerController(DataManagerMapper dataManagerMapper,CkdManagerMapper ckdManagerMapper,DatabaseManagerMapper databaseManagerMapper,CkdTableManagerMapper ckdTableManagerMapper) {
        this.dataManagerMapper = dataManagerMapper;
        this.ckdManagerMapper=ckdManagerMapper;
        this.databaseManagerMapper=databaseManagerMapper;
        this.ckdTableManagerMapper=ckdTableManagerMapper;
    }

    @GetMapping("/heart")
    public List<DataManager> getheartDataWithoutresult() {
        return dataManagerService.getDatawithoutresult();
    }

    //    分页查询heart
    @GetMapping("/data/heart")
    public PageInfo<DataManager> getheartdatawithoutresult(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return dataManagerService.getDatawithoutresult(page, pageSize);
    }

    @GetMapping("/ckd")
    public List<DataManager> getckdDataWithoutresult() {
        return ckdManagerMapper.getckdManagerwithoutresult();
    }

    @GetMapping("/database")
    public  List<DatabaseManager> getall(){
        return databaseManagerMapper.getall();
    }

    @PostMapping("/data")
    public List<DataManager> getDetail(@RequestBody Map<String,String> map) {
        String diseasename=map.get("diseaseName");
        return dataManagerService.getDetail(diseasename);
    }

//    @GetMapping("/data")
//    public List<DataManager> getDetails(@RequestParam("databasename") String databasename) {
//        if (databasename.equals("dataandresult")) {
//            return getheartDataWithoutresult();
//        } else if (databasename.equals("ckd")) {
//            return getckdDataWithoutresult();
//        }
//        throw new IllegalArgumentException("Invalid databasename: " + databasename);
//    }

    @GetMapping("/getInfoByTableID/{id}")
    public R<List<Map<String,String>>> getInfoByTableName(@PathVariable Integer id){
        String tableName = dataManagerService.getTableNameByID(id);
        tableName = tableName + "_result";
        List<Map<String,String>> result = dataManagerService.getInfoByTableName(tableName);

        return new R<>(200,"查找成功",result);
    }


}
