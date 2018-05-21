package cn.edu.njust.demo.mapper;


import java.util.List;

import cn.edu.njust.demo.model.DemoBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface DemoMapper {

    //    @Select("select * from student where age >#{record}")
    List<DemoBean> getDemoList(@Param("record") Integer age);
}