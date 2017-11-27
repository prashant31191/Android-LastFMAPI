package com.boswelja.lastfm.tasks;

import com.boswelja.lastfm.Callback;
import com.boswelja.lastfm.LastFMApi;
import com.boswelja.lastfm.models.artist.LastFMArtist;
import retrofit2.Call;
import retrofit2.Response;

public class ArtistTask {

  private LastFMApi api;
  private String query, apiKey;
  private retrofit2.Callback<LastFMArtist> callback;

  public ArtistTask(LastFMApi api, String apiKey) {
    this.apiKey = apiKey;
    this.api = api;
  }

  public ArtistTask setCallback(final Callback<LastFMArtist> callback) {
    this.callback =
        new retrofit2.Callback<LastFMArtist>() {
          @Override
          public void onResponse(Call<LastFMArtist> call, Response<LastFMArtist> response) {
              if (response.isSuccessful()) {
                  final LastFMArtist data = response.body();
                  if (data != null) {
                      callback.onDataRetrieved(data);
                  } else {
                      callback.onResultEmpty();
                  }
              } else {
                  callback.onResultEmpty();
              }
          }

          @Override
          public void onFailure(Call<LastFMArtist> call, Throwable t) {
            callback.onFailed(t);
          }
        };
    return this;
  }

  public ArtistTask withName(String name) {
    this.query = name;
    return this;
  }

  public void build() {
    Call<LastFMArtist> artistCall = api.getArtist(query, apiKey);
    artistCall.enqueue(callback);
  }
}
