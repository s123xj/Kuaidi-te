package com.itheima.colleter;
import com.itheima.domin.*;
import com.itheima.service.Dinfrom;
import com.itheima.service.UpdateInfrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("admin")
public class adminControl {

    @Autowired
    private Dinfrom df;
    @Autowired
    private UpdateInfrom ui;
    //
    @PutMapping("/order")
    public Result order(dingDan dingD){
        log.info("订单信息====="+dingD);
        if (df.dingDan(dingD)){
            return Result.success();
        }else{
            return Result.error("信息输入有误");
        }
    }
    //快递员查询订单
    @GetMapping("/serDing")
    public Result serDing(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pagesize,
            HttpServletRequest request,
            String did,String snumber){
        log.info("页数"+page+"每页条数"+pagesize+"订单号"+did+"收件人手机号"+snumber);
        Integer id = ((KUser) request.getSession().getAttribute("kuser")).getId();
        pageBean pagebean=df.search(page,pagesize,did,snumber,id);
        return Result.success(pagebean);
    }
    //快递员获取待接单的订单
    @GetMapping("/getdan")
    public Result getDan(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pagesize){
        pageBean getdan = df.getdan(page, pagesize);
        return Result.success(getdan);
    }
    //快递员接单
    @PostMapping("/receivedan")
    public Result receivedan(Integer eid,HttpServletRequest request){
        Integer kuserid = ((KUser) request.getSession().getAttribute("kuser")).getId();
        df.receivedan(eid,kuserid);
        return Result.success();
    }

    //修改前的回显操作
    @PostMapping("/searbynumber")
    public Result serbynumber(String znumber){
        KUser kUser = ui.serbynumber(znumber);
        return Result.success(kUser);
    }
    //修改员工
    @PutMapping("/update")
    public Result upfate(@RequestBody KUser kUser){
        Boolean update = ui.update(kUser);
        if (update){
            return Result.success();
        }else {
            return Result.error("更新失败，更新内容不合法！");
        }

    }
    //获取未审核订单
    @GetMapping("/check")
    public Result check(){
        List<dingDan> check = df.check();
        return Result.success(check);
    }
    //填写失败原因
    @PostMapping("/nopass")
    public void nopass(Integer eid,String reasion){
        df.nopass(eid,reasion);
    }

    //显示待揽收
    @GetMapping("/serbutype")
    public Result serbutype(Integer dtype,HttpServletRequest request){
        Integer id = ((KUser) request.getSession().getAttribute("kuser")).getId();
        List<dingDan> serchbytype = df.serchbytype(dtype,id);
        return Result.success(serchbytype);
    }
    //显示待派送
    @GetMapping("/serbutype1")
    public Result serbutype1(Integer dtype,HttpServletRequest request){
        Integer id = ((KUser) request.getSession().getAttribute("kuser")).getId();
        List<dingDan> serchbytype = df.serchbytype1(dtype,id);
        return Result.success(serchbytype);
    }
    //派单
    @PostMapping("/paidan")
    public void paidan(Integer eid){
        log.info("需要修改订单号编号"+String.valueOf(eid));
        df.paidan(eid);
        }
     //重新派单
    @PostMapping("/rpaidan")
    public void rpaidan(Integer eid){
        log.info("需要修改订单号编号"+String.valueOf(eid));
        df.rpaidan(eid);
    }
    //通过审核
    @PostMapping("/pass")
    public void pass(Integer eid){
        log.info("需要修改订单号编号"+String.valueOf(eid));
        df.pass(eid);
    }
    //揽收
    @PostMapping("/lanshou")
    public void lanshou(Integer eid,HttpServletRequest request){
        log.info("需要修改订单号编号"+eid);
        Integer id = ((KUser) request.getSession().getAttribute("kuser")).getId();
        df.lanshou(eid,id);
    }
    //派送
    @PostMapping("/paisong")
    public void paisong(Integer eid){
        log.info("需要修改订单号编号"+String.valueOf(eid));
        df.paidan(eid);
    }
    //禁用快递员
    @PostMapping("/ban")
    public Result ban(String znumber){
        df.ban(znumber);
        return Result.success();
    }

    //重置密码
    @PutMapping("/chongzhi")
    public Result chongzhi(String znumber){
        String password="s123456";
        String ciphertext = encryption(password, true);
        Boolean flag = ui.chongzhi(ciphertext, znumber);
        if (flag){
            return Result.success();
        }else {
            return Result.error("未知错误！！！");
        }

    }
    //数据饼图以及纤细后台数据
    //利用线程池进行异步查询
    @GetMapping("/shuju")
    public Result shuju(){
        List<Object> list=new ArrayList<>();
        ShuJuBean shuJuBean1 = new ShuJuBean();
        CompletableFuture<List<Integer>> map= df.totalUser();
        CompletableFuture<List<Integer>> map1 =df.totalGuser();
        CompletableFuture<List<Integer>> map2 =df.totalKuser();
        CompletableFuture<List<Integer>> map3 =df.totalExpre();

        CompletableFuture<List<Map<Object, Object>>> shuju = df.shuju();
        CompletableFuture<Void> rescompletableFuture2=CompletableFuture.allOf(shuju);
        rescompletableFuture2.join();

        CompletableFuture<Void> rescompletableFuture=CompletableFuture.allOf(map,map1,map2,map3);
        rescompletableFuture.join();
        list.add(map.join());
        list.add(map1.join());
        list.add(map2.join());
        list.add(map3.join());

        shuJuBean1.setSecond(shuju.join());
        ShuJuBean shuJuBean = new ShuJuBean(list,shuJuBean1.getSecond());
        return Result.success(shuJuBean);
    }

    private static String encryption(String text, boolean mode) {
        //位移
        int key=8;
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
