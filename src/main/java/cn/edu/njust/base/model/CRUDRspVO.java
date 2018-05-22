package cn.edu.njust.base.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author 冯锡禹
 * @Data 2017/8/1 13:22
 * 功能描述：前台CRUD的返回值模型（整个项目都使用这一个类型）
 * 修改返回值result
 */
@Component
public class CRUDRspVO<T> implements Serializable {

    private Integer status;     //状态，0表示失败，1表示成功
    private String msg;         //失败或成功后的信息
    private T result;           //一般而言，查找会有这个返回值，其他的只需要上面的字段即可。

     public CRUDRspVO(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public CRUDRspVO(Integer status, String msg, T result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public CRUDRspVO() {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
