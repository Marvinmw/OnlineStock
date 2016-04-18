package cn.nju.edu.tool;

import java.util.HashMap;
import java.util.Iterator;


public class ProductShow {
private HashMap<String,Integer> name=new HashMap<String,Integer>();
public ProductShow(){
	init();
}
public void init(){
	
	name.put("雪域天使",90);
	name.put("巧克力慕斯蛋糕",100);
	name.put("抹茶情深",89);
	name.put("月光倾城",99);
	name.put("神秘园",120);
	name.put("奇栗秋香",80);
	name.put("唇齿留香",50);
	name.put("留香",250);
	name.put("夜礼服假面",300);
	name.put("水果漩涡",330);
	name.put("梦幻花园",400);
	name.put("冬日漫步",80);
	name.put("延年益寿",200);
	name.put("田园风光",100);
	name.put("巧克力森林",90);
	name.put("巧克力浓情",80);
	name.put("幸福港湾",70);
	name.put("假面骑士",60);
	name.put("财源滚滚",40);
	name.put("绿野仙踪",60);
	name.put("浪漫之约",45);
}

public Iterator<String> getItr(){
	return name.keySet().iterator();
}

public int getPrice(String key){
	return name.get(key);
}
}
