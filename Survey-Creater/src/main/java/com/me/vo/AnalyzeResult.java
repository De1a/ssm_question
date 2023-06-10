package com.me.vo;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AnalyzeResult
 * @Description TODO
 * @Author noname
 * @Data
 * @Version 1.0
 **/

public class AnalyzeResult {
    public Boolean success;
    public List<Integer> count;
    public String type;
    public String title;
    public String name;
    public List<String> items;
    public List<HashMap<String,Object>> data;

    public AnalyzeResult(Boolean flag){
        this.success = flag;
    }

    public AnalyzeResult(Boolean success, List<Integer> count, String type, String title, String name, List<String> items) {
        this.success = success;
        this.count = count;
        this.type = type;
        this.title = title;
        this.name = name;
        this.items = items;
    }

    public AnalyzeResult(Boolean success, String type, String title, List<HashMap<String, Object>> data){
        this.success = success;
        this.type = type;
        this.title = title;
        this.data = data;
    }

    public AnalyzeResult(Boolean success,String type,String title,List<String> items,List<HashMap<String,Object>> data){
        this.success = success;
        this.type = type;
        this.title = title;
        this.items = items;
        this.data = data;
    }

}
