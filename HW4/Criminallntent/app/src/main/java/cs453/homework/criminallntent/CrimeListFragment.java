package cs453.homework.criminallntent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    public void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }


    private class CrimeAdapter extends RecyclerView.Adapter{
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        @Override
        public int getItemViewType(int position) {
            if(mCrimes.get(position).ismRequiresPolice()){
                return 1;
            }else{
                return 0;
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            if(viewType == 0){
                return new CrimeHolder(layoutInflater,parent);
            }else{
                return new SeriousCrimeHolder(layoutInflater,parent);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            if(crime.ismRequiresPolice()){
                SeriousCrimeHolder seriousCrimeHolder = (SeriousCrimeHolder)holder;
                seriousCrimeHolder.bind(crime);
            }
            else{
                CrimeHolder crimeHolder = (CrimeHolder)holder;
                crimeHolder.bind(crime);
            }
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }



    }

    public class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Crime mCrime;
        private ImageView mSolvedImageView;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime,parent,false));
            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            mSolvedImageView = itemView.findViewById(R.id.crime_solved);
            itemView.setOnClickListener(this);
        }

        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getmDate().toString());
            mSolvedImageView.setVisibility(crime.ismSolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getActivity(), mCrime.getmTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    public class SeriousCrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Crime mCrime;
        private ImageView mSolvedImageView;
        private Button mCallPolice;

        public SeriousCrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime_serious,parent,false));
            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            mSolvedImageView = itemView.findViewById(R.id.crime_solved);
            mCallPolice = itemView.findViewById(R.id.button_call_police);

            mCallPolice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "HELP POLICE!", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(this);
        }

        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getmDate().toString());
            mSolvedImageView.setVisibility(crime.ismSolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getActivity(), mCrime.getmTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }

}
