package com.haanhgs.app.uitheme;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//test
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

    private void loadInstanceState(Bundle bundle){
        if (bundle != null){
            score1 = bundle.getInt(SCORE1);
            score2 = bundle.getInt(SCORE2);
            tvScore1.setText(String.format("%s", score1));
            tvScore2.setText(String.format("%s", score2));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE1, score1);
        outState.putInt(SCORE2, score2 );
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

    //change theme
    private void changeIconByTheme(Menu menu){
        int dark = AppCompatDelegate.getDefaultNightMode();
        if (dark == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.mniTheme).setIcon(R.drawable.dark);
        }else {
            menu.findItem(R.id.mniTheme).setIcon(R.drawable.light);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        changeIconByTheme(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
//        int id = item.getItemId();
        //to change to darkmode , need to change style to this line in styles.xml
        //<style name="AppTheme" parent="Theme.AppCompat.DayNight.DarkActionBar">
        int dark = AppCompatDelegate.getDefaultNightMode();
        if (dark == AppCompatDelegate.MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
//        recreate();
        return super.onOptionsItemSelected(item);
    }
}
