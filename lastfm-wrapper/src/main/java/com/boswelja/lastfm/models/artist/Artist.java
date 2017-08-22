
package com.boswelja.lastfm.models.artist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Artist {

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("image")
  @Expose
  private List<Image> image = null;

  @SerializedName("bio")
  @Expose
  private Bio bio;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Image> getImage() {
    return image;
  }

  public void setImage(List<Image> image) {
    this.image = image;
  }

  public Bio getBio() {
    return bio;
  }

  public void setBio(Bio bio) {
    this.bio = bio;
  }
}
