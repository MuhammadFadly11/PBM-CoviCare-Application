package com.example.covicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ImageButton backbtn = findViewById(R.id.backbtn);
        viewPager2 = findViewById(R.id.viewPager2Foods);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(FoodActivity.this, bottomNavigation.class);
                startActivity(home);
                finish();
            }
        });

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.beetrootpng));
        sliderItems.add(new SliderItem(R.drawable.brocoli));
        sliderItems.add(new SliderItem(R.drawable.chickensoup));
        sliderItems.add(new SliderItem(R.drawable.ginger));
        sliderItems.add(new SliderItem(R.drawable.lemon));
        sliderItems.add(new SliderItem(R.drawable.orange));
        sliderItems.add(new SliderItem(R.drawable.pineapple));
        sliderItems.add(new SliderItem(R.drawable.watermelon));

        viewPager2.setAdapter(new SliderAdapterFoods(sliderItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

    }
}