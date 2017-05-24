package com.boswelja.lastfm;

import com.boswelja.lastfm.tasks.AlbumTask;
import com.boswelja.lastfm.tasks.ArtistTask;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastFMRequest {

    private String apiKey;
    private Retrofit.Builder retrofitBuilder;

    public LastFMRequest() {
        retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://ws.audioscrobbler.com/2.0/");
    }

    public ArtistTask requestArtist() {
        Retrofit retrofit = retrofitBuilder.build();
        LastFMApi lastFMApi = retrofit.create(LastFMApi.class);
        return new ArtistTask(lastFMApi, apiKey);
    }

    public AlbumTask requestAlbum() {
        Retrofit retrofit = retrofitBuilder.build();
        LastFMApi lastFMApi = retrofit.create(LastFMApi.class);
        return new AlbumTask(lastFMApi, apiKey);
    }

    public LastFMRequest setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public LastFMRequest setCustomClient(final OkHttpClient client) {
        retrofitBuilder.client(client);
        return this;
    }
}