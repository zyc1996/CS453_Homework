package cs453.homework.hw5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class NamePagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Name> mName;

    private static final String EXTRA_NAME_ID = "cs453.homework.hw5.name_id";

    public static Intent newIntent(Context packageContext, UUID nameID){
        Intent intent = new Intent(packageContext,NamePagerActivity.class);
        intent.putExtra(EXTRA_NAME_ID, nameID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_pager);

        mViewPager = findViewById(R.id.name_pager);
        mName = NameList.get(this).getNames();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Name name = mName.get(position);
                return NameFragment.newInstance(name.getmID());
            }

            @Override
            public int getCount() {
                return mName.size();
            }

            @Override
            public int getItemPosition(@NonNull Object object) {
                return POSITION_NONE;
            }
        });
        mViewPager.getAdapter().notifyDataSetChanged();

        UUID nameID = (UUID)getIntent().getSerializableExtra(EXTRA_NAME_ID);

        for(int i = 0; i < mName.size(); i++){
            if(mName.get(i).getmID().equals(nameID)){
                mViewPager.setCurrentItem(i);;
                break;
            }
        }
    }
}