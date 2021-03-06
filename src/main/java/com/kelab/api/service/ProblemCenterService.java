package com.kelab.api.service;

import cn.wzy.verifyUtils.annotation.Verify;
import com.kelab.info.base.JsonAndModel;
import com.kelab.info.base.constant.StatusMsgConstant;
import com.kelab.info.problemcenter.info.*;
import com.kelab.info.problemcenter.vo.JudgeResult;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Set;

@FeignClient(name = "service-problemcenter")
@RequestMapping("/problemcenter")
public interface ProblemCenterService {

    /**
     * 获取用户的做题记录
     */
    @GetMapping("/user/problem/challenging.do")
    JsonAndModel queryAcAndChallenging(@RequestParam Map<String, Object> param);


    /**
     * 获取用户的做题记录
     */
    @GetMapping("/user/problem/collect.do")
    JsonAndModel collect(@RequestParam Map<String, Object> param);

    /**
     * 取消/添加收藏
     */
    @PostMapping("/user/problem/collect.do")
    JsonAndModel saveOrDeleteProblemCollect(@RequestParam Map<String, Object> param,
                                            @RequestBody ProblemUserMarkInfo problemUserMark);

    /**
     * 分页查询
     */
    @GetMapping("/problem.do")
    JsonAndModel queryPage(@RequestParam Map<String, Object> param);

    /**
     * 添加题目
     */
    @PostMapping("/problem.do")
    JsonAndModel save(@RequestParam Map<String, Object> param,
                      @RequestBody ProblemInfo problemInfo);

    /**
     * 删除题目
     */
    @DeleteMapping("/problem.do")
    JsonAndModel delete(@RequestParam Map<String, Object> param);

    /**
     * 修改题目
     */
    @PutMapping("/problem.do")
    JsonAndModel update(@RequestParam Map<String, Object> param,
                        @RequestBody ProblemInfo record);

    /**
     * 题目总数
     */
    @GetMapping("/problem/count.do")
    JsonAndModel problemTotal(@RequestParam Map<String, Object> param);

    /**
     * 查询来源列表
     */
    @GetMapping("/problem/source.do")
    JsonAndModel querySource(@RequestParam Map<String, Object> param);

    /**
     * 分页查询标签
     */
    @GetMapping("/tags.do")
    JsonAndModel queryTagsPage(@RequestParam Map<String, Object> param);

    /**
     * 添加标签
     */
    @PostMapping("/tags.do")
    JsonAndModel save(@RequestParam Map<String, Object> param,
                      @RequestBody ProblemTagsInfo record);

    /**
     * 修改标签
     */
    @PutMapping("/tags.do")
    JsonAndModel update(@RequestParam Map<String, Object> param,
                        @RequestBody ProblemTagsInfo record);

    /**
     * 删除标签
     */
    @DeleteMapping("/tags.do")
    JsonAndModel deleteTags(@RequestParam Map<String, Object> param);

    /**
     * 查询提交记录
     */
    @GetMapping("/submit.do")
    JsonAndModel querySubmitRecordPage(@RequestParam Map<String, Object> param);

    /**
     * 查询总提交量
     */
    @GetMapping("/submit/count.do")
    JsonAndModel judgeCount(@RequestParam Map<String, Object> param);

    /**
     * 提交判题
     */
    @PostMapping("/submit.do")
    JsonAndModel submit(@RequestParam Map<String, Object> param,
                        @RequestBody ProblemSubmitRecordInfo record);

    /**
     * 查询提交细节：源码和错误信息
     */
    @GetMapping("/submit/detail.do")
    JsonAndModel querySubmitDetail(@RequestParam Map<String, Object> param);

    /**
     * 查询里程碑
     */
    @GetMapping("/user/submit/milestone.do")
    JsonAndModel queryMilestone(@RequestParam Map<String, Object> param);

    /**
     * 一周内提交次数
     */
    @GetMapping("/submit/static.do")
    JsonAndModel queryStatic(@RequestParam Map<String, Object> param);

    /**
     * 分页查询笔记
     */
    @GetMapping("/problem/note.do")
    JsonAndModel queryNotePage(@RequestParam Map<String, Object> param);

    /**
     * 添加笔记
     */
    @PostMapping("/problem/note.do")
    JsonAndModel save(@RequestParam Map<String, Object> param,
                      @RequestBody ProblemNoteInfo record);

    /**
     * 修改笔记
     */
    @PutMapping("/problem/note.do")
    JsonAndModel update(@RequestParam Map<String, Object> param,
                        @RequestBody ProblemNoteInfo record);

    /**
     * 删除笔记
     */
    @DeleteMapping("/problem/note.do")
    JsonAndModel deleteNotes(@RequestParam Map<String, Object> param);

    /**
     * 查询段位
     */
    @GetMapping("/level.do")
    JsonAndModel queryAllLevel(@RequestParam Map<String, Object> param);

    /**
     * 添加段位
     */
    @PostMapping("/level.do")
    JsonAndModel saveLevel(@RequestParam Map<String, Object> param,
                           @RequestBody LevelInfo record);

    /**
     * 修改段位
     */
    @PutMapping("/level.do")
    JsonAndModel updateLevel(@RequestParam Map<String, Object> param,
                             @RequestBody LevelInfo record);

    /**
     * 删除段位
     */
    @DeleteMapping("/level.do")
    JsonAndModel deleteLevel(@RequestParam Map<String, Object> param);

    /**
     * 查看某个段位的题目-管理员端
     */
    @GetMapping("/queryProblems.do")
    JsonAndModel queryProblems(@RequestParam Map<String, Object> param);

    /**
     * 查询每个小段位的题目列表 用户端
     */
    @GetMapping("/levelProblem.do")
    JsonAndModel queryLevelProblems(@RequestParam Map<String, Object> param);

    /**
     * 插入段位题目
     */
    @PostMapping("/levelProblem.do")
    JsonAndModel insertProblem(@RequestParam Map<String, Object> param,
                               @RequestBody Set<LevelProblemInfo> records);

    /**
     * 下载判题数据
     */
    @GetMapping("/testdata/download.do")
    Response downloadTestData(@RequestParam Map<String, Object> param);

    /**
     * 查询判题数据
     */
    @GetMapping("/testdata/query.do")
    JsonAndModel queryByProblemId(@RequestParam Map<String, Object> param);

    /**
     * 更新判题数据
     */
    @PutMapping("/testdata/update.do")
    JsonAndModel updateTestData(@RequestParam Map<String, Object> param,
                                @RequestBody ProblemTestDataInfo record);

    /**
     * 删除判题数据
     */
    @DeleteMapping("/testdata/delete.do")
    JsonAndModel deleteTestData(@RequestParam Map<String, Object> param);

    /**
     * 文件上传,返回下载连接
     */
    @PostMapping(value = "/testdata/upload.do", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    JsonAndModel uploadTestData(@RequestParam Map<String, Object> param,
                                @RequestBody MultipartFile file);

    /**
     * 判题回调接口
     */
    @PutMapping("/submit.do")
    JsonAndModel judgeCallback(@RequestParam Map<String, Object> param,
                                      @RequestBody JudgeResult result);
}
