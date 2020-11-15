package cs453.homework.photogallery;

import androidx.annotation.NonNull;

public class GalleryItem {
    private String mCaption, mId, mUrl;

    public String getmCaption() {
        return mCaption;
    }

    public void setmCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return mCaption;
    }
}
