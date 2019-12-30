package gst.trainingcourse.quanlikhachsan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import gst.trainingcourse.quanlikhachsan.R;
import gst.trainingcourse.quanlikhachsan.dao.FloorDAO;
import gst.trainingcourse.quanlikhachsan.model.Floor;

public class AddFloorActivity extends AppCompatActivity {
    private EditText mEtFloorName;
    private EditText mEtFloorDes;
    private Button mBtnAddFloor;

    private View.OnClickListener mBtnAddFloorClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String sName = mEtFloorName.getText().toString();
            String sDes = mEtFloorDes.getText().toString();
            Floor floor = new Floor();
            floor.setName(sName);
            floor.setDescription(sDes);
            FloorDAO floorDAO = new FloorDAO(getApplicationContext());
            boolean kiemtra =floorDAO.addFloor(floor);
            if(kiemtra) Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_floor_activity);
        initView();
        initAction();
    }

    private void initAction() {
        mBtnAddFloor.setOnClickListener(mBtnAddFloorClick);
    }

    private void initView() {
        mEtFloorName = findViewById(R.id.etFloorName);
        mEtFloorDes = findViewById(R.id.etFloorDes);
        mBtnAddFloor = findViewById(R.id.btnAddFloor);
    }
}
