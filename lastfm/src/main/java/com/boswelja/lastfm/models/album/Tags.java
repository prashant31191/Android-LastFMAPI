
package com.boswelja.lastfm.models.album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tags {

  @SerializedName("tag")
  @Expose
  private List<Tag> tag = null;

  public List<Tag> getTag() {
    return tag;
  }

  public void setTag(List<Tag> tag) {
    this.tag = tag;
  }
}
