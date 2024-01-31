package com.itheima.colleter;
import com.itheima.dao.user;
import com.itheima.domin.*;
import com.itheima.service.Dinfrom;
import com.itheima.service.UpdatePesial;
import com.itheima.service.UserInfom;
import com.itheima.service.login;
import com.itheima.utils.JwtUtils;
import com.itheima.utils.loginutils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("user")
public class Colleter {
    @Autowired
    private login lg;
    @Autowired
    private Dinfrom df;
    @Autowired
    private UpdatePesial up;
    @Autowired
    private UserInfom ui;

    //将登入信息保存到session域中
    @PostMapping("/login")
    public Result login(String name, String password,HttpServletRequest request){
        //加密
        String ciphertext = encryption(password, true);
        User ulogin = lg.ulogin(name, ciphertext);
        if (ulogin!=null){
            //解密
            String encryption = encryption(ulogin.getPassword(), false);
            ulogin.setPassword(encryption);
            request.getSession().setAttribute("user",ulogin);
            //设置jwt令牌
            Map<String,Object> jwtchain=new HashMap();

            jwtchain.put("name",ulogin.getUsername());
            jwtchain.put("id",ulogin.getId());

            String jwt = JwtUtils.generateJwt(jwtchain);
            return Result.success(jwt);
        }else {
            return Result.error("账号密码有误请重新输入！");
        }

    }
    //显示基础信息
    @RequestMapping("/show")
    public Result show(HttpServletRequest request){
        //获取session域中的个人信息
        User user=(User) request.getSession().getAttribute("user");
        List<Map<Object, Object>> shuju = ui.shuju(user.getId());
        UserBean userBean = new UserBean(user,shuju);
        log.info(String.valueOf(userBean));
        return Result.success(userBean);
    }

    //更新个人信息
    @PutMapping("/update")
    public Result update(@RequestBody User user,HttpServletRequest request){
        if(user.getCity()!=null){
            List<Object> jc = user.getCity();
            user.setAddrescity(qiege(jc));
            String sadds =pignjie(user.getAddrescity(),user.getDetailaddress());
            user.setAddress(sadds);
        }else {
            String addrescity = user.getAddrescity();
            log.info("===="+addrescity);
            String sadds =pignjie(addrescity,user.getDetailaddress());
            user.setAddress(sadds);
        }
        //加密
        String ciphertext = encryption(user.getPassword(), true);
        user.setPassword(ciphertext);
        Boolean flag =up.update(user);
        if (flag){
            //解密
            String encryption = encryption(user.getPassword(), false);
            user.setPassword(encryption);
            request.getSession().setAttribute("user",user);
            return Result.success();
        }else {
            return Result.error("更新失败，更新内容不合法！");
        }
    }
    //用户个人订单显示
    @GetMapping("/mydan")
    public Result mydan(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pagesize,
                        HttpServletRequest request){
        int id = ((User) request.getSession().getAttribute("user")).getId();
        pageBean search = ui.mydan(page, pagesize,id);
        return Result.success(search);
    }

    //待审订单
    @GetMapping("/wack")
    public Result wack(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pagesize,
                        HttpServletRequest request){
        int id = ((User) request.getSession().getAttribute("user")).getId();
        pageBean search = ui.wack(page, pagesize,id);
        return Result.success(search);
    }
    //待审接单re
    @GetMapping("/ware")
    public Result ware(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pagesize,
                       HttpServletRequest request){
        int id = ((User) request.getSession().getAttribute("user")).getId();
        pageBean search = ui.ware(page, pagesize,id);
        return Result.success(search);
    }


    @GetMapping("/history")
    public Result history(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pagesize,
                          String did,String snumber,
                          HttpServletRequest request){
        int id = ((User) request.getSession().getAttribute("user")).getId();
        //传入对应参数以及当前用户id
        pageBean search = ui.search(page, pagesize, did, snumber, id);
        return Result.success(search);
    }
    //未通过审核的订单
    @GetMapping("/reasion")
    public Result faile(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pagesize,
                        HttpServletRequest request){
        int user = ((User) request.getSession().getAttribute("user")).getId();
        pageBean faile = ui.faile(page, pagesize, user);
        return Result.success(faile);
    }

