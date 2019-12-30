package gst.trainingcourse.quanlikhachsan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import gst.trainingcourse.quanlikhachsan.common.Constant;


public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(Context context) {
        super(context, "myDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createFloorDb = "CREATE TABLE " + Constant.TB_FLOOR + "( " + Constant.TB_FLOOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + Constant.TB_FLOOR_NAME + " TEXT ," + Constant.TB_FLOOR_DES + " TEXT ) ";
        String createRoomDb = "CREATE TABLE " + Constant.TB_ROOM + "( " + Constant.TB_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + Constant.TB_ROOM_NAME + " TEXT ," + Constant.TB_ROOM_SQUARE + " INTEGER , " + Constant.TB_ROOM_PEOPLENUM + " INTEGER , "
                + Constant.TB_ROOM_FLOORNAME + " TEXT ) ";
        String createUserDb = "CREATE TABLE " + Constant.TB_USER + "( " + Constant.TB_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + Constant.TB_USER_EMAIL + " TEXT ," + Constant.TB_USER_PASSWORD + " TEXT ) ";
        db.execSQL(createFloorDb);
        db.execSQL(createRoomDb);
        db.execSQL(createUserDb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open() {
        return this.getWritableDatabase();
    }
}
