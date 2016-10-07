package com.mytest.concurrency;

public class MutilThreadShareData {
	private int count2;
	public static void main(String[] args) {
		ShareData1 shareData1  = new ShareData1();
		new Thread(new Inc1(shareData1)).start();
		new Thread(new Dec1(shareData1)).start();
		
		MutilThreadShareData m = new MutilThreadShareData();
		new Thread(m.new Inc2()).start();
		new Thread(m.new Dec2()).start();
	}

	private synchronized void inc(){
		count2++;
	}
	
	private synchronized void dec() {
		count2--;
	}
	class Inc2 implements Runnable{

		@Override
		public void run() {
			inc();
		}
		
	}
	
	class Dec2 implements Runnable{

		@Override
		public void run() {
			dec();
		}
		
	}
}

class ShareData1 {
	
	private int count1=0;
	public synchronized void increment(){
		count1++;
	}
	
	public synchronized void decrement(){
		count1--;
	}
}
	class Inc1 implements Runnable{
		private ShareData1 shareData1;
		public Inc1(ShareData1 shareData1) {
			this.shareData1 = shareData1;
		}
		@Override
		public synchronized void run() {
			shareData1.increment();		
		}
	}
	
	class Dec1 implements Runnable{
		private ShareData1 shareData1;
		public Dec1(ShareData1 shareData1) {
			this.shareData1 = shareData1;
		}
		@Override
		public void run() {
			shareData1.decrement(); 
		}
		
	}

