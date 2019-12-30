package gst.trainingcourse.quanlikhachsan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import gst.trainingcourse.quanlikhachsan.common.Constant;
import gst.trainingcourse.quanlikhachsan.database.MyDatabase;
import gst.trainingcourse.quanlikhachsan.model.Floor;
import gst.trainingcourse.quanlikhachsan.model.User;


public class FloorDAO {
    SQLiteDatabase database;

    public FloorDAO(Context context) {
        MyDatabase myDatabase = new MyDatabase(context);
        database = myDatabase.open();
    }

    public boolean addFloor(Floor floor) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.TB_FLOOR_NAME, floor.getName());
        contentValues.put(Constant.TB_FLOOR_DES, floor.getDescription());
        long kiemtra = database.insert(Constant.TB_USER, null, contentValues);
        if (kiemtra != 0) return true;
        else return false;
    }

    public List<String> getListFloorName() {
        List<String> list = new ArrayList<>();
        String sql = " select * from " + Constant.TB_FLOOR;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(1);
            list.add(name);
            cursor.moveToNext();
        }
        return list;
    }
}
