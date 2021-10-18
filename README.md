# dark-mode-sample

## Dark-mode sample app with MVVM architecutre
Dark-mode starts from android Q ( API 29, Android 10 )
In android Q phones, we can change the system UI in the setting.
_( Setting > Display > Theme > Dark Theme )_
With the system UI, Apps also can know the MODE of the system and can also set their app setting mode.

In style, Theme.xml, there are two main types of Theme : 
- Light for ``` “ Theme.AppCompat.Light” or “Theme.MaterialComponents.Light” ```
- Dark for ```“Theme.AppCompat.DayNight” or “Theme.MaterialComponents.DayNight”```

So, the child item of the parent Theme will change. But we can make the color and icon of our app change. We must make values-directory: values-night and drawables-night to change color and icon.

There are four options about DarkMode that users can choose.
- Light Theme
- Dark Theme
- Set by Battery Saver 
- System default ( recommended and default option of Android Q )

But we should let the users choose just 3, battery saver mode should not be included in user choice.

We can change App Dark Mode dynamically with AppCompatDelegate.setDefaultNightMode(..)
```
1. AppCompatDelegate.MODE_NIGHT_NO 			( Light Mode )
2. AppCompatDelegate.MODE_NIGHT_YES 		( Night Mode )
3. AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM 	( same with System Ui )
4. AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY 	( Battery Saver Mode )
```


### Adding Dark Theme ( Quick change by android 10 )
Start from Android 10, compileSdkVersion and targetSdkVersion to 29, Force Dark can be applied to our application.
```“forceDarkAllowed”: boolean.```
This can be applied to the Theme of the whole app and the Theme for each activity. By this attribute, the corresponding app or activity changes to Dark-theme quickly. This attribute only works on Android 10+ and can’t have control over the dark theme in detail ( like image rendering )

### Adding dark Theme ( Custom Theme )
_“Daylight”_ is the theme that we can customize the dark theme. We have to use specific res files like values-night.  If we make a project with targetSdkVersion to29+, res for dark mode add include by IDE. If not switch to Project _View>Android Resource Directory>Night_.
In values-night file, we add our custom color by creating new ```colors-night``` dir, a new ```drawable-night``` folder for icon.

### For dark-mode, we need to know the material color design guidline
Read this article for this : https://material.io/design/color/color-usage.html#hierarchy

## Tech usage

- Hilt ( for dependency Injection )
 ``` 
    def hilt_version = '2.36'
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version" 
```
- Datasource ( to store the flag of user choice mode )
 ``` 
    def datastore_v = '1.0.0'
    implementation "androidx.datastore:datastore-preferences:$datastore_v"
```

### You can read the detail in this article : https://medium.com/@kyawlinnthantkyawlinnthant/android-dark-theme-in-the-easiest-way-e82806c7331c

