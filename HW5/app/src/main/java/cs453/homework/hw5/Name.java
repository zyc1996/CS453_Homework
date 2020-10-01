package cs453.homework.hw5;

import java.util.UUID;

public class Name {
    private UUID mID;
    private String mName;

    public Name(){
        mID = UUID.randomUUID();
    }

    public UUID getmID() {
        return mID;
    }

    public void setmID(UUID mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
