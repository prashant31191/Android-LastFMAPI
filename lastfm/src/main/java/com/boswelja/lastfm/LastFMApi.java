package com.boswelja.lastfm;

import com.boswelja.lastfm.models.album.LastFMAlbum;
import com.boswelja.lastfm.models.artist.LastFMArtist;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LastFMApi {
    @GET("?method=artist.getinfo&format=json")
    Call<LastFMArtist> getArtist(@Query("artist") String name, @Query("api_key") String apiKey);

    @GET("?method=album.getinfo&format=json")
    Call<LastFMAlbum> getAlbum(@Query("artist") String artistName, @Query("album") String albumName, @Query("api_key") String apiKey);
}
