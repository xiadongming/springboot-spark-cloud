解决超卖问题？
解决方法1：请求排队，在线程池队列中排队请求(本系统采用)
解决方法2：在订单表中，建立唯一索引(user_id,item_id)
解决方法3：点击秒杀的时候，会出现验证码输入的操作，停留几秒钟

超时未支付的订单怎样处理？
解决方案：
方案一：rocketmq的死信队列
方案二：定时任务扫描未支付状态的数据和创建时间，将剩余时间=30分钟-创建时间，将剩余时间和订单id放到redis中，设置一个redis的监听watch对这个订单id，过期时间是剩余时间，
       过期时间会触发一个时间，如果还是未支付就更新为失效，回滚库存

抢购的逻辑方案有哪些？
解决方案：
方案一：请求排队，在线程池队列中排队请求(本系统采用)
方案二：通过redis分布式锁实现，入参是goodsItemId，userId，，通过redis的setnx(goodsItemid)(或者使用redsession更好，或者zk的分布式锁)
        totalnum = redid.getForValue(),key=userId_lock,
        boolean isSuccess = totalnum.setIfAbsent(key,"1000") -- 重要
        if(isSuccess){
          更新数据库库存，创建订单
        }


