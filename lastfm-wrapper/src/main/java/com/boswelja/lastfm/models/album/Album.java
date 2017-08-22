
package com.boswelja.lastfm.models.album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album {

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("artist")
  @Expose
  private String artist;

  @SerializedName("image")
  @Expose
  private List<Image> image = null;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public List<Image> getImage() {
    return image;
  }

  public void setImage(List<Image> image) {
    this.image = image;
  }
}
