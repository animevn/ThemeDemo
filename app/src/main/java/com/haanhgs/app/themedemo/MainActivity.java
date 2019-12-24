package com.haanhgs.app.themedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.bnMinus1)
    ImageButton bnMinus1;
    @BindView(R.id.bnPlus1)
    ImageButton bnPlus1;
    @BindView(R.id.tvScore1)
    TextView tvScore1;
    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.bnMinus2)
    ImageButton bnMinus2;
    @BindView(R.id.bnPlus2)
    ImageButton bnPlus2;
    @BindView(R.id.tvScore2)
    TextView tvScore2;
    @BindView(R.id.constraintLayout2)
    ConstraintLayout constraintLayout2;

    private int score1 = 0;
    private int score2 = 0;

    private static final String SCORE1 = "score1";
    private static final String SCORE2 = "score2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bnMinus1, R.id.bnPlus1, R.id.bnMinus2, R.id.bnPlus2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnMinus1:
                score1--;
                if (score1 < 0) score1 = 0;
                tvScore1.setText(String.format("%s", score1));
                break;
            case R.id.bnPlus1:
                score1++;
                tvScore1.setText(String.format("%s", score1));
                break;
            case R.id.bnMinus2:
                score2--;
                if (score2 < 0) score2 = 0;
                tvScore2.setText(String.format("%s", score2));
                break;
            case R.id.bnPlus2:
                score2++;
                tvScore2.setText(String.format("%s", score2));
                break;
        }
    }
}
