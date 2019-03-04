package com.liushiyu.developer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liushiyu.developer.DeveloperModelManager;
import com.liushiyu.developer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeveloperLogTestActivity extends AppCompatActivity {

    private String TAG = "DeveloperLogTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test_page);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.logNormalButton)
    public void logNormalButtonClick() {
        DeveloperModelManager.setLog(TAG, "{\n" +
                "\t\"code\": 99990200,\n" +
                "\t\"message\": \"Success\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"total\": 15,\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"contentId\": \"278943997593518080\",\n" +
                "\t\t\t\"name\": \"龙猫\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2540924496.jpg\",\n" +
                "\t\t\t\"des\": \"小月的母亲生病住院了，父亲带着她与四岁的妹妹小梅到乡间的居住。她们对那里的环境都感到十分新奇，也发现了很多有趣的事情。她们遇到了很多小精灵，她们来到属于她们的环境中，看到了她们世界中很多的奇怪事物，更与一只大大胖胖的龙猫成为了朋友。龙猫与小精灵们利用他们的神奇力量，为小月与妹妹带来了很多神奇的景观，令她们大开眼界。\\n妹妹小梅常常挂念生病中的母亲，嚷着要姐姐带着她去看母亲，但小月拒绝了。小梅竟然自己前往，不料途中迷路了，小月只好寻找她的龙猫及小精灵朋友们帮助。©豆瓣\",\n" +
                "\t\t\t\"score\": \"9.2\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278943756764971008\",\n" +
                "\t\t\t\"name\": \"前任3：再见前任\",\n" +
                "\t\t\t\"posterUrl\": \"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg\",\n" +
                "\t\t\t\"des\": \"一对好基友孟云（韩庚 饰）和余飞（郑恺 饰）跟女友都因为一点小事宣告分手，并且“拒绝挽回，死不认错”。两人在夜店、派对与交友软件上放飞人生第二春，大肆庆祝“黄金单身期”，从而引发了一系列好笑的故事。孟云与女友同甘共苦却难逃“五年之痒”，余飞与女友则棋逢敌手相爱相杀无绝期。然而现实的“打脸”却来得猝不及防：一对推拉纠结零往来，一对纠缠互怼全交代。两对恋人都将面对最终的选择：是再次相见？还是再也不见？\",\n" +
                "\t\t\t\"score\": \"5.5\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278943544956813312\",\n" +
                "\t\t\t\"name\": \"情圣\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2409022364.jpg\",\n" +
                "\t\t\t\"des\": \"肖瀚（肖央 饰）和妻子沈红（代乐乐 饰）结婚多年，感情早已经归于平淡，在两人漫长的婚姻生活中，肖瀚一直保持着对妻子的忠诚，直到某日，一位名叫yoyo（李成敏 饰）的美丽女子出现在了肖瀚的身边，令肖瀚再也无法忽略内心里的悸动，他决定正视自己的感情，不再受道德和舆论的约束，大胆追求自己真正渴望的爱情。\\n为了成功抱得美人归，肖瀚找到了好友艾木（艾伦 饰）、汤怀（乔杉 饰）和刘磊（小沈阳 饰）等人，几人策划了一个看似万无一失的计谋，胜利的果实势在必得。哪知道在执行计划的过程中，肖瀚的老板玛丽莲（闫妮 饰）几度搅局，闹出了一堆的笑料，不仅如此，敏感的沈红亦预感到丈夫正在“搞事情”。©豆瓣\",\n" +
                "\t\t\t\"score\": \"6.0\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278943282510823424\",\n" +
                "\t\t\t\"name\": \"全城戒备\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p564146105.jpg\",\n" +
                "\t\t\t\"des\": \"奇艺坊马戏团在马来西亚巡回演出，团员们偶然听说二战时期日本人留下的宝藏的消息。在飞刀高手张大初（邹兆龙 饰）的带领下，他们一行五人杀害寻宝者，一心想成为飞刀行家的小人物桑尼（郭富城 饰）尾随前来，亲眼目睹大初一众行凶全过程。他被迫随众人下洞，却无意开启日军留下的生化武器。经过一番难以想象的艰苦磨难，桑尼侥幸逃生，却变成奇怪的摸样。\\n与此同时，香港接连发生数起抢劫案。行凶者赤手空拳，手段残忍，他们正是受毒气感染发生变异的张大初等人。这一连串事件震惊全港，警方从内地请来个中高手孙皓（吴京 饰）与程秀华（张静初 饰）协助调查。而桑尼也摇身一变成为与邪恶对抗的正义使者……©豆瓣\",\n" +
                "\t\t\t\"score\": \"4.4\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278943088880779264\",\n" +
                "\t\t\t\"name\": \"四大名捕大结局\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2194662832.jpg\",\n" +
                "\t\t\t\"des\": \"杀害捕神的女杀手在姬摇花（江一燕 饰）的协助下， 利用易容术从六扇门的大牢中逃脱。宋徽宗（苏有朋 饰）为此震怒不已，命令六扇门尽快将其捉拿归案。冷血（邓超 饰）无法坐视不管，执意回到六扇门追查真相，在他的眼中摇花的秘密似乎昭然若揭。与此同时，适逢重阳庙会，宋徽宗以体察民情为名执意微服出巡，群臣劝诫无数，眼睁睁看着皇上出宫，最终宋徽宗突然消失，下落不明。在此期间，冷血遇到了此前决然离去的无情（刘亦菲 饰），两人的关系跌至冰点。为了找到皇帝的下落，冷血和铁手（邹兆龙 饰）、追命（郑中基 饰）相继出动，一连串的纷争搏杀再起……\\n本片根据温瑞安同名武侠小说改编。©豆瓣\",\n" +
                "\t\t\t\"score\": \"4.8\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278942867882901504\",\n" +
                "\t\t\t\"name\": \"无名之辈\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2539661066.jpg\",\n" +
                "\t\t\t\"des\": \"来自乡村的笨贼眼镜（章宇 饰）和大头（潘斌龙 饰）抢了一家手机店，慌乱之中逃进坐着轮椅的单身女子嘉旗（任素汐 饰）的家中。嘉旗早已失去活着的欲望，她强横地要求俩笨贼杀死自己。另一边，某楼盘老板资金链断裂跑路，留下保安马先勇（陈建斌 饰）与讨债者周旋。马曾经是立功无数的协警，可就在转正的关头因为一场车祸毁了原本看似美好的一切。不久前他挖到一把喷子，原本打算交给当初的警察好友立功，却发现喷子被换成了水枪。而成为了新闻的手机抢劫案，让马先勇意识到喷子正在劫匪的手上。\\n漫长的一天，所有与之相关的老老少少都在纠结煎熬。他们是渺小的无名之辈，却真真切切感受到来自命运的重压……©豆瓣\",\n" +
                "\t\t\t\"score\": \"8.1\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278942637519142912\",\n" +
                "\t\t\t\"name\": \"无双\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2535260806.jpg\",\n" +
                "\t\t\t\"des\": \"身陷囹圄的李问（郭富城 饰）被引渡回港，他原本隶属于一个的跨国假钞制贩组织。该组织曾犯下过多宗恶性案件，而首脑“画家”不仅始终逍遥法外，连真面目都没人知道。为了逼迫李问吐露“画家”真实身份，警方不惜用足以判死刑的假罪证使其就范。就在此时，富有的遗孀阮文（张静初 饰）申请保释李问，而警方提出的条件依然是“画家”的真面目。\\n原来早在十数年前，李问和阮文是一对画家情侣，无奈女友的作品受人青睐，李问的画作却被贬得一文不值。就在此困顿期间，他制作假画的才能被“画家”（周润发 饰）发掘，进而成为对方美元假币团伙中的一员……©豆瓣\",\n" +
                "\t\t\t\"score\": \"8.0\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278942514072387584\",\n" +
                "\t\t\t\"name\": \"西游记女儿国\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2511375626.jpg\",\n" +
                "\t\t\t\"des\": \"唐僧师徒途经忘川河，因激怒河神而误入西梁女界。闯入其中，众人才发现这个国家只有女性，并且建国以来此地就没来过男性。而且国中立有祖训，将男人视为天敌。典籍中更有预言，指明有朝一日，会有东土而来的僧人带着一只猴子、一头猪和一个小蓝人闯入其中。他们到来之日，便是女儿国走向毁灭之时。\",\n" +
                "\t\t\t\"score\": \"4.4\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278942169908772864\",\n" +
                "\t\t\t\"name\": \"夏洛特烦恼\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2264377763.jpg\",\n" +
                "\t\t\t\"des\": \"在学生时代的初恋秋雅（王智 饰）的婚礼上，毕业后吃软饭靠老婆养的夏洛（沈腾 饰）假充大款，出尽其丑，中间还被老婆马冬梅（马丽 饰）戳穿暴捶。混乱之中，夏洛意外穿越时空，回到了1997年的学生时代的课堂里。他懵懵懂懂，以为是场真实感极强的梦，于是痛揍王老师，强吻秋雅，还尝试跳楼让自己醒来。当受伤的他从病床上苏醒时，他意识到自己真的穿越了时空。既然有机会重新来过，那不如好好折腾一回。他勇敢追求秋雅、奚落优等生袁华（尹正 饰）、拒绝马冬梅的死缠烂打。后来夏洛凭借“创作”朴树、窦唯等人的成名曲而进入娱乐圈。\\n他的人生发生翻天覆地的巨变，但是内心某个地方却越来越感到空虚……©豆瓣\",\n" +
                "\t\t\t\"score\": \"7.5\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"contentId\": \"278937132625166336\",\n" +
                "\t\t\t\"name\": \"星际穿越\",\n" +
                "\t\t\t\"posterUrl\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2206088801.jpg\",\n" +
                "\t\t\t\"des\": \"近未来的地球黄沙遍野，小麦、秋葵等基础农作物相继因枯萎病灭绝，人类不再像从前那样仰望星空，放纵想象力和灵感的迸发，而是每日在沙尘暴的肆虐下倒数着所剩不多的光景。在家务农的前NASA宇航员库珀（马修·麦康纳 Matthew McConaughey 饰）接连在女儿墨菲（麦肯吉·弗依 Mackenzie Foy 饰）的书房发现奇怪的重力场现象，随即得知在某个未知区域内前NASA成员仍秘密进行一个拯救人类的计划。多年以前土星附近出现神秘虫洞，NASA借机将数名宇航员派遣到遥远的星系寻找适合居住的星球。在布兰德教授（迈克尔·凯恩 Michael Caine 饰）的劝说下，库珀忍痛告别了女儿，和其他三名专家教授女儿艾米莉亚·布兰德（安妮·海瑟薇 Anne Hathaway 饰）、罗米利（大卫·吉雅西 David Gyasi 饰）、多伊尔（韦斯·本特利 Wes Bentley 饰）搭乘宇宙飞船前往目前已知的最有希望的三颗星球考察。\\n他们穿越遥远的星系银河，感受了一小时七年光阴的沧海桑田，窥见了未知星球和黑洞的壮伟与神秘。在浩瀚宇宙的绝望而孤独角落，总有一份超越了时空的笃定情怀将他们紧紧相连……©豆瓣\",\n" +
                "\t\t\t\"score\": \"9.2\"\n" +
                "\t\t}],\n" +
                "\t\t\"page_num\": 0\n" +
                "\t}\n" +
                "}");
//        DeveloperModelManager.setNormalLog(TAG, "我是内容我是内容。。我是内容 " + DATE_FORMAT_YMD.format(new Date()));
    }

    @OnClick(R.id.logWarnButton)
    public void logWarnButtonClick() {
        DeveloperModelManager.setWarnLog(TAG, "我是内容我是内容。。我是内容");
    }

    @OnClick(R.id.logErrorButton)
    public void logErrorButtonClick() {
        DeveloperModelManager.setErrorLog(TAG, "我是内容我是内容。。我是内容");
    }
}
