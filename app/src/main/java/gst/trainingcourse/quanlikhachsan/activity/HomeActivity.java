package gst.trainingcourse.quanlikhachsan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import gst.trainingcourse.quanlikhachsan.R;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ImageButton mBtnToolBar;
    private NavigationView mNvMain;
    private TextView mTxtTrangChu;

    private final View.OnClickListener mBtnToolBarClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    };

    private final NavigationView.OnNavigationItemSelectedListener mNvMainClick = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.itThemTang:
                    Intent intent = new Intent(HomeActivity.this, AddFloorActivity.class);
                    startActivity(intent);
                    break;
                case R.id.itThemPhong:
                    Intent intent1 = new Intent(HomeActivity.this, AddRoomActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.itTimKiem:
                    Intent intent2 = new Intent(HomeActivity.this, SearchActivity.class);
                    startActivity(intent2);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initView();
        setTextView();
        initAction();
    }

    private void setTextView() {
        Intent intent = getIntent();
        String tenUser = intent.getStringExtra("tenUser");
        mTxtTrangChu.setText("Chào mừng nhà quản lí : " + tenUser);
    }

    private void initAction() {
        mNvMain.setNavigationItemSelectedListener(mNvMainClick);
        mBtnToolBar.setOnClickListener(mBtnToolBarClick);
    }

    private void initView() {
        mNvMain = findViewById(R.id.navigationview_trangchu);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mBtnToolBar = findViewById(R.id.imgButtonToolbar);
        mTxtTrangChu = findViewById(R.id.txtTrangChuActivity);
    }
}
