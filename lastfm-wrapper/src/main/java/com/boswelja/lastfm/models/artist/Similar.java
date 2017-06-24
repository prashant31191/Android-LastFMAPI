
package com.boswelja.lastfm.models.artist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Similar {

  @SerializedName("artist")
  @Expose
  private List<Artist_> artist = null;

  public List<Artist_> getArtist() {
    return artist;
  }

  public void setArtist(List<Artist_> artist) {
    this.artist = artist;
  }
}