    //管理员登入
    @PostMapping("/glogin")
    public Result glogin(String phnumber, String password){
        log.info(phnumber+"++"+password);
        String ciphertext = encryption(password, true);
        Guser ulogin = lg.glogin(phnumber,ciphertext);
        if (ulogin!=null){
            Map<String,Object> jwtchain=new HashMap();

            jwtchain.put("phnumber",ulogin.getGPhnumber());
            jwtchain.put("id",ulogin.getId());

            String jwt = JwtUtils.generateJwt(jwtchain);
            return Result.success(jwt);
        }else {
            return Result.error("账号密码有误请重新输入！");
        }

    }

//快递员登入,先验证账号密码，如果正确，赋值到实体类中，并获取状态id，如果禁用则返回错误消息
    @PostMapping("/klogin")
    public Result klogin(String znumber,String passward,HttpServletRequest request){
        log.info("znumber"+znumber+"pass="+passward);

        //加密
        String ciphertext = encryption(passward, true);
        KUser klogin = lg.klogin(znumber, ciphertext);
        if (klogin!=null){
            if (klogin.getType()!=1){
                return Result.error("该账号已被禁用");
            }else {
                //保存快递员登入信息
                request.getSession().setAttribute("kuser",klogin);

                Map<String,Object> jwtchain=new HashMap();
                jwtchain.put("phnumber",klogin.getTphnumber());
                jwtchain.put("id",klogin.getId());
                String jwt = JwtUtils.generateJwt(jwtchain);
                return Result.success(jwt);
            }
        }else{
            return Result.error("账号或密码有误");
        }
    }

    @GetMapping("/serbyid")
    public Result serbyid(String did){
        log.info("订单号==="+did);
        List<dingDan>list=lg.searbyid(did);
        if (list.get(0).getDId().equals(did)){
            return Result.success(list);
        }else {
            return Result.error("订单号不存在！！！");
        }
    }
    //下单
    @PostMapping("/order")
    public Result order(@RequestBody dingDan dan,HttpServletRequest request){
        log.info(String.valueOf(dan));
        //手机号格式验证
        if (!(loginutils.phnumber(dan.getJPhnumber()) || loginutils.phnumber(dan.getSNumber()))){
            return Result.error("手机号格式有误，请正确输入！");
        }

        //获取Session域中的用户id
        int id = ((User) request.getSession().getAttribute("user")).getId();
        log.info("==所属用户ID=="+id);

        List<Object> jc = dan.getJc();
        dan.setJCity( qiege(jc));
        List<Object> sc = dan.getSc();
        dan.setSCity(qiege(sc));

        String jadds = pignjie(dan.getJCity(), dan.getJAddress());
        String sadds =pignjie(dan.getSCity(),dan.getSDetailcity());
        dan.setJAddress(jadds);
        dan.setSDetailcity(sadds);

        dan.setDType(5);
        dan.setSId(id);
        //随机生成订单号
        //时间戳+手机号前5位 订单号全数字
        long s=System.currentTimeMillis();
        String number=dan.getJPhnumber();
        String substring = number.substring(0, 5);
        dan.setDId(s+substring);
        dan.setWeight(dan.getWeight()+"kg");
        dan.setJTime(LocalDateTime.now());
        Boolean flag = df.dingDan(dan);
        if (flag){
            return Result.success();
        }else {
            return Result.error("未知错误！！！");
        }
    }
    //注册
    @PostMapping("/register")
    public Result reGister(@RequestBody User user){
        log.info("数据模型"+ user.toString());
       user.setRegisterTime(LocalDateTime.now());
        //  密码格式校验
        Boolean passward = loginutils.passward(user.getPassword());
        if (!passward){
            return Result.error("输入密码格式有误");
        }
        User search = lg.search(user.getUsername());
        if (search!=null){
            return Result.error("账号已存在!!!");
        }else {
            //加密后存入数据库
            String ciphertext = encryption(user.getPassword(), true);
            user.setPassword(ciphertext);
            lg.zhuce(user);
            return Result.success();
        }
    }


    //查找员工信息
    @RequestMapping("/ksearch")
    public Result seardetial(){
        List<KUser> list =lg.kSearch();
        return Result.success(list);
    }
    //根据账号删除员工信息
    @PostMapping("/deletebyid")
    public void deletebyid(String znumber){
        log.info("----+++----"+znumber);
        lg.deletebyid(znumber);
    }

    //  增加员工信息
    @PostMapping("/addyuan")
    public Result add(@RequestBody KUser kUser){
        log.info("数据模型"+kUser.toString());
        Boolean phnumber = loginutils.phnumber(kUser.getTphnumber());
        if (!phnumber){
            return Result.error("手机号格式有误！");
        }
        Boolean passward = loginutils.passward(kUser.getPassward());
        if (!passward){
            return Result.error("密码格式有误");
        }
        Boolean bool=lg.addinfrom(kUser);
        if (bool){
            return Result.success();
        }else {
            return Result.error("账号重复,请重新输入！");
        }

    }
    //将集合切割为字符串
    public String qiege(List list){
        StringBuilder sb=new StringBuilder();
        for (Object o : list) {
            sb.append(o);
        }
        return sb.toString();

    }
    //拼接数据
    public String pignjie(String p,String c){
        StringBuilder s=new StringBuilder();
        s.append(p).append(c);
        return s.toString();
    }
    //密码加密与解密
    /**
     * @param text 明文/密文
     * @param mode 加密/解密  true/false
     * @return 密文/明文
     */
    private static String encryption(String text, boolean mode) {
        //位移
        int key=7;
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
