package patterns.structural.proxy.some_cool_media_library;

import java.util.HashMap;

public interface ThirdPartyYoutubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}