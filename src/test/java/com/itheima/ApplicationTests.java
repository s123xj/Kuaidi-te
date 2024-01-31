package com.itheima;
import com.itheima.dao.dingdan;
import com.itheima.domin.*;
import com.itheima.service.Dinfrom;
import com.itheima.service.UpdateInfrom;
import com.itheima.service.UserInfom;
import com.itheima.service.login;
import com.itheima.utils.loginutils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private login lg;
    @Autowired
    private Dinfrom dg;
    @Autowired
    private UpdateInfrom ui;
    @Autowired
    private UserInfom uif;

    @Test
    void login() {
        User loginflg = lg.ulogin("张", "123");
        if (loginflg!=null){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
    @Test
    void glogin() {
        Guser loginflg =lg.glogin("15659731239","123");

        if (loginflg!=null){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    @Test
    void kSarch(){
        List<KUser> list=lg.kSearch();
        System.out.println(list);
    }
    @Test
    void deleteByid(){
        lg.deletebyid("2222223445");
    }
    @Test
    void addInfrom(){
        KUser ku=new KUser();
        ku.setPassward("3");
        ku.setRejuster(2);
        ku.setYname("3");
        ku.setTphnumber("3");
        ku.setZnumber("3");
        ku.setType(3);
        lg.addinfrom(ku);
    }

    @Test
    void register(){
        User user=new User();
        user.setPassword("123456");
        user.setUsername("牛2");
        user.setRegisterTime(LocalDateTime.now());
        User search = lg.search(user.getUsername());
//        System.out.println(search);
        if (search!=null){

            System.out.println("账号已存在");
        }else {
            lg.zhuce(user);
        }
//        System.out.println(search.equals(null));
//        if (!search.equals(null)){
//            System.out.println("账号已存在");
//        }else {
//            lg.zhuce(user);
//        }


    }
    @Test
    void SearchDingdan(){
        pageBean pagebean=dg.search(1,5,"","",1);
        System.out.println("总数==="+pagebean.getTotal());
//        dingDan dingDan = new dingDan();
//        StringBuilder s=new StringBuilder();
//        s.append(dingDan.getJCity()+dingDan.getJAddress());
//        System.out.println("拼接后的数据"+s);
//        System.out.println(pagebean);
    }
    @Test
    void  xiadan(){
        dingDan dDan=new dingDan();
        UUID uuid=UUID.randomUUID();
        String s=uuid.toString().replace("-","");
        int desirelength=10;
        String r=s.substring(0,desirelength);
        dDan.setDId(r);
        dDan.setJAddress("福建福州");
//        dDan.setJCity("福州");
//        dDan.setSCity("广州");
        dDan.setSDetailcity("广东广州");
        dDan.setSName("罗峰");
        dDan.setSNumber("15659731222");
        dDan.setJTime(LocalDateTime.now());
        dDan.setJPhnumber("123123123");
        dDan.setJName("龙皓晨");
        dDan.setWName("书本");
        dDan.setFType(1);
        dDan.setJInfrom("没啥备注");
        dDan.setSTatus(1);
        dDan.setNUmber(2);
        dDan.setWeight("20kg");
        dDan.setDType(2);
        dg.dingDan(dDan);
    }

    @Test
    void searchbyid(){
        List<dingDan> list=lg.searbyid("2222");
        System.out.println(list.get(0).getDId());
        boolean b=(list.get(0).getDId().equals("2222"));
        System.out.println(b);
        System.out.println(list);
    }

    @Test
    void searbytype(){

    }

    @Test
    void searbytype1(){
        List<dingDan> serchbytype = dg.serchbytype1(3,1);
        System.out.println(serchbytype);
    }

    @Test
    void paidan()
    {
//        dg.paidan(4);
        Boolean flage=false;
        if (!flage){
            System.out.println("对");
        }else {
            System.out.println("错");
        }
    }


    @Test
    void rpaidan(){
        dg.rpaidan(3);
    }


    @Test
    void ban(){dg.ban("2101130086");}

    @Test
    void chognzhi(){

        Boolean flag = ui.chongzhi("s123456", "2101133333");
        System.out.println(flag);
    }
    @Test
    void sebynu(){
        KUser serbynumber = ui.serbynumber("2101130086");
        System.out.println(serbynumber);
    }
    @Test
    void  update(){
        KUser kUser=new KUser();
        kUser.setZnumber("21011339933");
        kUser.setRejuster(2);
        kUser.setTphnumber("6666666");
        Boolean update = ui.update(kUser);
        System.out.println(update);
    }

    @Test
    void klogin(){
        KUser klogin = lg.klogin("21011336676", "123");
        if (klogin!=null){
            if (klogin.getType()!=1){
                System.out.println("该账号已被禁用");
            }else {
                System.out.println("登入成功");
            }
        }else{
            System.out.println("账号密码有误");
        }
    }

    @Test
    void ceshi(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("北京");
        list.add("朝阳区");
        list.add("故宫");
        System.out.println(list);
        StringBuilder sb=new StringBuilder();
        for (Object o : list) {
             sb.append(o).append("/");
        }
        System.out.println(sb.toString());

    }
    @Test
    void test(){
        StringBuilder s=new StringBuilder();
        String a="123";
        String b="456";
        s.append(a).append(b);
        System.out.println(s);
    }
    @Test
    //全数字订单号
    void number(){
        long s=System.currentTimeMillis();
        String number="15659731239";
        String substring = number.substring(0, 5);
        String number1=(s+substring);
        System.out.println(s);
        System.out.println(number1);

    }
    @Test
    void geshi(){
        Boolean phnumber = loginutils.phnumber("15659731239");
        System.out.println("手机号"+phnumber);
        Boolean passward = loginutils.passward("s1");
        System.out.println("passward=="+passward);
        System.out.println(!passward);
    }
    @Test
    void check(){
        List<dingDan> check = dg.check();
        System.out.println(check);
    }
    @Test
    void shuju(){
        List<Map<Object, Object>> shuju = uif.shuju(1);
        System.out.println(shuju);
    }

    @Test
    void xiancheng(){
        List<Object> list=new ArrayList<>();
        List<Object> list1=new ArrayList<>();
        CompletableFuture<List<Integer>> map= dg.totalUser();
        CompletableFuture<List<Integer>> map1 =dg.totalGuser();
        CompletableFuture<List<Integer>> map2 =dg.totalKuser();
        CompletableFuture<List<Integer>> map3 =dg.totalExpre();

        CompletableFuture<List<Map<Object, Object>>> shuju = dg.shuju();
        CompletableFuture<Void> rescompletableFuture2=CompletableFuture.allOf(shuju);
        rescompletableFuture2.join();

        CompletableFuture<Void> rescompletableFuture=CompletableFuture.allOf(map,map1,map2,map3);
        rescompletableFuture.join();

        list.add(map.join());
        list.add(map1.join());
        list.add(map2.join());
        list.add(map3.join());
        list1.add(shuju.join());

//        ShuJuBean shuJuBean = new ShuJuBean(list,list1);

    }

    @Test
    //加密算法
    void jiami() throws Exception {
        String show = "s123456";
        int key =7;
        //加密
        String ciphertext = encryption(show, key, true);
        System.out.println("加密后"+ciphertext);
        //解密
        String s="{9:;<=>";
        String showText = encryption(s, key, false);
        System.out.println("解密后的密码"+showText);
    }

    /**
     * @param text 明文/密文
     * @param key  位移
     * @param mode 加密/解密  true/false
     * @return 密文/明文
     */
    private static String encryption(String text, int key, boolean mode) {
        char[] chars = text.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            int a = mode ? aChar + key : aChar - key;
            char newa = (char) a;
            sb.append(newa);
        }
        return sb.toString();
    }
}


