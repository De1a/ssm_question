package com.me.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.me.vo.ReturnMessage;
import com.me.po.Surveys;
import com.me.service.SurveysService;
import com.me.service.TableService;
import com.me.utils.JSONResultFormatterUtils;
import com.me.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author noname
 * @since
 */
@RestController
@RequestMapping("/surveys")
public class SurveysController {

    @Autowired
    private SurveysService surveysService;
    @Autowired
    private TableService tableService;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/page")
    @ResponseBody
    public ReturnMessage returnPage(@RequestParam("pageId")String pageId){

        Surveys surveys = surveysService.selectOne(new EntityWrapper<Surveys>().eq("pageid",pageId));

        if(surveys == null){
            return new ReturnMessage(true);
        }
/*        String data =  StringEscapeUtils.escapeJava(surveys.getContent()) ;*/
        String data = surveys.getContent();
        return new ReturnMessage(true,data);
    }

    @PostMapping("/commit")
    @ResponseBody
    public ReturnMessage commitResult(@RequestParam("params")String result,@RequestParam("tableId") String tableId){
        HashMap rMap = JSONResultFormatterUtils.forResult(result,redisUtil,tableId);
        tableService.insertData(rMap,tableId);
        return new ReturnMessage(true);
    }
}

