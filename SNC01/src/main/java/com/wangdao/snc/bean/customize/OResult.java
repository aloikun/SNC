package com.wangdao.snc.bean.customize;

public class OResult {
    // 响应码
    private Integer code;

    private String msgname;

    private String msgpwd;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsgname() {
        return msgname;
    }

    public void setMsgname(String msgname) {
        this.msgname = msgname;
    }

    public String getMsgpwd() {
        return msgpwd;
    }

    public void setMsgpwd(String msgpwd) {
        this.msgpwd = msgpwd;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "OResult{" +
                "code=" + code +
                ", msgname='" + msgname + '\'' +
                ", msgpwd='" + msgpwd + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
