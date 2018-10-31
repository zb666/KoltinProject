package com.tianli.litemall.koltinproject.block;

import com.tianli.litemall.koltinproject.bean.LoadMore;

public interface IContract {
    interface IPresenter {
        void getList(String userId);

        void fetchLoadMoreList(int i);
    }

    interface IView {
        void showSuccessView(String mode);
        void showListData(LoadMore loadMore);
    }

    interface IModel {
        String getMode(String userId);

        String getUrl(int i);
    }
}
