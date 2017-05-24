# Android-LastFMAPI<br>
[ ![Download](https://api.bintray.com/packages/boswelja/maven/lastfm-wrapper/images/download.svg) ](https://bintray.com/boswelja/maven/lastfm-wrapper/_latestVersion)<br>
A wrapper for the Last FM web API

## Include
Add this to your modules build.gradle
```groovy
dependencies {
  repositories {
    jcenter()
  }
  compile 'com.boswelja:lastfm-wrapper:{Latest Version}'
}
```
Where {Latest Version} is the version shown by the download badge above

##Usage
```java
LastFMRequest request = new LastFMRequest() // Create the request
                .setApiKey(context.getString(R.string.lastfm_api_key)) //REQUIRED Sets the API key
```

###Fetching artist info
```java
request
    .requestArtist()    //Returns a new ArtistTask for fetching info about an artist
    .withName("Cher")    //Name of the artist you want
    .setCallback(new Callback<LastFMArtist>() {    //Lets you do something with the result
            @Override
            public void onResponse(Call<LastFMArtist> call, Response<LastFMArtist> response) {
                if(response.isSuccessful()) {
                    LastFMArtist artistInfo = response.body().getArtist() //Returns a java class with the artist info
                    //Response successful, do what you want with the result here
                }
            }

            @Override
            public void onFailure(Call<LastFMArtist> call, Throwable throwable) {
                //Request failed
            }
        })
        .build(); //Create and send the request
```

###Fetching album info
```java
request
    .requestAlbum()    //Returns a new AlbumTask for fetching info about an artist
    .withQuery("Cher", "Believe")    //The albums artist and name
    .setCallback(new Callback<LastFMAlbum>() {    //Lets you do something with the result
            @Override
            public void onResponse(Call<LastFMAlbum> call, Response<LastFMAlbum> response) {
                if(response.isSuccessful()) {
                    LastFMAlbum albumInfo = response.body().getArtist() //Returns a java class with the album info
                    //Response successful, do what you want with the result here
                }
            }

            @Override
            public void onFailure(Call<LastFMAlbum> call, Throwable throwable) {
                //Request failed
            }
        })
        .build(); //Create and send the request
```

###Setting a custom client
You can choose to use your own OkHttpClient by passing it to your LastFMRequest class with:
```java
.setCustomClient(client);
```


More coming later
