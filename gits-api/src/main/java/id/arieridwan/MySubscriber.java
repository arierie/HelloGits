package id.arieridwan;

import rx.Subscriber;

/**
 * Created by arieridwan on 24/01/2017.
 */

public abstract class MySubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onError(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        onNextAndCompleted(t);
    }

    public abstract void onError(String errorMessage);

    public abstract void onNextAndCompleted(T t);
}
