package phanloi.recyclerviewmixdecorations;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import phanloi.recyclerviewmixdecorations.item.AdsItem;
import phanloi.recyclerviewmixdecorations.item.CustomItem;
import phanloi.recyclerviewmixdecorations.item.HeaderItem;
import phanloi.recyclerviewmixdecorations.item.ImageItem;
import phanloi.recyclerviewmixdecorations.item.Item;
import phanloi.recyclerviewmixdecorations.item.TextItem;
import phanloi.recyclerviewmixdecorations.model.Ads;
import phanloi.recyclerviewmixdecorations.model.Custom;
import phanloi.recyclerviewmixdecorations.model.Header;
import phanloi.recyclerviewmixdecorations.model.Image;
import phanloi.recyclerviewmixdecorations.model.Text;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since June 24, 2017
 */

public class ItemBuilder {
    public static List<Item> randomList(Context context) {
        HeaderItem headerItem = new HeaderItem(new Header("This is Header"));
        TextItem textItem = new TextItem(new Text(context.getString(R.string.text_1), context.getString(R.string.text_2)));
        ImageItem imageItem = new ImageItem(new Image(R.drawable.sample));
        AdsItem adsItem = new AdsItem(new Ads(context.getString(R.string.ads)));
        CustomItem customItem = new CustomItem(new Custom("Something"));

        List<Item> itemList = new ArrayList<>();
        itemList.add(headerItem);
        itemList.add(imageItem);
        itemList.add(textItem);
        itemList.add(customItem);

        int i = 0;
        Random random = new Random();
        while (i < 10) {
            i++;
            switch (random.nextInt(3)) {
                case 0:
                    itemList.add(textItem);
                    break;
                case 1:
                    itemList.add(imageItem);
                    break;
                case 2:
                    itemList.add(customItem);
                    break;
            }
        }

        itemList.add(adsItem);

        return itemList;
    }
}
