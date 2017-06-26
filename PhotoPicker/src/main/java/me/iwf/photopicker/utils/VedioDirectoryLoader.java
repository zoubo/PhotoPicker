package me.iwf.photopicker.utils;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.support.v4.content.CursorLoader;

import static android.provider.MediaStore.MediaColumns.MIME_TYPE;

/**
 * Created by 黄东鲁 on 15/6/28.
 */
public class VedioDirectoryLoader extends CursorLoader {

    final String[] IMAGE_PROJECTION = {
            Media._ID,
            Media.DATA,
            Media.BUCKET_ID,
            Media.BUCKET_DISPLAY_NAME,
            Media.DATE_ADDED,
            Media.SIZE
    };

    public VedioDirectoryLoader(Context context) {
        super(context);

        setProjection(IMAGE_PROJECTION);
        setUri(MediaStore.Video.Media.EXTERNAL_CONTENT_URI);//修改后的代码
        setSortOrder(Media.DATE_ADDED + " DESC");

        setSelection(
                MIME_TYPE + "=? or " + MIME_TYPE + "=? or " + MIME_TYPE + "=? or " + MIME_TYPE + "=? ");
        String[] selectionArgs;

        selectionArgs = new String[]{"video/wmv", "video/mp4", "video/3gp"};

        setSelectionArgs(selectionArgs);
    }


    private VedioDirectoryLoader(Context context, Uri uri, String[] projection, String selection,
                                 String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }


}
