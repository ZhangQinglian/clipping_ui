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

package com.zql.android.clippings.device.view.home;

import android.os.Handler;
import android.os.Looper;

import com.zql.android.clippings.bridge.mvpc.UseCase;
import com.zql.android.clippings.bridge.mvpc.UseCaseHandler;
import com.zql.android.clippings.usecase.GetAllClippings;

/**
 * @author qinglian.zhang, created on 2017/2/23.
 */
public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View mView ;

    private Handler mainHandler = new Handler(Looper.getMainLooper());
    public HomePresenter(HomeContract.View view){
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void showContent() {
        mView.showContent();
    }

    @Override
    public void loadClippings(boolean isFavourite) {
        UseCaseHandler.getInstance().execute(new GetAllClippings(), new GetAllClippings.RequestValues(isFavourite), new UseCase.UseCaseCallback<GetAllClippings.ResponseValues>() {
            @Override
            public void onSuccess(GetAllClippings.ResponseValues response) {
                mView.updateClippings(response.clippings);
            }

            @Override
            public void onError() {

            }
        });


    }
}
