# Android-LastFMAPI[ ![Download](https://api.bintray.com/packages/boswelja/maven/lastfm-wrapper/images/download.svg) ](https://bintray.com/boswelja/maven/lastfm-wrapper/_latestVersion)
A wrapper for the Last FM web API

## Include
Add this to your modules build.gradle
```groovy
dependencies {
  repositories {
    jcenter()
  }
  compile 'com.boswelja:lastfm-wrapper:{Latest Version}'
  compile 'com.squareup.retrofit2:retrofit:{Retrofit Version}'
}
```
Where {Latest Version} is the version shown by the download badge above
Where {Retrofit Version} is the latest version of [Retrofit](https://github.com/square/retrofit)

##Usage
```java
new LastFMRequest() // Create the request
                .setApiKey(context.getString(R.string.lastfm_api_key)) //REQUIRED Sets the API key
                .setQuery(Uri.parse(Search term))                      //REQUIRED Must be run through Uri.parse()
                .setCustomClient(new OkHttpClient())                   //OPTIONAL Allows setting a custom http client
                .setArtist()                                           //REQUIRED Returns a new ArtistTask for fetching info about an artist
                .setCallback(new Callback<LastFMArtist>() {            //REQUIRED Lets you do something with the result
                    @Override
                    public void onResponse(Call<LastFMArtist> call, Response<LastFMArtist> response) {
                        if(response.isSuccessful()) {
                            response.body().getArtist() //Returns a java class with the artist info
                            //Do something here
                        }
                    }

                    @Override
                    public void onFailure(Call<LastFMArtist> call, Throwable throwable) {
                        // Request failed
                    }
                })
                .build(); //REQUIRED Make the request
```
More coming later
