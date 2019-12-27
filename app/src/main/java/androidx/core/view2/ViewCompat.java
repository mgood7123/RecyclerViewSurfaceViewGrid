package androidx.core.view2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewCompat extends androidx.core.view.ViewCompat {
    /**
     * Stores debugging information about attributes. This should be called in a constructor by
     * every custom {@link View} that uses a custom styleable. If the custom view does not call it,
     * then the custom attributes used by this view will not be visible in layout inspection tools.
     *
     * No-op before API 29.
     *
     *  @param context Context under which this view is created.
     * @param styleable A reference to styleable array R.styleable.Foo
     * @param attrs AttributeSet used to construct this view.
     * @param t Resolved {@link TypedArray} returned by a call to
     *        {@link android.content.res.Resources#obtainAttributes(AttributeSet, int[])}.
     * @param defStyleAttr Default style attribute passed into the view constructor.
     * @param defStyleRes Default style resource passed into the view constructor.
     */
    public static void saveAttributeDataForStyleable(@NonNull View view,
                                                     @SuppressLint("ContextFirst") @NonNull Context context, @NonNull int[] styleable,
                                                     @Nullable AttributeSet attrs, @NonNull TypedArray t, int defStyleAttr,
                                                     int defStyleRes) {
        if (Build.VERSION.SDK_INT >= 29) {
            // No-op as ViewCompatApi29 is unavailable
//            ViewCompatApi29.saveAttributeDataForStyleable(
//                    view, context, styleable, attrs, t, defStyleAttr, defStyleRes);
        }
    }
}
