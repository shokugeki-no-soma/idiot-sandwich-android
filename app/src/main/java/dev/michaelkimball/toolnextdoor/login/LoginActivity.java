package dev.michaelkimball.toolnextdoor.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;
import dev.michaelkimball.toolnextdoor.R;
import dev.michaelkimball.toolnextdoor.home.HomeActivity;

public class LoginActivity extends DaggerAppCompatActivity {

    @BindView(R.id.login_logo)
    ImageView loginImage;

    @BindView(R.id.login)
    Button loginButton;

    @OnClick(R.id.login)
    void login(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
    }
}
