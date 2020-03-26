package com.haanhgs.app.uitheme.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.haanhgs.app.uitheme.R;
import com.haanhgs.app.uitheme.viewmodel.MyViewModel;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//test
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnMinus1)
    ImageButton bnMinus1;
    @BindView(R.id.bnPlus1)
    ImageButton bnPlus1;
    @BindView(R.id.tvScore1)
    TextView tvScore1;

    @BindView(R.id.bnMinus2)
    ImageButton bnMinus2;
    @BindView(R.id.bnPlus2)
    ImageButton bnPlus2;
    @BindView(R.id.tvScore2)
    TextView tvScore2;

    private MyViewModel viewModel;

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        viewModel.getScores().observe(this, model -> {
            tvScore1.setText(String.format("%s",model.getScoreA()));
            tvScore2.setText(String.format("%s", model.getScoreB()));
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewModel();
    }

    @OnClick({R.id.bnMinus1, R.id.bnPlus1, R.id.bnMinus2, R.id.bnPlus2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnMinus1:
                viewModel.decreaseA();
                break;
            case R.id.bnPlus1:
                viewModel.increaseA();
                break;
            case R.id.bnMinus2:
                viewModel.decreaseB();
                break;
            case R.id.bnPlus2:
                viewModel.increaseB();
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
