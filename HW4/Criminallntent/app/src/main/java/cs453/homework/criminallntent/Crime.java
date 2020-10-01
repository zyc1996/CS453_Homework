package cs453.homework.criminallntent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId; //crime id
    private String mTitle; //crime title
    private Date mDate; //crime date
    private boolean mSolved; //is crime solved?

    public boolean ismRequiresPolice() {
        return mRequiresPolice;
    }

    public void setmRequiresPolice(boolean mRequiresPolice) {
        this.mRequiresPolice = mRequiresPolice;
    }

    private boolean mRequiresPolice; //require police?

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
