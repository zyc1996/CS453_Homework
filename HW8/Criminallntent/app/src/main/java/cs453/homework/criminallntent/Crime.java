package cs453.homework.criminallntent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId; //crime id
    private String mTitle; //crime title
    private Date mDate; //crime date
    private boolean mSolved; //is crime solved?
    private String mSuspect; //the crime suspect

    public Crime(){
        this(UUID.randomUUID());
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getID() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String mSuspect) {
        this.mSuspect = mSuspect;
    }

    public String getPhotoFileName(){
        return "IMG_"+ getID().toString() + ".jpg";
    }
}
