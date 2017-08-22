package com.boswelja.lastfm;

import retrofit2.Call;
import retrofit2.Response;

public interface Callback<T> {

  @Deprecated
  void onFailed(Call<T> call, Throwable t);

  @Deprecated
  void onResponse(Call<T> call, Response<T> response);

  void onDataRetrieved(T data);

  void onResultFailed();

  void onResultEmpty();
}
