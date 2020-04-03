package com.kelab.api.controller;

import com.kelab.api.controller.base.BaseController;
import com.kelab.api.service.ExperimentCenterService;
import com.kelab.info.base.JsonAndModel;
import com.kelab.info.experiment.info.ExperimentClassInfo;
import com.kelab.info.experiment.query.ExperimentClassQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "实验平台相关Controller", tags = "experiment-center")
public class ExperimentCenterController extends BaseController {

    private ExperimentCenterService experimentCenterService;

    public ExperimentCenterController(ExperimentCenterService experimentCenterService) {
        this.experimentCenterService = experimentCenterService;
    }

    @GetMapping("/experiment/class.do")
    @ApiOperation(value = "查询所有班级")
    public JsonAndModel queryPage(ExperimentClassQuery query) {
        return experimentCenterService.queryPage(buildParam(query));
    }

    @PostMapping("/experiment/class.do")
    @ApiOperation(value = "开设班级")
    public JsonAndModel createExperimentClass(@RequestBody ExperimentClassInfo record) {
        return experimentCenterService.createExperimentClass(buildParam(), record);
    }

    @PutMapping("/experiment/class.do")
    @ApiOperation(value = "修改班级信息")
    public JsonAndModel updateExperimentClass(@RequestBody ExperimentClassInfo record) {
        return experimentCenterService.updateExperimentClass(buildParam(), record);
    }

    @DeleteMapping("/experiment/class.do")
    @ApiOperation(value = "删除班级")
    public JsonAndModel deleteExperimentClass(String ids) {
        return experimentCenterService.deleteExperimentClass(buildParam().param("ids", ids));
    }
}
