package com.android.gl2jni;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// here is where we shall open, and add, new Plugins
public class VstGrid {
    private final Activity mActivity;
    private LinearLayout recyclerViewMain;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private VstGridAdapter mAdapter;

    public VstGrid(Activity activity) {
        mActivity = activity;
    }

    public LinearLayout getView() {
        if (recyclerViewMain == null)
            recyclerViewMain = (LinearLayout) LayoutInflater.from(mActivity.getApplicationContext())
                    .inflate(R.layout.vst_grid, null, false);
        if (recyclerView == null) {
            recyclerView = recyclerViewMain
                    .findViewById(R.id.VstGrid);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            recyclerView.setHasFixedSize(false);
        }
        if (layoutManager == null) {
            // use a linear layout manager
            layoutManager = new GridLayoutManager(mActivity, 1);
            recyclerView.setLayoutManager(layoutManager);
        }
        if (mAdapter == null) {
            // specify an adapter (see also next example)
            mAdapter = new VstGridAdapter(mActivity);
            recyclerView.setAdapter(mAdapter);
        }
        return recyclerViewMain;
    }
}
