package cs453.homework.hw5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

public class NameFragment extends Fragment {

    private Name mName;
    private EditText mNameField;
    private Button mAdd, mEdit;
    private ViewPager mPagerReference;

    private static final String ARG_NAME_ID = "name_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID nameID = (UUID)getArguments().getSerializable(ARG_NAME_ID);
        mName = NameList.get(getActivity()).getName(nameID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_name_fragment,container,false);

        mNameField = v.findViewById(R.id.name_edit);
        mNameField.setText(mName.getmName());

        mPagerReference = container.findViewById(R.id.name_pager);


        mAdd = v.findViewById(R.id.button_add);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = mNameField.getText().toString();
                NameList.get(getActivity()).addName(newName); //suppose call update here, but how?
                mPagerReference.getAdapter().notifyDataSetChanged();

            }
        });

        mEdit = v.findViewById(R.id.button_edit);
        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editName = mNameField.getText().toString();
                mName.setmName(editName);
                mPagerReference.getAdapter().notifyDataSetChanged();
            }
        });

        return v;
    }

    public static NameFragment newInstance(UUID nameID){
        Bundle args = new Bundle();
        args.putSerializable(ARG_NAME_ID,nameID);
        NameFragment fragment = new NameFragment();
        fragment.setArguments(args);
        return fragment;
    }
}