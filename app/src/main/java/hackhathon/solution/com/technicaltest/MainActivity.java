package hackhathon.solution.com.technicaltest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import hackhathon.solution.com.technicaltest.adapter.ImageLoaderAdapter;
import hackhathon.solution.com.technicaltest.app.RecyclerTouchlListener;
import hackhathon.solution.com.technicaltest.model.Data;
import hackhathon.solution.com.technicaltest.view.ActivityShowImage;

public class MainActivity extends AppCompatActivity {

    //01752883330
    private RecyclerView recyclerImage;
    private GridLayoutManager mLayoutManager;
    private ImageLoaderAdapter adapter;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkConnected()){
            initRecycler();
        }else {
            Toast.makeText(this,"Please check your internet connection!",Toast.LENGTH_LONG).show();
        }


        recyclerImage.addOnItemTouchListener(new RecyclerTouchlListener(this, recyclerImage, new RecyclerTouchlListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                intent = new Intent(MainActivity.this, ActivityShowImage.class);
                intent.putExtra("image_position",position);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }


    private void initRecycler() {

        adapter = new ImageLoaderAdapter(this, Data.imageThumbUrls);
        recyclerImage = findViewById(R.id.recyclerImage);
        mLayoutManager = new GridLayoutManager(this,3);
        recyclerImage.setLayoutManager(mLayoutManager);
        recyclerImage.setItemAnimator(new DefaultItemAnimator());
        recyclerImage.setNestedScrollingEnabled(true);
        recyclerImage.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
