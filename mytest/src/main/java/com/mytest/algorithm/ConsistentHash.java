package com.mytest.algorithm;

import java.util.Map.Entry;
import java.util.TreeMap;

//CΪclient�ͻ��ˣ�SΪservice������
public class ConsistentHash<c,s> {
  //����ڵ�ĸ�����Ĭ��200
  private int virtualNum;
  private long unit;//�ƶ�
  //�洢������������
  private TreeMap<Integer,String> map = new TreeMap<>();
  public ConsistentHash() {
      this(200);
  }
  public ConsistentHash(int virtualNum) {
      this.virtualNum = virtualNum;
      unit = ((long)(Integer.MAX_VALUE/virtualNum)<<1)-2;
  }
  //��ӷ��������
  public void add(String s){
      int hash = hash(s);
      //��֤��ɢ��Integer�ķ�Χ��
      for (int i = 0; i < virtualNum; i++) 
          map.put((int)(hash+i*unit), s);
  }
  //ɾ�����������
  public void remove(String s){
      int hash = hash(s);
      //��֤��ɢ��Integer�ķ�Χ��,��ת��Ϊint��ת��ΪInteger
      for (int i = 0; i < virtualNum; i++) 
          map.remove((Integer)(int)(hash+i*unit));
  }
  //��ȡ������
  public String get(String c){
      if(map.isEmpty())
          return null;
      int hash = hash(c);
      //TreeMap���е�ȡ�Ϻ�ȡ�·���
      //ceiling �� floor (Math����ceil)
      Entry<Integer,String> entry = map.ceilingEntry(hash);
      if(entry == null) //�վʹ�����Ҫ�ػ���
          return map.firstEntry().getValue();
      else
          return entry.getValue();
  }
  //�ٴη�ɢ��hash����
  private int hash(Object o) {
      if(o == null)
          return 0;
      int h = 0;
      h ^= o.hashCode();
      h ^= (h >>> 20) ^ (h >>> 12);
      return h ^ (h >>> 7) ^ (h >>> 4);
  }
}