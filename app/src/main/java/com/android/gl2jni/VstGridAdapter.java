package com.android.gl2jni;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Stack;

public class VstGridAdapter extends RecyclerView.Adapter<VstGridAdapter.MyViewHolder> {
    static String TAG = "VstGridAdapter";
    private final Activity mActivity;
    public Stack<Object> viewList = new Stack<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        String TAG = "VstGridAdapter:MyViewHolder";
        public ViewGroup plugin;
        public MyViewHolder(ViewGroup pluginToAdd) {
            super(pluginToAdd);
            Log.w(TAG, "MyViewHolder(View pluginToAdd)");
            plugin = pluginToAdd;
        }
    }

    public VstGridAdapter(Activity activity) {
        Log.w(TAG, "VstGridAdapter()");
        mActivity = activity;
        viewList.add("GLVIEW");
        notifyItemInserted(0);
    }

    @Override
    public int getItemViewType(final int position) {
        Log.w(TAG, "getItemViewType");
        return position;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GL2JNIView mView = new GL2JNIView(mActivity);
        RelativeLayout rel = new RelativeLayout(mActivity);
//        rel.addView(new Button(mActivity));
        rel.addView(mView);
        mView.onResume();
        return new MyViewHolder(rel);
    }

    // required but may be left empty
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {}

    // required
    @Override
    public int getItemCount() {
        return viewList.size();
    }
}