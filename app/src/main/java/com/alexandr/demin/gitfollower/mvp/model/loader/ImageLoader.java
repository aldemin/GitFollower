package com.alexandr.demin.gitfollower.mvp.model.loader;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.alexandr.demin.gitfollower.utils.NetworkStatus;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class ImageLoader {

    private final NetworkStatus networkStatus;

    public ImageLoader(NetworkStatus networkStatus) {
        this.networkStatus = networkStatus;
    }

    public void loadInto(String avatarUrl, ImageView container) {
        if (networkStatus.isOnline()) {
            Glide.with(container.getContext()).asBitmap().load(avatarUrl).listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                    // TODO: 21.10.2018 add show error
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                    return false;
                }
            }).into(container);
        } else {
            // TODO: 21.10.2018  add show error
        }
    }
}
