package phanloi.recyclerviewmixdecorations.adapter;

import android.view.ViewGroup;

import phanloi.recyclerviewmixdecorations.R;
import phanloi.recyclerviewmixdecorations.item.AdsItem;
import phanloi.recyclerviewmixdecorations.item.CustomItem;
import phanloi.recyclerviewmixdecorations.item.HeaderItem;
import phanloi.recyclerviewmixdecorations.item.ImageItem;
import phanloi.recyclerviewmixdecorations.item.Item;
import phanloi.recyclerviewmixdecorations.item.TextItem;
import phanloi.recyclerviewmixdecorations.viewholder.AdsItemViewHolder;
import phanloi.recyclerviewmixdecorations.viewholder.BaseItemViewHolder;
import phanloi.recyclerviewmixdecorations.viewholder.CustomItemViewHolder;
import phanloi.recyclerviewmixdecorations.viewholder.HeaderItemViewHolder;
import phanloi.recyclerviewmixdecorations.viewholder.ImageItemViewHolder;
import phanloi.recyclerviewmixdecorations.viewholder.TextItemViewHolder;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since June 24, 2017
 */

public class MyAdapter extends BaseItemAdapter {
    private static final int ITEM_HEADER = 0;
    private static final int ITEM_TEXT = 1;
    private static final int ITEM_IMAGE = 2;
    private static final int ITEM_ADS = 3;
    private static final int ITEM_CUSTOM = 4;

    @Override
    public int getItemViewType(int position) {
        Item item = getItemAt(position);

        if (item instanceof HeaderItem) {
            return ITEM_HEADER;
        }

        if (item instanceof TextItem) {
            return ITEM_TEXT;
        }

        if (item instanceof ImageItem) {
            return ITEM_IMAGE;
        }

        if (item instanceof AdsItem) {
            return ITEM_ADS;
        }

        if (item instanceof CustomItem) {
            return ITEM_CUSTOM;
        }

        throw new RuntimeException("Not support item " + item);
    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case ITEM_HEADER:
                return new HeaderItemViewHolder(parent, R.layout.item_header);

            case ITEM_TEXT:
                return new TextItemViewHolder(parent, R.layout.item_text);

            case ITEM_IMAGE:
                return new ImageItemViewHolder(parent, R.layout.item_image);

            case ITEM_ADS:
                return new AdsItemViewHolder(parent, R.layout.item_ads);

            case ITEM_CUSTOM:
                return new CustomItemViewHolder(parent, R.layout.item_custom);

            default:
                throw new RuntimeException("Not support type=" + viewType);
        }
    }
}
