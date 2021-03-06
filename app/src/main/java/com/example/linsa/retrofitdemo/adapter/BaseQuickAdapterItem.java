package com.example.linsa.retrofitdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.linsa.retrofitdemo.R;
import com.example.linsa.retrofitdemo.bean.Movie;

import java.util.List;

/**
 * Created by Linsa on 2017/8/17:10:55.
 * des: 使用BaseQucikAdapterItem实现BaseQuickAdapter的实现
 */

public class BaseQuickAdapterItem extends BaseQuickAdapter<Movie.SubjectsBean, BaseViewHolder> {


    public BaseQuickAdapterItem(@LayoutRes int layoutResId, @Nullable List<Movie.SubjectsBean> data) {
        super(R.layout.item_base_quick_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Movie.SubjectsBean item) {

        Glide.with(mContext.getApplicationContext())
                .load(item.getCasts().get(0).getAvatars().getMedium())
                .placeholder(R.drawable.lodingview)
                .error(R.drawable.taylor)
                .crossFade(1000)
                .into((ImageView) helper.getView(R.id.iv_ibqa_pic));

        helper.setText(R.id.tv_ibqa_name, item.getCasts().get(0).getName())
                .setText(R.id.tv_ibqa_title, item.getTitle())
                .setText(R.id.tv_ibqa_url, item.getAlt())
                .linkify(R.id.tv_ibqa_url);

    }
}
