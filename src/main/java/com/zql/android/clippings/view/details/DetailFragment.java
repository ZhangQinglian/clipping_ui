/*******************************************************************************
 *    Copyright 2017-present, Clippings Contributors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/

package com.zql.android.clippings.view.details;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zql.android.clippings.R;
import com.zql.android.clippings.databinding.FragmentDetailBinding;
import com.zql.android.clippings.sdk.parser.Clipping;
import com.zql.android.clippings.view.BaseFragment;
import com.zqlite.android.logly.Logly;

/**
 * @author qinglian.zhang, created on 2017/2/24.
 */
public class DetailFragment extends BaseFragment implements DetailContract.View{

    private DetailContract.Presenter mPresenter;

    private FragmentDetailBinding mDetailBinding;

    public interface DetailFragmentCallback{
        void clippingUpdate(Clipping clipping);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDetailBinding = FragmentDetailBinding.inflate(getActivity().getLayoutInflater());
        View view = mDetailBinding.getRoot();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        int id = args.getInt(DetailContract.PICK_CLIPPING_ID);
        mPresenter.getClipping(id);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void clippingUpdate(Clipping clipping) {
        ((DetailFragmentCallback)(getActivity())).clippingUpdate(clipping);
        mDetailBinding.setClipping(clipping);
        if(clipping.type == Clipping.K_CLIPPING_TYPE_LABEL){
            mPresenter.getClippingsNote(clipping);
        }
    }

    @Override
    public void updateNote(Clipping clipping) {
        mDetailBinding.setNote(clipping);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
    public static DetailFragment getInstance(Bundle args){
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        return detailFragment;
    }


}
