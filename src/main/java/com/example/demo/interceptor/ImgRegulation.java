package com.example.demo.interceptor;

public class ImgRegulation {

    public boolean VERIFY(String imgverify){
        //可以随意添加图片类型 无需改代码
        String[] imgformat = {".jpg",".png",".jpeg",".pjg",".pjeg",".jfif"};
        for(String img:imgformat){
            if(img.equals(imgverify)){
                return true;
            }
        }
        return false;
    }
}
