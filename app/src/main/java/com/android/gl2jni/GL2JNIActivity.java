/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gl2jni;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.io.File;


public class GL2JNIActivity extends Activity {

    GL2JNIView mView;
    VstGrid vstGrid;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        vstGrid = new VstGrid(this);
        setContentView(R.layout.main);
        findViewById(R.id.buttonRenderSurfaceViewInsideRecyclerView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GL2JNIActivity.this.setContentView(vstGrid.getView());
                // onResume is called from onCreateViewHolder
            }
        });
        findViewById(R.id.buttonRenderSurfaceViewDirectly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView = new GL2JNIView(getApplication());
                GL2JNIActivity.this.setContentView(mView);
                mView.onResume();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mView != null) mView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mView != null) mView.onResume();
    }
}
