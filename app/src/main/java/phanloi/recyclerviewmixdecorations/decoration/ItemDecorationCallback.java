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

public interface ItemDecorationCallback {

    boolean shouldDecor(@NonNull Item item, @Nullable Item nextItem);
}
