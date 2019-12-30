package gst.trainingcourse.quanlikhachsan.model;

public class Room {
    private int mId;
    private String mName;
    private int mSquare;
    private int mPeopleNum;
    private String mFloorName;

    public String getNameFloor() {
        return mFloorName;
    }

    public void setNameFloor(String mFloorName) {
        this.mFloorName = mFloorName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getSquare() {
        return mSquare;
    }

    public void setSquare(int mSquare) {
        this.mSquare = mSquare;
    }

    public int getPeopleNum() {
        return mPeopleNum;
    }

    public void setPeopleNum(int mPeopleNum) {
        this.mPeopleNum = mPeopleNum;
    }
}
