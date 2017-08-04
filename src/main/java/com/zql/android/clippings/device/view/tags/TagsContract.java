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

package com.zql.android.clippings.device.view.tags;

import com.zql.android.clippings.bridge.mvpc.IContract;
import com.zql.android.clippings.bridge.mvpc.IPresenter;
import com.zql.android.clippings.bridge.mvpc.IView;
import com.zql.android.clippings.device.db.Label;

import java.util.List;

/**
 * @author qinglian.zhang, created on 2017/3/6.
 */
public class TagsContract implements IContract {

    public interface Presenter extends IPresenter{
        void getAllLabels();

        void loadMd5(String label);


    }

    public interface View extends IView<Presenter>{
        void showLabels(List<Label> labels);
        void loadMd5Finish(List<String> md5s,String label);
    }
}
