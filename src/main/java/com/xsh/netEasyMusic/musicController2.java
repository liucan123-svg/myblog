package com.xsh.netEasyMusic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
public class musicController2 {

    @RequestMapping("getMusicList3")
    public String getMusicList1(@RequestParam("id")String id, Model model) throws Exception {
        RestTemplate restTemplate=new RestTemplate();
        String result = restTemplate.getForObject("http://neteasymusic.xiongsihao.com/playlist/detail?id="+id,String.class);
        JSONObject jsonObject = new JSONObject(result);
        JSONArray jsonArray = jsonObject.getJSONObject("playlist").getJSONArray("tracks");
        List<NetEasyMusicResult> netEasyMusicResults=new ArrayList<>();
        String urlResult=null;
        String lyricResult=null;
        for(int i=0; i< jsonArray.length(); i++){
            NetEasyMusicResult netEasyMusicResult=new NetEasyMusicResult();
            JSONObject song = (JSONObject)jsonArray.get(i);
            netEasyMusicResult.setTitle(song.getString("name"));
            JSONObject ar = (JSONObject) song.getJSONArray("ar").get(0);
            netEasyMusicResult.setAuthor(ar.getString("name"));
            netEasyMusicResult.setPic(song.getJSONObject("al").getString("picUrl")+"?param=240y240");

            //获取歌曲url
            urlResult=restTemplate.getForObject("http://neteasymusic.xiongsihao.com/song/url?id="+song.getInt("id"),String.class);
            JSONObject jsonObject2 = new JSONObject(urlResult);
            JSONObject songUrl = (JSONObject) jsonObject2.getJSONArray("data").get(0);
            //部分歌曲可能无版权或已下架，特殊处理
            if(urlResult.contains(".mp3")){
                netEasyMusicResult.setUrl(songUrl.getString("url"));
            }else{
               continue;
            }
            //获取歌词
            lyricResult=restTemplate.getForObject("http://neteasymusic.xiongsihao.com/lyric?id="+song.getInt("id"),String.class);
            JSONObject jsonObject3 = new JSONObject(lyricResult);
            if(lyricResult.contains("lrc")){
                netEasyMusicResult.setLrc(jsonObject3.getJSONObject("lrc").getString("lyric"));
            }else {
                netEasyMusicResult.setLrc("当前歌曲无歌词");
            }
            netEasyMusicResults.add(netEasyMusicResult);
        }
        model.addAttribute("result",netEasyMusicResults);
        return "musicList";
    }
}
