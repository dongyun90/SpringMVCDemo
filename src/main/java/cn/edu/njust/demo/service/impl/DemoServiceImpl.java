package cn.edu.njust.demo.service.impl;

import cn.edu.njust.demo.mapper.DemoMapper;
import cn.edu.njust.demo.model.DemoBean;
import cn.edu.njust.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
    //    @Autowired
//    private DemoDao demoDao;
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<DemoBean> getDemoList(Integer age) throws Exception {
//        return demoDao.getDemoList(age);
        return demoMapper.getDemoList(age);
    }
}
