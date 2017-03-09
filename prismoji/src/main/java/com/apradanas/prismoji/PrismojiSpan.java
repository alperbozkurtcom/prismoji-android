package com.apradanas.prismoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.content.res.AppCompatResources;
import android.text.style.DynamicDrawableSpan;

import static com.apradanas.prismoji.Utils.checkNotNull;

final class PrismojiSpan extends DynamicDrawableSpan {
    private final Context context;
    private final int resourceId;
    private final int size;

    private Drawable drawable;

    PrismojiSpan(@NonNull final Context context, @DrawableRes final int resourceId, final int size) {
        this.context = context;
        this.resourceId = resourceId;
        this.size = size;
    }

    @Override
    public Drawable getDrawable() {
        if (drawable == null) {
            drawable = checkNotNull(AppCompatResources.getDrawable(context, resourceId), "emoji drawable == null");
            drawable.setBounds(0, 0, size, size);
        }

        return drawable;
    }
}