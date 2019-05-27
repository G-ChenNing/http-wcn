package com.github.wangchenning.httpwcn.http;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;


public interface HttpUrl {

    URI getUrl() throws URISyntaxException;

    URI getUrl(Map<String, Object> paramer) throws URISyntaxException;

    URI getUrl(Object onlyKey) throws URISyntaxException;
}
