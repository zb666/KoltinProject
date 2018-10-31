package com.tianli.litemall.koltinproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public interface IPA {
        void onAClick();
    }

    private void onClick(){
        //点击的时候 触发A的回调
        ((IPA)getActivity()).onAClick();
    }

    public void executeA(String resB){

    }

}
