package phanloi.recyclerviewmixdecorations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import phanloi.recyclerviewmixdecorations.adapter.HorizontalAdapter;
import phanloi.recyclerviewmixdecorations.decoration.HorizontalDividerItemDecoration;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since July 20, 2017
 */

public class HorizontalDecorationActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(new HorizontalAdapter());

        RecyclerView.ItemDecoration decoration = new HorizontalDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_horizontal));

        mRecyclerView.addItemDecoration(decoration);
    }
}
