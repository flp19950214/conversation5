('数字', '《获取下一个词的下标》');
('加号', '如果前面有数字，那么可以作为被加数');
('加号', '如果后面有数字，那么可以作为加数');
('加号', '执行加法方法');
('获取下一个词的词性', '《获取下一个词语》《作为》查询的词语；《执行查询词语的词性方法》；');
('获取下一个词的下标', '￥{当前处理的词语位置}《作为》被加数；1《作为》加数；《执行加法方法》；');
('获取下一个词语', '￥{输入的句子}《作为》查询的对象；《获取下一个词的下标》《作为》查询的下标；《执行获取指定下标值方法》；');
('如果下一个词的类型是数字', '《获取下一个词的类型》《作为》被判断的对象；判断的对象《是》数字；《执行判断包含方法》；');
('跟当前词合并成一个新词', '被追加的对象《是》￥{当前词}；追加的对象《是》￥{上一步结果}；《执行追加方法》');
('那么', '《是否终止逻辑执行》');
('', '￥{上一步结果}《作为》被判断的对象；判断的对象《是》true；《执行判断等于方法》；');
('下一个词的词性是否是数字', '《获取下一个词的词性》《作为》被判断的对象；数字《作为》判断的对象；《执行判断集合包含方法》');
('合并下一个词', '￥{当前处理的词语}《作为》被合并的对象；《获取下一个词语》《作为》合并的对象；《执行合并方法》');
('合并下一个词作为新的处理词语', '《合并下一个词》《作为》￥{当前处理的词语}');
('如果下一个词的词性是数字，那么合并下一个词作为新的处理词语', '《下一个词的词性是否是数字》《作为》是否执行判断结果；《合并下一个词作为新的处理词语》');
('如果下一个词的词性不是数字，那么把当前词作为句子的一个成分', '《下一个词的词性是否是数字》《作为》是否执行判断结果；《合并下一个词作为新的处理词语》');
('生成对象唯一标识', '《执行生成对象唯一标识方法》');
('获取输入的句子的唯一标识', '查询的对象的键《是》输入的句子；查询的对象的值《是》￥{当前处理的句子}；查询的属性《是》_id；《执行查询对象指定属性值方法》');
('给输入的句子赋值唯一标识', '查询的对象的键《是》输入的句子；查询的对象的值《是》￥{当前处理的句子}；更新的属性《是》_id；《生成对象唯一标识》《作为》更新的属性值；《执行更新对象属性方法》');
('如果输入的句子的唯一标识为空，那么就创建一个', '《获取输入的句子的唯一标识》《作为》被判断的条件；《执行判断是不为空方法》《作为》是否执行判断结果；《给输入的句子赋值唯一标识》');

-- 处理相加功能完整流程
('给当前句子成分添加上级唯一标识', '《获取输入的句子的唯一标识》《作为》更新的属性值；查询的对象的键《是》对象；查询的对象的值《是》￥{当前处理的词语}；更新的对象类型《是》句子成分；更新的属性《是》上级对象唯一标识；《执行更新对象属性方法》');
('把当前词作为句子的一个成分', '《添加当前词语为句子成分》；《给当前句子成分添加上级唯一标识》');
('添加当前词语为句子成分', '《执行添加当前词语为句子成分方法》');
('如果下一个词的词性不是数字，那么把当前词作为句子的一个成分', '《下一个词的词性是否是数字》《作为》是否执行判断结果；《合并下一个词作为新的处理词语》');
('把前面最近的一个数作为被加数', '《下一个词的词性是否是数字》《作为》是否执行判断结果；《合并下一个词作为新的处理词语》');
('把后面最近的一个数作为加数', '《下一个词的词性是否是数字》《作为》是否执行判断结果；《合并下一个词作为新的处理词语》');
('执行相加方法', '《执行加法方法》');
