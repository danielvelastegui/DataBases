package com.danielvelastegui.deberpetagram.restApi;

public final class ConstantesRestApi {
    public static final String ROOT_URL = "https://graph.instagram.com/";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String ACCESS_TOKEN = "IGQVJYR0Jfa3J4amEyQXYtbm9oYVl6dlc5ZATlUN1pLekdXcVNCMlgwbzlIc0ZAFYk1kdlVBN3NTSV94N0xmLXVSRVNNNFh5bXdjVGU0XzUtWXRYOTI1VDhGZAktrc1JRRUhTNy1ENWRB";
    public static final String KEY_GET_MEDIA_USER = "me/media?fields=media_url,username";
    public static final String URL_GET_MEDIA_USER = KEY_GET_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}
