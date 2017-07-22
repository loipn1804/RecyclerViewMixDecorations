package phanloi.recyclerviewmixdecorations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import phanloi.recyclerviewmixdecorations.adapter.MyAdapter;
import phanloi.recyclerviewmixdecorations.decoration.MixDividerItemDecoration;
import phanloi.recyclerviewmixdecorations.decoration.SimpleItemDecorationCallback;
import phanloi.recyclerviewmixdecorations.item.AdsItem;
import phanloi.recyclerviewmixdecorations.item.HeaderItem;
import phanloi.recyclerviewmixdecorations.item.Item;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private List<RecyclerView.ItemDecoration> mItemDecorationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MyAdapter myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setItemList(ItemBuilder.randomList(this));

        addHeaderDivider();
        addAdsDivider();
        addDifferentTypeDivider();
        addSameTypeDivider();

        showItemDecoration();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_horizontal) {
            startActivity(new Intent(this, HorizontalDecorationActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addHeaderDivider() {
        mItemDecorationList.add(new MixDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_large), 0, new SimpleItemDecorationCallback(HeaderItem.class)));
    }

    private void addAdsDivider() {
        mItemDecorationList.add(new MixDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_large), 0, new SimpleItemDecorationCallback() {
            @Override
            public boolean shouldDecor(Item item, @Nullable Item nextItem) {
                return (nextItem != null && nextItem instanceof AdsItem);
            }
        }));
    }

    private void addDifferentTypeDivider() {
        mItemDecorationList.add(new MixDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_medium), 0, new SimpleItemDecorationCallback() {
            @Override
            public boolean shouldDecor(Item item, @Nullable Item nextItem) {
                return (nextItem != null && !item.getClass().isAssignableFrom(nextItem.getClass()) && !item.getClass().isAssignableFrom(HeaderItem.class) && !nextItem.getClass().isAssignableFrom(AdsItem.class));
            }
        }));
    }

    private void addSameTypeDivider() {
        mItemDecorationList.add(new MixDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_small), getResources().getDimensionPixelOffset(R.dimen.padding), new SimpleItemDecorationCallback() {
            @Override
            public boolean shouldDecor(Item item, @Nullable Item nextItem) {
                return (nextItem != null && item.getClass().isAssignableFrom(nextItem.getClass()));
            }
        }));
    }

    private void showItemDecoration() {
        for (RecyclerView.ItemDecoration itemDecoration : mItemDecorationList) {
            mRecyclerView.addItemDecoration(itemDecoration);
        }
    }
}
