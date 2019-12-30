package gst.trainingcourse.quanlikhachsan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import gst.trainingcourse.quanlikhachsan.common.Constant;
import gst.trainingcourse.quanlikhachsan.database.MyDatabase;
import gst.trainingcourse.quanlikhachsan.model.User;

public class UserDAO {
    private SQLiteDatabase database;

    public UserDAO(Context context) {
        MyDatabase myDatabase = new MyDatabase(context);
        database = myDatabase.open();
    }

    public boolean addUser(User user) {
        ContentValues contentValues = new ContentValues();
        if (user.getEmail() != null && user.getPassword() != null) {
            contentValues.put(Constant.TB_USER_EMAIL, user.getEmail());
            contentValues.put(Constant.TB_USER_PASSWORD, user.getPassword());
            database.insert(Constant.TB_USER, null, contentValues);
            return true;
        } else return false;

    }

    public String checkLogin(String tendangnhap, String matkhau) {
        String sql = "SELECT * FROM " + Constant.TB_USER + " WHERE " + Constant.TB_USER_EMAIL + " = '" + tendangnhap
                + "' AND " + Constant.TB_USER_PASSWORD + " = '" + matkhau + "'";
        String tenUser = null;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            tenUser = cursor.getString(1);
            cursor.moveToNext();
        }
        return tenUser;
    }
}
