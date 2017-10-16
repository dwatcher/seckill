-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE IF NOT EXISTS seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
CREATE TABLE IF NOT EXISTS seckill (
    `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
    `name` varchar(120) NOT NULL COMMENT '商品名称',
    `number` int NOT NULL NULL COMMENT '库存数量',
    `start_time`timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开启时间',
    `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存';

INSERT INTO
	seckill(name, number, start_time, end_time)
VALUES
    ('800元秒杀iphoneX', 100, '2017-09-26 00:00:00', '2017-09-27 00:00:00'),
    ('500元秒杀iphoneX', 200, '2017-09-26 00:00:00', '2017-09-27 00:00:00'),
    ('300元秒杀iphoneX', 300, '2017-09-26 00:00:00', '2017-09-27 00:00:00'),
    ('200元秒杀iphoneX', 400, '2017-09-26 00:00:00', '2017-09-27 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE IF NOT EXISTS success_kill(
	`seckill_id` bigint NOT NULL COMMENT '商品库存id',
    `user_phone` bigint NOT NULL COMMENT '商品库存id',
    `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标志:-1:无效 0:成功 1:已付款 2:已发货',
    `create_time` timestamp NOT NULL COMMENT '创建时间',
    PRIMARY KEY (seckill_id, user_phone), /* 联合主键 */
    key idx_create_time(create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存';

-- 连接数据库控制器
