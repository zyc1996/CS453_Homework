package cs453.homework.criminallntent;

import androidx.fragment.app.Fragment;

public class CrimeListActivity extends SingleFragmnetActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
