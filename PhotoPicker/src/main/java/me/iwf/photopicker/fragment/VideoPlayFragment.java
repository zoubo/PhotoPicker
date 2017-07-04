package me.iwf.photopicker.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import me.iwf.photopicker.R;

/**
 * Created by donglua on 15/6/21.
 */
public class VideoPlayFragment extends Fragment {

    public final static String ARG_PATH = "PATHS";
    private VideoView videoView;
    private Uri uri;

    public static VideoPlayFragment newInstance(String path) {

        VideoPlayFragment f = new VideoPlayFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PATH, path);

        f.setArguments(args);

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String path = getArguments().getString(ARG_PATH);

        uri = Uri.parse(path);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.__picker_picker_fragment_videoplay_pager, container, false);

        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        //设置视频控制器
        videoView.setMediaController(new MediaController(getActivity()));
        // 播放完成回调
//         videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());
        //设置视频路径
        videoView.setVideoURI(uri);
        // 开始播放视频
        videoView.start();

        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
