package com.boswelja.lastfm.tasks;

import com.boswelja.lastfm.Callback;
import com.boswelja.lastfm.LastFMApi;
import com.boswelja.lastfm.models.album.LastFMAlbum;
import retrofit2.Call;
import retrofit2.Response;

public class AlbumTask {

  private LastFMApi api;
  private String artistName, albumName, apiKey;
  private retrofit2.Callback<LastFMAlbum> callback;

  public AlbumTask(LastFMApi api, String apiKey) {
    this.apiKey = apiKey;
    this.api = api;
  }

  public AlbumTask setCallback(final Callback<LastFMAlbum> callback) {
    this.callback =
        new retrofit2.Callback<LastFMAlbum>() {
          @Override
          public void onResponse(Call<LastFMAlbum> call, Response<LastFMAlbum> response) {
            callback.onResponse(call, response);
          }

          @Override
          public void onFailure(Call<LastFMAlbum> call, Throwable t) {
            callback.onFailed(call, t);
          }
        };
    return this;
  }

  public AlbumTask withQuery(String artistName, String albumName) {
    this.artistName = artistName;
    this.albumName = albumName;
    return this;
  }

  public void build() {
    Call<LastFMAlbum> artistCall = api.getAlbum(artistName, albumName, apiKey);
    artistCall.enqueue(callback);
  }
}
