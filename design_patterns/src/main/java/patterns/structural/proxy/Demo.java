package patterns.structural.proxy;

import patterns.structural.proxy.downloader.YoutubeDownloader;
import patterns.structural.proxy.proxy.YoutubeCacheProxy;
import patterns.structural.proxy.some_cool_media_library.ThirdPartyYoutubeClass;

/**
 * Caching proxy
 * In this example, the Proxy pattern helps to implement the lazy initialization and caching to an 
 * inefficient 3rd-party Youtube integration library.
 * Proxy is invaluable when you have to add some additional behaviours to a class which code you can’t change.
 */
public class Demo {

    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behaviour in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}