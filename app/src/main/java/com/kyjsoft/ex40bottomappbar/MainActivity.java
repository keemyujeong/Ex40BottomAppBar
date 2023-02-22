package com.kyjsoft.ex40bottomappbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bab; // 이쪽 저쪽 에서 쓸거임
    FloatingActionButton fab;

    boolean isCenter = true; // fab가 가운데 있는 지 여부

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BottomAppbar를 ActionBar로 대체하겠다고 알려주셈
        bab = findViewById(R.id.bab);
        setSupportActionBar(bab); // 제목줄을 대체할거임. -> 툴바는 옵션메뉴를 달 수 짐다.

        // 옵션 메뉴는 다 자바에서
        // 제목줄에 뒤로 가기 버튼(업버튼이라고 부름) 붙이기
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // BottomAppbar는 제목 글씨가 안보임 settitle해도 안보임.

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isCenter) bab.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END); // 자바에서 위치 고칠 수도 있음.
                else bab.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);

                isCenter = !isCenter; // 눌러서 위치 옮겼으니까 디폴트가 처음의 반대로 가게하는 거임. 그래야 클릭할 때 반대반응을 하지.
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }
}