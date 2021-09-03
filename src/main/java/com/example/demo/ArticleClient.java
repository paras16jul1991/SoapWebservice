package com.example.demo;

import com.example.demo.model.GetArticleRequest;
import com.example.demo.model.GetArticleResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ArticleClient extends WebServiceGatewaySupport {

    public GetArticleResponse getArticle(int id) {
        GetArticleRequest getArticleRequest = new GetArticleRequest();
        getArticleRequest.setId(id);
        return (GetArticleResponse) getWebServiceTemplate().marshalSendAndReceive(getArticleRequest);
    }
}