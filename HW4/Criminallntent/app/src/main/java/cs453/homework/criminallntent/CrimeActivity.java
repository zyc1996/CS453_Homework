package cs453.homework.criminallntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CrimeActivity extends SingleFragmnetActivity {
    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }
}