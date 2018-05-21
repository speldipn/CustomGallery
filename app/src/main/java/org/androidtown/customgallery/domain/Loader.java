package org.androidtown.customgallery.domain;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Loader {
  public List<Item> getGalleryItem(Context context) {
    List<Item> result = new ArrayList<>();

    ContentResolver resolver = context.getContentResolver();

//   Get Original Image
    Uri uri = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
    String projections[] = {
      MediaStore.Images.Thumbnails.DATA
    };

    Cursor cursor = resolver.query(uri, projections, null, null, null);
    if (cursor != null) {
      while (cursor.moveToNext()) {
        Item item = new Item();
        item.imagePath = cursor.getString(0);
        result.add(item);
      }
      cursor.close();
    }

    return result;
  }
}
