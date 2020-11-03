package com.xsh.netEasyMusic;


public class NetEasyMusicResult {

    private String title;//歌曲名
    private String author;//歌手名字
    private String url;//歌曲播放链接
    private String pic;//歌曲图
    private String lrc;//歌词

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    @Override
    public String toString() {
        return "netEasyMusicResult{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", pic='" + pic + '\'' +
                ", lrc='" + lrc + '\'' +
                '}';
    }
}
