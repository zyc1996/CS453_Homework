package cs453.homework.criminallntent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.File;

public class ZoomPhotoFragment extends DialogFragment {

    private static final String ARG_ZOOM = "zoom";
    private ImageView mImageView;

    public static ZoomPhotoFragment newInstance(File file){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ZOOM, file);
        ZoomPhotoFragment fragment = new ZoomPhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        File mPhotoFile = (File)getArguments().getSerializable(ARG_ZOOM);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_zoom, null);

        mImageView = v.findViewById(R.id.zoomed_crime_scene);
        if(mPhotoFile == null || !mPhotoFile.exists()){
            mImageView.setImageDrawable(null);
        }else{
            Bitmap bm = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(), getActivity()
            );
            mImageView.setImageBitmap(bm);
        }

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Crime Scene")
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

}
