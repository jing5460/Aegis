package com.beemdevelopment.aegis.ui.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.beemdevelopment.aegis.R;
import com.beemdevelopment.aegis.helpers.ThemeHelper;
import com.beemdevelopment.aegis.icons.IconPack;
import com.beemdevelopment.aegis.icons.IconType;
import com.beemdevelopment.aegis.ui.glide.GlideHelper;
import com.bumptech.glide.Glide;

import java.io.File;

public class IconHolder extends RecyclerView.ViewHolder {
    private File _iconFile;
    private IconType _iconType;
    private boolean _isCustom;

    private final ImageView _imageView;
    private final TextView _textView;

    public IconHolder(final View view) {
        super(view);
        _imageView = view.findViewById(R.id.icon);
        _textView = view.findViewById(R.id.icon_name);
    }

    public void setData(IconPack.Icon icon) {
        _iconFile = icon.getFile();
        _iconType = icon.getIconType();
        _isCustom = icon instanceof IconAdapter.DummyIcon;
        _textView.setText(icon.getName());
    }

    public void loadIcon(Context context) {
        if (_isCustom) {
            int tint = ThemeHelper.getThemeColor(R.attr.iconColorPrimary, context.getTheme());
            GlideHelper.loadResource(Glide.with(context), R.drawable.ic_plus_black_24dp, tint, _imageView);
        } else {
            GlideHelper.loadIconFile(Glide.with(context), _iconFile, _iconType, _imageView);
        }
    }
}
