package hackhathon.solution.com.technicaltest.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import hackhathon.solution.com.technicaltest.R;
import hackhathon.solution.com.technicaltest.model.Data;

public class ActivityShowImage extends AppCompatActivity {

    private ImageView imageView;

    private String imgUrl;
    private Intent intent;
    private int imgPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        initUI();

        parseData();
    }

    private void initUI() {
        imageView = findViewById(R.id.imageView);
    }

    private void parseData() {
        intent = getIntent();
        imgPos = intent.getIntExtra("image_position",0);
        imgUrl = Data.imageUrls[imgPos];

        loadImage(imgUrl);
    }

    private void loadImage(final String imgUrl) {


        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(ActivityShowImage.this).load(imgUrl).into(imageView);
            }
        });
    }
}
