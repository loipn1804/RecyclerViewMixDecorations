package phanloi.recyclerviewmixdecorations.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import phanloi.recyclerviewmixdecorations.item.Item;
import phanloi.recyclerviewmixdecorations.viewholder.BaseItemViewHolder;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since June 24, 2017
 */

public abstract class BaseItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {

    protected List<Item> mItemList = null;

    public void setItemList(List<Item> itemList) {
        mItemList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BaseItemViewHolder holder, int position) {
        holder.setItem(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList != null ? mItemList.size() : 0;
    }

    public Item getItemAt(int position) {
        return (mItemList != null && mItemList.size() > position) ? mItemList.get(position) : null;
    }
}
