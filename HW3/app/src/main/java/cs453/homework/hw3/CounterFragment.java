package cs453.homework.hw3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {

    private MyCounter mCounter;
    private TextView mCountDisplay;
    private Button mButtonPlusOne, mButtonPlusFive, mButtonReset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCounter = new MyCounter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.counter_fragment,container,false);

        mCountDisplay = v.findViewById(R.id.count_display);
        mButtonPlusOne = v.findViewById(R.id.plus_one_button);
        mButtonPlusFive = v.findViewById(R.id.plus_five_button);
        mButtonReset = v.findViewById(R.id.reset_button);

        mButtonPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter.plusOneCount();
                updateDisplay();
            }
        });

        mButtonPlusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter.plusFiveCount();
                updateDisplay();
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter.resetCount();
                updateDisplay();
            }
        });

        updateDisplay();
        return v;
    }

    public void updateDisplay(){
        int currentCount = mCounter.getCurrentCount();
        mCountDisplay.setText(String.valueOf(currentCount));
    }
}