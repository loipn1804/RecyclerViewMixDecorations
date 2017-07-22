package phanloi.recyclerviewmixdecorations.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import phanloi.recyclerviewmixdecorations.adapter.BaseItemAdapter;
import phanloi.recyclerviewmixdecorations.item.Item;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since July 20, 2017
 */

public class HorizontalDividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;

    public HorizontalDividerItemDecoration(Drawable drawable) {
        mDivider = drawable;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        boolean isLastItem = parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1;
        outRect.left = mDivider.getIntrinsicWidth();
        if (isLastItem) {
            outRect.right = mDivider.getIntrinsicWidth();
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int left = child.getLeft() - params.leftMargin - mDivider.getIntrinsicWidth();
            int right = left + mDivider.getIntrinsicWidth();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);

            if (i == childCount - 1) { // last item
//                Drawable drawable = mDivider;
                mDivider.setBounds(left + child.getWidth() + mDivider.getIntrinsicWidth(), top, right + child.getWidth() + mDivider.getIntrinsicWidth(), bottom);
                mDivider.draw(c);
            }
        }
    }
}