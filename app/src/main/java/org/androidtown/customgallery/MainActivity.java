package org.androidtown.customgallery;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import org.androidtown.customgallery.adapter.GalleryAdapter;
import org.androidtown.customgallery.domain.Item;
import org.androidtown.customgallery.domain.Loader;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
  public static final String IMAGE_KEY = "55";
  public static int REQUEST_CODE = 100;
  ImageView imageView;

  static String[] permissions = {
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.WRITE_EXTERNAL_STORAGE
  };

  public MainActivity() {
    super(permissions);
  }

  @Override
  public void init() {
    setContentView(R.layout.activity_main);
    imageView = findViewById(R.id.imageView);
  }

  public void getImage(View v) {
    Intent intent = new Intent(this, GalleryActivity.class);
    startActivityForResult(intent,REQUEST_CODE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
      Uri uri = Uri.parse(data.getStringExtra(GalleryActivity.SELECTED_PATH));
      imageView.setImageURI(uri);
    }
  }
}
