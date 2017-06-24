
package com.boswelja.lastfm.models.album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tracks {

  @SerializedName("track")
  @Expose
  private List<Track> track = null;

  public List<Track> getTrack() {
    return track;
  }

  public void setTrack(List<Track> track) {
    this.track = track;
  }
}
