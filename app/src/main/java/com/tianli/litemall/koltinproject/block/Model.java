package com.tianli.litemall.koltinproject.block;

public class Model implements IContract.IModel {
    @Override
    public String getMode(String userId) {
        return "userId: "+userId;
    }

    @Override
    public String getUrl(int i){
        String REQUEST_URL = "http://wanandroid.com/wxarticle/chapters/json";
        return String.format(REQUEST_URL,i);
    }
}
