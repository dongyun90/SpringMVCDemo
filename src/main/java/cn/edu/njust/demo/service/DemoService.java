package cn.edu.njust.demo.service;

import cn.edu.njust.demo.model.DemoBean;

import java.util.List;

public interface DemoService {
    public List<DemoBean> getDemoList(Integer age) throws Exception;

}
