package com.bytedance.android.lesson.restapi.solution.newtork;

import com.bytedance.android.lesson.restapi.solution.bean.Cat;
import com.bytedance.android.lesson.restapi.solution.bean.FeedResponse;
import com.bytedance.android.lesson.restapi.solution.bean.PostVideoResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * @author Xavier.S
 * @date 2019.01.17 20:38
 */
public interface IMiniDouyinService {
    // TODO-C2 (7) Implement your MiniDouyin PostVideo Request here, url: (POST) http://10.108.10.39:8080/minidouyin/video
    @POST("minidouyin/video") Call<List<Cat>> randomJoke();
    // TODO-C2 (8) Implement your MiniDouyin Feed Request here, url: http://10.108.10.39:8080/minidouyin/feed
//    @GET("minidouyin/feed")
}
