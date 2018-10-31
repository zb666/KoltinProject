package com.tianli.litemall.koltinproject.block;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.tianli.litemall.koltinproject.bean.LoadMore;

import okhttp3.Call;
import okhttp3.Response;

public class Presenter implements IContract.IPresenter {

    private Model model;
    private IContract.IView iView;

    public Presenter(Model model, IContract.IView iView) {
        this.model = model;
        this.iView = iView;
    }

    @Override
    public void getList(String userId) {
        String mode = model.getMode(userId);
    }

    @Override
    public void fetchLoadMoreList(int i){

    }
}
