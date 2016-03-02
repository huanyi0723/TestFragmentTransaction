package com.example.testfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.ImageView;
import android.view.View;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

  private AllPhotosFragment allPhotosFragment;
  private MyAlbumFragment myAlbumFragment;
  private ShareTimeFragment shareTimeFragment;
  private ShotTimeFragment shotTimeFragment;
  private ThemeAlbumFragment themeAlbumFragment;
  private PersonalFragment personalFragment;

  private ImageView test1;
  private ImageView test2;
  private ImageView test3;
  
  private FragmentManager fragmentManager;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
    setContentView(R.layout.activity_main);

    test1 = (ImageView) findViewById(R.id.test1);
    test2 = (ImageView) findViewById(R.id.test2);
    test3 = (ImageView) findViewById(R.id.test3);
    test1.setOnClickListener(this);
    test2.setOnClickListener(this);
    test3.setOnClickListener(this);
    
    fragmentManager = getSupportFragmentManager();

  }



  @Override
  public void onClick(View v) {
    
    //必须使用局部变量 只能commit一次
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    hideFragments(transaction);

    switch (v.getId()) {
      case R.id.test1:
        if (allPhotosFragment == null) {
          allPhotosFragment = new AllPhotosFragment();
          transaction.add(R.id.id_content, allPhotosFragment);
        }else {
          transaction.show(allPhotosFragment);
        }
        break;
      case R.id.test2:
        if (shareTimeFragment == null) {
          shareTimeFragment = new ShareTimeFragment();
          transaction.add(R.id.id_content, shareTimeFragment);
        }else {
          transaction.show(shareTimeFragment);
        }
        break;
      case R.id.test3:
        if (personalFragment == null) {
          personalFragment = new PersonalFragment();
          transaction.add(R.id.id_content, personalFragment);
        }else {
          transaction.show(personalFragment);
        }
        break;
    }
    
    transaction.commit();

  }
  
  private void hideFragments(FragmentTransaction transaction) {
    if (allPhotosFragment != null) {
      transaction.hide(allPhotosFragment);
    }
    if (shareTimeFragment != null) {
      transaction.hide(shareTimeFragment);
    }
    if (personalFragment != null) {
      transaction.hide(personalFragment);
    }
  }
  
  
}
