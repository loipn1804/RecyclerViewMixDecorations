package phanloi.recyclerviewmixdecorations.item;

import phanloi.recyclerviewmixdecorations.model.Text;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since June 24, 2017
 */

public class TextItem implements Item {
    private Text mText;

    public TextItem(Text text) {
        mText = text;
    }

    public Text getText() {
        return mText;
    }
}
