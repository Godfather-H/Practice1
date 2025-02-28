package com.itheima;

import com.itheima.mapper.UserMapper;

import com.itheima.pojo.User;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest{
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertAll() {
        Random rand = new Random();
        //List<User> users = new ArrayList<User>();
        //姓名

        String familyName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅卞齐康伍余元卜顾孟平"
                + "黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计成戴宋茅庞熊纪舒屈项祝董粱杜阮席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田胡凌霍万柯卢莫房缪干解应宗丁宣邓郁单杭洪包诸左石崔吉"
                + "龚程邢滑裴陆荣翁荀羊甄家封芮储靳邴松井富乌焦巴弓牧隗山谷车侯伊宁仇祖武符刘景詹束龙叶幸司韶黎乔苍双闻莘劳逄姬冉宰桂牛寿通边燕冀尚农温庄晏瞿茹习鱼容向古戈终居衡步都耿满弘国文东殴沃曾关红游盖益桓公晋楚闫";
        int familyNameLength = familyName.length();
        String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
        int girlNameLength = girlName.length();
        String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int boyNameLength = boyName.length();

        String[] degrees = {"高中", "大专", "本科", "硕士", "博士"};

        String[] jobs = {"程序员", "设计师", "教师", "医生", "建筑师", "律师", "记者", "工程师", "市场营销", "人力资源", "项目经理"};

        String[] areas = {"河北", "山西", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "台湾"};

        String[] hobbies = {"健身", "游戏", "音乐", "跳舞", "摄影", "读书", "旅行", "绘画", "书法"};
        for (int i = 0; i < 100000; i++) {
            String name;
            String sex;
            String height;
            String weight;
            //设置姓名、性别、身高、体重
            int randomSex = rand.nextInt(2);
            char[] nm = new char[3];
            if (randomSex == 0) {
                nm[0] = familyName.charAt(rand.nextInt(familyNameLength));
                nm[1] = girlName.charAt(rand.nextInt(girlNameLength));
                nm[2] = girlName.charAt(rand.nextInt(girlNameLength));
                name = String.valueOf(nm);
                sex = "女";
                float randInstance = rand.nextInt(25);
                float randHeight = (float) (1.6 + randInstance / 100);
                BigDecimal bd = new BigDecimal(randHeight);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                height = bd.toString();
                weight = String.valueOf(rand.nextInt(50) + 45);
            } else {
                nm[0] = familyName.charAt(rand.nextInt(familyNameLength));
                nm[1] = boyName.charAt(rand.nextInt(boyNameLength));
                nm[2] = boyName.charAt(rand.nextInt(boyNameLength));
                name = String.valueOf(nm);
                sex = "男";
                float randInstance = rand.nextInt(20);
                float randHeight = (float) (1.7 + randInstance / 100);
                BigDecimal bd = new BigDecimal(randHeight);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                height = bd.toString();
                weight = String.valueOf(rand.nextInt(50) + 50);
            }

            //设置年龄
            int age = rand.nextInt(30) + 20;

            //设置学历
            String degree = degrees[rand.nextInt(degrees.length)];

            //设置职业
            String job = jobs[rand.nextInt(jobs.length)];

            //设置地区
            String area = areas[rand.nextInt(areas.length)];

            //设置收入
            int income = rand.nextInt(10000) + 3000;

            //设置爱好
            String hobby = hobbies[rand.nextInt(hobbies.length)];

            User user = new User(name, age, sex, height, weight, degree, job, area, income, hobby);

            userMapper.insertUser(user);
        }
    }
}
