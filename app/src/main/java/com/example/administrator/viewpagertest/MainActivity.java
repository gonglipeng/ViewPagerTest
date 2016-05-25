package com.example.administrator.viewpagertest;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabPageIndicator tvTitle;
    private ViewPager vpTest;
    private ArrayList<String> mList;


    private void assignViews() {
        tvTitle = (TabPageIndicator) findViewById(R.id.tv_title);
        vpTest = (ViewPager) findViewById(R.id.vp_test);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        addData();
        vpTest.setAdapter(new MyAdapter());
        tvTitle.setViewPager(vpTest);
    }

    private void addData() {
        mList=new ArrayList<>();
        for(int i=0;i<2;i++) {
            mList.add("" + i);
        }
    }

    class MyAdapter extends PagerAdapter {

        // 指定指示器的标题
        @Override
        public CharSequence getPageTitle(int position) {
            String data = mList.get(position);
            return data;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            String pager = mList.get(position);

            View view = View.inflate(MainActivity.this,R.layout.viewpage_item, null);
            TextView tv= (TextView) view.findViewById(R.id.textview);
            tv.setText(pager);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }


}
