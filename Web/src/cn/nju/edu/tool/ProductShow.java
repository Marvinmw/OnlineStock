package cn.nju.edu.tool;

import java.util.HashMap;
import java.util.Iterator;


public class ProductShow {
private HashMap<String,Integer> name=new HashMap<String,Integer>();
public ProductShow(){
	init();
}
public void init(){
	
	name.put("ѩ����ʹ",90);
	name.put("�ɿ���Ľ˹����",100);
	name.put("Ĩ������",89);
	name.put("�¹����",99);
	name.put("����԰",120);
	name.put("��������",80);
	name.put("��������",50);
	name.put("����",250);
	name.put("ҹ�������",300);
	name.put("ˮ������",330);
	name.put("�λû�԰",400);
	name.put("��������",80);
	name.put("��������",200);
	name.put("��԰���",100);
	name.put("�ɿ���ɭ��",90);
	name.put("�ɿ���Ũ��",80);
	name.put("�Ҹ�����",70);
	name.put("������ʿ",60);
	name.put("��Դ����",40);
	name.put("��Ұ����",60);
	name.put("����֮Լ",45);
}

public Iterator<String> getItr(){
	return name.keySet().iterator();
}

public int getPrice(String key){
	return name.get(key);
}
}
