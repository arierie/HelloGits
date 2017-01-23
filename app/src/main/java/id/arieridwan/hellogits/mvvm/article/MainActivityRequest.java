package id.arieridwan.hellogits.mvvm.article;

import java.util.List;

import rx.Observable;

/**
 * Created by ASUS on 06/10/2016.
 */

public interface MainActivityRequest {

    Observable<HeadlineRespones> requestHeadlineRespones();

    class HeadlineRespones{
        List<Articles> mList;

        public List<Articles> getmList() {
            return mList;
        }

        public void setmList(List<Articles> mList) {
            this.mList = mList;
        }
    }

    class Articles{
        String judul;
        String img;

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
