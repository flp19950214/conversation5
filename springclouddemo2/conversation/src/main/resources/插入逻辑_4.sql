CREATE TABLE `数据表4` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `类型` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `时间` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `数据` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8693 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `逻辑表4` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `逻辑名` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `逻辑` text CHARACTER SET utf8 COLLATE utf8_bin,
  `逻辑类型` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (17, ''是是分割词'', ''是是分割词'', NULL);
INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (18, ''获取分割后的第一个元素'', ''获取分割后的第一个元素'', NULL);
INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (19, ''执行分割方法'', ''执行分割方法'', NULL);
INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (20, ''上一句话按照是分割后的第一个元素是什么'', ''获取上一句话,上一句话是分割对象,是是分割词,执行分割方法,获取分割后的第一个元素,输出上一步结果'', NULL);
INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (21, ''获取上一句话'', ''获取上一句话'', NULL);
INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (22, ''上一句话是分割对象'', ''上一句话是分割对象'', NULL);
INSERT INTO `conversation`.`逻辑表4` (`id`, `逻辑名`, `逻辑`, `逻辑类型`) VALUES (23, ''输出上一步结果'', ''输出上一步结果'', NULL);
