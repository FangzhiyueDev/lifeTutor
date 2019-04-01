package com.xiaofangfang.lifetatuor.Activity.fragment.newsFragment.parent;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.xiaofangfang.lifetatuor.dao.DbOpener;
import com.xiaofangfang.lifetatuor.net.NewsRequest;
import com.xiaofangfang.lifetatuor.set.SettingStandard;
import com.xiaofangfang.lifetatuor.tools.Looger;
import com.xiaofangfang.lifetatuor.tools.UiThread;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ParentFragment extends Fragment {


    protected String response;

    /**
     * 这个方法是一个空实现,子类对其进行继承,实现自己的封装方法
     *
     * @param responseData
     */
    protected void progressResult(String responseData) {
        Looger.d("调用的是父类的方法");
    }


    /**
     * 检查我们是否需要进行网络的链接进行更新数据
     * 该方法运行在子线程中
     */
    protected void checkUpdate(String className,
                               SettingStandard.News.NewsType type) {
        String response = DbOpener.readInfo(getContext(), className);
        if (response != null && (!"".equals(response))) {
            // 如果存在数据就去取出数据
            Looger.d("存在当前的数据" + response);
            progressResult(response);

        } else {
            Looger.d("不存在文件,我们开始进行网络请求");
            // requestData(type);
            //这里使用本地数据来测试,减少网络访问
            progressResult(data);
        }

    }

    protected void requestData(SettingStandard.News.NewsType type) {

        NewsRequest.getNewsInfo(type, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                UiThread.getUiThread(getContext()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "请求信息失败,请稍后再试",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                //将数据存放到全局
                Looger.d("请求的数据" + responseData);
                progressResult(responseData);
            }
        });
    }

    private static String data = "{\"result\":{\"data\":[{\"uniquekey\":\"4d5388d59cd4d8385e5eeef178b277ef\",\"title\":\"万圣节将至，世界各地民众趁着周末提早庆祝\",\"date\":\"2018-10-29 21:36\",\"category\":\"国际\",\"author_name\":\"默默看国际\",\"url\":\"http://mini.eastday.com/mobile/181029213615059.html\",\"thumbnail_pic_s\":\"http://00imgmini.eastday.com/mobile/20181029/20181029_8c227f360f45d48a0eb716e63710a2b8_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://00imgmini.eastday.com/mobile/20181029/20181029_d89b6c590664a78e87e4d8bce609dcd3_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://00imgmini.eastday.com/mobile/20181029/20181029_00d649b1de6acdb9e3926f756f8db339_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"dc2868f7cc6c7a76ac1bc7f37e48caaf\",\"title\":\"中白政府间合作委员会第三次会议将举行\",\"date\":\"2018-10-29 21:35\",\"category\":\"国际\",\"author_name\":\"中国新闻网\",\"url\":\"http://mini.eastday.com/mobile/181029213528192.html\",\"thumbnail_pic_s\":\"http://01imgmini.eastday.com/mobile/20181029/20181029213528_41d440d81b478bcaf446c0aa565dbe2f_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"667909594e38b738844265201a48c351\",\"title\":\"澳中关系研究院发布报告指出 澳大利亚应积极与中国对话\",\"date\":\"2018-10-29 21:35\",\"category\":\"国际\",\"author_name\":\"国际在线\",\"url\":\"http://mini.eastday.com/mobile/181029213518993.html\",\"thumbnail_pic_s\":\"http://09imgmini.eastday.com/mobile/20181029/20181029213518_73754c4755408b02c82e692d9a280954_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"702e8d497dbfa2f9f843b7cfa7b3df16\",\"title\":\"齐白石百余件作品在日本展出\",\"date\":\"2018-10-29 21:32\",\"category\":\"国际\",\"author_name\":\"新华社\",\"url\":\"http://mini.eastday.com/mobile/181029213223335.html\",\"thumbnail_pic_s\":\"http://03imgmini.eastday.com/mobile/20181029/20181029213223_697a14c9a7d300fa6e9d5d13fdf9c827_5_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://03imgmini.eastday.com/mobile/20181029/20181029213223_697a14c9a7d300fa6e9d5d13fdf9c827_2_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://03imgmini.eastday.com/mobile/20181029/20181029213223_697a14c9a7d300fa6e9d5d13fdf9c827_1_mwpm_03200403.jpg\"},{\"uniquekey\":\"869d18b69fd8f9faf0a8cbc29491a7d9\",\"title\":\"VANS国际女子圆桌会谈，让更多女性从滑板中找到自信！\",\"date\":\"2018-10-29 21:31\",\"category\":\"国际\",\"author_name\":\"HERO\",\"url\":\"http://mini.eastday.com/mobile/181029213147825.html\",\"thumbnail_pic_s\":\"http://09imgmini.eastday.com/mobile/20181029/20181029213147_793b5e6a5e073276184e0bbbc89a6567_7_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://09imgmini.eastday.com/mobile/20181029/20181029213147_793b5e6a5e073276184e0bbbc89a6567_9_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://09imgmini.eastday.com/mobile/20181029/20181029213147_793b5e6a5e073276184e0bbbc89a6567_6_mwpm_03200403.jpg\"},{\"uniquekey\":\"c657c5c402c72b96847c9aa625dc2613\",\"title\":\"印尼客机坠海 189人全部遇难 更多细节曝光\",\"date\":\"2018-10-29 21:27\",\"category\":\"国际\",\"author_name\":\"央视网\",\"url\":\"http://mini.eastday.com/mobile/181029212758412.html\",\"thumbnail_pic_s\":\"http://02imgmini.eastday.com/mobile/20181029/20181029212758_4608391d43638dd32d8a889c3d37a961_7_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://02imgmini.eastday.com/mobile/20181029/20181029212758_4608391d43638dd32d8a889c3d37a961_5_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://02imgmini.eastday.com/mobile/20181029/20181029212758_4608391d43638dd32d8a889c3d37a961_1_mwpm_03200403.jpg\"},{\"uniquekey\":\"11c9f40ad4f76286d5fd33150924c6ae\",\"title\":\"安德鲁王子非常正式地点头表示欢迎杰克加入他的家族\",\"date\":\"2018-10-29 21:27\",\"category\":\"国际\",\"author_name\":\"海比阿特丽丝\",\"url\":\"http://mini.eastday.com/mobile/181029212748789.html\",\"thumbnail_pic_s\":\"http://07imgmini.eastday.com/mobile/20181029/20181029_6ad150924e1eb433b719e490333d05a7_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://07imgmini.eastday.com/mobile/20181029/20181029_726c97e7941438957502974a04cfe923_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":null},{\"uniquekey\":\"811a7b86ce68c072029f049eab5b38b1\",\"title\":\"金卡戴珊曝光豪宅，简单至极近乎“寒酸”，纯白色几乎看不到家具\",\"date\":\"2018-10-29 21:26\",\"category\":\"国际\",\"author_name\":\"献媚邀宠的月季\",\"url\":\"http://mini.eastday.com/mobile/181029212600763.html\",\"thumbnail_pic_s\":\"http://03imgmini.eastday.com/mobile/20181029/20181029212600_c189c4401b0bc4acbd5cdfcfcd3176a8_6_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://03imgmini.eastday.com/mobile/20181029/20181029212600_c189c4401b0bc4acbd5cdfcfcd3176a8_3_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://03imgmini.eastday.com/mobile/20181029/20181029212600_c189c4401b0bc4acbd5cdfcfcd3176a8_1_mwpm_03200403.jpg\"},{\"uniquekey\":\"edd56a8986127fa0abc66ac246c6aefc\",\"title\":\"看了这些图片，你能相信这里也是非洲吗\",\"date\":\"2018-10-29 21:24\",\"category\":\"国际\",\"author_name\":\"地球趣谈\",\"url\":\"http://mini.eastday.com/mobile/181029212404437.html\",\"thumbnail_pic_s\":\"http://04imgmini.eastday.com/mobile/20181029/20181029212404_7063abf99bc4e3b7c07b24aa27945b81_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://04imgmini.eastday.com/mobile/20181029/20181029212404_7063abf99bc4e3b7c07b24aa27945b81_5_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://04imgmini.eastday.com/mobile/20181029/20181029212404_7063abf99bc4e3b7c07b24aa27945b81_4_mwpm_03200403.jpg\"},{\"uniquekey\":\"e55ec0155154eeb2542baca44a7408d7\",\"title\":\"中俄跨境网购：俄罗斯人买服装家电 中国人主要买食品\",\"date\":\"2018-10-29 21:21\",\"category\":\"国际\",\"author_name\":\"环球时报\",\"url\":\"http://mini.eastday.com/mobile/181029212120466.html\",\"thumbnail_pic_s\":\"http://04imgmini.eastday.com/mobile/20181029/20181029212120_f1b9e2dbddef07c81a874e2ceeb5fe70_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://04imgmini.eastday.com/mobile/20181029/20181029212120_f1b9e2dbddef07c81a874e2ceeb5fe70_3_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://04imgmini.eastday.com/mobile/20181029/20181029212120_f1b9e2dbddef07c81a874e2ceeb5fe70_2_mwpm_03200403.jpg\"},{\"uniquekey\":\"78617827f79a3ed9f9f98c5a57eed398\",\"title\":\"快讯！德国总理默克尔将于2021年卸任\",\"date\":\"2018-10-29 21:18\",\"category\":\"国际\",\"author_name\":\"环球网\",\"url\":\"http://mini.eastday.com/mobile/181029211859192.html\",\"thumbnail_pic_s\":\"http://05imgmini.eastday.com/mobile/20181029/20181029211859_77a1831500447ed9b2086c06bb450159_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"5f8c3fa88e8cbd0878b6d5931d2946a0\",\"title\":\"波音737飞机在雅加达海域坠毁  \u200B\",\"date\":\"2018-10-29 21:16\",\"category\":\"国际\",\"author_name\":\"苍穹视界\",\"url\":\"http://mini.eastday.com/mobile/181029211636343.html\",\"thumbnail_pic_s\":\"http://04imgmini.eastday.com/mobile/20181029/20181029_05b5aba406293d268300d97debfc6212_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://04imgmini.eastday.com/mobile/20181029/20181029_628491253f4d9014593056d0d2b7189c_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://04imgmini.eastday.com/mobile/20181029/20181029_452d772c260605f48cba722f044bbf5d_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"d668141cc3727f01b2883da089d2288d\",\"title\":\"印尼失事客机坠毁前曾急速下降 机长惊呼“救命”\",\"date\":\"2018-10-29 21:15\",\"category\":\"国际\",\"author_name\":\"海外网\",\"url\":\"http://mini.eastday.com/mobile/181029211509498.html\",\"thumbnail_pic_s\":\"http://02imgmini.eastday.com/mobile/20181029/20181029211509_d22f818fce00128bcc609c8c207d2661_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://02imgmini.eastday.com/mobile/20181029/20181029211509_d22f818fce00128bcc609c8c207d2661_2_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":null},{\"uniquekey\":\"77209ab0107e0b46ef2f1e3887f0f2b3\",\"title\":\"王毅同菲律宾新任外长洛钦会谈\",\"date\":\"2018-10-29 21:14\",\"category\":\"国际\",\"author_name\":\"国际在线\",\"url\":\"http://mini.eastday.com/mobile/181029211446659.html\",\"thumbnail_pic_s\":\"http://09imgmini.eastday.com/mobile/20181029/20181029211446_c29d68728d85acf7bae09ba27924dfc8_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://09imgmini.eastday.com/mobile/20181029/20181029211446_c29d68728d85acf7bae09ba27924dfc8_2_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":null},{\"uniquekey\":\"4cc1c06d3f33c36346821f12aea4296c\",\"title\":\"德国城市见闻，奔驰满街跑，这才是真正的国民车\",\"date\":\"2018-10-29 21:14\",\"category\":\"国际\",\"author_name\":\"透透世道\",\"url\":\"http://mini.eastday.com/mobile/181029211435505.html\",\"thumbnail_pic_s\":\"http://01imgmini.eastday.com/mobile/20181029/20181029_71a5dcf21195b7a00d123c2fc5d15246_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://01imgmini.eastday.com/mobile/20181029/20181029_0bcb3ad15b997bbae6b9bba59b6be1e9_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://01imgmini.eastday.com/mobile/20181029/20181029_b502a60aa4ff2ce031b92f968f395d2e_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"34d49e6e1eda614748fc03be3b351c21\",\"title\":\"外交部就印尼客机坠毁、巴西总统大选等答问\",\"date\":\"2018-10-29 21:11\",\"category\":\"国际\",\"author_name\":\"中国网\",\"url\":\"http://mini.eastday.com/mobile/181029211108064.html\",\"thumbnail_pic_s\":\"http://01imgmini.eastday.com/mobile/20181029/20181029211108_c81bfebea63a2c9139ea434451f7435b_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"508eed63c35e88b017679a0c49e783ac\",\"title\":\"巴基斯坦总理伊姆兰·汗、俄罗斯总理梅德韦杰夫将访华\",\"date\":\"2018-10-29 21:11\",\"category\":\"国际\",\"author_name\":\"中国网\",\"url\":\"http://mini.eastday.com/mobile/181029211106267.html\",\"thumbnail_pic_s\":\"http://08imgmini.eastday.com/mobile/20181029/20181029211106_fda8376d43dbf66cc58e6ffab829a593_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"73abf0dbb1134349d3736e10ab5c0e64\",\"title\":\"国际社会相信进博会将推进多边合作\",\"date\":\"2018-10-29 21:05\",\"category\":\"国际\",\"author_name\":\"央视网\",\"url\":\"http://mini.eastday.com/mobile/181029210514962.html\",\"thumbnail_pic_s\":\"http://06imgmini.eastday.com/mobile/20181029/20181029210514_5d440c84a9df199a83a483b5bfa1c0cc_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"3dd462a04db8b39993647e760713f7dd\",\"title\":\"芬木日报｜柬埔寨成越南第3大木材来源国\",\"date\":\"2018-10-29 21:00\",\"category\":\"国际\",\"author_name\":\"芬木FinWood\",\"url\":\"http://mini.eastday.com/mobile/181029210010903.html\",\"thumbnail_pic_s\":\"http://08imgmini.eastday.com/mobile/20181029/20181029210010_cdba47474748217b33ab45673f73191c_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"6fc20eaf334cc81025c83932d84dd2f2\",\"title\":\"泰国男子劫大巴与警方对峙19小时，5颗催泪弹都没能将其赶下车\",\"date\":\"2018-10-29 21:00\",\"category\":\"国际\",\"author_name\":\"瘦马南风\",\"url\":\"http://mini.eastday.com/mobile/181029210000812.html\",\"thumbnail_pic_s\":\"http://09imgmini.eastday.com/mobile/20181029/20181029_237592a691ab89fa449b62c687786f9a_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://09imgmini.eastday.com/mobile/20181029/20181029_448472274d144573a3b0bf0e9f4dfb93_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://09imgmini.eastday.com/mobile/20181029/20181029_8d5b2f01caae860c9364737ac743334b_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"69883c715c2099d7b89f4e381537051f\",\"title\":\"美国创业公司开发“共享饮用水”App ：瓶装水公司都是抢劫\",\"date\":\"2018-10-29 20:58\",\"category\":\"国际\",\"author_name\":\"素白\",\"url\":\"http://mini.eastday.com/mobile/181029205856261.html\",\"thumbnail_pic_s\":\"http://07imgmini.eastday.com/mobile/20181029/20181029_0a213e63033e89caf6743d9c39d3e9b1_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"09c9a513898b187804b602520e9a1af4\",\"title\":\"诺贝尔经济学奖得主萨金特：我在中国也用支付宝微信，这些金融创新是独一无二的\",\"date\":\"2018-10-29 20:58\",\"category\":\"国际\",\"author_name\":\"东方网\",\"url\":\"http://mini.eastday.com/mobile/181029205827064.html\",\"thumbnail_pic_s\":\"http://00imgmini.eastday.com/mobile/20181029/20181029205827_e6ae097d8649c9bed728414c7b7af040_2_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://00imgmini.eastday.com/mobile/20181029/20181029205827_e6ae097d8649c9bed728414c7b7af040_1_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":null},{\"uniquekey\":\"90d708717304792aedc1d6610008ab93\",\"title\":\"蜜月旅行连机场都没出就被遣返 只因家中狗子咬掉护照一角\",\"date\":\"2018-10-29 20:58\",\"category\":\"国际\",\"author_name\":\"瘦马南风\",\"url\":\"http://mini.eastday.com/mobile/181029205802208.html\",\"thumbnail_pic_s\":\"http://07imgmini.eastday.com/mobile/20181029/20181029_9339690038ce91b5754ca48b0d0c814f_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://07imgmini.eastday.com/mobile/20181029/20181029_ac2a43414900aaecd9a630e160b0da15_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://07imgmini.eastday.com/mobile/20181029/20181029_ca7b87232a6784d103a3d55dd9ff93bc_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"b995ae703ce97067301516f339a49548\",\"title\":\"擦鞋三十年、美金二十万，美国古稀老人把下半生时光都献给了孩子\",\"date\":\"2018-10-29 20:55\",\"category\":\"国际\",\"author_name\":\"酒桶说三观\",\"url\":\"http://mini.eastday.com/mobile/181029205548033.html\",\"thumbnail_pic_s\":\"http://02imgmini.eastday.com/mobile/20181029/20181029_488116839824880533ac57b54ed93f8a_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://02imgmini.eastday.com/mobile/20181029/20181029_51aba87a8b9841aa75a37bc16742b83e_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://02imgmini.eastday.com/mobile/20181029/20181029_51155696950b4e53233c6862f40d7f7f_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"27d7d5e8e5681c129fc5fc46680b095b\",\"title\":\"俄罗斯土著大哥煮螃蟹就是这么简单粗放，馋得让人直流口水\",\"date\":\"2018-10-29 20:54\",\"category\":\"国际\",\"author_name\":\"刚刚开幕就要剧终\",\"url\":\"http://mini.eastday.com/mobile/181029205442835.html\",\"thumbnail_pic_s\":\"http://06imgmini.eastday.com/mobile/20181029/20181029205442_300db76532a8b6871bd343c3ed5b2a1e_7_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://06imgmini.eastday.com/mobile/20181029/20181029205442_300db76532a8b6871bd343c3ed5b2a1e_8_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://06imgmini.eastday.com/mobile/20181029/20181029205442_300db76532a8b6871bd343c3ed5b2a1e_10_mwpm_03200403.jpg\"},{\"uniquekey\":\"1646d6ee967042f41f8ca2c52449edad\",\"title\":\"经典系列作品欣赏 李察·约翰逊Richard Johnson\",\"date\":\"2018-10-29 20:53\",\"category\":\"国际\",\"author_name\":\"艺术研究\",\"url\":\"http://mini.eastday.com/mobile/181029205344337.html\",\"thumbnail_pic_s\":\"http://09imgmini.eastday.com/mobile/20181029/20181029205344_ea17ea2fc1df98a4846538d06c4b3bba_22_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://09imgmini.eastday.com/mobile/20181029/20181029205344_ea17ea2fc1df98a4846538d06c4b3bba_9_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://09imgmini.eastday.com/mobile/20181029/20181029205344_ea17ea2fc1df98a4846538d06c4b3bba_13_mwpm_03200403.jpg\"},{\"uniquekey\":\"6eb7d85978eee6a33c6b298ec1bf5834\",\"title\":\"印尼客机坠海：客机8月才启用，正副机长共1.1万小时飞行经验\",\"date\":\"2018-10-29 20:53\",\"category\":\"国际\",\"author_name\":\"鑫原\",\"url\":\"http://mini.eastday.com/mobile/181029205337314.html\",\"thumbnail_pic_s\":\"http://09imgmini.eastday.com/mobile/20181029/20181029_39d1070aee68c3cf77d65be00b571e26_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://09imgmini.eastday.com/mobile/20181029/20181029_8df2263ee5442349b1453d551f982208_cover_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://09imgmini.eastday.com/mobile/20181029/20181029_e67db99e96e4a2fc43d06aef1d878873_cover_mwpm_03200403.jpg\"},{\"uniquekey\":\"bff7e5bcbc3a3ce1e7ee4c2ad0fffa12\",\"title\":\"日本绚子公主今日大婚，缘分始于“长辈牵线”\",\"date\":\"2018-10-29 20:53\",\"category\":\"国际\",\"author_name\":\"光明网\",\"url\":\"http://mini.eastday.com/mobile/181029205337199.html\",\"thumbnail_pic_s\":\"http://07imgmini.eastday.com/mobile/20181029/20181029205337_123f57ffb6b89a909e5c6e635900cc2b_3_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://07imgmini.eastday.com/mobile/20181029/20181029205337_123f57ffb6b89a909e5c6e635900cc2b_1_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://07imgmini.eastday.com/mobile/20181029/20181029205337_123f57ffb6b89a909e5c6e635900cc2b_2_mwpm_03200403.jpg\"},{\"uniquekey\":\"5d0f84062509f8146688fec22bfd54b2\",\"title\":\"沙特检察官抵达伊斯坦布尔，将与土耳其检察官举行会谈\",\"date\":\"2018-10-29 20:52\",\"category\":\"国际\",\"author_name\":\"澎湃新闻网\",\"url\":\"http://mini.eastday.com/mobile/181029205223682.html\",\"thumbnail_pic_s\":\"http://02imgmini.eastday.com/mobile/20181029/20181029205223_3e62b0c0d4b03210f47bda4977ae10bf_1_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":null,\"thumbnail_pic_s03\":null},{\"uniquekey\":\"4f4362d144051da803e4de6f6680b9b4\",\"title\":\"荷兰铁路公司设计出更适合通勤时工作的车厢\",\"date\":\"2018-10-29 20:50\",\"category\":\"国际\",\"author_name\":\"cnBeta\",\"url\":\"http://mini.eastday.com/mobile/181029205037101.html\",\"thumbnail_pic_s\":\"http://00imgmini.eastday.com/mobile/20181029/20181029205037_a68ecdaea5f1f2e9f6eb82cba3144a24_2_mwpm_03200403.jpg\",\"thumbnail_pic_s02\":\"http://00imgmini.eastday.com/mobile/20181029/20181029205037_a68ecdaea5f1f2e9f6eb82cba3144a24_4_mwpm_03200403.jpg\",\"thumbnail_pic_s03\":\"http://00imgmini.eastday.com/mobile/20181029/20181029205037_a68ecdaea5f1f2e9f6eb82cba3144a24_1_mwpm_03200403.jpg\"}]},\"error_code\":0,\"reason\":\"Succes\"}";
}
