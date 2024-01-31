package com.itheima.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/*
自定义线程池
参数一：核心线程数                   不能小于零
参数二：最大线程数                   不能小于等于零 最大数量>=核心线程数量
参数三：空闲线程最大存活时间           不能小于零
参数四：时间单位                    用TimeUnit指定
参数五：任务队列                    不能为bull
参数六：创建线程工厂                 不能为bull
参数七：任务拒绝策略                 不能为bull
 */
//                3,
//                6,
//                60,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(3), //指定3个队列
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("first")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(5);
        //最大线程数
        executor.setMaxPoolSize(7);
        //队列容量
        executor.setQueueCapacity(3);
        //活跃时间
        executor.setKeepAliveSeconds(60);
        //线程名字前缀
        executor.setThreadNamePrefix("taskExecutor-");
        // 设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 线程池对拒绝任务的处理策略,当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化
        executor.initialize();
        return executor;
    }
}
