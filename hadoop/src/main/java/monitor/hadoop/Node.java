package monitor.hadoop;

public enum Node {
	
	master("10.79.192.51",new String[]{"8020","50070","50030","8021"}),
	slave1("10.79.196.12",new String[]{"50010","50075","50060"}),
	slave2("10.79.196.13",new String[]{"50010","50075","8888"}),
	slave3("10.79.196.14",new String[]{"50010","50075","50060"}),
	slave4("10.79.196.15",new String[]{"50010","50075","50060"}),
	slave5("10.79.196.16",new String[]{"50010","50075","50060"}),
	slave6("10.79.196.17",new String[]{"50010","50075","50060"}),
	slave7("10.79.196.18",new String[]{"50010","50075","50060"}),
	slave8("10.79.196.19",new String[]{"50010","50075","50060"}),
	slave9("10.79.196.20",new String[]{"50010","50075","50060"}),
	slave10("10.79.196.11",new String[]{"50010","50075","50060"}),
	slave11("10.79.192.52",new String[]{"50010","50075","50060"}),
	slave12("10.79.192.53",new String[]{"50010","50075","50060"}),
	slave13("10.79.192.54",new String[]{"50010","50075","50060"}),
	slave14("10.79.192.55",new String[]{"50010","50075","50060"}),
	slave15("10.79.192.56",new String[]{"50010","50075","50060"}),
	slave16("10.79.192.57",new String[]{"50010","50075","50060"}),
	slave17("10.79.192.58",new String[]{"50010","50075","50060"}),
	slave18("10.79.192.59",new String[]{"50010","50075","50060"}),
	slave19("10.79.192.60",new String[]{"50010","50075","50060"});
	
	
	private String url;
	private String[] port;
	
	private Node(){
		
	}
	

	private Node(String url){
		this.url = url;
	}
	private Node(String url,String[] port){
		this.url = url;
		this.port = port;
	}
	public String getUrl(){
		return url;
	}
	public String[] getPort(){
		return port;
	}
	
	@Override
	public String toString() {
		return url;
	}
	
}
