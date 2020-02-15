package dev.michaelkimball.toolnextdoor.login;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;
import dev.michaelkimball.toolnextdoor.R;

public class LoginActivity extends DaggerAppCompatActivity {

    @BindView(R.id.login_logo)
    ImageView loginImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }
}
