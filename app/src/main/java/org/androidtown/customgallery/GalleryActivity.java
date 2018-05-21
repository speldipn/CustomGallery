package org.androidtown.customgallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidtown.customgallery.adapter.GalleryAdapter;
import org.androidtown.customgallery.domain.Item;
import org.androidtown.customgallery.domain.Loader;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity implements GalleryAdapter.Callback{
  public static final String SELECTED_PATH = "selectedPath";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gallery);

    Loader loader = new Loader();
    List<Item> list = loader.getGalleryItem(this);
    GalleryAdapter adapter = new GalleryAdapter(list,this);

    RecyclerView recycler = findViewById(R.id.recyclerView);
    recycler.setAdapter(adapter);
    recycler.setLayoutManager(new GridLayoutManager(this, 2));
  }

  @Override
  public void returnValue(String imagePath) {
    Intent intent = new Intent();
    intent.putExtra(SELECTED_PATH, imagePath);
    setResult(RESULT_OK, intent);
    finish();
  }
}