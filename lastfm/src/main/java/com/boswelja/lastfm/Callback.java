package com.boswelja.lastfm;

import retrofit2.Call;
import retrofit2.Response;

public interface Callback<T> {

    void onFailed(Call<T> call, Throwable t);

    void onResponse(Call<T> call, Response<T> response);
}
