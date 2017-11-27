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
  compile 'com.boswelja:lastfm-wrapper:0.8@aar'
}
```

## Usage
```java
LastFMRequest request = new LastFMRequest() // Create the request
                .setApiKey(context.getString(R.string.lastfm_api_key)) //REQUIRED Sets the API key
```

### Fetching artist info
```java
request
    .requestArtist()    //Returns a new ArtistTask for fetching info about an artist
    .withName("Cher")    //Name of the artist you want
    .setCallback(new Callback<LastFMArtist>() {    //Lets you do something with the result
            @Override
            public void onDataRetrieved(LastFMArtist data) {
                //Response successful, do what you want with the result here
            }

            @Override
            public void onFailed(Throwable throwable) {
                //Request failed
            }
            
            @Override
            public void onResultEmpty() {
              //No artist by that name found
            }
        })
        .build(); //Create and send the request
```

### Fetching album info
```java
request
    .requestAlbum()    //Returns a new AlbumTask for fetching info about an artist
    .withQuery("Cher", "Believe")    //The albums artist and name
    .setCallback(new Callback<LastFMAlbum>() {    //Lets you do something with the result
            @Override
            public void onDataRetrieved(LastFMAlbum data) {
                //Response successful, do what you want with the result here
            }

            @Override
            public void onFailed(Throwable throwable) {
                //Request failed
            }
            
            @Override
            public void onResultEmpty() {
                //No album by that name found
            }
        })
        .build(); //Create and send the request
```

### Setting a custom client
You can choose to use your own OkHttpClient by passing it to your LastFMRequest class with:
```java
.setCustomClient(client);
```

More coming later