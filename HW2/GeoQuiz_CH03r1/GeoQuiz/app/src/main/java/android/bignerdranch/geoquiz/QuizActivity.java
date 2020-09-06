package android.bignerdranch.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    public static final String TAG = "QuizActivity";
    public static final String KEY_INDEX = "index";
    private Button mTrueButton, mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true ),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    private int mCurrentIndex = 0;
    private boolean[] mUserScore = new boolean[mQuestionBank.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null)
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);

        Log.d(TAG, "onCreate(Bundle) called");

        setContentView(R.layout.activity_quiz);

        //prevent false read from question skip
        initializeRecord();

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getmTextResId();

        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mNextButton = (Button)findViewById(R.id.next_button);

        /**
         * modifying this to consistent question order display, if shows as random might not
         * ever reach the end or have question repeated or non-recorded answers
        * */
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex < mQuestionBank.length-1){
                    mCurrentIndex++;
                }else{
                    mCurrentIndex = 0;
                    initializeRecord();
                }
                Log.d("textViewUpdate2: ", "index" + mCurrentIndex);

                updateQuestion();
            }
        });


        // True Button Listener
        mTrueButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Code to execute on button click goes here.
            checkAnswer(true);
            }
        });

        //False Button Listener
        mFalseButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Code to execute on button click goes here.
            checkAnswer(false);
            }
        });
        updateQuestion();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "OnSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0, totalCorrect;
        if (userPressedTrue == answerIsTrue) {
            mUserScore[mCurrentIndex] = true;
            if(mCurrentIndex != mQuestionBank.length-1) {
                messageResId = R.string.correct_toast;
            }
        }
        else {
            mUserScore[mCurrentIndex] = false;
            if(mCurrentIndex != mQuestionBank.length-1) {
                messageResId = R.string.incorrect_toast;
            }
        }

        if(mCurrentIndex != mQuestionBank.length-1) {
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
        }else{
            totalCorrect = totalCorrects();
            if(totalCorrect == mQuestionBank.length) {
                Toast.makeText(this, "Congraz! you got ALL Answers correct!", Toast.LENGTH_SHORT).show();
            }else if(totalCorrect == 0){
                Toast.makeText(this, "Bummer, you failed every single question", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Congraz! you got " + totalCorrect + " out of " + mQuestionBank.length + " Answers correct!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private int totalCorrects(){
        int x=0;
        for(int i = 0; i < mUserScore.length; i++){
            if(mUserScore[i] == true){
                x++;
            }
        }

        return  x;
    }

    private void initializeRecord(){
        for(int i = 0; i < mUserScore.length; i++){
            mUserScore[i] = false;
        }
    }
}
