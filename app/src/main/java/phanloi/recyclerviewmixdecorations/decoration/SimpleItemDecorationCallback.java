package phanloi.recyclerviewmixdecorations.decoration;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import phanloi.recyclerviewmixdecorations.item.Item;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since July 16, 2017
 */

public class SimpleItemDecorationCallback implements ItemDecorationCallback {
    private Class<? extends Item>[] mClasses;

    @SafeVarargs
    public SimpleItemDecorationCallback(Class<? extends Item>... classes) {
        mClasses = classes;
    }

    protected boolean valid(Item item) {
        if (item != null)
            for (Class clazz : mClasses)
                if (clazz.isAssignableFrom(item.getClass()))
                    return true;
        return false;
    }

    @Override
    public boolean shouldDecor(Item item, @Nullable Item nextItem) {
        return nextItem != null && valid(item);
    }
}
