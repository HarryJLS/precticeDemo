package com.example.springbootdemo.designpatterns.responsiblity;

/**
 * @author JLS
 * @description: 责任链模式
 * @since 2023-05-14 15:15
 */
public class responsibilityTest {
    public static void main(String[] args) {

        Request request = new Request.RequestBuilder().frequentOk(true).build();

    }
}

class Request {
    private Boolean loggedOn;
    private Boolean frequentOk;
    private Boolean isPermits;
    private Boolean containsSensitiveWords;
    private String requestBody;

    public Request(Boolean loggedOn, Boolean frequentOk, Boolean isPermits, Boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
        this.requestBody = requestBody;
    }

    static class RequestBuilder {
        private Boolean loggedOn;
        private Boolean frequentOk;
        private Boolean isPermits;
        private Boolean containsSensitiveWords;

        RequestBuilder loggedOn(Boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        RequestBuilder frequentOk(Boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermits(Boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder containsSensitiveWords(Boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build() {
            Request request = new Request(loggedOn, frequentOk, isPermits, containsSensitiveWords);
            return request;
        }
    }

    public Boolean isLoggedOn() {
        return loggedOn;
    }

    public Boolean isFrequentOk() {
        return frequentOk;
    }

    public Boolean isPermits() {
        return isPermits;
    }

    public Boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}

abstract class Handler {
    Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler(Handler next) {
        this.next = next;
    }

    abstract Boolean process(Request request);
}

class RequestFrewquentHandler extends Handler {

    public RequestFrewquentHandler(Handler next) {
        super(next);
    }

    @Override
    Boolean process(Request request) {
        System.out.println("访问频率控制");
        if (request.isFrequentOk()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
