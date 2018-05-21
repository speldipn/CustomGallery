package org.androidtown.customgallery.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.androidtown.customgallery.MainActivity;
import org.androidtown.customgallery.R;
import org.androidtown.customgallery.domain.Item;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Holder> {
  List<Item> list;
  Callback callback;

  // 나(Adapter)를 사용하는 측에 클릭시 호출할 인터페이스를 제공한다
  public interface Callback{
    public void returnValue(String imagePath);
  }

  public GalleryAdapter(List<Item> list,Callback callback) {
    this.list = list;
    this.callback = callback;
  }


  public void setDataAndRefresh(List<Item> data) {
    // not used.
    this.list = data;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    Item item = list.get(position);
    holder.setImage(item.imagePath);
    holder.item = item;
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public class Holder extends RecyclerView.ViewHolder {
    ImageView image;
    Item item;
    public Holder(View itemView) {
      super(itemView);
      image = itemView.findViewById(R.id.gridImgView);
      image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          callback.returnValue(item.imagePath);
        }
      });
    }

    public void setImage(String path) {
      Uri uri = Uri.parse(path);
      image.setImageURI(uri);
    }

    public void setImage(Uri uri) {
      // TODO
    }

    public void setImage(Bitmap bitmap) {
      // TODO
    }
  }
}
