package com.boswelja.lastfm;

public interface Callback<T> {

  void onDataRetrieved(T data);

  void onFailed(Throwable t);

  void onResultEmpty();
}
