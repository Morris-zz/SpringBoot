package com.example.oppo.demo.dto;

import java.io.Serializable;

public class DownLoadExcelDto implements Serializable {
    /**
     * fromCompany : insight
     * analyseMethod : 0
     * data : [{"title":"人口属性-基础属性-职业:中小学生(包含)","index_data":[{"data":[{"index":21288690,"val":"女"},{"index":13091055,"val":"男"},{"index":137643,"val":null}],"name":"性别"},{"data":[{"index":16021386,"val":"18～24"},{"index":14324738,"val":"25～34"},{"index":2829650,"val":"10～17"},{"index":1222434,"val":"35～49"},{"index":101169,"val":"50～70"},{"index":2,"val":null}],"name":"年龄"}]}]
     */

    private String fromCompany;
    private int analyseMethod;
    private String data;

    public String getFromCompany() {
        return fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public int getAnalyseMethod() {
        return analyseMethod;
    }

    public void setAnalyseMethod(int analyseMethod) {
        this.analyseMethod = analyseMethod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
